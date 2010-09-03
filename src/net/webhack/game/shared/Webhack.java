package net.webhack.game.shared;

import net.webhack.game.client.WebhackUI;

public class Webhack {
	
	// CONFIG Things go here for now.
	
	/** Number of columns in the dungeon. */
	public static int COLNO = 80;
	
	/** Number of rows in the dungeon. */
	public static int ROWNO = 21;
	
	/** Maximum rooms per level. */
	public static int MAXNROFROOMS = 40;
	
	/** Maximum subrooms per level. */
	public static int MAX_SUBROOMS = 24;
	
	/** Maximum doors per level. */
	public static int DOORMAX = 120;

	/** current maximum number of dungeons */
	public static int MAXDUNGEON = 16; 
	
	/** max number of levels in one dungeon */
	public static int MAXLEVEL = 32; 
	
	/** max # of special stairways in a dungeon */
	public static int MAXSTAIRS = 1; 
	
	/** generation weight of alignment */
	public static int ALIGNWEIGHT = 4; 

	/** max character experience level */
	public static int MAXULEV = 30; 

	/** extinct monst after this number created */
	public static int MAXMONNO = 120; 
	
	/** maximum monster hp */
	public static int MHPMAX = 500; 

	
	DungeonLevel dlevel;

	static int YLIM = 3;

	static int XLIM = 4;
	
	public Webhack(WebhackUI ui) {
		
	}

	public void main() {
		newGame();		
	}
	
	private void newGame() {
		RandomHelper random = new WebhackRandom();
		
		dlevel = new DungeonLevel(random);
	}
}
