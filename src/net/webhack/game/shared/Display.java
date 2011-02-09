package net.webhack.game.shared;

import java.util.EnumSet;

import net.webhack.game.shared.command.Command;
import net.webhack.game.shared.monsters.Monster;

public abstract class Display implements WebhackUI {

	public enum WindowType {
		MESSAGE, STATUS, MAP, MENU, TEXT;
	}

	/**
	 * Seen vector values. The seen vector is an array of 8 bits, one for each
	 * octant around a given center x:
	 * 
	 * <pre>
	 *                      0 1 2
	 *                      7 x 3
	 *                      6 5 4
	 * </pre>
	 * 
	 * In the case of walls, a single wall square can be viewed from 8 possible
	 * directions. If we know the type of wall and the directions from which it
	 * has been seen, then we can determine what it looks like to the hero.
	 */

	enum SeenVector {
		SV0, SV1, SV2, SV3, SV4, SV5, SV6, SV7;
	}

	protected class Gbuf {
		public boolean updated = false;

		/** Initializes the entry to be a stone background */
		public int glyph = cmap_to_glyph(S_stone);
	}

	protected Webhack webhack;

	protected Dungeon dungeon;

	protected You you;

	/* begin dungeon characters */

	public static int S_stone = 0;
	public static int S_vwall = 1;
	public static int S_hwall = 2;
	public static int S_tlcorn = 3;
	public static int S_trcorn = 4;
	public static int S_blcorn = 5;
	public static int S_brcorn = 6;
	public static int S_crwall = 7;
	public static int S_tuwall = 8;
	public static int S_tdwall = 9;
	public static int S_tlwall = 10;
	public static int S_trwall = 11;
	public static int S_ndoor = 12;
	public static int S_vodoor = 13;
	public static int S_hodoor = 14;
	public static int S_vcdoor = 15; /* closed door, vertical wall */
	public static int S_hcdoor = 16; /* closed door, horizontal wall */
	public static int S_bars = 17; /* KMH -- iron bars */
	public static int S_tree = 18; /* KMH */
	public static int S_room = 19;
	public static int S_corr = 20;
	public static int S_litcorr = 21;
	public static int S_upstair = 22;
	public static int S_dnstair = 23;
	public static int S_upladder = 24;
	public static int S_dnladder = 25;
	public static int S_altar = 26;
	public static int S_grave = 27;
	public static int S_throne = 28;
	public static int S_sink = 29;
	public static int S_fountain = 30;
	public static int S_pool = 31;
	public static int S_ice = 32;
	public static int S_lava = 33;
	public static int S_vodbridge = 34;
	public static int S_hodbridge = 35;
	public static int S_vcdbridge = 36; /* closed drawbridge, vertical wall */
	public static int S_hcdbridge = 37; /* closed drawbridge, horizontal wall */
	public static int S_air = 38;
	public static int S_cloud = 39;
	public static int S_water = 40;

	/* end dungeon characters, begin traps */

	public static int S_arrow_trap = 41;
	public static int S_dart_trap = 42;
	public static int S_falling_rock_trap = 43;
	public static int S_squeaky_board = 44;
	public static int S_bear_trap = 45;
	public static int S_land_mine = 46;
	public static int S_rolling_boulder_trap = 47;
	public static int S_sleeping_gas_trap = 48;
	public static int S_rust_trap = 49;
	public static int S_fire_trap = 50;
	public static int S_pit = 51;
	public static int S_spiked_pit = 52;
	public static int S_hole = 53;
	public static int S_trap_door = 54;
	public static int S_teleportation_trap = 55;
	public static int S_level_teleporter = 56;
	public static int S_magic_portal = 57;
	public static int S_web = 58;
	public static int S_statue_trap = 59;
	public static int S_magic_trap = 60;
	public static int S_anti_magic_trap = 61;
	public static int S_polymorph_trap = 62;

	/* end traps, begin special effects */

