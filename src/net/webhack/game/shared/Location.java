/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import net.webhack.game.shared.monsters.Monster;

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
	public LocationType typ = LocationType.STONE;
	/** seen vector */
	EnumSet<Display.SeenVector> seenv = EnumSet
			.noneOf(Display.SeenVector.class);

	// The various typ assists below had all been a unified bitfield.
	// If we need to save memory, putting this into an interface with an
	// inherited type could save ~64k.

	/** Ladder information */
	LocationType.Ladder ladder;

	// More things that eventually provide typ information
	public LocationType.Door doormask;
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

	List<Obj> things = new LinkedList<Obj>();
	Monster monster = null;

	/**
	 * Check if there are objects at this location.
	 * 
	 * @return true if objects at this location
	 */
	public boolean obj_at() {
		return !things.isEmpty();
	}

	/**
	 * Look for a specified type of Object at the location
	 * 
	 * @param n
	 *            Type of Object
	 * @return Object or null if not found.
	 */
	public Obj sobj_at(final ObjectName n) {
		for (final Obj thingloc : things) {
			if (thingloc.otyp == n) {
				return thingloc;
			}
		}

		return null;
	}

	/**
	 * Converts a Secret Door to a Door. Used when discovering a hidden door.
	 */
	@Stub
	void convertSdoorToDoor() {
		typ = LocationType.DOOR;
	}

}
