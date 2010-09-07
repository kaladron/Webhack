/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Role {

	public abstract class Class {
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

	public class Archeologist extends Role.Class {
		public Archeologist() {
			name = new String[] { "Archeologist", null };
			title = new String[][] { { "Digger", null },
					{ "Field Worker", null }, { "Investigator", null },
					{ "Exhumer", null }, { "Excavator", null },
					{ "Spelunker", null }, { "Speleologist", null },
					{ "Collector", null }, { "Curator", null } };

			/* Central American */
			lgod = "Quetzalcoatl";
			ngod = "Camaxtli";
			cgod = "Huhetotl";

			filecode = "Arc";
			homebase = "the College of Archeology";
			intermed = "the Tomb of the Toltec Kings";

			monster = new PM[] { PM.ARCHEOLOGIST, null };
			pet = null;
			questLeader = PM.LORD_CARNARVON;
			questGuardian = PM.STUDENT;
			questNemisis = PM.MINION_OF_HUHETOTL;

			questEnemy = new PM[] { null, PM.HUMAN_MUMMY };

			questMonsterClass = new Monster[] { Monster.SNAKE, Monster.MUMMY };
			questArtifact = Artifact.ORB_OF_DETECTION;

			// TODO(jeffbailey): Variations.
			// MH_HUMAN|MH_DWARF|MH_GNOME | ROLE_MALE|ROLE_FEMALE |
			// ROLE_LAWFUL|ROLE_NEUTRAL,

			// TODO(jeffbailey): Lowest attributes.
			/* Str Int Wis Dex Con Cha */
			// { 7, 10, 10, 7, 7, 7 },

			// TODO(jeffbailey): Highest Attributes.
			// { 20, 20, 20, 10, 20, 10 },

			// TODO(jeffbailey): Hitpoint advancement.
			/* Init Lower Higher */
			// { 11, 0, 0, 8, 1, 0 }, /* Hit points */

			// TODO(jeffbailey): Energy advancement.
			// { 1, 0, 0, 1, 0, 1 }, /* Energy */

			maxLevel = 14;
			alignmentRecord = 10;

			spelbase = 5;
			spelheal = 0;
			spelshld = 2;
			spelarmr = 10;
			spelstat = You.Attribute.INT;
			spelspec = ObjectName.SPE_MAGIC_MAPPING;
			spelsbon = -4;

		}
	}

	public enum Gender {
		MALE,
		FEMALE,
		NEUTER;
	}

	public interface Alignment {

	}

	public interface Race {

	}

}