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
	// TODO(jeffbailey): Don't hardcode this. This is the glyph for stone.
	int glyph = 2344;
	/** what is really there */
	LocationType typ = LocationType.STONE;
	/** seen vector */
	int seenv;

	// The various typ assists below had all been a unified bitfield.
	// If we need to save memory, putting this into an interface with an
	// inherited type could save ~64k.

	/** Ladder information */
	LocationType.Ladder ladder;

	// More things that eventually provide typ information
	// #define doormask flags
	// #define altarmask flags
	// #define wall_info flags
	// #define drawbridgemask flags
	// #define looted flags
	// #define icedpool flags

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
