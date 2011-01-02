/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.role;

import java.util.EnumSet;

import net.webhack.game.shared.Artifact;
import net.webhack.game.shared.Attributes;
import net.webhack.game.shared.Gender;
import net.webhack.game.shared.MonsterClass;
import net.webhack.game.shared.ObjectName;
import net.webhack.game.shared.PM;
import net.webhack.game.shared.RandomHelper;
import net.webhack.game.shared.Stub;
import net.webhack.game.shared.You;
import net.webhack.game.shared.monsters.GridBug;
import net.webhack.game.shared.monsters.Monster;
import net.webhack.game.shared.race.Race;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public abstract class Role {

	public class Advance {
		/* "fix" is the fixed amount, "rnd" is the random amount */
		public final int infix; /* at character initialization */
		public final int inrnd;
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
	}

	public enum Alignment {
		LAWFUL, NEUTRAL, CHAOTIC;
	};

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
		return new Archeologist(random);
	}

	public static Role newRole(final RandomHelper random, final Roles role) {
		switch (role) {
		case ARCHEOLOGIST:
			return new Archeologist(random);
		case BARBARIAN:
			return new Barbarian(random);
		case CAVEMAN:
			return new Caveman(random);
		case HEALER:
			return new Healer(random);
		case KNIGHT:
			return new Knight(random);
		case MONK:
			return new Monk(random);
		case PRIEST:
			return new Priest(random);
		case RANGER:
			return new Ranger(random);
		case ROGUE:
			return new Rogue(random);
		case SAMURAI:
			return new Samurai(random);
		case TOURIST:
			return new Tourist(random);
		case VALKYRIE:
			return new Valkyrie(random);
		case WIZARD:
			return new Wizard(random);
		default:
			return null;
		}
	}

	protected RandomHelper random;

	public String[] name;

	public String[][] title;
	public String lgod;

	public String ngod;
	public String cgod;
	public String filecode;

	public String homebase;
	public String intermed;
	public PM[] monster;
	PM pet;
	PM questLeader;

	PM questGuardian;

	PM questNemisis;
	PM questEnemy[];

	MonsterClass questMonsterClass[];
	Artifact questArtifact;
	EnumSet<Race.Races> allowedRace;

	EnumSet<Gender> allowedGender;
	EnumSet<Alignment> allowedAlignment;

	Attributes attrbase;
	Attributes attrdist;

	public Advance hpadv;
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

	@Stub
	public Monster getMonster(final Gender gender) {
		return new GridBug(random);
	}

}
