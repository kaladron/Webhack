/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.Collections;
import java.util.Vector;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Rooms {

	private final Rectangles rectangles;
	Vector<Room> rooms = new Vector<Room>();

	/** Token to determine if room is part of the mesh. */
	int[] smeq = new int[Webhack.MAXNROFROOMS];

	private final int doorindex = 0;

	private final RandomHelper random;

	private final LocationMap locMap;

	public Rooms(final Rectangles rectangles, final RandomHelper random,
			final LocationMap lmap) {
		this.rectangles = rectangles;
		this.random = random;
		this.locMap = lmap;

		makeRooms();
		sortRooms();
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
	public boolean createRoom(final int x, final int y, final int w,
			final int h, final int xal, final int yal, int rtype, Boolean rlit) {
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

		/*
		 * Here we will try to create a room. If some parameters are random we
		 * are willing to make several try before we give it up.
		 */
		do {
			wtmp = w;
			htmp = h;
			final int xtmp = x;
			final int ytmp = y;
			final int xaltmp = xal;
			final int yaltmp = yal;
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
				final int hx = r1.highX;
				final int hy = r1.highY;
				final int lx = r1.lowX;
				final int ly = r1.lowY;
				if (vault) {
					dx = dy = 1;
				} else {
					dx = 2 + random.rn2((hx - lx > 28) ? 12 : 8);
					dy = 2 + random.rn2(4);
					if (dx * dy > 50) {
						dy = (int) Math.floor(50 / dx);
					}
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
						&& (rooms.size() == 0 || random.rn2(rooms.size()) == 0)
						&& (yabs + dy > Webhack.ROWNO / 2)) {
					yabs = random.rn1(3, 2);
					if (rooms.size() < 4 && dy > 1) {
						dy--;
					}
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

		if (r1 == null) {
			return false;
		}

		rectangles.splitRects(r1, r2);

		if (!vault) {
			smeq[rooms.size()] = rooms.size();
			addRoom(xabs, yabs, xabs + wtmp - 1, yabs + htmp - 1, rlit, rtype,
					false);
		}
		return true;

	}

	public void sortRooms() {
		Collections.sort(rooms);
	}

	boolean createVault() {
		return createRoom(-1, -1, 2, 2, -1, -1, Room.VAULT, true);
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
	private void addRoom(final int lowx, final int lowy, final int hix,
			final int hiy, final boolean lit, final int rtype,
			final boolean special) {
		final Room aRoom = new Room();
		rooms.add(aRoom);
		doRoomOrSubroom(aRoom, lowx, lowy, hix, hiy, lit, rtype, special, true);
	}

	private boolean checkRoom(final int a, final int b, final int c,
			final int d, final boolean e) {
		// TODO(jeffbailey): Stub
		return true;
	}

	private void doRoomOrSubroom(final Room croom, int lowx, int lowy, int hix,
			int hiy, final boolean lit, final int rtype, final boolean special,
			final boolean isRoom) {
		/* locations might bump level edges in wall-less rooms */
		/* add/subtract 1 to allow for edge locations */
		if (lowx == 0) {
			lowx++;
		}
		if (lowy == 0) {
			lowy++;
		}
		if (hix >= Webhack.COLNO - 1) {
			hix = Webhack.COLNO - 2;
		}
		if (hiy >= Webhack.ROWNO - 1) {
			hiy = Webhack.ROWNO - 2;
		}

		if (lit) {
			for (int x = lowx - 1; x <= hix + 1; x++) {
				for (int y = lowy - 1; y <= hiy + 1; y++) {
					locMap.getLoc(x, y).lit = true;
				}
			}
			croom.rlit = true;
		} else {
			croom.rlit = false;
		}

		croom.lx = lowx;
		croom.hx = hix;
		croom.ly = lowy;
		croom.hy = hiy;
		croom.rtype = rtype;
		croom.doorct = 0;
		/*
		 * if we're not making a vault, doorindex will still be 0 if we are,
		 * we'll have problems adding niches to the previous room unless fdoor
		 * is at least doorindex
		 */
		croom.fdoor = doorindex;
		croom.irregular = false;

		croom.nsubrooms = 0;
		croom.sbrooms[0] = null;
		if (!special) {
			for (int x = lowx - 1; x <= hix + 1; x++) {
				for (int y = lowy - 1; y <= hiy + 1; y += (hiy - lowy + 2)) {
					locMap.getLoc(x, y).typ = LocationType.HWALL;
					/*
					 * For open/secret doors.
					 */
					locMap.getLoc(x, y).horizontal = true;
				}
			}

			for (int x = lowx - 1; x <= hix + 1; x += (hix - lowx + 2)) {
				for (int y = lowy; y <= hiy; y++) {
					locMap.getLoc(x, y).typ = LocationType.VWALL;
					/*
					 * For open/secret doors.
					 */
					locMap.getLoc(x, y).horizontal = false;
				}
			}

			for (int x = lowx; x <= hix; x++) {
				for (int y = lowy; y <= hiy; y++) {
					locMap.getLoc(x, y).typ = LocationType.ROOM;
				}
			}

			if (isRoom) {
				locMap.getLoc(lowx - 1, lowy - 1).typ = LocationType.TLCORNER;
				locMap.getLoc(hix + 1, lowy - 1).typ = LocationType.TRCORNER;
				locMap.getLoc(lowx - 1, hiy + 1).typ = LocationType.BLCORNER;
				locMap.getLoc(hix + 1, hiy + 1).typ = LocationType.BRCORNER;
			} else { /* a subroom */
				// wallification(lowx - 1, lowy - 1, hix + 1, hiy + 1);
			}
		}

	}

	private void makeRooms() {
		boolean tried_vault = false;

		// make rooms until satisfied.
		// rnd_rect() will return 0 if no more rects are available...

		while (rooms.size() < Webhack.MAXNROFROOMS
				&& (rectangles.rndRect() != null)) {
			if (rooms.size() >= (Webhack.MAXNROFROOMS / 6)
					&& (random.rn2(2) != 0) && !tried_vault) {
				tried_vault = true;
				if (createVault()) {
					// TODO(jeffbailey): More vault processing.
				}
			} else {
				if (!createRoom(-1, -1, -1, -1, -1, -1, Room.OROOM, null)) {
					return;
				}
			}
		}
		return;
	}
}
