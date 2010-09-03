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
public class DungeonLevel implements LocationMap {

	/**
	 * <pre>
	 * TLCORNER     TDWALL          TRCORNER
	 * +-           -+-             -+
	 * |             |               |
	 * 
	 * TRWALL       CROSSWALL       TLWALL          HWALL
	 * |             |               |
	 * +-           -+-             -+              ---
	 * |             |               |
	 * 
	 * BLCORNER     TUWALL          BRCORNER        VWALL
	 * |             |               |              |
	 * +-           -+-             -+              |
	 * </pre>
	 */
	/* Level location types */
	static int STONE = 0;
	static int VWALL = 1;
	static int HWALL = 2;
	static int TLCORNER = 3;
	static int TRCORNER = 4;
	static int BLCORNER = 5;
	static int BRCORNER = 6;
	static int CROSSWALL = 7; /* For pretty mazes and special levels */
	static int TUWALL = 8;
	static int TDWALL = 9;
	static int TLWALL = 10;
	static int TRWALL = 11;
	static int DBWALL = 12;
	static int TREE = 13; /* KMH */
	static int SDOOR = 14;
	static int SCORR = 15;
	static int POOL = 16;
	static int MOAT = 17; /* pool that doesn't boil, adjust messages */
	static int WATER = 18;
	static int DRAWBRIDGE_UP = 19;
	static int LAVAPOOL = 20;
	static int IRONBARS = 21; /* KMH */
	static int DOOR = 22;
	static int CORR = 23;
	static int ROOM = 24;
	static int STAIRS = 25;
	static int LADDER = 26;
	static int FOUNTAIN = 27;
	static int THRONE = 28;
	static int SINK = 29;
	static int GRAVE = 30;
	static int ALTAR = 31;
	static int ICE = 32;
	static int DRAWBRIDGE_DOWN = 33;
	static int AIR = 34;
	static int CLOUD = 35;
	static int MAX_TYPE = 36;
	static int INVALID_TYPE = 127;

	Location[][] locations = new Location[Webhack.COLNO][Webhack.ROWNO];

	/** number of fountains on level */
	int nfountains;
	/** number of sinks on the level */
	int nsinks;

	/* Several flags that give hints about what's on the level */
	boolean has_shop;
	boolean has_vault;
	boolean has_zoo;
	boolean has_court;
	boolean has_morgue;
	boolean has_beehive;
	boolean has_barracks;
	boolean has_temple;

	boolean has_swamp;
	boolean noteleport;
	boolean hardfloor;
	boolean nommap;
	/** hero has memory */
	boolean hero_memory;
	/** monsters are shortsighted */
	boolean shortsighted;
	/** has_morgue, but remains set */
	boolean graveyard;
	boolean is_maze_lev;

	boolean is_cavernous_lev;
	/** Trees replace rock */
	boolean arboreal;

	public Location getLoc(int x, int y) {
		return locations[x][y];
	}

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

		for (int x = 0; x < Webhack.COLNO; x++) {
			for (int y = 0; y < Webhack.ROWNO; y++) {
				locations[x][y] = new Location();
			}
		}