	public static int S_vbeam = 63; /* The 4 zap beam symbols. Do NOT separate. */
	public static int S_hbeam = 64; /* To change order or add, see function */
	public static int S_lslant = 65; /* zapdir_to_glyph() in display.c. */
	public static int S_rslant = 66;
	public static int S_digbeam = 67; /* dig beam symbol */
	public static int S_flashbeam = 68; /* camera flash symbol */
	public static int S_boomleft = 69; /* thrown boomerang, open left, e.g ')' */
	public static int S_boomright = 70; /*
										 * thrown boomerand, open right, e.g.
										 * '('
										 */
	public static int S_ss1 = 71; /* 4 magic shield glyphs */
	public static int S_ss2 = 72;
	public static int S_ss3 = 73;
	public static int S_ss4 = 74;

	/* The 8 swallow symbols. Do NOT separate. To change order or add, see */
	/* the function swallow_to_glyph() in display.c. */
	public static int S_sw_tl = 75; /* swallow top left [1] */
	public static int S_sw_tc = 76; /* swallow top center [2] Order: */
	public static int S_sw_tr = 77; /* swallow top right [3] */
	public static int S_sw_ml = 78; /* swallow middle left [4] 1 2 3 */
	public static int S_sw_mr = 79; /* swallow middle right [6] 4 5 6 */
	public static int S_sw_bl = 80; /* swallow bottom left [7] 7 8 9 */
	public static int S_sw_bc = 81; /* swallow bottom center [8] */
	public static int S_sw_br = 82; /* swallow bottom right [9] */

	public static int S_explode1 = 83; /* explosion top left */
	public static int S_explode2 = 84; /* explosion top center */
	public static int S_explode3 = 85; /* explosion top right Ex. */
	public static int S_explode4 = 86; /* explosion middle left */
	public static int S_explode5 = 87; /* explosion middle center /-\ */
	public static int S_explode6 = 88; /* explosion middle right |@| */
	public static int S_explode7 = 89; /* explosion bottom left \-/ */
	public static int S_explode8 = 90; /* explosion bottom center */
	public static int S_explode9 = 91; /* explosion bottom right */

	/**
	 * A glyph is an abstraction that represents a _unique_ monster, object,
	 * dungeon part, or effect. The uniqueness is important. For example, It is
	 * not enough to have four (one for each "direction") zap beam glyphs, we
	 * need a set of four for each beam type. Why go to so much trouble? Because
	 * it is possible that any given window dependent display driver
	 * [print_glyph()] can produce something different for each type of glyph.
	 * That is, a beam of cold and a beam of fire would not only be different
	 * colors, but would also be represented by different symbols.
	 * 
	 * Glyphs are grouped for easy accessibility:
	 * 
	 * monster Represents all the wild (not tame) monsters. Count: NUMMONS.
	 * 
	 * pet Represents all of the tame monsters. Count: NUMMONS
	 * 
	 * invisible Invisible monster placeholder. Count: 1
	 * 
	 * detect Represents all detected monsters. Count: NUMMONS
	 * 
	 * corpse One for each monster. Count: NUMMONS
	 * 
	 * ridden Represents all monsters being ridden. Count: NUMMONS
	 * 
	 * object One for each object. Count: NUM_OBJECTS
	 * 
	 * cmap One for each entry in the character map. The character map is the
	 * dungeon features and other miscellaneous things. Count: MAXPCHARS
	 * 
	 * explosions A set of nine for each of the following seven explosion types:
	 * dark, noxious, muddy, wet, magical, fiery, frosty. The nine positions
	 * represent those surrounding the hero. Count: MAXEXPCHARS * EXPL_MAX
	 * (EXPL_MAX is defined in hack.h)
	 * 
	 * zap beam A set of four (there are four directions) for each beam type.
	 * The beam type is shifted over 2 positions and the direction is stored in
	 * the lower 2 bits. Count: NUM_ZAP << 2
	 * 
	 * swallow A set of eight for each monster. The eight positions rep- resent
	 * those surrounding the hero. The monster number is shifted over 3
	 * positions and the swallow position is stored in the lower three bits.
	 * Count: NUMMONS << 3
	 * 
	 * warning A set of six representing the different warning levels.
	 * 
	 * The following are offsets used to convert to and from a glyph.
	 */

