package net.webhack.game.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.webhack.game.shared.Display.WindowType;
import net.webhack.game.shared.command.Command;
import net.webhack.game.shared.command.DDoInv;
import net.webhack.game.shared.command.DoClose;
import net.webhack.game.shared.command.DoDown;
import net.webhack.game.shared.command.DoKick;
import net.webhack.game.shared.command.DoLook;
import net.webhack.game.shared.command.DoOpen;
import net.webhack.game.shared.command.DoPickup;
import net.webhack.game.shared.command.DoSearch;
import net.webhack.game.shared.command.DoTogglePickup;
import net.webhack.game.shared.command.DoUp;
import net.webhack.game.shared.command.WizMap;
import net.webhack.game.shared.monsters.Monster;
import net.webhack.game.shared.race.Race;
import net.webhack.game.shared.role.Role;

public class Webhack {

	// CONFIG Things go here for now.

	class FuncTab {
		public final Command command;
		public final boolean canIfBuried;
		public final String text;

		FuncTab(final Command command, final boolean canIfBuried,
				final String text) {
			this.command = command;
			this.canIfBuried = canIfBuried;
			this.text = text;
		}
	}

	final String sdir = "hykulnjb><";
	// final char ndir[] = {'4','7','8','9','6','3','2','1','>','<'}; /*
	// number pad mode */
	final int xdir[] = { -1, -1, 0, 1, 1, 1, 0, -1, 0, 0 };
	final int ydir[] = { 0, -1, -1, -1, 0, 1, 1, 1, 0, 0 };

	final int zdir[] = { 0, 0, 0, 0, 0, 0, 0, 0, 1, -1 };

	public static final int CMD_TRAVEL = 0x90;

	/** Number of columns in the dungeon. */
	public static int COLNO = 80;

	/** Number of rows in the dungeon. */
	public static int ROWNO = 21;

	/** Maximum rooms per level. */
	public static int MAXNROFROOMS = 40;

	/** Maximum subrooms per level. */
	public static int MAX_SUBROOMS = 24;

	/** Maximum doors per level. */
	public static int DOORMAX = 120;

	/** current maximum number of dungeons */
	public static int MAXDUNGEON = 16;

	/** max number of levels in one dungeon */
	public static int MAXLEVEL = 32;

	/** max # of special stairways in a dungeon */
	public static int MAXSTAIRS = 1;

	/** generation weight of alignment */
	public static int ALIGNWEIGHT = 4;

	/** max character experience level */
	public static int MAXULEV = 30;

	/** extinct monst after this number created */
	public static int MAXMONNO = 120;

	/** maximum monster hp */
	public static int MHPMAX = 500;
	public Dungeon dungeon;

	public You you;

	static int YLIM = 3;

	static int XLIM = 4;

	private final int CONTROL = 0x1F;

	public final Bindery bindery;

	private final Map<Integer, FuncTab> cmdMap = new HashMap<Integer, FuncTab>();

	public Webhack(final WebhackUI ui, final Flags flags, final Vision vision) {
		this.bindery = new Bindery(this, new WebhackRandom(), ui, flags, vision);
		ui.setBindery(bindery);
		vision.setBindery(bindery);
		registerCommands();
	}

	@Stub
	public void display_inventory() {
		final List<Character> keys = new ArrayList<Character>(
				you.invent.items.keySet());
		java.util.Collections.sort(keys);
		for (final char item : keys) {
			bindery.ui
					.pline(item + " - " + you.invent.items.get(item).doName());
		}

	}

	@Stub
	public void doMove() {

		if (bindery.flags.travel) {
			if (!findtravelpath(false)) {
				findtravelpath(true);
			}
			bindery.iflags.travel1 = false;
		}

		final int x = you.ux + you.dx;
		final int y = you.uy + you.dy;

		if (!bindery.dlevel.isOk(x, y)) {
			return;
		}

		final Monster mtmp = bindery.dlevel.mAt(x, y);

		you.ux0 = you.ux;
		you.uy0 = you.uy;

		/* attack monster */
		if (mtmp != null) {
			if (mtmp.mpeaceful) {
				bindery.ui.pline("You move right into " + mtmp.mname);
			}
			you.attack(mtmp);
			return;
		}

		if (!bindery.dlevel.testMove(you.ux, you.uy, you.dx, you.dy, 1)) {
			return;
		}

		/* now move the hero */
		// mtmp = m_at(x, y);
		you.ux += you.dx;
		you.uy += you.dy;

		if (you.ux0 != you.ux || you.uy0 != you.uy) {
			you.umoved = true;
			/* Clean old position -- vision_recalc() will print our new one. */
			bindery.ui.newsym(you.ux0, you.uy0);
			/* Since the hero has moved, adjust what can be seen/unseen. */
			bindery.vision.vision_recalc(1); /*
											 * Do the work now in the recover
											 * time.
											 */
		}

		spoteffects(true);

	}

