package net.webhack.game.shared;

public class Room implements Comparable<Room> {

	int lx, hx, ly, hy; /* usually xchar, but hx may be -1 */
	RoomType rtype; /* type of room (zoo, throne, etc...) */
	boolean rlit; /* is the room lit ? */
	int doorct; /* door count */
	int fdoor; /* index for the first door of the room */
	int nsubrooms; /* number of subrooms */
	boolean irregular; /* true if room is non-rectangular */
	Room[] sbrooms = new Room[Webhack.MAX_SUBROOMS]; /* Subrooms pointers */

	// struct monst *resident; /* priest/shopkeeper/guard for this room */

	public int compareTo(final Room arg0) {
		if (this.lx < arg0.lx) {
			return -1;
		}
		if (this.lx > arg0.lx) {
			return 1;
		}
		return 0;
	}

	/**
	 * Random X coordinate within a room
	 * 
	 * @param random
	 * @return
	 */
	public int someX(final WebhackRandom random) {
		return random.rn2(hx - lx + 1) + lx;
	}

	/**
	 * Random Y coordinate within a room
	 * 
	 * @param random
	 * @return
	 */
	public int someY(final WebhackRandom random) {
		return random.rn2(hy - ly + 1) + ly;
	}

	Coordinate someXY(final WebhackRandom random) {
		if (nsubrooms == 0) {
			final int x = someX(random);
			final int y = someY(random);

			return new Coordinate(x, y);
		}

		return null;

	}
}
