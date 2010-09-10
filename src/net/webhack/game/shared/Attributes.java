/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumMap;

import net.webhack.game.shared.You.Attribute;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
final public class Attributes extends EnumMap<Attribute, Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4002834944436724922L;

	public Attributes() {
		super(Attribute.class);
	}

	public Attributes(int STR, int INT, int WIS, int DEX, int CON, int CHA) {
		this();
		this.put(Attribute.STR, STR);
		this.put(Attribute.INT, INT);
		this.put(Attribute.WIS, WIS);
		this.put(Attribute.DEX, DEX);
		this.put(Attribute.CON, CON);
		this.put(Attribute.CHA, CHA);
	}

}
