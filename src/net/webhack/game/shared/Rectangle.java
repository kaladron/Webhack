/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * Rectangles used for creating rooms or regions in a level.
 * 
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Rectangle {
	public int lowX;
	public int lowY;
	public int highX;
	public int highY;

	Rectangle() {
	}
	
	Rectangle(int lx, int ly, int hx, int hy) {
		this.lowX = lx;
		this.lowY = ly;
		this.highX = hx;
		this.highY = hy;
	}

	Rectangle(Rectangle aRectangle) {
		this.lowX = aRectangle.lowX;
		this.lowY = aRectangle.lowY;
		this.highX = aRectangle.highX;
		this.highY = aRectangle.highY;
	}

	/*
	 * Implementation of Equals for Rectangle.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Rectangle)) {
			return false;
		}
		Rectangle r = (Rectangle) obj;
		return (this.lowX == r.lowX && this.lowY == r.lowY && this.highX == r.highX && this.highY == r.highY);
	}
	
	public String toString() {
		String out = "lowX: " + lowX;
		out += " lowY: " + lowY;
		out += " highX: " + highX;
		out += " highY: " + highY;
		return out;
	}

}
