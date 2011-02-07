/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.role;

import java.util.EnumSet;

import net.webhack.game.shared.Artifact;
import net.webhack.game.shared.Attributes;
import net.webhack.game.shared.Bindery;
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
public class Valkyrie extends Role {
	public Valkyrie(final Bindery bindery) {
		this.bindery = bindery;
		name = new String[] { "Valkyrie", null };
		title = new String[][] { { "Stripling", null }, { "Skirmisher", null },
				{ "Fighter", null }, { "Man-at-arms", "Woman-at-arms" },
				{ "Warrior", null }, { "Swashbuckler", null },
				{ "Hero", "Heroine" }, { "Champion", null }, { "Lord", "Lady" } };

		/* Norse */
		lgod = "Tyr";
		ngod = "Odin";
		cgod = "Loki";

		filecode = "Val";
		homebase = "the Shrine of Destiny";
		intermed = "the cave of Surtur";

		monster = new PM[] { PM.VALKYRIE, null };
		pet = null; /* PM.WINTER_WOLF_CUB */

		questLeader = PM.NORN;
		questGuardian = PM.WARRIOR;
		questNemisis = PM.LORD_SURTUR;

		questEnemy = new PM[] { PM.FIRE_ANT, PM.FIRE_GIANT };
		questMonsterClass = new MonsterClass[] { MonsterClass.ANT,
				MonsterClass.GIANT };
		questArtifact = Artifact.ORB_OF_FATE;

		allowedRace = EnumSet.of(Race.Races.HUMAN, Race.Races.DWARF);
		allowedGender = EnumSet.of(Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL, Alignment.NEUTRAL);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(10, 7, 7, 7, 10, 7);
		attrdist = new Attributes(30, 6, 7, 20, 30, 7);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(14, 0, 0, 8, 2, 0);
		/* Energy */enadv = new Advance(1, 0, 0, 1, 0, 1);

		maxLevel = 10;
		alignmentRecord = 0;

		spelbase = 10;
		spelheal = -2;
		spelshld = 0;
		spelarmr = 9;
		spelstat = You.Attribute.WIS;
		spelspec = ObjectName.SPE_CONE_OF_COLD;
		spelsbon = -4;
	}

}
