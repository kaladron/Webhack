/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Healer extends Role {
	{
		name = new String[] { "Healer", null };
		title = new String[][] { { "Rhizotomist", null }, { "Empiric", null },
				{ "Embalmer", null }, { "Dresser", null },
				{ "Medicus ossium", "Medica ossium" }, { "Herbalist", null },
				{ "Magister", "Magistra" }, { "Physician", null },
				{ "Chirurgeon", null } };

		/* Greek */
		lgod = "_Athena";
		ngod = "Hermes";
		cgod = "Poseidon";

		filecode = "Hea";
		homebase = "the Temple of Epidaurus";
		intermed = "the Temple of Coeus";

		monster = new PM[] { PM.HEALER, null };
		pet = null;
		questLeader = PM.HIPPOCRATES;
		questGuardian = PM.ATTENDANT;
		questNemisis = PM.CYCLOPS;
		questEnemy = new PM[] { PM.GIANT_RAT, PM.SNAKE };
		questMonsterClass = new MonsterClass[] { MonsterClass.RODENT, MonsterClass.YETI };
		questArtifact = Artifact.STAFF_OF_AESCULAPIUS;

		allowedRace = EnumSet.of(Race.HUMAN, Race.GNOME);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.NEUTRAL);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(7, 7, 13, 7, 11, 16);
		attrdist = new Attributes(15, 20, 20, 15, 25, 5);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(11, 0, 0, 8, 1, 0);
		/* Energy */enadv = new Advance(1, 4, 0, 1, 0, 2);

		maxLevel = 20;
		alignmentRecord = 10;

		spelbase = 3;
		spelheal = -3;
		spelshld = 2;
		spelarmr = 10;
		spelstat = You.Attribute.WIS;
		spelspec = ObjectName.SPE_CURE_SICKNESS;
		spelsbon = -4;

	}

}
