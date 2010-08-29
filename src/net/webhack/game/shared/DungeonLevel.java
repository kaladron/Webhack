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

		makeLevel();
	}

	private void makeLevel() {
		rooms = new Rooms(rectangles, random);
	}


}
