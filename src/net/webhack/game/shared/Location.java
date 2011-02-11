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

	public static final int WM_W_LEFT = 1; /* vertical or horizontal wall */
	public static final int WM_W_RIGHT = 2;
	public static final int WM_W_TOP = WM_W_LEFT;
	public static final int WM_W_BOTTOM = WM_W_RIGHT;

	public static final int WM_C_OUTER = 1; /* corner wall */
	public static final int WM_C_INNER = 2;

	public static final int WM_T_LONG = 1; /* T wall */
	public static final int WM_T_BL = 2;
	public static final int WM_T_BR = 3;

	public static final int WM_X_TL = 1; /* cross wall */
	public static final int WM_X_TR = 2;
	public static final int WM_X_BL = 3;
	public static final int WM_X_BR = 4;
	public static final int WM_X_TLBR = 5;
	public static final int WM_X_BLTR = 6;

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
	// public final int altarmask flags

	// TODO(jeffbailey): Some type safety would be nice here.
	int wall_info;

	// public final int wall_info flags
	// public final int drawbridgemask flags
	// public final int looted flags
	// public final int icedpool flags

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
