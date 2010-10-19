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

	public class Advance {
		/* "fix" is the fixed amount, "rnd" is the random amount */
		final int infix, inrnd; /* at character initialization */
		final int lofix, lornd; /* gained per level < urole.xlev */
		final int hifix, hirnd; /* gained per level >= urole.xlev */

		public Advance(final int infix, final int inrnd, final int lofix,
				final int lornd, final int hifix, final int hirnd) {
			this.infix = infix;
			this.inrnd = inrnd;
			this.lofix = lofix;
			this.lornd = lornd;
			this.hifix = hifix;
			this.hirnd = hirnd;
		}
	};

	public enum Alignment {
		LAWFUL, NEUTRAL, CHAOTIC;
	}

	public enum Roles {
		ARCHEOLOGIST,

		BARBARIAN,

		CAVEMAN,

		HEALER,

		KNIGHT,

		MONK,

		PRIEST,

		RANGER,

		ROGUE,

		SAMURAI,

		TOURIST,

		VALKYRIE,

		WIZARD
	}

	public static Role getRandom(final RandomHelper random) {
		// TODO(jeffbailey): STUB!
		// return roles[random.rn2(roles.length)];
		return new Archeologist();
	}

	public static Role newRole(final Roles role) {
		switch (role) {
		case ARCHEOLOGIST:
			return new Archeologist();
		case BARBARIAN:
			return new Barbarian();
		case CAVEMAN:
			return new Caveman();
		case HEALER:
			return new Healer();
		case KNIGHT:
			return new Knight();
		case MONK:
			return new Monk();
		case PRIEST:
			return new Priest();
		case RANGER:
			return new Ranger();
		case ROGUE:
			return new Rogue();
		case SAMURAI:
			return new Samurai();
		case TOURIST:
			return new Tourist();
		case VALKYRIE:
			return new Valkyrie();
		case WIZARD:
			return new Wizard();
		default:
			return null;
		}
	}

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

}
