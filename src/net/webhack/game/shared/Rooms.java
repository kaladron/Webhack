/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Rooms {

	private final Rectangles rectangles;
	Rooms[] rooms = new Rooms[Webhack.MAXNROFROOMS];

	/** Number of rooms */
	private int nroom = 0;

	private int subroom = 0;

	private RandomHelper random;

	public Rooms(Rectangles rectangles, RandomHelper random) {
		this.rectangles = rectangles;
		this.random = random;
		boolean tried_vault = false;

		// make rooms until satisfied.
		// rnd_rect() will return 0 if no more rects are available...

		while (nroom < Webhack.MAXNROFROOMS && (rectangles.rndRect() != null)) {
			if (nroom >= (Webhack.MAXNROFROOMS / 6) && (random.rn2(2) != 0)
					&& !tried_vault) {
				tried_vault = true;
				// TODO(jeffbailey): Create_vault stuff goes here.
			} else {
                if (!createRoom(-1, -1, -1, -1, -1, -1, Room.OROOM, null)) {
                    return;
				}
			}
		}
		return;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param xal
	 * @param yal
	 * @param rtype
	 *            Room type
	 * @param rlit
	 *            Is the room lit
	 */
	public boolean createRoom(int x, int y, int w, int h, int xal, int yal,
			int rtype, Boolean rlit) {
		Rectangle r1 = null;
		Rectangle r2 = null;
		int trycnt = 0;
		boolean vault = false;
		int wtmp;
		int htmp;
		int xlim = Webhack.XLIM;
		int ylim = Webhack.YLIM;
		int xabs = -1;
		int yabs = -1;

		System.out.println("1");
		
		if (rtype == -1) {
			rtype = Room.OROOM;
		}

		if (rtype == Room.VAULT) {
			vault = true;
			xlim++;
			ylim++;
		}

		/* on low levels the room is lit (usualy) */
		/* some other rooms may require lighting */

		/* is light state random ? */
		if (rlit == null) {
			// TODO(jeffbailey): Handle lighting.
			rlit = true;
		}

		System.out.println("2");

		
		/*
		 * Here we will try to create a room. If some parameters are random we
		 * are willing to make several try before we give it up.
		 */
		do {
			wtmp = w;
			htmp = h;
			int xtmp = x;
			int ytmp = y;
			int xaltmp = xal;
			int yaltmp = yal;
			int xborder;
			int yborder;

			/* First case : a totaly random room */

			if ((xtmp < 0 && ytmp < 0 && wtmp < 0 && xaltmp < 0 && yaltmp < 0)
					|| vault) {
				int dx;
				int dy;
				r1 = rectangles.rndRect();

				if (r1 == null) { // No more free rectangles!
					System.out.println("No more rects...");
					return false;
				}
				int hx = r1.hx;
				int hy = r1.hy;
				int lx = r1.lx;
				int ly = r1.ly;
				if (vault) {
					dx = dy = 1;
				} else {
					dx = 2 + random.rn2((hx - lx > 28) ? 12 : 8);
					dy = 2 + random.rn2(4);
					if (dx * dy > 50)
						dy = (int) Math.floor(50 / dx);
				}
				xborder = (lx > 0 && hx < Webhack.COLNO - 1) ? 2 * xlim
						: xlim + 1;
				yborder = (ly > 0 && hy < Webhack.ROWNO - 1) ? 2 * ylim
						: ylim + 1;
				if (hx - lx < dx + 3 + xborder || hy - ly < dy + 3 + yborder) {
					r1 = null;
					continue;
				}
				xabs = lx + (lx > 0 ? xlim : 3)
						+ random.rn2(hx - (lx > 0 ? lx : 3) - dx - xborder + 1);
				yabs = ly + (ly > 0 ? ylim : 2)
						+ random.rn2(hy - (ly > 0 ? ly : 2) - dy - yborder + 1);
				if (ly == 0 && hy >= (Webhack.ROWNO - 1)
						&& (nroom == 0 || random.rn2(nroom) == 0)
						&& (yabs + dy > Webhack.ROWNO / 2)) {
					yabs = random.rn1(3, 2);
					if (nroom < 4 && dy > 1)
						dy--;
				}
				if (!checkRoom(xabs, dx, yabs, dy, vault)) {
					r1 = null;
					continue;
				}
				wtmp = dx + 1;
				htmp = dy + 1;
				r2 = new Rectangle(xabs - 1, yabs - 1, xabs + wtmp, yabs + htmp);
			} // Only some parameters are random.
		} while (++trycnt <= 100 && r1 == null);

		System.out.println("3");
		
		if (r1 == null) {
			return false;
		}

		rectangles.splitRects(r1, r2);

		System.out.println("4");

		
		if (!vault) {
			addRoom(xabs, yabs, xabs + wtmp - 1, yabs + htmp - 1, rlit, rtype,
					false);
		}
		return true;

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
	private void addRoom(int lowx, int lowy, int hix, int hiy, boolean lit,
			int rtype, boolean special) {
		System.out.println(lowx);
		System.out.println(lowy);
		System.out.println(hix);
		System.out.println(hiy);
		System.out.println(lit);
		System.out.println(rtype);
		System.out.println(special);
		
        // do_room_or_subroom(rooms[nroom], lowx, lowy, hix, hiy, lit, rtype, special, true);
	}

	private void makeRooms() {
	}

	private boolean checkRoom(int a, int b, int c, int d, boolean e) {
		// TODO(jeffbailey): Stub
		return true;
	}
}
