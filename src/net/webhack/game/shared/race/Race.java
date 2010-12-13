package net.webhack.game.shared.race;

import net.webhack.game.shared.RandomHelper;

public abstract class Race {

	public enum Races {
		HUMAN, ELF, DWARF, GNOME, ORC;
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

	protected final String name;

	Race(final String name) {
		this.name = name;
	}

	public String name() {
		return this.name;
	}
}