	public void main() {
		bindery.ui.initNhWindows(this);

		newGame();

		premove();

	}

	/**
	 * Handles input from the user and takes the turn.
	 * 
	 * The original NetHack code uses a strange putch/getch setup to handle
	 * movement. This isn't available to us as we want to be purely event-based.
	 * moveloop() in NH also has a bunch of init at the top of moveloop, which
	 * we don't want to be performed on each action, so it's split out into
	 * premove()
	 */
	public void moveLoop(final int c) {

		rhack(c);

		bindery.dlevel.moveMon();

		/********************************/
		/* once-per-turn things go here */
		/********************************/

		/****************************************/
		/* once-per-player-input things go here */
		/****************************************/

		if (bindery.flags.botl || bindery.flags.botlx) {
			bot();
		}

		bindery.ui.displayNhWindow(WindowType.MAP, false);
	}

	/**
	 * One-shot in-game initialization.
	 */
	public void premove() {
		// TODO(jeffbailey): STUB
		bindery.ui.displayNhWindow(WindowType.MAP, false);
		// flags.moonphase = phase_of_the_moon();
		// if(flags.moonphase == FULL_MOON) {
		// You("are lucky!  Full moon tonight.");
		// change_luck(1);
		// } else if(flags.moonphase == NEW_MOON) {
		// pline("Be careful!  New moon tonight.");
		// }
		// flags.friday13 = friday_13th();
		// if (flags.friday13) {
		// pline("Watch out!  Bad things can happen on Friday the 13th.");
		// change_luck(-1);
		// }
		//
		// (void) encumber_msg(); /* in case they auto-picked up something */
		//
		// u.uz0.dlevel = u.uz.dlevel;
		// youmonst.movement = NORMAL_SPEED; /* give the hero some movement
		// points */

		// Make sure status screen is updated with our character info.
		bot();

	}

	@Stub
	public void rhack(final int c) {

		boolean doWalk = false, doRush = false;
		if (cmdMap.containsKey(c)) {
			cmdMap.get(c).command.execute();
		}

		if (c == CMD_TRAVEL) {
			bindery.flags.travel = true;
			bindery.iflags.travel1 = true;
			bindery.flags.run = 8;
			bindery.flags.nopick = true;
			doRush = true;
		}

		if (moveCmd(c)) {
			doWalk = true;
		}

		if (doWalk) {
			doMove();
			return;
		} else if (doRush) {
			bindery.flags.mv = true;
			doMove();
			return;
		}
	}

	/**
	 * What happens after a move?
	 * 
	 * @param pick
	 *            if an autopickup should be attempted
	 */
	public void spoteffects(final boolean pick) {
		if (pick) {
			bindery.dlevel.pickup(1);
		}

	}

	void nomul(final int nval) {
		// if(multi < nval) return; /* This is a bug fix by ab@unido */
		you.uinvulnerable = false; /* Kludge to avoid ctrl-C bug -dlc */
		you.usleep = 0;
		// multi = nval;
		bindery.flags.travel = bindery.iflags.travel1 = bindery.flags.mv = false;
		bindery.flags.run = 0;
	}

	/**
	 * Registers the keyboard commands
	 */
	void registerCommands() {
		registerCommand('d' & CONTROL, new DoKick(bindery));
		registerCommand('f' & CONTROL, new WizMap(bindery));
		registerCommand('c', new DoClose(bindery));
		registerCommand('i', new DDoInv(bindery));
		registerCommand('o', new DoOpen(bindery));
		registerCommand('s', new DoSearch(bindery));
		registerCommand('<', new DoUp(bindery));
		registerCommand('>', new DoDown(bindery));
		registerCommand(',', new DoPickup(bindery));
		registerCommand('@', new DoTogglePickup(bindery));
		registerCommand(':', new DoLook(bindery));
	}

	/** return the sign of a number: -1, 0, or 1 */
	int sgn(final int n) {
		return (n < 0) ? -1 : (n != 0 ? 1 : 0);
	}