	/** number of zap beam types */
	public final int NUM_ZAP = 8;

	// TODO(jeffbailey): This number is from pm.h and should be infered from
	// PlayerMonster somehow.
	public final int NUMMONS = 382;

	// TODO(jeffbailey): Likewise from ObjectName
	public final int NUM_OBJECTS = 433;

	/** maximum number of mapped characters */
	public final int MAXPCHARS = 92;
	/** maximum of mapped dungeon characters */
	public final int MAXDCHARS = 41;
	/** maximum of mapped trap characters */
	public final int MAXTCHARS = 22;
	/** maximum of mapped effects characters */
	public final int MAXECHARS = 29;
	/** number of explosion characters */
	public final int MAXEXPCHARS = 9;

	// TODO(jeffbailey): From hack.h
	public final int EXPL_MAX = 7;

	// TODO(jeffbailey): From decl.h
	/** number of different warning levels */
	public final int WARNCOUNT = 6;

	public final int GLYPH_MON_OFF = 0;
	public final int GLYPH_PET_OFF = (NUMMONS + GLYPH_MON_OFF);
	public final int GLYPH_INVIS_OFF = (NUMMONS + GLYPH_PET_OFF);
	public final int GLYPH_DETECT_OFF = (1 + GLYPH_INVIS_OFF);
	public final int GLYPH_BODY_OFF = (NUMMONS + GLYPH_DETECT_OFF);
	public final int GLYPH_RIDDEN_OFF = (NUMMONS + GLYPH_BODY_OFF);
	public final int GLYPH_OBJ_OFF = (NUMMONS + GLYPH_RIDDEN_OFF);
	public final int GLYPH_CMAP_OFF = (NUM_OBJECTS + GLYPH_OBJ_OFF);
	public final int GLYPH_EXPLODE_OFF = ((MAXPCHARS - MAXEXPCHARS) + GLYPH_CMAP_OFF);
	public final int GLYPH_ZAP_OFF = ((MAXEXPCHARS * EXPL_MAX) + GLYPH_EXPLODE_OFF);
	public final int GLYPH_SWALLOW_OFF = ((NUM_ZAP << 2) + GLYPH_ZAP_OFF);
	public final int GLYPH_WARNING_OFF = ((NUMMONS << 3) + GLYPH_SWALLOW_OFF);
	public final int MAX_GLYPH = (WARNCOUNT + GLYPH_WARNING_OFF);

	protected Gbuf gbuf[][];
	protected Flags flags;
	Command command;

	protected Bindery bindery;

	public Display() {
		clear_glyph_buffer();
	}

	/**
	 * This routine assumes that cls() does the following: + fills the physical
	 * screen with the symbol for rock + clears the glyph buffer
	 */
	public void cls() {
		displayNhWindow(WindowType.MESSAGE, false); /* flush messages */
		flags.botlx = true; /* force update of botl window */
		clearNhWindow(WindowType.MAP); /* clear physical screen */

		clear_glyph_buffer(); /* this is sort of an extra effort, but OK */

	}

	public boolean command(final int cmdKey) {
		if (command != null) {
			return command.callback(cmdKey);
		}
		return false;
	}

	@Stub
	public void docrt() {
		if (you.ux == 0) {
			return; /* display isn't ready yet */
		}

		if (you.uswallow) {
			swallowed(true);
			return;
		}
		// if (Underwater && !Is_waterlevel(&u.uz)) {
		// under_water(1);
		// return;
		// }

		if (you.uburied) {
			under_ground(1);
			return;
		}

		/* shut down vision */
		// vision_recalc(2);

		/*
		 * This routine assumes that cls() does the following: + fills the
		 * physical screen with the symbol for rock + clears the glyph buffer
		 */
		cls();

		/* display memory */
		for (int x = 1; x < Webhack.COLNO; x++) {
			for (int y = 0; y < Webhack.ROWNO; y++) {
				final Location ptr = dungeon.getLevel().getLoc(x, y);
				if (ptr.glyph != cmap_to_glyph(S_stone)) {
					show_glyph(x, y, ptr.glyph);
				}
			}
		}

		/* see what is to be seen */
		vision_recalc(0);

		/* overlay with monsters */
		see_monsters();

		bindery.flags.botlx = true; /* force a redraw of the bottom line */

	}

