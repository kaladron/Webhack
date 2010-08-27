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
	
	DungeonLevel dlevel;
	
	public Webhack(WebhackUI ui) {
		
	}

	public void main() {
		newGame();		
	}
	
	private void newGame() {
		dlevel = new DungeonLevel();
	}
}
