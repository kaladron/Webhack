/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Location {
	/*
	 * The structure describing a coordinate position. Before adding fields,
	 * remember that this will significantly affect the size of temporary files
	 * and save files.
	 */
	/** what the hero thinks is there */
	int glyph;
	/** what is really there */
	int typ;
	/** seen vector */
	int seenv;
	/** extra information for typ */
	Flags flags;
	/** wall/door/etc is horiz. (more typ info) */
	boolean horizontal;

	/** speed hack for lit rooms */
	boolean lit;
	/** remember if a location was lit */
	boolean waslit;
	/** room # for special rooms */
	int roomno;
	/** marks boundaries for special rooms */
	boolean edge;
}
