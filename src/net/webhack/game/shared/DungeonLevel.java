/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * Routines defining a level within a Webhack Dungeon
 * 
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DungeonLevel implements LocationMap {

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
	static int STONE = 0;
	static int VWALL = 1;
	static int HWALL = 2;
	static int TLCORNER = 3;
	static int TRCORNER = 4;
	static int BLCORNER = 5;
	static int BRCORNER = 6;
	static int CROSSWALL = 7; /* For pretty mazes and special levels */
	static int TUWALL = 8;
	static int TDWALL = 9;
	static int TLWALL = 10;
	static int TRWALL = 11;
	static int DBWALL = 12;
	static int TREE = 13; /* KMH */
	static int SDOOR = 14;
	static int SCORR = 15;
	static int POOL = 16;
	static int MOAT = 17; /* pool that doesn't boil, adjust messages */
	static int WATER = 18;
	static int DRAWBRIDGE_UP = 19;
	static int LAVAPOOL = 20;
	static int IRONBARS = 21; /* KMH */
	static int DOOR = 22;
	static int CORR = 23;
	static int ROOM = 24;
	static int STAIRS = 25;
	static int LADDER = 26;
	static int FOUNTAIN = 27;
	static int THRONE = 28;
	static int SINK = 29;
	static int GRAVE = 30;
	static int ALTAR = 31;
	static int ICE = 32;
	static int DRAWBRIDGE_DOWN = 33;
	static int AIR = 34;
	static int CLOUD = 35;
	static int MAX_TYPE = 36;
	static int INVALID_TYPE = 127;

	Location[][] locations = new Location[Webhack.COLNO][Webhack.ROWNO];
	
	public Location getLoc(int x, int y) {
		return locations[x][y];
	}
	
	/** Number of doors */
	private int doorIndex = 0;

	/** Coordinates of down stairs */
	private Coordinate dnstair;

	/** Coordinates of up stairs */
	private Coordinate upstair;

	private final RandomHelper random;

	/** Rectangles for making room. */
	private final Rectangles rectangles;

	/** References to Rooms. */
	private Rooms rooms;

	public DungeonLevel(final RandomHelper random) {
		this.random = random;
		this.rectangles = new Rectangles(random);

		for (int x = 0; x < Webhack.COLNO; x++) {
			for (int y = 0; y < Webhack.ROWNO; y++) {
				locations[x][y] = new Location();
			}
		}

		makeLevel();
	}

	private void makeLevel() {
		rooms = new Rooms(rectangles, random, this);
		
		dumpLevelMap();
	}
		
	private void dumpLevelMap() {
		for (int y = 0; y < Webhack.ROWNO; y++) {
			for (int x = 0; x < Webhack.COLNO; x++) {
				if (locations[x][y].typ < 10) {
					System.out.print('0');
				}
				System.out.print(locations[x][y].typ);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

}
