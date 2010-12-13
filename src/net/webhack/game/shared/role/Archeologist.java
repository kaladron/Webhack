package net.webhack.game.shared.role;

import java.util.EnumSet;

import net.webhack.game.shared.Artifact;
import net.webhack.game.shared.Attributes;
import net.webhack.game.shared.Gender;
import net.webhack.game.shared.MonsterClass;
import net.webhack.game.shared.ObjectName;
import net.webhack.game.shared.PM;
import net.webhack.game.shared.You;
import net.webhack.game.shared.race.Race;

public class Archeologist extends Role {
	public Archeologist() {
		name = new String[] { "Archeologist", null };
		title = new String[][] { { "Digger", null }, { "Field Worker", null },
				{ "Investigator", null }, { "Exhumer", null },
				{ "Excavator", null }, { "Spelunker", null },
				{ "Speleologist", null }, { "Collector", null },
				{ "Curator", null } };

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

		questMonsterClass = new MonsterClass[] { MonsterClass.SNAKE,
				MonsterClass.MUMMY };
		questArtifact = Artifact.ORB_OF_DETECTION;

		allowedRace = EnumSet.of(Race.Races.HUMAN, Race.Races.DWARF,
				Race.Races.GNOME);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL, Alignment.NEUTRAL);

		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(7, 10, 10, 7, 7, 7);
		attrdist = new Attributes(20, 20, 20, 10, 20, 10);

		// Hit points
		hpadv = new Advance(11, 0, 0, 8, 1, 0); /* Hit points */

		// Energy
		enadv = new Advance(1, 0, 0, 1, 0, 1); /* Energy */

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