	/**
	 * Updates attributes display
	 */
	private void bot() {
		bindery.ui.updateStats();
		bindery.flags.botl = bindery.flags.botlx = false;
	}

	/**
	 * Find a path from the destination (u.tx,u.ty) back to (u.ux,u.uy). A
	 * shortest path is returned. If guess is true, consider various
	 * inaccessible locations as valid intermediate path points.
	 * 
	 * @return true if a path was found.
	 */
	private boolean findtravelpath(final boolean guess) {
		// TODO(jeffbailey): Ditch this:
		final int TEST_MOVE = 0;
		/* if travel to adjacent, reachable location, use normal movement rules */
		if (!guess && bindery.iflags.travel1
				&& bindery.dlevel.distmin(you.ux, you.uy, you.tx, you.ty) == 1) {
			bindery.flags.run = 0;

			if (bindery.dlevel.testMove(you.ux, you.uy, you.tx - you.ux, you.ty
					- you.uy, TEST_MOVE)) {
				you.dx = you.tx - you.ux;
				you.dy = you.ty - you.uy;
				bindery.iflags.travelcc.x = bindery.iflags.travelcc.y = -1;
				return true;
			}
			bindery.flags.run = 8;
		}

		if (you.tx == you.ux && you.ty == you.uy) {
			return findtravelpathcleanup();
		}

		final int[][] travel = new int[Webhack.COLNO][Webhack.ROWNO];
		final int[][] travelstepx = new int[2][COLNO * ROWNO];
		final int[][] travelstepy = new int[2][COLNO * ROWNO];
		int tx, ty, ux, uy;
		/*
		 * If guessing, first find an "obvious" goal location. The obvious goal
		 * is the position the player knows of, or might figure out (couldsee)
		 * that is closest to the target on a straight path.
		 */
		if (guess) {
			tx = you.ux;
			ty = you.uy;
			ux = you.tx;
			uy = you.ty;
		} else {
			tx = you.tx;
			ty = you.ty;
			ux = you.ux;
			uy = you.uy;
		}

		return findtravelpathloop(guess, travel, travelstepx, travelstepy, tx,
				ty, ux, uy);
	}

	private boolean findtravelpathcleanup() {
		you.dx = 0;
		you.dy = 0;
		nomul(0);
		return false;

	}

