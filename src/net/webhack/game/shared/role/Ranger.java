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
import net.webhack.game.shared.Race;
import net.webhack.game.shared.You;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Ranger extends Role {
	{
		name = new String[] { "Ranger", null };

		title = new String[][] { { "Tenderfoot", null }, { "Lookout", null },
				{ "Trailblazer", null }, { "Reconnoiterer", "Reconnoiteress" },
				{ "Scout", null }, { "Arbalester", null }, /*
															 * One skilled at
															 * crossbows
															 */
				{ "Archer", null }, { "Sharpshooter", null },
				{ "Marksman", "Markswoman" } };

		/* Roman/planets */
		lgod = "Mercury";
		ngod = "_Venus";
		cgod = "Mars";

		filecode = "Ran";
		homebase = "Orion's camp";
		intermed = "the cave of the wumpus";

		monster = new PM[] { PM.RANGER, null };

		/* Orion & canis major */
		pet = PM.LITTLE_DOG;
		questLeader = PM.ORION;
		questGuardian = PM.HUNTER;
		questNemisis = PM.SCORPIUS;

		questEnemy = new PM[] { PM.FOREST_CENTAUR, PM.SCORPION };
		questMonsterClass = new MonsterClass[] { MonsterClass.CENTAUR,
				MonsterClass.SPIDER };

		questArtifact = Artifact.LONGBOW_OF_DIANA;

		allowedRace = EnumSet.of(Race.HUMAN, Race.ELF, Race.GNOME, Race.ORC);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.NEUTRAL, Alignment.CHAOTIC);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(13, 13, 13, 9, 13, 7);
		attrdist = new Attributes(30, 10, 10, 20, 20, 10);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(13, 0, 0, 6, 1, 0);
		/* Energy */enadv = new Advance(1, 0, 0, 1, 0, 1);

		maxLevel = 12;
		alignmentRecord = 10;

		spelbase = 9;
		spelheal = 2;
		spelshld = 1;
		spelarmr = 10;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_INVISIBILITY;
		spelsbon = -4;
	}
}
