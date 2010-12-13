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
public class Tourist extends Role {
	{
		name = new String[] { "Tourist", null };
		title = new String[][] { { "Rambler", null }, { "Sightseer", null },
				{ "Excursionist", null }, { "Peregrinator", "Peregrinatrix" },
				{ "Traveler", null }, { "Journeyer", null },
				{ "Voyager", null }, { "Explorer", null },
				{ "Adventurer", null } };

		/* Discworld */
		lgod = "Blind Io";
		ngod = "_The Lady";
		cgod = "Offler";

		filecode = "Tou";
		homebase = "Ankh-Morpork";
		intermed = "the Thieves' Guild Hall";

		monster = new PM[] { PM.TOURIST, null };
		pet = null;

		questLeader = PM.TWOFLOWER;
		questGuardian = PM.GUIDE;
		questNemisis = PM.MASTER_OF_THIEVES;

		questEnemy = new PM[] { PM.GIANT_SPIDER, PM.FOREST_CENTAUR };
		questMonsterClass = new MonsterClass[] { MonsterClass.SPIDER,
				MonsterClass.CENTAUR };

		questArtifact = Artifact.YENDORIAN_EXPRESS_CARD;

		allowedRace = EnumSet.of(Race.Races.HUMAN);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.NEUTRAL);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(7, 10, 6, 7, 7, 10);
		attrdist = new Attributes(15, 10, 10, 15, 30, 20);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(8, 0, 0, 8, 0, 0);
		/* Energy */enadv = new Advance(1, 0, 0, 1, 0, 1);

		maxLevel = 14;
		alignmentRecord = 0;
		spelbase = 5;
		spelheal = 1;
		spelshld = 2;
		spelarmr = 10;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_CHARM_MONSTER;
		spelsbon = -4;

	}

}
