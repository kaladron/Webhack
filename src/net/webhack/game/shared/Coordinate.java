/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 *
 */
public class Coordinate {
	/** X Coordinate */
	public int x;
	
	/** Y Coordinate */
	public int y;
	
	/** Default constructor */
	public Coordinate() { }
	
	/**
	 * 
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param c Coordinate from which to copy.
	 */
	public Coordinate(Coordinate c) {
		this.x = c.x;
		this.y = c.y;
	}
	
	@Override
	public String toString() {
		return "X: " + x + " Y: " + y;
	}
}
