/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Rogue extends Role {
	{
		name = new String[] { "Rogue", null };
		title = new String[][] { { "Footpad", null }, { "Cutpurse", null },
				{ "Rogue", null }, { "Pilferer", null }, { "Robber", null },
				{ "Burglar", null }, { "Filcher", null },
				{ "Magsman", "Magswoman" }, { "Thief", null } };

		/* Nehwon */
		lgod = "Issek";
		ngod = "Mog";
		cgod = "Kos";

		filecode = "Rog";
		homebase = "the Thieves' Guild Hall";
		intermed = "the Assassins' Guild Hall";
		monster = new PM[] { PM.ROGUE, null };
		pet = null;

		questLeader = PM.MASTER_OF_THIEVES;
		questGuardian = PM.THUG;
		questNemisis = PM.MASTER_ASSASSIN;

		questEnemy = new PM[] { PM.LEPRECHAUN, PM.GUARDIAN_NAGA };

		questMonsterClass = new MonsterClass[] { MonsterClass.NYMPH, MonsterClass.NAGA };

		questArtifact = Artifact.MASTER_KEY_OF_THIEVERY;

		allowedRace = EnumSet.of(Race.HUMAN, Race.ORC);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.CHAOTIC);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(7, 7, 7, 10, 7, 6);
		attrdist = new Attributes(20, 10, 10, 30, 20, 10);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(10, 0, 0, 8, 1, 0);
		/* Energy */enadv = new Advance(1, 0, 0, 1, 0, 1);

		maxLevel = 11;
		alignmentRecord = 10;

		spelbase = 8;
		spelheal = 0;
		spelshld = 1;
		spelarmr = 9;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_DETECT_TREASURE;
		spelsbon = -4;

	}

}
