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
	 * @param rtype Room type
	 * @param rlit Is the room lit
	 */
	public Room(int x, int y, int w, int h, int xal, int yal, int rtype, Boolean rlit) {
	}
	
	public Room(int rtype) {
		this(-1, -1, -1, -1, -1, -1, rtype, null);
	}

}
