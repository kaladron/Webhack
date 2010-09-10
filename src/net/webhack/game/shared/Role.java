/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public abstract class Role {

	public String[] name;
	public String[][] title;

	public String lgod;
	public String ngod;
	public String cgod;

	public String filecode;
	public String homebase;
	public String intermed;

	PM[] monster;
	PM pet;
	PM questLeader;
	PM questGuardian;
	PM questNemisis;

	PM questEnemy[];

	Monster questMonsterClass[];
	Artifact questArtifact;

	EnumSet<Race> allowedRace;
	EnumSet<Gender> allowedGender;
	EnumSet<Alignment> allowedAlignment;

	Attributes attrbase;
	Attributes attrdist;

	Advance hpadv;
	Advance enadv;

	int maxLevel;
	int alignmentRecord;

	/** base spellcasting penalty */
	int spelbase;
	/** penalty (-bonus) for healing spells */
	int spelheal;
	/** penalty for wearing any shield */
	int spelshld;
	/** penalty for wearing metal armour */
	int spelarmr;
	/** which stat is used */
	You.Attribute spelstat;
	/** spell (SPE_) the class excels at */
	ObjectName spelspec;
	/** penalty (-bonus) for that spell */
	int spelsbon;

	public class Advance {
		/* "fix" is the fixed amount, "rnd" is the random amount */
		final int infix, inrnd; /* at character initialization */
		final int lofix, lornd; /* gained per level < urole.xlev */
		final int hifix, hirnd; /* gained per level >= urole.xlev */

		public Advance(int infix, int inrnd, int lofix, int lornd, int hifix,
				int hirnd) {
			this.infix = infix;
			this.inrnd = inrnd;
			this.lofix = lofix;
			this.lornd = lornd;
			this.hifix = hifix;
			this.hirnd = hirnd;
		}
	}

	public enum Gender {
		MALE, FEMALE, NEUTER;
	}

	public enum Alignment {
		LAWFUL, NEUTRAL, CHAOTIC;
	}

	public enum Race {
		HUMAN, ELF, DWARF, GNOME, ORC;
	}

}
