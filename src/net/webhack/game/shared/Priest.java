/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Priest extends Role {
	{
		name = new String[] { "Priest", "Priestess" };
		title = new String[][] { { "Aspirant", null }, { "Acolyte", null },
				{ "Adept", null }, { "Priest", "Priestess" },
				{ "Curate", null }, { "Canon", "Canoness" }, { "Lama", null },
				{ "Patriarch", "Matriarch" },
				{ "High Priest", "High Priestess" } };

		/* chosen randomly from among the other roles */
		lgod = null;
		ngod = null;
		cgod = null;

		filecode = "Pri";
		homebase = "the Great Temple";
		intermed = "the Temple of Nalzok";

		monster = new PM[] { PM.PRIEST, PM.PRIESTESS };
		pet = null;
		questLeader = PM.ARCH_PRIEST;
		questGuardian = PM.ACOLYTE;
		questNemisis = PM.NALZOK;
		questEnemy = new PM[] { PM.HUMAN_ZOMBIE, PM.WRAITH };
		questMonsterClass = new MonsterClass[] { MonsterClass.ZOMBIE, MonsterClass.WRAITH };

		questArtifact = Artifact.MITRE_OF_HOLINESS;

		allowedRace = EnumSet.of(Race.HUMAN, Race.ELF);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL, Alignment.NEUTRAL,
				Alignment.CHAOTIC);

		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(7, 7, 10, 7, 7, 7);
		attrdist = new Attributes(15, 10, 30, 15, 20, 10);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(12, 0, 0, 8, 1, 0);
		/* Energy */enadv = new Advance(4, 3, 0, 2, 0, 2);

		maxLevel = 10;
		alignmentRecord = 0;

		spelbase = 3;
		spelheal = -2;
		spelshld = 2;
		spelarmr = 10;
		spelstat = You.Attribute.WIS;
		spelspec = ObjectName.SPE_REMOVE_CURSE;
		spelsbon = -4;

	}
}
