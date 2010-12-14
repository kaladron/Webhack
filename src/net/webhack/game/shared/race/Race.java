package net.webhack.game.shared.race;

import net.webhack.game.shared.Attributes;
import net.webhack.game.shared.PM;
import net.webhack.game.shared.RandomHelper;
import net.webhack.game.shared.role.Role;

public abstract class Race {

	public enum Races {
		HUMAN, ELF, DWARF, GNOME, ORC;
	}

	class RoleName {
		String m;
		String f;
	}

	public static Race getRandom(final RandomHelper random) {
		final Races[] races = Races.values();
		return newRace(races[random.rn2(races.length)]);
	}

	public static Race newRace(final Races race) {
		switch (race) {
		case HUMAN:
			return new Human();
		case ELF:
			return new Elf();
		case DWARF:
			return new Dwarf();
		case GNOME:
			return new Gnome();
		case ORC:
			return new Orc();
		default:
			return null;
		}
	}

	/*** Strings that name various things ***/
	String noun; /* noun ("human", "elf") */
	String adj; /* adjective ("human", "elven") */

	String coll; /* collective ("humanity", "elvenkind") */

	String filecode; /* code for filenames */
	RoleName individual; /* individual as a noun ("man", "elf") */

	/*** Indices of important monsters and objects ***/
	PM malenum, /* PM_ as a male monster */
	femalenum, /* ...or as a female (NON_PM == same) */
	mummynum, /* PM_ as a mummy */
	zombienum; /* PM_ as a zombie */
	/*** Bitmasks ***/
	short allow; /* bit mask of allowed variations */
	short selfmask, /* your own race's bit mask */
	lovemask, /* bit mask of always peaceful */
	hatemask; /* bit mask of always hostile */
	/*** Attributes ***/
	Attributes attrmin; /* minimum allowable attribute */

	Attributes attrmax; /* maximum allowable attribute */

	Role.Advance hpadv; /* hit point advancement */

	Role.Advance enadv; /* energy advancement */

	protected final String name;

	Race(final String name) {
		this.name = name;
	}

	public String name() {
		return this.name;
	}
}