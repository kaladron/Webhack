/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Dungeon {

	private final DungeonLevel dlevel;
	private final RandomHelper random;
	private final You you;

	public Dungeon(RandomHelper random, You you) {
		this.random = random;
		this.you = you;
		// TODO(jeffbailey): This is for testing.
		you.role = new Archeologist();
		dlevel = new DungeonLevel(random, you);

	}

	/**
	 * use instead of depth() wherever a degree of difficulty is made dependent
	 * on the location in the dungeon (eg. monster creation).
	 */
	int level_difficulty() {
		// TODO(jeffbailey): STUB!
		if (you.inEndGame()) {
			// return((xchar)(depth(&sanctum_level) + u.ulevel/2));
			return 1;
		} else if (you.youHave.amulet) {
			// return(deepest_lev_reached(FALSE));
			return 1;
		} else {
			return depth(you.uz);
		}
	}

	int depth(DLevel level) {
		// TOOD(jeffbailey): STUB!
		return 1;
	}
	
}
