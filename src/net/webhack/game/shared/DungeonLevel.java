/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.Random;

import com.google.gwt.user.client.Window;

/**
 * Routines defining a level within a Webhack Dungeon
 * 
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DungeonLevel {
	/** Number of rooms */
	private int nroom = 0;

	private int subroom = 0;

	/** Number of doors */
	private int doorIndex = 0;

	/** Coordinates of down stairs */
	private Coordinate dnstair;

	/** Coordinates of up stairs */
	private Coordinate upstair;
	
	/** Rectangles for making room. */
	private Rectangles rectangles = new Rectangles();

	public DungeonLevel() {
		makeLevel();
	}

	private void makeLevel() {
		makeRooms();
	}

	private void makeRooms() {
		boolean tried_vault = false;
		Random rand = new Random();
		
		// make rooms until satisfied.
		// rnd_rect() will return 0 if no more rects are available...

		while (nroom < Webhack.MAXNROFROOMS && (rectangles.rndRect() != null)) {
			if (nroom >= (Webhack.MAXNROFROOMS / 6) && (rand.nextInt(2) != 0)
					&& !tried_vault) {
				tried_vault = true;
				// TODO(jeffbailey): Create_vault stuff goes here.
			} else {
				Room aRoom = new Room(Room.OROOM);
				// add_room
				return;
				// }
			}
		}
		return;

	}
}
