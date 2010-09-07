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
		public String name[];
		public String title[];
	}

	public class Archeologist extends Role.Class {
		{
			final String name[] = { "Archeologist", null };
			final String title[][] = { { "Digger", null },
					{ "Field Worker", null }, { "Investigator", null },
					{ "Exhumer", null }, { "Excavator", null },
					{ "Spelunker", null }, { "Speleologist", null },
					{ "Collector", null }, { "Curator", null } };

			/* Central American */
			final String lgod = "Quetzalcoatl";
			final String ngod = "Camaxtli";
			final String cgod = "Huhetotl";

			final String filecode = "Arc";
			final String homebase = "the College of Archeology";
			final String intermed = "the Tomb of the Toltec Kings";

			final PM monster[] = { PM.ARCHEOLOGIST, null };
			final PM pet = null;
			final PM questLeader = PM.LORD_CARNARVON;
			final PM questGuardian = PM.STUDENT;
			final PM questNemisis = PM.MINION_OF_HUHETOTL;

			final PM questEnemy[] = { null, PM.HUMAN_MUMMY };

			final Monster questMonsterClass[] = { Monster.SNAKE, Monster.MUMMY };
			final Artifact questArtifact = Artifact.ORB_OF_DETECTION;

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

			int maxLevel = 14;
			int alignmentRecord = 10;

			/** base spellcasting penalty */
			int spelbase = 5;
			/** penalty (-bonus) for healing spells */
			int spelheal = 0;
			/** penalty for wearing any shield */
			int spelshld = 2;
			/** penalty for wearing metal armour */
			int spelarmr = 10;
			/** which stat (A_) is used */
			int spelstat; // A_INT
			/** spell (SPE_) the class excels at */
			int spelspec; // SPE_MAGIC_MAPPING
			/** penalty (-bonus) for that spell */
			int spelsbon = -4;

		}

	}

	public interface Gender {

	}

	public interface Alignment {

	}

	public interface Race {

	}

}
