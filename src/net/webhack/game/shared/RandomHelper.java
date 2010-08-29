/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public interface RandomHelper {

	/** (rn2(x)+(y)) */
	int rn1(int x, int y);
	
	/** 0 <= rn2(x) < x */
	int rn2(int x);

	/**
	 * 0 <= rnl(x) < x; sometimes subtracting Luck
	 * 
	 * good luck approaches 0, bad luck approaches (x-1)
	 */
	int rnl(int x);

	/** 1 <= rnd(x) <= x */
	int rnd(int x);

	/** n <= d(n,x) <= (n*x) */
	int d(int n, int x);

	int rne(int x);

	int rnz(int i);
}
