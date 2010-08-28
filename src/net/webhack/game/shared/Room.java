/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Room {

	/** Ordinary Room */
	public static int OROOM = 0;

	/** Contains a throne */
	public static int COURT = 2;

	/** contains pools */
	public static int SWAMP = 3;

	/** contains piles of gold */
	public static int VAULT = 4;

	/** contains killer bees and royal jelly */
	public static int BEEHIVE = 5;

	/** contains corpses, undead and ghosts */
	public static int MORGUE = 6;

	/* contains soldiers and their gear */
	public static int BARRACKS = 7;

	/** floor covered with treasure and monsters */
	public static int ZOO = 8;

	/** contains Oracle and peripherals */
	public static int DELPHI = 9;

	/** contains a shrine */
	public static int TEMPLE = 10;

	/** leprechaun hall (Tom Proudfoot) */
	public static int LEPREHALL = 11;

	/** cockatrice nest (Tom Proudfoot) */
	public static int COCKNEST = 12;

	/** ants (Tom Proudfoot) */
	public static int ANTHOLE = 13;

	/** everything above this is a shop */
	public static int SHOPBASE = 14;

	/** specific shop defines for level compiler */
	public static int ARMORSHOP = 15;

	public static int SCROLLSHOP = 16;

	public static int POTIONSHOP = 17;

	public static int WEAPONSHOP = 18;

	public static int FOODSHOP = 19;

	public static int RINGSHOP = 20;

	public static int WANDSHOP = 21;

	public static int TOOLSHOP = 22;

	public static int BOOKSHOP = 23;

	/** shops here & above not randomly gen'd. */
	public static int UNIQUESHOP = 24;

	public static int CANDLESHOP = 24;

	/** maximum valid room type */
	public static int MAXRTYPE = 24;

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
	public Room(Rectangles rectangles, int x, int y, int w, int h, int xal,
			int yal, int rtype, Boolean rlit) {
		Rectangle r1;
		Rectangle r2;
		int trycnt = 0;
		boolean vault = false;
		int xlim = Webhack.XLIM;
		int ylim = Webhack.YLIM;
		int xabs;
		int yabs;

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
		if (rlit = null) {
			// TODO(jeffbailey): Handle lighting.
			rlit = true;
		}

		/*
		 * Here we will try to create a room. If some parameters are random we
		 * are willing to make several try before we give it up.
		 */
		do {
			int wtmp = w;
			int htmp = h;
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
					dx = 2 + webhack.rn2((hx - lx > 28) ? 12 : 8);
					dy = 2 + webhack.rn2(4);
					if (dx * dy > 50)
						dy = (int) Math.floor(50 / dx);
				}
				xborder = (lx > 0 && hx < Webhack.COLNO - 1) ? 2 * xlim
						: xlim + 1;
				yborder = (ly > 0 && hy < Webhack.ROWNO - 1) ? 2 * ylim
						: ylim + 1;
				if (hx - lx < dx + 3 + xborder || hy - ly < dy + 3 + yborder) {
					r1 = 0;
					continue;
				}
				xabs = lx
						+ (lx > 0 ? xlim : 3)
						+ webhack
								.rn2(hx - (lx > 0 ? lx : 3) - dx - xborder + 1);
				yabs = ly
						+ (ly > 0 ? ylim : 2)
						+ webhack
								.rn2(hy - (ly > 0 ? ly : 2) - dy - yborder + 1);
				if (ly == 0 && hy >= (Webhack.ROWNO - 1)
						&& (!webhack.nroom || !webhack.rn2(webhack.nroom))
						&& (yabs + dy > Webhack.ROWNO / 2)) {
					yabs = webhack.rn1(3, 2);
					if (webhack.nroom < 4 && dy > 1)
						dy--;
				}
				if (!webhack.check_room(xabs, dx, yabs, dy, vault)) {
					r1 = 0;
					continue;
				}
				wtmp = dx + 1;
				htmp = dy + 1;
				r2 = new rectangles.nhrect(xabs - 1, yabs - 1, xabs + wtmp, yabs
						+ htmp);
			} // Only some parameters are random.
		} while (++trycnt <= 100 && !r1);

		if (r1 == null) {
			return false;
		}

		rectangles.splitRects(r1, r2);

		if (!vault) {

		}
		return;

	}

	/**
	 * Constructor for all random option room, the most common type.
	 * 
	 * @param rtype
	 */
	public Room(Rectangles rectangles, int rtype) {
		this(rectangles, -1, -1, -1, -1, -1, -1, rtype, null);
	}

}
