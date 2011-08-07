package net.webhack.game.shared;


public enum MonsterName {

	// GRID_BUG(115, "grid bug", MonsterClass.XAN, 0, 12, 9, 0, 0, EnumSet.of(
	// G.GENO, G.SGROUP, G.NOCORPSE, 3), AT_BITE, AD_ELEC, 1, 1, NO_ATTK,
	// NO_ATTK, NO_ATTK, NO_ATTK, NO_ATTK, 15, 10, 0, MS_BUZZ, MZ_TINY,
	// EnumSet.of(Mr.ELEC, Mr.POISON), 0, M1.ANIMAL, M2.HOSTILE,
	// M3.INFRAVISIBLE);

	GRID_BUG();

	enum G {
		GENO, SGROUP, NOCORPSE;
	}

	enum M1 {
		ANIMAL;
	}

	enum M2 {
		HOSTILE;
	}

	enum M3 {
		INFRAVISIBLE;
	}

	enum Mr {
		ELEC, POISON;
	}

	MonsterName() {
	}

	MonsterName(final int idx, final String nam, final MonsterClass sym,
			final int lvl, final int mov, final int ac, final int mr,
			final int aln, final int gen, final int atk, final int wt,
			final int nut, final int pxl, final int snd, final int siz,
			final int mr1, final int mr2, final int flg1, final int flg2,
			final int flg3) {

	}

}
