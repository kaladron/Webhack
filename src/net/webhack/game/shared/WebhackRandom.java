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
	
	private Random random = new Random(); 
	
	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#rn1(int)
	 */
	public int rn1(int x, int y) {
		return random.nextInt(x) + y;
	}

	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#rn2(int)
	 */
	public int rn2(int x) {
        return random.nextInt(x);
	}

	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#rnl(int)
	 */
	public int rnl(int x) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#rnd(int)
	 */
	public int rnd(int x) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#d(int, int)
	 */
	public int d(int n, int x) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#rne(int)
	 */
	public int rne(int x) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see net.webhack.game.shared.RandomHelper#rnz(int)
	 */
	public int rnz(int i) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

}