	public void init(final Dungeon dungeon, final You you, final Flags flags) {
		this.dungeon = dungeon;
		this.flags = flags;
		this.you = you;
	}

	/**
	 * Possibly put a new glyph at the given location
	 * 
	 * @param x
	 * @param y
	 */
	public void newsym(final int x, final int y) {
		final Location ptr = dungeon.getLevel().getLoc(x, y);

		// TODO(jeffbailey): stub
		if (x == you.ux && y == you.uy) {
			if (senseself()) {
				map_location(x, y, false); /* map *under* self */
				display_self();
			} else {
				/* we can see what is there */
				map_location(x, y, true);
			}
		} else {
			if (ptr.monster != null) {
				map_location(x, y, false);
				display_monster(x, y, ptr.monster);
			} else {
				map_location(x, y, true);
			}
		}
	}

	@Stub
	public void pline(final String line) {
		putstr(WindowType.MESSAGE, 0, line);
	}

	public abstract void putstr(WindowType window, int i, String line);

	/**
	 * Loops through all of the monsters and update them. Called when: + going
	 * blind & telepathic + regaining sight & telepathic + getting and losing
	 * infravision + hallucinating + doing a full screen redraw + see invisible
	 * times out or a ring of see invisible is taken off + when a potion of see
	 * invisible is quaffed or a ring of see invisible is put on + gaining
	 * telepathy when blind [givit() in eat.c, pleased() in pray.c] + losing
	 * telepathy while blind [xkilled() in mon.c, attrcurse() in sit.c]
	 */
	public void see_monsters() {
		// for (mon = fmon; mon; mon = mon->nmon) {
		// if (DEADMONSTER(mon)) continue;
		// newsym(mon->mx,mon->my);
		// if (mon->wormno) see_wsegs(mon);
		// }
		/* when mounted, hero's location gets caught by monster loop */
		if (you.steed == null) {
			newsym(you.ux, you.uy);
		}
	}

	public void setBindery(final Bindery bindery) {
		this.bindery = bindery;
	}

	public void setCommand(final Command command) {
		this.command = command;
	}

	@Stub
	public void showMapSpot(final int x, final int y) {
		Location lev;

		// if (Confusion && rn2(7)) return;
		lev = dungeon.getLevel().getLoc(x, y);

		lev.seenv = EnumSet.allOf(Display.SeenVector.class);

		/* Secret corridors are found, but not secret doors. */
		if (lev.typ == LocationType.SCORR) {
			lev.typ = LocationType.CORR;
			// unblock_point(x,y);
		}

		/* if we don't remember an object or trap there, map it */
		// if (lev.typ == LocationType.ROOM ?
		// (glyph_is_cmap(lev.glyph) && !glyph_is_trap(lev.glyph) &&
		// glyph_to_cmap(lev.glyph) != ROOM) :
		// (!glyph_is_object(lev.glyph) && !glyph_is_trap(lev.glyph))) {
		// if (level.flags.hero_memory) {
		// magic_map_background(x,y,0);
		newsym(x, y); /* show it, if not blocked */
		// } else {
		// magic_map_background(x,y,1); /* display it */
		// }
		// }
	}

