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
import net.webhack.game.shared.RandomHelper;
import net.webhack.game.shared.You;
import net.webhack.game.shared.race.Race;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Wizard extends Role {
	public Wizard(final RandomHelper random) {
		this.random = random;
		name = new String[] { "Wizard", null };
		title = new String[][] { { "Evoker", null }, { "Conjurer", null },
				{ "Thaumaturge", null }, { "Magician", null },
				{ "Enchanter", "Enchantress" }, { "Sorcerer", "Sorceress" },
				{ "Necromancer", null }, { "Wizard", null }, { "Mage", null } };

		/* Egyptian */
		lgod = "Ptah";
		ngod = "Thoth";
		cgod = "Anhur";

		filecode = "Wiz";
		homebase = "the Lonely Tower";
		intermed = "the Tower of Darkness";

		monster = new PM[] { PM.WIZARD, null };
		pet = PM.KITTEN;
		questLeader = PM.NEFERET_THE_GREEN;
		questGuardian = PM.APPRENTICE;
		questNemisis = PM.DARK_ONE;

		questEnemy = new PM[] { PM.VAMPIRE_BAT, PM.XORN };
		questMonsterClass = new MonsterClass[] { MonsterClass.BAT,
				MonsterClass.WRAITH };

		questArtifact = Artifact.EYE_OF_THE_AETHIOPICA;

		allowedRace = EnumSet.of(Race.Races.HUMAN, Race.Races.ELF,
				Race.Races.GNOME, Race.Races.ORC);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.NEUTRAL, Alignment.CHAOTIC);

		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(7, 10, 7, 7, 7, 7);
		attrdist = new Attributes(10, 30, 10, 20, 20, 10);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(10, 0, 0, 8, 1, 0);
		/* Energy */enadv = new Advance(4, 3, 0, 2, 0, 3);

		maxLevel = 12;
		alignmentRecord = 0;

		spelbase = 1;
		spelheal = 0;
		spelshld = 3;
		spelarmr = 10;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_MAGIC_MISSILE;
		spelsbon = -4;

	}
}
