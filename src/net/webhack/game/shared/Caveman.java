package net.webhack.game.shared;

import java.util.EnumSet;

public class Caveman extends Role {
	{
		name = new String[] { "Caveman", "Cavewoman" };
		title = new String[][] { { "Troglodyte", null }, { "Aborigine", null },
				{ "Wanderer", null }, { "Vagrant", null },
				{ "Wayfarer", null }, { "Roamer", null }, { "Nomad", null },
				{ "Rover", null }, { "Pioneer", null } };

		/* Babylonian */
		lgod = "Anu";
		ngod = "_Ishtar";
		cgod = "Anshar";

		filecode = "Cav";
		homebase = "the Caves of the Ancestors";
		intermed = "the Dragon's Lair";

		monster = new PM[] { PM.CAVEMAN, PM.CAVEWOMAN };
		pet = PM.LITTLE_DOG;
		questLeader = PM.SHAMAN_KARNOV;
		questLeader = PM.NEANDERTHAL;
		questNemisis = PM.CHROMATIC_DRAGON;
		questEnemy = new PM[] { PM.BUGBEAR, PM.HILL_GIANT };
		questMonsterClass = new Monster[] { Monster.HUMANOID, Monster.GIANT };
		questArtifact = Artifact.SCEPTRE_OF_MIGHT;

		allowedRace = EnumSet.of(Race.HUMAN, Race.DWARF, Race.GNOME);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL, Alignment.NEUTRAL);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(10, 7, 7, 7, 8, 6);
		attrdist = new Attributes(30, 6, 7, 20, 30, 7);
		/* Init Lower Higher */
		/* Hit points */
		hpadv = new Advance(14, 0, 0, 8, 2, 0);
		/* Energy */
		enadv = new Advance(1, 0, 0, 1, 0, 1);
		maxLevel = 10;
		alignmentRecord = 0;

		spelbase = 12;
		spelheal = 0;
		spelshld = 1;
		spelarmr = 8;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_DIG;
		spelsbon = -4;

	};

}
