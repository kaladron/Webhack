package net.webhack.game.shared;

public abstract class Display implements WebhackUI {

	protected Dungeon dungeon;

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

	public void init(Dungeon dungeon) {
		dungeon = this.dungeon;
	}

	/**
	 * Make the real background part of our map. This routine assumes that the
	 * hero can physically see the location. Update the screen if directed.
	 */
	void map_background(int x, int y, boolean show) {
		int glyph = back_to_glyph(x, y);

		if (dungeon.getLevel().hero_memory)
			dungeon.getLevel().getLoc(x, y).glyph = glyph;
		if (show)
			show_glyph(x, y, glyph);
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
	int back_to_glyph(int x, int y) {
		int idx;
		Location ptr = dungeon.getLevel().getLoc(x, y);

		switch (ptr.typ) {
		case SCORR:
		case STONE:
			idx = dungeon.getLevel().arboreal ? S_tree : S_stone;
			break;
			
        case ROOM:              idx = S_room;     break;
        //TODO(jeffbailey):
        //case CORR:
        //    idx = (ptr.waslit || dungeon.getLevel().lit_corridor) ? S_litcorr : S_corr;
        //    break;
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
        //TODO(jeffbailey):
        //case SDOOR:
        //    idx = ptr.seenv ? wall_angle(ptr) : S_stone;
        //    break;
        //case DOOR:
        //    if (ptr.doormask) {
        //        if (ptr.doormask & D_BROKEN)
        //            idx = S_ndoor;
        //        else if (ptr.doormask & D_ISOPEN)
        //            idx = (ptr.horizontal) ? S_hodoor : S_vodoor;
        //        else                    /* else is closed */
        //            idx = (ptr.horizontal) ? S_hcdoor : S_vcdoor;
        //    } else
        //        idx = S_ndoor;
        //    break;
        case IRONBARS:  idx = S_bars;     break;
        case TREE:              idx = S_tree;     break;
        case POOL:
        case MOAT:              idx = S_pool;     break;
        // TODO(jeffbailey):
        //case STAIRS:
        //    idx = (ptr.ladder & LA_DOWN) ? S_dnstair : S_upstair;
        //    break;
        //case LADDER:
        //    idx = (ptr.ladder & LA_DOWN) ? S_dnladder : S_upladder;
        //    break;
        case FOUNTAIN:          idx = S_fountain; break;
        case SINK:              idx = S_sink;     break;
        case ALTAR:             idx = S_altar;    break;
        case GRAVE:             idx = S_grave;    break;
        case THRONE:            idx = S_throne;   break;
        case LAVAPOOL:          idx = S_lava;     break;
        case ICE:               idx = S_ice;      break;
        case AIR:               idx = S_air;      break;
        case CLOUD:             idx = S_cloud;    break;
        case WATER:             idx = S_water;    break;
        case DBWALL:
            idx = (ptr.horizontal) ? S_hcdbridge : S_vcdbridge;
            break;
        //TODO(jeffbailey):    
        //case DRAWBRIDGE_UP:
        //    switch(ptr.drawbridgemask & DB_UNDER) {
        //    case DB_MOAT:  idx = S_pool; break;
        //    case DB_LAVA:  idx = S_lava; break;
        //    case DB_ICE:   idx = S_ice;  break;
        //    case DB_FLOOR: idx = S_room; break;
        //    default:
        //        impossible("Strange db-under: %d",
        //                   ptr.drawbridgemask & DB_UNDER);
        //        idx = S_room; /* something is better than nothing */
        //        break;
        //    }
        //    break;
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

	void show_glyph(int x, int y, int glyph) {
		// TODO(jeffbailey): STUB
	}

	int cmap_to_glyph(int cmap_idx) {
		return cmap_idx + GLYPH_CMAP_OFF;
	}

}