		makeLevel();
	}

	private void makeLevel() {
		rooms = new Rooms(rectangles, random, this);
		makeStairs();
		makeCorridors();

		dumpLevelMap();
	}

	private void makeStairs() {

	}

	private void makeCorridors() {
		boolean any = true;
		
		for (int a = 0; a < rooms.nroom - 1; a++) {
			join(a, a + 1, false);
			if (random.rn2(50) == 0)
				break; /* allow some randomness */
		}
		for (int a = 0; a < rooms.nroom - 2; a++)
			if (rooms.smeq[a] != rooms.smeq[a + 2])
				join(a, a + 2, false);
		for (int a = 0; any && a < rooms.nroom; a++) {
			any = false;
			for (int b = 0; b < rooms.nroom; b++)
				if (rooms.smeq[a] != rooms.smeq[b]) {
					join(a, b, false);
					any = true;
				}
		}
		if (rooms.nroom > 2)
			for (int i = random.rn2(rooms.nroom) + 4; i != 0; i--) {
				int a = random.rn2(rooms.nroom);
				int b = random.rn2(rooms.nroom - 2);
				if (b >= a)
					b += 2;
				join(a, b, true);
			}
	}

	/**
	 * @param a
	 *            First room to join
	 * @param b
	 *            Second room to join
	 * @param nxcor
	 */
	private void join(int a, int b, boolean nxcor) {
		Coordinate cc = new Coordinate();
		Coordinate tt = new Coordinate();
		Coordinate org = new Coordinate();
		Coordinate dest = new Coordinate();
		int tx, ty, xx, yy;
		int dx, dy;

		Room croom = rooms.rooms[a];
		Room troom = rooms.rooms[b];

		/*
		 * find positions cc and tt for doors in croom and troom and direction
		 * for a corridor between them
		 */

		if (troom.hx < 0 || croom.hx < 0 || doorIndex >= Webhack.DOORMAX) {
			return;
		}
		if (troom.lx > croom.hx) {
			dx = 1;
			dy = 0;
			xx = croom.hx + 1;
			tx = troom.lx - 1;
			finddpos(cc, xx, croom.ly, xx, croom.hy);
			finddpos(tt, tx, troom.ly, tx, troom.hy);
		} else if (troom.hy < croom.ly) {
			dy = -1;
			dx = 0;
			yy = croom.ly - 1;
			finddpos(cc, croom.lx, yy, croom.hx, yy);
			ty = troom.hy + 1;
			finddpos(tt, troom.lx, ty, troom.hx, ty);
		} else if (troom.hx < croom.lx) {
			dx = -1;
			dy = 0;
			xx = croom.lx - 1;
			tx = troom.hx + 1;
			finddpos(cc, xx, croom.ly, xx, croom.hy);
			finddpos(tt, tx, troom.ly, tx, troom.hy);
		} else {
			dy = 1;
			dx = 0;
			yy = croom.hy + 1;
			ty = troom.ly - 1;
			finddpos(cc, croom.lx, yy, croom.hx, yy);
			finddpos(tt, troom.lx, ty, troom.hx, ty);
		}
		xx = cc.x;
		yy = cc.y;
		tx = tt.x - dx;
		ty = tt.y - dy;
		if (nxcor && getLoc(xx + dx, yy + dy).typ != 0)
			return;
		if (okDoor(xx, yy) || !nxcor)
			doDoor(xx, yy, croom);

		org.x = xx + dx;
		org.y = yy + dy;
		dest.x = tx;
		dest.y = ty;

		if (!digCorridor(org, dest, nxcor, arboreal ? ROOM : CORR, STONE))
			return;

		/* we succeeded in digging the corridor */
		if (okDoor(tt.x, tt.y) || !nxcor)
			doDoor(tt.x, tt.y, troom);

		if (rooms.smeq[a] < rooms.smeq[b])
			rooms.smeq[b] = rooms.smeq[a];
		else
			rooms.smeq[a] = rooms.smeq[b];

	}

	void doDoor(int x, int y, Room aroom) {
		if (doorIndex >= Webhack.DOORMAX) {
			// TODO(jeffbailey): console.error("DOORMAX exceeded?");
			return;
		}

		// TODO(jeffbailey): dosdoor(x, y, aroom, random.oneIn(8) ? DOOR :
		// SDOOR);
	}

	boolean digCorridor(Coordinate org, Coordinate dest, boolean nxcor,
			int ftyp, int btyp) {
		int dx = 0, dy = 0, dix, diy, cct;
		Location crm;
		int tx, ty, xx, yy;

		xx = org.x;
		yy = org.y;
		tx = dest.x;
		ty = dest.y;
		if (xx <= 0 || yy <= 0 || tx <= 0 || ty <= 0 || xx > Webhack.COLNO - 1
				|| tx > Webhack.COLNO - 1 || yy > Webhack.ROWNO - 1
				|| ty > Webhack.ROWNO - 1) {
			return false;
		}
		if (tx > xx)
			dx = 1;
		else if (ty > yy)
			dy = 1;
		else if (tx < xx)
			dx = -1;
		else
			dy = -1;

		xx -= dx;
		yy -= dy;
		cct = 0;
		while (xx != tx || yy != ty) {
			/* loop: dig corridor at [xx,yy] and find new [xx,yy] */
			if (cct++ > 500 || (nxcor && random.oneIn(35)))
				return false;

			xx += dx;
			yy += dy;

			if (xx >= Webhack.COLNO - 1 || xx <= 0 || yy <= 0
					|| yy >= Webhack.ROWNO - 1)
				return false; /* impossible */

			crm = locations[xx][yy];
			if (crm.typ == btyp) {
				if (ftyp != CORR || random.oneIn(100)) {
					crm.typ = ftyp;
					if (nxcor && random.oneIn(50)) {
						// TODO(jeffbailey): webhack.mksobj_at(webhack.BOULDER,
						// xx, yy, true, false);
					}
				} else {
					crm.typ = SCORR;
				}
			} else if (crm.typ != ftyp && crm.typ != SCORR) {
				/* strange ... */
				return false;
			}

			/* find next corridor position */
			dix = Math.abs(xx - tx);
			diy = Math.abs(yy - ty);

			/* do we have to change direction ? */
			if (dy != 0 && dix > diy) {
				int ddx = (xx > tx) ? -1 : 1;

				crm = locations[xx + ddx][yy];
				if (crm.typ == btyp || crm.typ == ftyp || crm.typ == SCORR) {
					dx = ddx;
					dy = 0;
					continue;
				}
			} else if (dx != 0 && diy > dix) {
				int ddy = (yy > ty) ? -1 : 1;

				crm = locations[xx][yy + ddy];
				if (crm.typ == btyp || crm.typ == ftyp || crm.typ == SCORR) {
					dy = ddy;
					dx = 0;
					continue;
				}
			}

			/* continue straight on? */
			crm = locations[xx + dx][yy + dy];
			if (crm.typ == btyp || crm.typ == ftyp || crm.typ == SCORR)
				continue;

			/* no, what must we do now?? */
			if (dx != 0) {
				dx = 0;
				dy = (ty < yy) ? -1 : 1;
			} else {
				dy = 0;
				dx = (tx < xx) ? -1 : 1;
			}
			crm = locations[xx + dx][yy + dy];
			if (crm.typ == btyp || crm.typ == ftyp || crm.typ == SCORR)
				continue;
			dy = -dy;
			dx = -dx;
		}
		return true;
	}

	void gotit(Coordinate cc, int x, int y) {
		cc.x = x;
		cc.y = y;
	}

	void finddpos(Coordinate cc, int xl, int yl, int xh, int yh) {

		int x = (xl == xh) ? xl : (xl + random.rn2(xh - xl + 1));
		int y = (yl == yh) ? yl : (yl + random.rn2(yh - yl + 1));
		if (okDoor(x, y)) {
			gotit(cc, x, y);
			return;
		}

		for (x = xl; x <= xh; x++)
			for (y = yl; y <= yh; y++)
				if (okDoor(x, y)) {
					gotit(cc, x, y);
					return;
				}

		for (x = xl; x <= xh; x++)
			for (y = yl; y <= yh; y++)
				if (isDoor(locations[x][y].typ) || locations[x][y].typ == SDOOR) {
					gotit(cc, x, y);
					return;
				}
		/* cannot find something reasonable -- strange */
		x = xl;
		y = yh;
		gotit(cc, x, y);
		return;
	}

	boolean isDoor(int typ) {
		return typ == DOOR;
	}

	boolean byDoor(int x, int y) {
		int typ;

		if (isOk(x + 1, y)) {
			typ = locations[x + 1][y].typ;
			if (isDoor(typ) || typ == SDOOR)
				return true;
		}
		if (isOk(x - 1, y)) {
			typ = locations[x - 1][y].typ;
			if (isDoor(typ) || typ == SDOOR)
				return true;
		}
		if (isOk(x, y + 1)) {
			typ = locations[x][y + 1].typ;
			if (isDoor(typ) || typ == SDOOR)
				return true;
		}
		if (isOk(x, y - 1)) {
			typ = locations[x][y - 1].typ;
			if (isDoor(typ) || typ == SDOOR)
				return true;
		}
		return false;
	}

	boolean isOk(int x, int y) {
		/* x corresponds to curx, so x==1 is the first column. Ach. %% */
		return x >= 1 && x <= Webhack.COLNO - 1 && y >= 0
				&& y <= Webhack.ROWNO - 1;
	}

	boolean okDoor(int x, int y) {
		boolean near_door = byDoor(x, y);

		return ((locations[x][y].typ == HWALL || locations[x][y].typ == VWALL)
				&& doorIndex < Webhack.DOORMAX && !near_door);
	}

	private void dumpLevelMap() {
		for (int y = 0; y < Webhack.ROWNO; y++) {
			for (int x = 0; x < Webhack.COLNO; x++) {
				if (locations[x][y].typ < 10) {
					System.out.print('0');
				}
				System.out.print(locations[x][y].typ);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

}
