/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.Random;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class WebhackRandom implements RandomHelper {

	private final Random random = new Random();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#d(int, int)
	 */
	public int d(final int n, final int x) {
		int tmp = 0;
		for (int i = n; i >= 0; i--) {
			tmp += random.nextInt(x);
		}
		return tmp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#oneIn(int)
	 */
	public boolean oneIn(final int x) {
		return rn2(x) == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#rn1(int)
	 */
	public int rn1(final int x, final int y) {
		return random.nextInt(x) + y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#rn2(int)
	 */
	public int rn2(final int x) {
		return random.nextInt(x);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#rnd(int)
	 */
	public int rnd(final int x) {
		return random.nextInt(x) + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#rne(int)
	 */
	public int rne(final int x) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#rnl(int)
	 */
	public int rnl(final int x) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.webhack.game.shared.RandomHelper#rnz(int)
	 */
	public int rnz(final int i) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

}
