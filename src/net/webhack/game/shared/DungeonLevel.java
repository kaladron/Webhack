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
public class DungeonLevel {
	/** Number of rooms */
	private int nroom = 0;
	Room[] rooms = new Room[Webhack.MAXNROFROOMS];

	private int subroom = 0;

	/** Number of doors */
	private int doorIndex = 0;

	/** Coordinates of down stairs */
	private Coordinate dnstair;

	/** Coordinates of up stairs */
	private Coordinate upstair;

	private final RandomHelper random;
	
	/** Rectangles for making room. */
	private final Rectangles rectangles;
	
	public DungeonLevel(final RandomHelper random) {
		this.random = random;
		this.rectangles = new Rectangles(random);

		makeLevel();
	}

	private void makeLevel() {
		makeRooms();
	}

	/**
	 * @param lowx
	 * @param lowy
	 * @param hix
	 * @param hiy
	 * @param lit
	 * @param rtype
	 * @param special
	 */
	private void addRoom(Room aRoom) {
		rooms[nroom] = aRoom;
		nroom++;
	}

	private void makeRooms() {
		boolean tried_vault = false;

		// make rooms until satisfied.
		// rnd_rect() will return 0 if no more rects are available...

		while (nroom < Webhack.MAXNROFROOMS && (rectangles.rndRect() != null)) {
			if (nroom >= (Webhack.MAXNROFROOMS / 6) && (random.rn2(2) != 0)
					&& !tried_vault) {
				tried_vault = true;
				// TODO(jeffbailey): Create_vault stuff goes here.
			} else {
				addRoom(new Room(rectangles, Room.OROOM));
				return;
				// }
			}
		}
		return;

	}
}
