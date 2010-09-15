package net.webhack.game.shared;

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
	
	
	
    int lx,hx,ly,hy;      /* usually xchar, but hx may be -1 */
    int rtype;            /* type of room (zoo, throne, etc...) */
    boolean rlit;             /* is the room lit ? */
    int doorct;           /* door count */
    int fdoor;            /* index for the first door of the room */
    int nsubrooms;        /* number of subrooms */
    boolean irregular;      /* true if room is non-rectangular */
    Room[] sbrooms = new Room[Webhack.MAX_SUBROOMS];  /* Subrooms pointers */
    //struct monst *resident; /* priest/shopkeeper/guard for this room */

    /**
     * Random X coordinate within a room
     * 
     * @param random
     * @return
     */
    public int someX(RandomHelper random) {
        return random.rn2(hx - lx + 1) + lx;
    }
    
    /**
     * Random Y coordinate within a room
     * 
     * @param random
     * @return
     */
    public int someY(RandomHelper random) {
        return random.rn2(hy - ly + 1) + ly;
    }
}
