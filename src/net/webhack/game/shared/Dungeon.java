/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Dungeon {

	public final DungeonLevel dlevel;
	private final Bindery bindery;

	public Dungeon(final Bindery bindery) {
		this.bindery = bindery;
		// TODO(jeffbailey): Figure out better bootstrapping
		bindery.ui.init(this, bindery.you, bindery.flags);
		dlevel = new DungeonLevel(bindery, this);
		dlevel.onUpstairs();
	}

	int depth(final DLevel level) {
		// TODO(jeffbailey): STUB!
		return level.dlevel;
	}

	DungeonLevel getLevel() {
		return dlevel;
	}

	/**
	 * use instead of depth() wherever a degree of difficulty is made dependent
	 * on the location in the dungeon (eg. monster creation).
	 */
	int level_difficulty() {
		// TODO(jeffbailey): STUB!
		if (bindery.you.inEndGame()) {
			// return((xchar)(depth(&sanctum_level) + u.ulevel/2));
			return 1;
		} else if (bindery.you.youHave.amulet) {
			// return(deepest_lev_reached(FALSE));
			return 1;
		} else {
			return depth(bindery.you.uz);
		}
	}

}
