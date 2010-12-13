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
public class Barbarian extends Role {
	{
		name = new String[] { "Barbarian", null };
		title = new String[][] { { "Plunderer", "Plunderess" },
				{ "Pillager", null }, { "Bandit", null }, { "Brigand", null },
				{ "Raider", null }, { "Reaver", null }, { "Slayer", null },
				{ "Chieftain", "Chieftainess" }, { "Conqueror", "Conqueress" } };

		/* Hyborian */
		lgod = "Mitra";
		ngod = "Crom";
		cgod = "Set";

		filecode = "Bar";
		homebase = "the Camp of the Duali Tribe";
		intermed = "the Duali Oasis";

		monster = new PM[] { PM.BARBARIAN, null };
		pet = null;
		questLeader = PM.PELIAS;
		questGuardian = PM.CHIEFTAIN;
		questNemisis = PM.THOTH_AMON;

		questEnemy = new PM[] { PM.OGRE, PM.TROLL };
		questMonsterClass = new MonsterClass[] { MonsterClass.OGRE,
				MonsterClass.TROLL };
		questArtifact = Artifact.HEART_OF_AHRIMAN;

		allowedRace = EnumSet.of(Race.Races.HUMAN, Race.Races.ORC);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.NEUTRAL, Alignment.CHAOTIC);

		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(16, 7, 7, 15, 16, 6);
		attrdist = new Attributes(30, 6, 7, 20, 30, 7);
		/* Init Lower Higher */
		hpadv = new Advance(14, 0, 0, 10, 2, 0); /* Hit points */
		enadv = new Advance(1, 0, 0, 1, 0, 1); /* Energy */

		maxLevel = 10;
		alignmentRecord = 10;
		spelbase = 14;
		spelheal = 0;
		spelshld = 0;
		spelarmr = 8;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_HASTE_SELF;
		spelsbon = -4;

	}

}
