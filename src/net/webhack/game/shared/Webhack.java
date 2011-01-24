package net.webhack.game.shared;

import java.util.HashMap;
import java.util.Map;

import net.webhack.game.shared.Display.WindowType;
import net.webhack.game.shared.command.Command;
import net.webhack.game.shared.command.DoClose;
import net.webhack.game.shared.command.DoKick;
import net.webhack.game.shared.command.DoOpen;
import net.webhack.game.shared.command.DoSearch;
import net.webhack.game.shared.command.DoTogglePickup;
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

	public Webhack(final WebhackUI ui, final Flags flags) {
		this.bindery = new Bindery(this, new WebhackRandom(), ui, flags);

		registerCommands();
	}

	@Stub
	public void doMove() {
		final int x = you.ux + you.dx;
		final int y = you.uy + you.dy;

		if (!dungeon.dlevel.isOk(x, y)) {
			return;
		}

		final Monster mtmp = dungeon.dlevel.mAt(x, y);

		you.ux0 = you.ux;
		you.uy0 = you.uy;

		/* attack monster */
		if (mtmp != null) {
			if (mtmp.mpeaceful) {
				dungeon.ui.pline("You move right into " + mtmp.mname);
			}
			you.attack(mtmp);
			return;
		}

		if (!dungeon.dlevel.testMove(you.ux, you.uy, you.dx, you.dy, 1)) {
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
			bindery.ui.vision_recalc(1); /* Do the work now in the recover time. */
		}

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

		dungeon.dlevel.moveMon();

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

	public void rhack(final int c) {

		boolean doWalk = false;

		if (cmdMap.containsKey(c)) {
			cmdMap.get(c).command.execute();
		}

		if (moveCmd(c)) {
			doWalk = true;
		}

		if (doWalk) {
			doMove();
		}
	}

	/**
	 * Registers the keyboard commands
	 */
	void registerCommands() {
		registerCommand('d' & CONTROL, new DoKick(bindery));
		registerCommand('f' & CONTROL, new WizMap(bindery));
		registerCommand('c', new DoClose(bindery));
		registerCommand('o', new DoOpen(bindery));
		registerCommand('s', new DoSearch(bindery));
		registerCommand('@', new DoTogglePickup(bindery));
	}

	/**
	 * Updates attributes display
	 */
	private void bot() {
		bindery.ui.updateStats();
		bindery.flags.botl = bindery.flags.botlx = false;
	}

	/**
	 * also sets u.dz, but returns false for level changes
	 * 
	 * @param c
	 */
	private boolean moveCmd(final int c) {
		final String sdir = "hykulnjb><";
		// final char ndir[] = {'4','7','8','9','6','3','2','1','>','<'}; /*
		// number pad mode */
		final int xdir[] = { -1, -1, 0, 1, 1, 1, 0, -1, 0, 0 };
		final int ydir[] = { 0, -1, -1, -1, 0, 1, 1, 1, 0, 0 };
		final int zdir[] = { 0, 0, 0, 0, 0, 0, 0, 0, 1, -1 };

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
				: Role.getRandom(bindery.random),
				Race.getRandom(bindery.random),
				Gender.getRandom(bindery.random), bindery);
		dungeon = new Dungeon(bindery.random, you, bindery.ui, bindery.flags);

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