	/*
	 * Returns true if the hero can see her/himself.
	 * 
	 * The u.uswallow check assumes that you can see yourself even if you are
	 * invisible. If not, then we don't need the check.
	 */
	/**
	 * * Do all of the heavy vision work. Recalculate all locations that could
	 * possibly be seen by the hero --- if the location were lit, etc. Note
	 * which locations are actually seen because of lighting. Then add to this
	 * all locations that be seen by hero due to night vision and x-ray vision.
	 * Finally, compare with what the hero was able to see previously. Update
	 * the difference.
	 * 
	 * This function is usually called only when the variable
	 * 'vision_full_recalc' is set. The following is a list of places where this
	 * function is called, with three valid values for the control flag
	 * parameter:
	 * 
	 * Control flag = 0. A complete vision recalculation. Generate the vision
	 * tables from scratch. This is necessary to correctly set what the hero can
	 * see. (1) and (2) call this routine for synchronization purposes, (3)
	 * calls this routine so it can operate correctly.
	 * 
	 * + After the monster move, before input from the player. [moveloop()] + At
	 * end of moveloop. [moveloop() ??? not sure why this is here] + Right
	 * before something is printed. [pline()] + Right before we do a vision
	 * based operation. [do_clear_area()] + screen redraw, so we can renew all
	 * positions in sight. [docrt()]
	 * 
	 * Control flag = 1. An adjacent vision recalculation. The hero has moved
	 * one square. Knowing this, it might be possible to optimize the vision
	 * recalculation using the current knowledge. This is presently
	 * unimplemented and is treated as a control = 0 call.
	 * 
	 * + Right after the hero moves. [domove()]
	 * 
	 * Control flag = 2. Turn off the vision system. Nothing new will be
	 * displayed, since nothing is seen. This is usually done when you need a
	 * newsym() run on all locations in sight, or on some locations but you
	 * don't know which ones.
	 * 
	 * + Before a screen redraw, so all positions are renewed. [docrt()] + Right
	 * before the hero arrives on a new level. [goto_level()] + Right after a
	 * scroll of light is read. [litroom()] + After an option has changed that
	 * affects vision [parseoptions()] + Right after the hero is swallowed.
	 * [gulpmu()] + Just before bubbles are moved. [movebubbles()]
	 */
	public void vision_recalc(final int control) {
		// TODO(jeffbailey): STUB

		// At this point, we're just making everything visible to the hero. Want
		// to make the game playable soonish.

		// for (int y = 0; y < Webhack.ROWNO; y++) {
		// for (int x = 0; x < Webhack.COLNO; x++) {
		// final Location ptr = dungeon.getLevel().getLoc(x, y);
		// if (ptr.typ != LocationType.STONE) {
		// newsym(x, y);
		// }
		// }
		// }
		newsym(you.ux, you.uy);
	}

