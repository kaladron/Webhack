package net.webhack.game.shared;

import net.webhack.game.shared.Display.WindowType;

public class Webhack {

	// CONFIG Things go here for now.

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
	You you;
	public final Flags flags;
	final WebhackUI ui;

	static int YLIM = 3;

	static int XLIM = 4;

	public Webhack(final WebhackUI ui, final Flags flags) {
		this.flags = flags;
		this.ui = ui;
	}

	public void main() {
		ui.initNhWindows(this);

		// askname();
		// player_selection();

		newGame();

		premove();
		// moveloop();

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
	public void moveLoop(final char c) {

		switch (c) {
		case 'o':
			dungeon.dlevel.doOpen.execute();
		}

		final String sdir = "hykulnjb><";
		// final char ndir[] = {'4','7','8','9','6','3','2','1','>','<'}; /*
		// number pad mode */
		final int xdir[] = { -1, -1, 0, 1, 1, 1, 0, -1, 0, 0 };
		final int ydir[] = { 0, -1, -1, -1, 0, 1, 1, 1, 0, 0 };
		final int offset = sdir.indexOf(c);

		if (offset != -1) {
			you.ux0 = you.ux;
			you.uy0 = you.uy;
			you.uz0 = you.uz;

			you.dx = xdir[offset];
			you.dy = ydir[offset];

			if (!dungeon.dlevel.testMove(you.ux, you.uy, you.dx, you.dy, 1)) {
				return;
			}

			you.ux += you.dx;
			you.uy += you.dy;
			// you.uz += zdir[offset];
			ui.newsym(you.ux, you.uy);
			ui.newsym(you.ux0, you.uy0);
		}

		dungeon.dlevel.moveMon();

		ui.displayNhWindow(WindowType.MAP, false);
	}

	/**
	 * One-shot in-game initialization.
	 */
	public void premove() {
		// TODO(jeffbailey): STUB
		ui.displayNhWindow(WindowType.MAP, false);
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

	}

	private void newGame() {
		final RandomHelper random = new WebhackRandom();
		you = new You(flags.initrole != null ? flags.initrole
				: Role.getRandom(random), Race.getRandom(random),
				Gender.getRandom(random));
		dungeon = new Dungeon(random, you, ui, flags);

		this.ui.docrt();

		welcome(true);
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

		this.ui.pline("Hello, player, welcome to WebHack!  You are a "
				+ you.gender.name() + " " + you.race.name() + " "
				+ you.role.name[0] + ".");
		// this.ui.pline(welcome);
	}
}
