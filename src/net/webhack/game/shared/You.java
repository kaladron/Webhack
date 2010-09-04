/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class You {
	public You() {
		int ux, uy;
		/** direction of move (or zap or ... ) */
		int dx, dy, dz;
		/** direction of FF */
		int di;
		/** destination of travel */
		int tx, ty;
		/** initial position FF */
		int ux0, uy0;
		/** your level on this and the previous turn */
		DLevel uz, uz0;
		/** level monster teleported you to, or uz */
		DLevel utolev;
		/** bitmask of goto_level() flags for utolev */
		int utotype;
		/** changed map location (post-move) */
		boolean umoved;
		/**
		 * 0: none, 1: half turn, 2: full turn +: turn right, -: turn left
		 */
		int last_str_turn;
		/** 1 to MAXULEV */
		int ulevel;
		int ulevelmax;
		/** trap timeout */
		int utrap;
		/** defined if utrap nonzero */
		int utraptype;

	}
}