	/**
	 * Use the information in the rm structure at the given position to create a
	 * glyph of a background.
	 * 
	 * I had to add a field in the rm structure (horizontal) so that we knew if
	 * open doors and secret doors were horizontal or vertical. Previously, the
	 * screen symbol had the horizontal/vertical information set at level
	 * generation time.
	 * 
	 * I used the 'ladder' field (really doormask) for deciding if stairwells
	 * were up or down. I didn't want to check the upstairs and dnstairs
	 * variables.
	 */
	int back_to_glyph(final int x, final int y) {
		int idx;
		final Location ptr = dungeon.getLevel().getLoc(x, y);

		switch (ptr.typ) {
		case SCORR:
		case STONE:
			idx = dungeon.getLevel().arboreal ? S_tree : S_stone;
			break;
		case ROOM:
			idx = S_room;
			break;
		case CORR:
			idx = (ptr.waslit || flags.lit_corridor) ? S_litcorr : S_corr;
			break;
		case HWALL:
		case VWALL:
		case TLCORNER:
		case TRCORNER:
		case BLCORNER:
		case BRCORNER:
		case CROSSWALL:
		case TUWALL:
		case TDWALL:
		case TLWALL:
		case TRWALL:
		case SDOOR:
			/* TODO(jeffbailey): don't force this! */
			ptr.seenv = EnumSet.allOf(Display.SeenVector.class);
			idx = !ptr.seenv.isEmpty() ? wall_angle(ptr) : S_stone;
			break;
		case DOOR:
			switch (ptr.doormask) {
			case BROKEN:
			case NODOOR:
				idx = S_ndoor;
				break;
			case ISOPEN:
				idx = (ptr.horizontal) ? S_hodoor : S_vodoor;
				break;
			default:
				idx = (ptr.horizontal) ? S_hcdoor : S_vcdoor;
				break;
			}
			break;
		case IRONBARS:
			idx = S_bars;
			break;
		case TREE:
			idx = S_tree;
			break;
		case POOL:
		case MOAT:
			idx = S_pool;
			break;
		case STAIRS:
			idx = (ptr.ladder == LocationType.Ladder.DOWN) ? S_dnstair
					: S_upstair;
			break;
		case LADDER:
			idx = (ptr.ladder == LocationType.Ladder.DOWN) ? S_dnladder
					: S_upladder;
			break;
		case FOUNTAIN:
			idx = S_fountain;
			break;
		case SINK:
			idx = S_sink;
			break;
		case ALTAR:
			idx = S_altar;
			break;
		case GRAVE:
			idx = S_grave;
			break;
		case THRONE:
			idx = S_throne;
			break;
		case LAVAPOOL:
			idx = S_lava;
			break;
		case ICE:
			idx = S_ice;
			break;
		case AIR:
			idx = S_air;
			break;
		case CLOUD:
			idx = S_cloud;
			break;
		case WATER:
			idx = S_water;
			break;
		case DBWALL:
			idx = (ptr.horizontal) ? S_hcdbridge : S_vcdbridge;
			break;
		// TODO(jeffbailey):
		// case DRAWBRIDGE_UP:
		// switch(ptr.drawbridgemask & DB_UNDER) {
		// case DB_MOAT: idx = S_pool; break;
		// case DB_LAVA: idx = S_lava; break;
		// case DB_ICE: idx = S_ice; break;
		// case DB_FLOOR: idx = S_room; break;
		// default:
		// impossible("Strange db-under: %d",
		// ptr.drawbridgemask & DB_UNDER);
		// idx = S_room; /* something is better than nothing */
		// break;
		// }
		// break;
		case DRAWBRIDGE_DOWN:
			idx = (ptr.horizontal) ? S_hodbridge : S_vodbridge;
			break;

		default:
			idx = S_room;
			break;

		}

		// TODO(jeffbailey): STUB
		return cmap_to_glyph(idx);
	}

	/**
	 * Returns true if the hero can see her/himself.
	 * 
	 * The u.uswallow check assumes that you can see yourself even if you are
	 * invisible. If not, then we don't need the check.
	 */
	boolean canseeself() {
		// TODO(jeffbailey): stub
		// return Blind || u.uswallow || (!Invisible && !u.uundetected)
		return true;
	}

	int cmap_to_glyph(final int cmap_idx) {
		return cmap_idx + GLYPH_CMAP_OFF;
	}

	void display_self() {
		// TODO(jeffbailey): STUB
		show_glyph(you.ux, you.uy, monnum_to_glyph(you.umonnum.idx));
	}

	/**
	 * Sync the third screen with the display.
	 * 
	 * @param cursorOnYou
	 *            if the cursor should be placed on the Character
	 */
	void flush_screen(final boolean cursorOnYou) {

	}

	/**
	 * Make the real background part of our map. This routine assumes that the
	 * hero can physically see the location. Update the screen if directed.
	 */
	void map_background(final int x, final int y, final boolean show) {
		final int glyph = back_to_glyph(x, y);

		if (dungeon.getLevel().hero_memory) {
			dungeon.getLevel().getLoc(x, y).glyph = glyph;
		}
		if (show) {
			show_glyph(x, y, glyph);
		}
	}

	/**
	 * Maps the given object. This routine assumes that the hero can physically
	 * see the location of the object. Update the screen if directed.
	 */
	void map_object(final Obj thingloc, final boolean show) {
		final int x = thingloc.x, y = thingloc.y;
		final int glyph = obj_to_glyph(thingloc);

		// if (level.flags.hero_memory)
		// levl[x][y].glyph = glyph;
		if (show) {
			show_glyph(x, y, glyph);
		}
	}

