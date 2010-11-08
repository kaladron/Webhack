/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class Samurai extends Role {
	{
		name = new String[] { "Samurai", null };
		title = new String[][] { { "Hatamoto", null }, /* Banner Knight */
		{ "Ronin", null }, /* no allegiance */
		{ "Ninja", "Kunoichi" }, /* secret society */
		{ "Joshu", null }, /* heads a castle */
		{ "Ryoshu", null }, /* has a territory */
		{ "Kokushu", null }, /* heads a province */
		{ "Daimyo", null }, /* a samurai lord */
		{ "Kuge", null }, /* Noble of the Court */
		{ "Shogun", null } };/* supreme commander, warlord */

		/* Japanese */
		lgod = "_Amaterasu Omikami";
		ngod = "Raijin";
		cgod = "Susanowo";

		filecode = "Sam";
		homebase = "the Castle of the Taro Clan";
		intermed = "the Shogun's Castle";

		monster = new PM[] { PM.SAMURAI, null };
		pet = PM.LITTLE_DOG;

		questLeader = PM.LORD_SATO;
		questGuardian = PM.ROSHI;
		questNemisis = PM.ASHIKAGA_TAKAUJI;

		questEnemy = new PM[] { PM.WOLF, PM.STALKER };
		questMonsterClass = new MonsterClass[] { MonsterClass.DOG, MonsterClass.ELEMENTAL };
		questArtifact = Artifact.TSURUGI_OF_MURAMASA;

		allowedRace = EnumSet.of(Race.HUMAN);
		allowedGender = EnumSet.of(Gender.MALE, Gender.FEMALE);
		allowedAlignment = EnumSet.of(Alignment.LAWFUL);
		/* Str Int Wis Dex Con Cha */
		attrbase = new Attributes(10, 8, 7, 10, 17, 6);
		attrdist = new Attributes(30, 10, 8, 30, 14, 8);
		/* Init Lower Higher */
		/* Hit points */hpadv = new Advance(13, 0, 0, 8, 1, 0);
		/* Energy */enadv = new Advance(1, 0, 0, 1, 0, 1);

		maxLevel = 11;
		alignmentRecord = 10;

		spelbase = 10;
		spelheal = 0;
		spelshld = 0;
		spelarmr = 8;
		spelstat = You.Attribute.INT;
		spelspec = ObjectName.SPE_CLAIRVOYANCE;
		spelsbon = -4;

	}

}
