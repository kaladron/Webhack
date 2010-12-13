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
import net.webhack.game.shared.You;
import net.webhack.game.shared.race.Race;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Monk extends Role {
	{
		name = new String[] { "Monk", null };
		title = new String[][] { { "Candidate", null }, { "Novice", null },
				{ "Initiate", null }, { "Student of Stones", null },
				{ "Student of Waters", null }, { "Student of Metals", null },
				{ "Student of Winds", null }, { "Student of Fire", null },
				{ "Master", null } };

		/* Chinese */
		lgod = "Shan Lai Ching";
		ngod = "Chih Sung-tzu";
		cgod = "Huan Ti";
		filecode = "Mon";
		homebase = "the Monastery of Chan-Sune";
		intermed = "the Monastery of the Earth-Lord";

		monster = new PM[] { PM.MONK, null };
		pet = null;
		questLeader = PM.GRAND_MASTER;
		questGuardian = PM.ABBOT;
		questNemisis = PM.MASTER_KAEN;

		questEnemy = new PM[] { PM.EARTH_ELEMENTAL, PM.XORN };
		questMonsterClass = new MonsterClass[] { MonsterClass.ELEMENTAL,
				MonsterClass.XORN };

		questArtifact = Artifact.EYES_OF_THE_OVERWORLD;

		allowedRace = EnumSet.of(Race.Races.HUMAN);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL, Alignment.NEUTRAL,
				Alignment.CHAOTIC);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(10, 7, 8, 8, 7, 7);
		attrdist = new Attributes(25, 10, 20, 20, 15, 10);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(12, 0, 0, 8, 1, 0);
		/* Energy */enadv = new Advance(2, 2, 0, 2, 0, 2);

		maxLevel = 10;
		alignmentRecord = 10;

		spelbase = 8;
		spelheal = -2;
		spelshld = 2;
		spelarmr = 20;
		spelstat = You.Attribute.WIS;
		spelspec = ObjectName.SPE_RESTORE_ABILITY;
		spelsbon = -4;

	}

}
