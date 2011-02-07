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
public class Knight extends Role {
	public Knight(final Bindery bindery) {
		this.bindery = bindery;
		name = new String[] { "Knight", null };
		title = new String[][] { { "Gallant", null }, { "Esquire", null },
				{ "Bachelor", null }, { "Sergeant", null }, { "Knight", null },
				{ "Banneret", null }, { "Chevalier", "Chevaliere" },
				{ "Seignieur", "Dame" }, { "Paladin", null } };

		/* Celtic */
		lgod = "Lugh";
		ngod = "_Brigit";
		cgod = "Manannan Mac Lir";

		filecode = "Kni";
		homebase = "Camelot Castle";
		intermed = "the Isle of Glass";

		monster = new PM[] { PM.KNIGHT, null };
		pet = PM.PONY;
		questLeader = PM.KING_ARTHUR;
		questGuardian = PM.PAGE;
		questNemisis = PM.IXOTH;

		questEnemy = new PM[] { PM.QUASIT, PM.OCHRE_JELLY };
		questMonsterClass = new MonsterClass[] { MonsterClass.IMP,
				MonsterClass.JELLY };
		questArtifact = Artifact.MAGIC_MIRROR_OF_MERLIN;
		allowedRace = EnumSet.of(Race.Races.HUMAN);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(13, 7, 14, 8, 10, 17);
		attrdist = new Attributes(30, 15, 15, 10, 20, 10);
		/* Init Lower Higher */
		/* Hit points */
		hpadv = new Advance(14, 0, 0, 8, 2, 0);
		/* Energy */
		enadv = new Advance(1, 4, 0, 1, 0, 2);

		maxLevel = 10;
		alignmentRecord = 10;
		spelbase = 8;
		spelheal = -2;
		spelshld = 0;
		spelarmr = 9;
		spelstat = You.Attribute.WIS;
		spelspec = ObjectName.SPE_TURN_UNDEAD;
		spelsbon = -4;

	}
}