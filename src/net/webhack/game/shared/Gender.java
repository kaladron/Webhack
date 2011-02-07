package net.webhack.game.shared;


public enum Gender {
	/** Male gender */
	MALE("male", "he", "him", "his", "Mal"),

	/** Female Gender */
	FEMALE("female", "she", "her", "her", "Fem"),

	/** Neuter Gender */
	NEUTER("neuter", "it", "it", "its", "Ntr");

	public static Gender getRandom(final Bindery bindery) {
		final Gender[] genders = Gender.values();
		return genders[bindery.random.rn2(genders.length)];
	}

	final String adj;
	final String he;
	final String his;

	final String filecode;

	Gender(final String adj, final String he, final String him,
			final String his, final String filecode) {
		this.adj = adj;
		this.he = he;
		this.his = his;
		this.filecode = filecode;
	}
}