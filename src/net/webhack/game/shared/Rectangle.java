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
	public int lx;
	public int ly;
	public int hx;
	public int hy;

	Rectangle() {
	}
	
	Rectangle(Rectangle aRectangle) {
		this.lx = aRectangle.lx;
		this.ly = aRectangle.ly;
		this.hx = aRectangle.hx;
		this.hy = aRectangle.hy;
	}

	Rectangle(int lx, int ly, int hx, int hy) {
		this.lx = lx;
		this.ly = ly;
		this.hx = hx;
		this.hy = hy;
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
		return (this.lx == r.lx && this.ly == r.ly && this.hx == r.hx && this.hy == r.hy);
	}
	
	public String toString() {
		String out = "lx: " + lx;
		out += " ly: " + ly;
		out += " hx: " + hx;
		out += " hy: " + hy;
		return out;
	}

}