	private boolean findtravelpathloop(final boolean guess,
			final int[][] travel, final int[][] travelstepx,
			final int[][] travelstepy, int tx, int ty, final int ux,
			final int uy) {

		// TODO(jeffbailey): Ditch this:
		final int TEST_MOVE = 0;
		final int TEST_TRAV = 1;

		int n = 1; /* max offset in travelsteps */
		int set = 0; /* two sets current and previous */
		int radius = 1; /* search radius */

		travelstepx[0][0] = tx;
		travelstepy[0][0] = ty;

		while (n != 0) {
			int nn = 0;

			for (int i = 0; i < n; i++) {
				int dir;
				final int x = travelstepx[set][i];
				final int y = travelstepy[set][i];
				final int ordered[] = { 0, 2, 4, 6, 1, 3, 5, 7 };
				/* no diagonal movement for grid bugs */
				final int dirmax = you.umonnum == PM.GRID_BUG ? 4 : 8;

				for (dir = 0; dir < dirmax; ++dir) {
					final int nx = x + xdir[ordered[dir]];
					final int ny = y + ydir[ordered[dir]];

					if (!bindery.dlevel.isOk(nx, ny)) {
						continue;
					}
					// TODO(jeffbailey):
					// if ((!Passes_walls && !can_ooze(you.youmonst) &&
					// closed_door(
					// x, y))
					// || bindery.dlevel.locations[x][y]
					// .sobj_at(ObjectName.BOULDER)) {
					if (bindery.dlevel.locations[x][y]
							.sobj_at(ObjectName.BOULDER) != null) {
						/*
						 * closed doors and boulders usually cause a delay, so
						 * prefer another path
						 */
						if (travel[x][y] > radius - 3) {
							travelstepx[1 - set][nn] = x;
							travelstepy[1 - set][nn] = y;
							/* don't change travel matrix! */
							nn++;
							continue;
						}
					}
					// TODO(jeffbailey): Fix this
					// if (bindery.dlevel.testMove(x, y, nx - x, ny - y,
					// TEST_TRAV)
					// && (bindery.dlevel.locations[nx][ny].seenv || (!Blind
					// && couldsee(
					// nx, ny)))) {
					if (bindery.dlevel
							.testMove(x, y, nx - x, ny - y, TEST_TRAV)) {
						if (nx == ux && ny == uy) {
							if (!guess) {
								you.dx = x - ux;
								you.dy = y - uy;
								if (x == you.tx && y == you.ty) {
									nomul(0);
									/* reset run so domove run checks work */
									bindery.flags.run = 8;
									bindery.iflags.travelcc.x = bindery.iflags.travelcc.y = -1;
								}
								return true;
							}
						} else if (travel[nx][ny] == 0) {
							travelstepx[1 - set][nn] = nx;
							travelstepy[1 - set][nn] = ny;
							travel[nx][ny] = radius;
							nn++;
						}
					}
				}
			}

			n = nn;
			set = 1 - set;
			radius++;
		}

		/* if guessing, find best location in travel matrix and go there */
		if (guess) {
			int px = tx, py = ty; /* pick location */
			int dist, nxtdist, d2, nd2;
			dist = bindery.dlevel.distmin(ux, uy, tx, ty);
			d2 = bindery.dlevel.dist2(ux, uy, tx, ty);
			for (tx = 1; tx < COLNO; ++tx) {
				for (ty = 0; ty < ROWNO; ++ty) {
					if (travel[tx][ty] != 0) {
						nxtdist = bindery.dlevel.distmin(ux, uy, tx, ty);
						// TODO(jeffbailey): if (nxtdist == dist &&
						// couldsee(tx, ty)) {
						if (nxtdist == dist) {
							nd2 = bindery.dlevel.dist2(ux, uy, tx, ty);
							if (nd2 < d2) {
								/* prefer non-zigzag path */
								px = tx;
								py = ty;
								d2 = nd2;
							}
							// TODO(jeffbailey): } else if (nxtdist < dist
							// && couldsee(tx, ty)) {
						} else if (nxtdist < dist) {
							px = tx;
							py = ty;
							dist = nxtdist;
							d2 = bindery.dlevel.dist2(ux, uy, tx, ty);
						}
					}
				}
			}

			if (px == you.ux && py == you.uy) {
				/* no guesses, just go in the general direction */
				you.dx = sgn(you.tx - you.ux);
				you.dy = sgn(you.ty - you.uy);
				if (bindery.dlevel.testMove(you.ux, you.uy, you.dx, you.dy,
						TEST_MOVE)) {
					return true;
				}
				return findtravelpathcleanup();
			}
			tx = px;
			ty = py;
			return findtravelpathloop(false, travel, travelstepx, travelstepy,
					tx, ty, you.ux, you.uy);
		}
		return false;
	}

	/**
	 * also sets u.dz, but returns false for level changes
	 * 
	 * @param c
	 */
	private boolean moveCmd(final int c) {

		final int offset = sdir.indexOf(c);

		if (offset == -1) {
			return false;
		}

		you.ux0 = you.ux;
		you.uy0 = you.uy;
		you.uz0 = you.uz;

		you.dx = xdir[offset];
		you.dy = ydir[offset];
		you.dz = zdir[offset];

		return you.dz == 0 ? true : false;

	}

	private void newGame() {
		you = new You(bindery.flags.initrole != null ? bindery.flags.initrole
				: Role.getRandom(bindery), Race.getRandom(bindery),
				Gender.getRandom(bindery), bindery);
		dungeon = new Dungeon(bindery);

		bindery.flags.botlx = true;

		bindery.ui.docrt();

		welcome(true);
	}

	private void registerCommand(final int letter, final Command command) {
		cmdMap.put(letter, new FuncTab(command, false, ""));
	}

	/**
	 * The "welcome back" message always describes your innate form even when
	 * polymorphed or wearing a helm of opposite alignment. Alignment is shown
	 * unconditionally for new games; for restores it's only shown if it has
	 * changed from its original value. Sex is shown for new games except when
	 * it is redundant; for restores it's only shown if different from its
	 * original value.
	 */
	@Stub
	private void welcome(final boolean newGame) {

		if (newGame) {
			// welcome = String.format(
			// "%1$s %1$s, welcome to WebHack!  You are a%1$s %1$s %1$s.",
			// params);
		} else {
			// welcome = String.format(
			// "%1$s %1$s, the%1$s %1$s %1$s, welcome back to WebHack!",
			// params);
		}

		bindery.ui.pline("Hello, player, welcome to WebHack!  You are a "
				+ you.gender.name() + " " + you.race.name() + " "
				+ you.role.name[0] + ".");
		// this.ui.pline(welcome);
	}
}
