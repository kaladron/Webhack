/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public enum LocationType {
	/**
	 * <pre>
	 * TLCORNER     TDWALL          TRCORNER
	 * +-           -+-             -+
	 * |             |               |
	 * 
	 * TRWALL       CROSSWALL       TLWALL          HWALL
	 * |             |               |
	 * +-           -+-             -+              ---
	 * |             |               |
	 * 
	 * BLCORNER     TUWALL          BRCORNER        VWALL
	 * |             |               |              |
	 * +-           -+-             -+              |
	 * </pre>
	 */
	/* Level location types */
	STONE,

	VWALL,

	HWALL, TLCORNER,

	TRCORNER,

	BLCORNER,

	BRCORNER,

	CROSSWALL, /*
				 * For pretty mazes and special levels
				 */
	TUWALL,

	TDWALL,

	TLWALL,

	TRWALL,

	DBWALL,

	TREE, /* KMH */

	SDOOR,

	SCORR,

	// Everything before this is considered "rock"

	POOL,
	/** pool that doesn't boil, adjust messages */
	MOAT, WATER, DRAWBRIDGE_UP, LAVAPOOL, IRONBARS, /* KMH */
	DOOR, CORR, ROOM, STAIRS, LADDER, FOUNTAIN, THRONE, SINK, GRAVE, ALTAR, ICE, DRAWBRIDGE_DOWN, AIR, CLOUD, MAX_TYPE, INVALID_TYPE;

	public enum Door {
		NODOOR, BROKEN, ISOPEN, CLOSED, LOCKED, TRAPPED;
	}

	public enum Ladder {
		UP, DOWN;
	}

	public boolean isRock() {
		if (compareTo(POOL) < 0) {
			return true;
		}
		return false;
	}
}
