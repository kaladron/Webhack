package net.webhack.game.shared;

public enum Race {
	HUMAN, ELF, DWARF, GNOME, ORC;

	public static Race getRandom(final RandomHelper random) {
		final Race[] races = Race.values();
		return races[random.rn2(races.length)];
	}
}