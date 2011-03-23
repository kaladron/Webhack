package net.webhack.game.shared;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

	HashMap<Character, Obj> items = new HashMap<Character, Obj>();
	List<Character> letters = new LinkedList<Character>(Arrays.asList('a', 'b',
			'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

	private final Bindery bindery;

	Inventory(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Stub
	Obj add(final Obj obj) {
		// The implementation here is slightly different than NetHack
		// because we have HashMaps.

		if (bindery.flags.invlet_constant) {
			assignInvlet(obj);
		}
		return obj;
	}

	@Stub
	void assignInvlet(final Obj obj) {
		items.put(letters.remove(0), obj);
	}
}