	@Stub
	int mon_to_glyph(final Monster monster) {
		return monster.idx + GLYPH_MON_OFF;
	}

	int monnum_to_glyph(final int idx) {
		return idx + GLYPH_MON_OFF;
	}

	@Stub
	int obj_to_glyph(final Obj thingloc) {
		return thingloc.otyp.idx + GLYPH_OBJ_OFF;
	}

	/**
	 * Returns true if the hero can sense her/himself.
	 */
	boolean senseself() {
		// TODO(jeffbailey): stub
		// return canseeself() || Unblind_telepat || Detect_monsters
		return true;
	}

	void show_glyph(final int x, final int y, final int glyph) {
		// TODO(jeffbailey): STUB
		if (gbuf[y][x].glyph != glyph) {
			gbuf[y][x].glyph = glyph;
			gbuf[y][x].updated = true;
		}

	}

	/**
	 * The hero is swallowed. Show a special graphics sequence for this. This
	 * bypasses all of the display routines and messes with buffered screen
	 * directly. This method works because both vision and display check for
	 * being swallowed.
	 * 
	 * @param first
	 *            if should refresh whole screen.
	 */
	void swallowed(final boolean first) {
		// TODO(jeffbailey): STUB
	}

	/**
	 * Very restricted display. You can only see yourself.
	 * 
	 * @param mode
	 */
	void under_ground(final int mode) {
		// TODO(jeffbailey): STUB
	}

	Obj vobj_at(final int x, final int y) {
		// TODO(jeffbailey): STUB, handle invisibility
		final Location ptr = dungeon.getLevel().getLoc(x, y);

		if (ptr.things.size() == 0) {
			return null;
		}

		for (final Obj thingloc : ptr.things) {
			return thingloc;
		}

		return null;
	}

	/**
	 * Turns the 3rd screen into stone.
	 */
	private void clear_glyph_buffer() {
		gbuf = new Gbuf[Webhack.ROWNO][Webhack.COLNO];
		for (int y = 0; y < Webhack.ROWNO; y++) {
			for (int x = 0; x < Webhack.COLNO; x++) {
				gbuf[y][x] = new Gbuf();
			}
		}
	}

	/**
	 * Note that this is *not* a map_XXXX() function! Monsters sort of float
	 * above everything.
	 * 
	 * Yuck. Display body parts by recognizing that the display position is not
	 * the same as the monster position. Currently the only body part is a worm
	 * tail.
	 */
	@Stub
	private void display_monster(final int x, final int y, final Monster mon) {
		show_glyph(x, y, mon_to_glyph(mon));
	}

	/**
	 * Make whatever at this location show up. This is only for non-living
	 * things. This will not handle feeling invisible objects correctly.
	 */
	private void map_location(final int x, final int y, final boolean show) {
		// TODO(jeffbailey): STUB
		Obj thingloc;
		if ((thingloc = vobj_at(x, y)) != null) {
			map_object(thingloc, show);
			return;
		}
		map_background(x, y, show);
	}

	/**
	 * Returns the correct graphics character index using wall type, wall mode,
	 * and the seen vector. It is expected that seenv is non zero.
	 * 
	 * All T-wall vectors are rotated to be TDWALL. All single crosswall blocks
	 * are rotated to bottom right. All double crosswall are rotated to
	 * W_X_BLTR. All results are converted back.
	 * 
	 * The only way to understand this is to take out pen and paper and draw
	 * diagrams. See rm.h for more details on the wall modes and seen vector
	 * (SV).
	 */
	@Stub
	private int wall_angle(final Location lev) {
		switch (lev.typ) {
		case TUWALL:

		case SDOOR:
			// TODO(jeffbailey): if (lev.horizontal) goto horiz;
			/* fall through */

		case VWALL:
			return S_vwall;

		case HWALL:
			return S_hwall;

		default:
			return S_stone;
		}
	}

}
