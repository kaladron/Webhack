/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.LinkedList;
import java.util.List;

import net.webhack.game.shared.LocationType.Door;
import net.webhack.game.shared.monsters.GridBug;
import net.webhack.game.shared.monsters.Monster;
import net.webhack.game.shared.things.Boulder;
import net.webhack.game.shared.things.Gold;
import net.webhack.game.shared.things.Thing;

/**
 * Routines defining a level within a Webhack Dungeon
 * 
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DungeonLevel implements LocationMap {

	Location[][] locations = new Location[Webhack.COLNO][Webhack.ROWNO];
	List<Monster> monlist = new LinkedList<Monster>();

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

	/** Number of doors */
	private final int doorIndex = 0;

	/** Coordinates of down stairs */
	@SuppressWarnings("unused")
	// TODO(jeffbailey): Remove this!
	private Coordinate dnstair;

	/** Coordinates of up stairs */
	private Coordinate upstair;

	public final Dungeon dungeon;

	public final RandomHelper random;

	private final You you;

	/** Rectangles for making room. */
	private final Rectangles rectangles;

	/** References to Rooms. */
	private Rooms rooms;

	public DungeonLevel(final RandomHelper random, final You you,
			final Dungeon dungeon) {
		this.random = random;
		this.you = you;
		this.rectangles = new Rectangles(random);
		this.dungeon = dungeon;

		for (int x = 0; x < Webhack.COLNO; x++) {
			for (int y = 0; y < Webhack.ROWNO; y++) {
				locations[x][y] = new Location();
			}
		}

		makeLevel();
	}

	public void doMapping() {
		int zx, zy;
		final boolean uw = you.uinwater;

		you.uinwater = false;
		for (zx = 1; zx < Webhack.COLNO; zx++) {
			for (zy = 0; zy < Webhack.ROWNO; zy++) {
				dungeon.ui.showMapSpot(zx, zy);
			}
		}
		// exercise(A_WIS, TRUE);
		you.uinwater = uw;
		// if (!level.flags.hero_memory || Underwater) {
		// dungeon.ui.flush_screen(1); /* flush temp screen */
		// display_nhwindow(WIN_MAP, TRUE); /* wait */
		dungeon.ui.docrt();
		// }

	}

	public Coordinate getAdjacentLoc(final int cmdKey, final String errorMsg,
			final int x, final int y) {
		if (!getdir(cmdKey)) {
			dungeon.ui.pline("Never mind.");
			return null;
		}
		return new Coordinate(x + you.dx, y + you.dy);
	}

	public Location getLoc(final int x, final int y) {
		return locations[x][y];
	}

	public Monster mAt(final int x, final int y) {
		return locations[x][y].monster;
	}

	/**
	 * Checks if there's a monster at this location.
	 * 
	 * @param x
	 * @param y
	 * @return True if there's a monster at this location
	 */
	@Stub
	public boolean monAt(final int x, final int y) {
		if (locations[x][y].monster == null) {
			return false;
		}

		return true;
	}

	public void onUpstairs() {
		you.newPos(upstair);
	}

	/**
	 * Helper for making a monster
	 * 
	 * @param monster
	 * @param x
	 * @param y
	 */
	public void placeMonster(final Monster monster, final int x, final int y) {
		monster.mx = x;
		monster.my = y;
		locations[x][y].monster = monster;
	}

	public void removeMonster(final int x, final int y) {
		locations[x][y].monster = null;
	}

	/**
	 * Searches the neighbouring squares.
	 * 
	 * @param autoSearch
	 *            if searching as an attribute. Quenches sarcastic messages.
	 */
	@Stub
	public boolean search(final boolean autoSearch) {
		for (int x = you.ux - 1; x < you.ux + 2; x++) {
			for (int y = you.uy - 1; y < you.uy + 2; y++) {
				if (!isOk(x, y)) {
					continue;
				}
				if (x != you.ux || y != you.uy) {
					if (locations[x][y].typ == LocationType.SDOOR) {
						locations[x][y].convertSdoorToDoor(); /* .typ = DOOR */
						dungeon.ui.newsym(x, y);
					} else if (locations[x][y].typ == LocationType.SCORR) {
						locations[x][y].typ = LocationType.CORR;
						dungeon.ui.newsym(x, y);
					}
				}
			}
		}
		return true;
	}

	/**
	 * Decides where the monster thinks you are standing.
	 */
	@Stub
	public void set_apparxy(final Monster mtmp) {
		mtmp.mux = you.ux;
		mtmp.muy = you.uy;
	}

	/**
	 * Checks if the player is at this location.
	 * 
	 * @param x
	 * @param y
	 * @return True if there player is at this location
	 */
	@Stub
	public boolean youAt(final int x, final int y) {
		if (you.ux == x && you.uy == y) {
			return true;
		}

		return false;
	}

	void add_door(final int x, final int y, final Room aroom) {
	};

	boolean byDoor(final int x, final int y) {
		LocationType typ;

		if (isOk(x + 1, y)) {
			typ = locations[x + 1][y].typ;
			if (typ.isDoor() || typ == LocationType.SDOOR) {
				return true;
			}
		}
		if (isOk(x - 1, y)) {
			typ = locations[x - 1][y].typ;
			if (typ.isDoor() || typ == LocationType.SDOOR) {
				return true;
			}
		}
		if (isOk(x, y + 1)) {
			typ = locations[x][y + 1].typ;
			if (typ.isDoor() || typ == LocationType.SDOOR) {
				return true;
			}
		}
		if (isOk(x, y - 1)) {
			typ = locations[x][y - 1].typ;
			if (typ.isDoor() || typ == LocationType.SDOOR) {
				return true;
			}
		}
		return false;
	}

	boolean digCorridor(final Coordinate org, final Coordinate dest,
			final boolean nxcor, final LocationType ftyp,
			final LocationType btyp) {
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
		if (tx > xx) {
			dx = 1;
		} else if (ty > yy) {
			dy = 1;
		} else if (tx < xx) {
			dx = -1;
		} else {
			dy = -1;
		}

		xx -= dx;
		yy -= dy;
		cct = 0;
		while (xx != tx || yy != ty) {
			/* loop: dig corridor at [xx,yy] and find new [xx,yy] */
			if (cct++ > 500 || (nxcor && random.oneIn(35))) {
				return false;
			}

			xx += dx;
			yy += dy;

			if (xx >= Webhack.COLNO - 1 || xx <= 0 || yy <= 0
					|| yy >= Webhack.ROWNO - 1) {
				return false; /* impossible */
			}

			crm = locations[xx][yy];
			if (crm.typ == btyp) {
				if (ftyp != LocationType.CORR || random.oneIn(100)) {
					crm.typ = ftyp;
					if (nxcor && random.oneIn(50)) {
						mksobj_at(new Boulder(), xx, yy, true, false);
					}
				} else {
					crm.typ = LocationType.SCORR;
				}
			} else if (crm.typ != ftyp && crm.typ != LocationType.SCORR) {
				/* strange ... */
				return false;
			}

			/* find next corridor position */
			dix = Math.abs(xx - tx);
			diy = Math.abs(yy - ty);

			/* do we have to change direction ? */
			if (dy != 0 && dix > diy) {
				final int ddx = (xx > tx) ? -1 : 1;

				crm = locations[xx + ddx][yy];
				if (crm.typ == btyp || crm.typ == ftyp
						|| crm.typ == LocationType.SCORR) {
					dx = ddx;
					dy = 0;
					continue;
				}
			} else if (dx != 0 && diy > dix) {
				final int ddy = (yy > ty) ? -1 : 1;

				crm = locations[xx][yy + ddy];
				if (crm.typ == btyp || crm.typ == ftyp
						|| crm.typ == LocationType.SCORR) {
					dy = ddy;
					dx = 0;
					continue;
				}
			}

			/* continue straight on? */
			crm = locations[xx + dx][yy + dy];
			if (crm.typ == btyp || crm.typ == ftyp
					|| crm.typ == LocationType.SCORR) {
				continue;
			}

			/* no, what must we do now?? */
			if (dx != 0) {
				dx = 0;
				dy = (ty < yy) ? -1 : 1;
			} else {
				dy = 0;
				dx = (tx < xx) ? -1 : 1;
			}
			crm = locations[xx + dx][yy + dy];
			if (crm.typ == btyp || crm.typ == ftyp
					|| crm.typ == LocationType.SCORR) {
				continue;
			}
			dy = -dy;
			dx = -dx;
		}
		return true;
	}

	/** returns true if monster died moving, false otherwise */
	@Stub
	boolean doChug(final Monster monster) {
		monster.move(this, 0);

		return false;
	}

	@Stub
	boolean doChugW(final Monster monster) {
		final boolean rd = doChug(monster);

		return rd;
	}

	void doDoor(final int x, final int y, final Room aroom) {
		if (doorIndex >= Webhack.DOORMAX) {
			// TODO(jeffbailey): console.error("DOORMAX exceeded?");
			return;
		}

		dosDoor(x, y, aroom, random.oneIn(8) ? LocationType.SDOOR
				: LocationType.DOOR);
	}

	void finddpos(final Coordinate cc, final int xl, final int yl,
			final int xh, final int yh) {

		int x = (xl == xh) ? xl : (xl + random.rn2(xh - xl + 1));
		int y = (yl == yh) ? yl : (yl + random.rn2(yh - yl + 1));
		if (okDoor(x, y)) {
			gotit(cc, x, y);
			return;
		}

		for (x = xl; x <= xh; x++) {
			for (y = yl; y <= yh; y++) {
				if (okDoor(x, y)) {
					gotit(cc, x, y);
					return;
				}
			}
		}

		for (x = xl; x <= xh; x++) {
			for (y = yl; y <= yh; y++) {
				if (locations[x][y].typ.isDoor()
						|| locations[x][y].typ == LocationType.SDOOR) {
					gotit(cc, x, y);
					return;
				}
			}
		}
		/* cannot find something reasonable -- strange */
		x = xl;
		y = yh;
		gotit(cc, x, y);
		return;
	}

	Gold g_at(final int x, final int y) {
		final List<ThingLocation> things = locations[x][y].things;

		for (final ThingLocation thingloc : things) {
			if (thingloc.thing instanceof Gold) {
				return (Gold) thingloc.thing;
			}
		}

		return null;
	}

	void gotit(final Coordinate cc, final int x, final int y) {
		cc.x = x;
		cc.y = y;
	}

	boolean isOk(final int x, final int y) {
		/* x corresponds to curx, so x==1 is the first column. Ach. %% */
		return x >= 1 && x <= Webhack.COLNO - 1 && y >= 0
				&& y <= Webhack.ROWNO - 1;
	}

	Thing mkgold(long amount, final int x, final int y) {
		Thing gold = g_at(x, y);

		if (amount <= 0L) {
			amount = (1 + random.rnd(dungeon.level_difficulty() + 2)
					* random.rnd(30));
		}
		if (gold != null) {
			gold.quan += amount;
		} else {
			gold = mksobj_at(new Gold(), x, y, true, false);
			gold.quan = amount;
		}

		return (gold);
	}

	Thing mksobj_at(final Thing thing, final int x, final int y,
			final boolean init, final boolean isArtifact) {
		// final int otmp = mksobj(oType, init, isArtifact);
		place_object(thing, x, y);
		return thing;
	}

	/**
	 * 
	 * @param x
	 *            X coordinate of stair
	 * @param y
	 *            Y coordinate of stair
	 * @param up
	 *            True if an upstair
	 * @param croom
	 *            Room in which to make the stairs
	 */
	void mkstairs(final int x, final int y, final boolean up, final Room croom) {
		/*
		 * We can't make a regular stair off an end of the dungeon. This attempt
		 * can happen when a special level is placed at an end and has an up or
		 * down stair specified in its description file.
		 */
		/*
		 * TODO(jeffbailey): Add this back in. if ((dunlev(&u.uz) == 1 && up) ||
		 * (dunlev(&u.uz) == dunlevs_in_dungeon(&u.uz) && !up)) return;
		 */

		if (up) {
			upstair = new Coordinate(x, y);
		} else {
			dnstair = new Coordinate(x, y);
		}

		locations[x][y].typ = LocationType.STAIRS;
		locations[x][y].ladder = up ? LocationType.Ladder.UP
				: LocationType.Ladder.DOWN;
	}

	/**
	 * Some of you may remember the former assertion here that because of deaths
	 * and other actions, a simple one-pass algorithm wasn't possible for
	 * movemon. Deaths are no longer removed to the separate list fdmon; they
	 * are simply left in the chain with hit points <= 0, to be cleaned up at
	 * the end of the pass.
	 * 
	 * The only other actions which cause monsters to be removed from the chain
	 * are level migrations and losedogs(). I believe losedogs() is a cleanup
	 * routine not associated with monster movements, and monsters can only
	 * affect level migrations on themselves, not others (hence the fetching of
	 * nmon before moving the monster). Currently, monsters can jump into traps,
	 * read cursed scrolls of teleportation, and drink cursed potions of raise
	 * level to change levels. These are all reflexive at this point. Should one
	 * monster be able to level teleport another, this scheme would have
	 * problems.
	 */
	@Stub
	boolean moveMon() {
		for (final Monster monster : monlist) {
			if (doChugW(monster)) {
				continue;
			}
		}
		return true;
	}

	boolean okDoor(final int x, final int y) {
		final boolean near_door = byDoor(x, y);

		return ((locations[x][y].typ == LocationType.HWALL || locations[x][y].typ == LocationType.VWALL)
				&& doorIndex < Webhack.DOORMAX && !near_door);
	}

	void place_object(final Thing thing, final int x, final int y) {
		locations[x][y].things.add(new ThingLocation(thing, x, y));
	}

	boolean testMove(final int ux, final int uy, final int dx, final int dy,
			final int mode) {
		final int x = ux + dx;
		final int y = uy + dy;

		final Location loc = locations[x][y];

		if (loc.typ.isRock()) {
			return false;
		}

		if (loc.typ.isDoor()
				&& (loc.doormask == Door.CLOSED || loc.doormask == Door.LOCKED)) {
			return false;
		}

		return true;
	}

	private void dosDoor(final int x, final int y, final Room aroom,
			final LocationType type) {

		final boolean shdoor = false;

		// final boolean shdoor = ((in_rooms(x, y, SHOPBASE)) ? true : false);

		// if (!isWall(locations[x][y].typ)) {
		// type = LocationType.DOOR;
		// }
		locations[x][y].typ = type;
		if (type == LocationType.DOOR) {
			if (random.oneIn(3)) { /*
									 * is it a locked door, closed, or a
									 * doorway?
									 */
				if (random.oneIn(5)) {
					locations[x][y].doormask = LocationType.Door.ISOPEN;
				} else if (random.oneIn(6)) {
					locations[x][y].doormask = LocationType.Door.LOCKED;
				} else {
					locations[x][y].doormask = LocationType.Door.CLOSED;
				}

				// TODO(jeffbailey): STUB
				// if (locations[x][y].doormask != LocationType.Door.ISOPEN
				// && !shdoor && level_difficulty() >= 5
				// && random.oneIn(25)) {
				// locations[x][y].doormask |= LocationType.Door.TRAPPED;
				// }
			} else {
				locations[x][y].doormask = (shdoor ? LocationType.Door.ISOPEN
						: LocationType.Door.NODOOR);
			}

			// TODO(jeffbailey): STUB!
			// if (locations[x][y].doormask & LocationType.Door.TRAPPED) {
			// final Monster mtmp;
			// if (level_difficulty() >= 9
			// && random.oneIn(5)
			// && !((mvitals[PM_SMALL_MIMIC].mvflags & G_GONE)
			// && (mvitals[PM_LARGE_MIMIC].mvflags & G_GONE) &&
			// (mvitals[PM_GIANT_MIMIC].mvflags & G_GONE))) {
			// /* make a mimic instead */
			// locations[x][y].doormask = LocationType.Door.NODOOR;
			// mtmp = makemon(mkclass(S_MIMIC, 0), x, y, NO_MM_FLAGS);
			// if (mtmp) {
			// set_mimic_sym(mtmp);
			// }
			// }
			// }
			/* newsym(x,y); */
		} else { /* SDOOR */
			if (shdoor || random.oneIn(5)) {
				locations[x][y].doormask = LocationType.Door.LOCKED;
			} else {
				locations[x][y].doormask = LocationType.Door.CLOSED;
			}

			// TODO(jeffbailey): STUB
			// if (!shdoor && level_difficulty() >= 4 && random.oneIn(20)) {
			// locations[x][y].doormask |= D_TRAPPED;
			// }
		}

		add_door(x, y, aroom);
	}

	/** for each room: put things inside */
	private void fillRooms() {

		for (final Room room : rooms.rooms) {

			// if(you.uhave.amulet || !rn2(3)) {
			// x = somex(croom); y = somey(croom);
			// tmonst = makemon((struct permonst *) 0, x,y,NO_MM_FLAGS);
			// if (tmonst && tmonst->data == &mons[PM_GIANT_SPIDER] &&
			// !occupied(x, y))
			// (void) maketrap(x, y, WEB);
			// }

			// Generate Monsters
			if (random.oneIn(3)) {
				final int x = room.someX(random);
				final int y = room.someY(random);
				final Monster monster = new GridBug(random);
				monster.mx = x;
				monster.my = y;
				locations[x][y].monster = monster;
				monlist.add(monster);
			}

			int difficulty = 8 - (dungeon.level_difficulty() / 6);
			if (difficulty <= 1) {
				difficulty = 2;
			}
			while (random.oneIn(difficulty)) {
				mktrap(0, false, room, null);
			}
			if (random.oneIn(3)) {
				mkgold(0L, room.someX(random), room.someY(random));
			}

			if (random.oneIn(10)) {
				mkfount(false, room);
			}

			if (random.oneIn(60)) {
				mksink(room);
			}

			if (random.oneIn(60)) {
				mkaltar(room);
			}
		}
	}

	private boolean getdir(final int dirsym) {
		if (dirsym == '.' || dirsym == 's') {
			you.dx = you.dy = you.dz = 0;
		} else if (!movecmd(dirsym) && you.dz == 0) {
			return false;
		}
		return true;
	}

	/**
	 * @param a
	 *            First room to join
	 * @param b
	 *            Second room to join
	 * @param nxcor
	 */
	private void join(final int a, final int b, final boolean nxcor) {
		final Coordinate cc = new Coordinate();
		final Coordinate tt = new Coordinate();
		final Coordinate org = new Coordinate();
		final Coordinate dest = new Coordinate();
		int tx, ty, xx, yy;
		int dx, dy;

		final Room croom = rooms.rooms.elementAt(a);
		final Room troom = rooms.rooms.elementAt(b);

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
		if (nxcor && getLoc(xx + dx, yy + dy).typ != null) {
			return;
		}
		if (okDoor(xx, yy) || !nxcor) {
			doDoor(xx, yy, croom);
		}

		org.x = xx + dx;
		org.y = yy + dy;
		dest.x = tx;
		dest.y = ty;

		if (!digCorridor(org, dest, nxcor, arboreal ? LocationType.ROOM
				: LocationType.CORR, LocationType.STONE)) {
			return;
		}

		/* we succeeded in digging the corridor */
		if (okDoor(tt.x, tt.y) || !nxcor) {
			doDoor(tt.x, tt.y, troom);
		}

		if (rooms.smeq[a] < rooms.smeq[b]) {
			rooms.smeq[b] = rooms.smeq[a];
		} else {
			rooms.smeq[a] = rooms.smeq[b];
		}

	}

	private void makeCorridors() {
		boolean any = true;

		for (int a = 0; a < rooms.rooms.size() - 1; a++) {
			join(a, a + 1, false);
			if (random.rn2(50) == 0) {
				break; /* allow some randomness */
			}
		}
		for (int a = 0; a < rooms.rooms.size() - 2; a++) {
			if (rooms.smeq[a] != rooms.smeq[a + 2]) {
				join(a, a + 2, false);
			}
		}
		for (int a = 0; any && a < rooms.rooms.size(); a++) {
			any = false;
			for (int b = 0; b < rooms.rooms.size(); b++) {
				if (rooms.smeq[a] != rooms.smeq[b]) {
					join(a, b, false);
					any = true;
				}
			}
		}
		if (rooms.rooms.size() > 2) {
			for (int i = random.rn2(rooms.rooms.size()) + 4; i != 0; i--) {
				final int a = random.rn2(rooms.rooms.size());
				int b = random.rn2(rooms.rooms.size() - 2);
				if (b >= a) {
					b += 2;
				}
				join(a, b, true);
			}
		}
	}

	private void makeLevel() {
		rooms = new Rooms(rectangles, random, this);
		makeStairs();
		makeCorridors();

		/* for each room: put things inside */
		fillRooms();

	}

	/** Constructs stairs (up and down in different rooms if possible) */
	@Stub
	private void makeStairs() {
		Room croom = rooms.rooms.elementAt(random.rn2(rooms.rooms.size()));
		// TODO(jeffbailey): if (!Is_botlevel(you.uz))
		mkstairs(croom.someX(random), croom.someY(random), false, croom); /* down */
		if (rooms.rooms.size() > 1) {
			int roomNum = random.rn2(rooms.rooms.size() - 1);
			final Room troom = croom;
			croom = rooms.rooms.elementAt(roomNum);
			if (croom == troom) {
				roomNum++;
				croom = rooms.rooms.elementAt(roomNum);
			}
		}

		// TODO(jeffbailey): if (you.uz.dlevel != 1)
		{
			int sx, sy;
			do {
				sx = croom.someX(random);
				sy = croom.someY(random);
				// TODO(jeffbailey): } while(occupied(sx, sy));
			} while (false);
			mkstairs(sx, sy, true, croom); /* up */
		}

	}

	@Stub
	private void mkaltar(final Room room) {
		Coordinate c;
		if ((c = room.someXY(random)) == null) {
			return;
		}

		locations[c.x][c.y].typ = LocationType.ALTAR;
	}

	@Stub
	private void mkfount(final boolean makeflag, final Room room) {
		Coordinate c;
		if ((c = room.someXY(random)) == null) {
			return;
		}

		locations[c.x][c.y].typ = LocationType.FOUNTAIN;
	}

	@Stub
	private void mksink(final Room room) {
		Coordinate c;
		if ((c = room.someXY(random)) == null) {
			return;
		}

		locations[c.x][c.y].typ = LocationType.SINK;
	}

	@Stub
	private void mktrap(final int num, final boolean mazeflag, final Room room,
			final Thing tm) {
	}

	@Stub
	private boolean movecmd(final int c) {
		// TODO this is a dupe of what's in MoveLoop. They should be
		// consolidated.

		// TODO Even worse, this isn't how movecmd is implemented at all. Need
		// to move to that.
		final String sdir = "hykulnjb><";
		// final char ndir[] = {'4','7','8','9','6','3','2','1','>','<'}; /*
		// number pad mode */
		final int xdir[] = { -1, -1, 0, 1, 1, 1, 0, -1, 0, 0 };
		final int ydir[] = { 0, -1, -1, -1, 0, 1, 1, 1, 0, 0 };
		final int offset = sdir.indexOf(c);

		if (offset != -1) {
			you.ux0 = you.ux;
			you.uy0 = you.uy;
			you.uz0 = you.uz;

			you.dx = xdir[offset];
			you.dy = ydir[offset];
			return true;
		}
		return false;
	}

}
