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
	
    String name;
    String parent;
    int x, y, w, h;
    int xalign, yalign;
    int rtype, chance, rlit, filled;
    int ndoor;
    // room_door **doors;
    int ntrap;
    // trap **traps;
    int nmonster;
    // monster **monsters;
    int nobject;
    // object **objects;
    int naltar;
    // altar **altars;
    int nstair;
    // stair **stairs;
    int ngold;
    // gold **golds;
    int nengraving;
    // engraving **engravings;
    int nfountain;
    // fountain **fountains;
    int nsink;
    // sink **sinks;
    int npool;
    // pool **pools;
    /* These three fields are only used when loading the level... */
    // int nsubroom;
    // struct _room *subrooms[MAX_SUBROOMS];
    // struct mkroom *mkr;


}
