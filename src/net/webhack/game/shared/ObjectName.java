/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public enum ObjectName {

	STRANGE_OBJECT,

	ARROW,

	ELVEN_ARROW,

	ORCISH_ARROW,

	SILVER_ARROW,

	YA,

	CROSSBOW_BOLT,

	DART,

	SHURIKEN,

	BOOMERANG,

	SPEAR(new Weapon(), 10, "spear", null, true, true, false, 50, 30, 3, 6, 8,
			0, EnumSet.of(WeaponType.PIERCE), Skills.SPEAR, Material.IRON),

	ELVEN_SPEAR(new Weapon(), 11, "elven spear", "runed spear", false, true,
			false, 10, 30, 3, 7, 8, 0, EnumSet.of(WeaponType.PIERCE),
			Skills.SPEAR, Material.WOOD),

	ORCISH_SPEAR(new Weapon(), 12, "orcish spear", "crude spear", false, true,
			false, 13, 30, 3, 5, 8, 0, EnumSet.of(WeaponType.PIERCE),
			Skills.SPEAR, Material.IRON),

	DWARVISH_SPEAR(new Weapon(), 13, "dwarvish spear", "stout spear", false,
			true, false, 12, 35, 3, 8, 8, 0, EnumSet.of(WeaponType.PIERCE),
			Skills.SPEAR, Material.IRON),

	SILVER_SPEAR(new Weapon(), 14, "silver spear", null, true, true, false, 2,
			36, 40, 6, 8, 0, EnumSet.of(WeaponType.PIERCE), Skills.SPEAR,
			Material.SILVER),

	JAVELIN(new Weapon(), 15, "javelin", "throwing spear", false, true, false,
			10, 20, 3, 6, 6, 0, EnumSet.of(WeaponType.PIERCE), Skills.JAVELIN,
			Material.IRON),

	/* +1 small, +2d4 large */
	TRIDENT(new Weapon(), 16, "trident", null, true, false, false, 8, 25, 5, 6,
			4, 0, EnumSet.of(WeaponType.PIERCE), Skills.TRIDENT, Material.IRON),

	DAGGER(new Weapon(), 17, "dagger", null, true, true, false, 30, 10, 4, 4,
			3, 2, EnumSet.of(WeaponType.PIERCE), Skills.DAGGER, Material.IRON),

	ELVEN_DAGGER(new Weapon(), 18, "elven dagger", "runed dagger", false, true,
			false, 10, 10, 4, 5, 3, 2, EnumSet.of(WeaponType.PIERCE),
			Skills.DAGGER, Material.WOOD),

	ORCISH_DAGGER(new Weapon(), 19, "orcish dagger", "crude dagger", false,
			true, false, 12, 10, 4, 3, 3, 2, EnumSet.of(WeaponType.PIERCE),
			Skills.DAGGER, Material.IRON),

	SILVER_DAGGER(new Weapon(), 20, "silver dagger", null, true, true, false,
			3, 12, 40, 4, 3, 2, EnumSet.of(WeaponType.PIERCE), Skills.DAGGER,
			Material.SILVER),

	ATHAME(new Weapon(), 21, "athame", null, true, true, false, 0, 10, 4, 4, 3,
			2, EnumSet.of(WeaponType.SLASH), Skills.DAGGER, Material.IRON),

	SCALPEL(new Weapon(), 22, "scalpel", null, true, true, false, 0, 5, 6, 3,
			3, 2, EnumSet.of(WeaponType.SLASH), Skills.KNIFE, Material.METAL),

	KNIFE(new Weapon(), 23, "knife", null, true, true, false, 20, 5, 4, 3, 2,
			0, EnumSet.of(WeaponType.PIERCE, WeaponType.SLASH), Skills.KNIFE,
			Material.IRON),

	STILETTO(new Weapon(), 24, "stiletto", null, true, true, false, 5, 5, 4, 3,
			2, 0, EnumSet.of(WeaponType.PIERCE, WeaponType.SLASH),
			Skills.KNIFE, Material.IRON),

	WORM_TOOTH(new Weapon(), 25, "worm tooth", null, true, false, false, 0, 20,
			2, 2, 2, 0, null, Skills.KNIFE, null),

	CRYSKNIFE(new Weapon(), 26, "crysknife", null, true, false, false, 0, 20,
			100, 10, 10, 3, EnumSet.of(WeaponType.PIERCE), Skills.KNIFE,
			Material.MINERAL),

	AXE(new Weapon(), 27, "axe", null, true, false, false, 40, 60, 8, 6, 4, 0,
			EnumSet.of(WeaponType.SLASH), Skills.AXE, Material.IRON),

	/* "double-bitted" ? */
	BATTLE_AXE(new Weapon(), 28, "battle-axe", "double-headed axe", false,
			false, true, 10, 120, 40, 8, 6, 0, EnumSet.of(WeaponType.SLASH),
			Skills.AXE, Material.IRON),

	SHORT_SWORD(new Weapon(), 29, "short sword", null, true, false, false, 8,
			30, 10, 6, 8, 0, EnumSet.of(WeaponType.PIERCE), Skills.SHORT_SWORD,
			Material.IRON),

	ELVEN_SHORT_SWORD(new Weapon(), 30, "elven short sword",
			"runed short sword", false, false, false, 2, 30, 10, 8, 8, 0,
			EnumSet.of(WeaponType.PIERCE), Skills.SHORT_SWORD, Material.WOOD),

	ORCISH_SHORT_SWORD(new Weapon(), 31, "orcish short sword",
			"crude short sword", false, false, false, 3, 30, 10, 5, 8, 0,
			EnumSet.of(WeaponType.PIERCE), Skills.SHORT_SWORD, Material.IRON),

	DWARVISH_SHORT_SWORD(new Weapon(), 32, "dwarvish short sword",
			"broad short sword", false, false, false, 2, 30, 10, 7, 8, 0,
			EnumSet.of(WeaponType.PIERCE), Skills.SHORT_SWORD, Material.IRON),

	SCIMITAR(new Weapon(), 33, "scimitar", "curved sword", false, false, false,
			15, 40, 15, 8, 8, 0, EnumSet.of(WeaponType.SLASH), Skills.SCIMITAR,
			Material.IRON),

	SILVER_SABER(new Weapon(), 34, "silver saber", null, true, false, false, 6,
			40, 75, 8, 8, 0, EnumSet.of(WeaponType.SLASH), Skills.SABER,
			Material.SILVER),

	/* +d4 small, +1 large */
	BROADSWORD(new Weapon(), 35, "broadsword", null, true, false, false, 8, 70,
			10, 4, 6, 0, EnumSet.of(WeaponType.SLASH), Skills.BROAD_SWORD,
			Material.IRON),

	/* +d4 small, +1 large */
	ELVEN_BROADSWORD(new Weapon(), 36, "elven broadsword", "runed broadsword",
			false, false, false, 4, 70, 10, 6, 6, 0, EnumSet
					.of(WeaponType.SLASH), Skills.BROAD_SWORD, Material.WOOD),

	LONG_SWORD(new Weapon(), 37, "long sword", null, true, false, false, 50,
			40, 15, 8, 12, 0, EnumSet.of(WeaponType.SLASH), Skills.LONG_SWORD,
			Material.IRON),

	/* +2d6 large */
	TWO_HANDED_SWORD(new Weapon(), 38, "two-handed sword", null, true, false,
			true, 22, 150, 50, 12, 6, 0, EnumSet.of(WeaponType.SLASH),
			Skills.TWO_HANDED_SWORD, Material.IRON),

	KATANA(new Weapon(), 39, "katana", "samurai sword", false, false, false, 4,
			40, 80, 10, 12, 1, EnumSet.of(WeaponType.SLASH), Skills.LONG_SWORD,
			Material.IRON),

	/* +2d6 large */
	TSURUGI(new Weapon(), 40, "tsurugi", "long samurai sword", false, false,
			true, 0, 60, 500, 16, 8, 2, EnumSet.of(WeaponType.SLASH),
			Skills.TWO_HANDED_SWORD, Material.METAL),

	RUNESWORD(new Weapon(), 41, "runesword", "runed broadsword", false, false,
			false, 0, 40, 300, 4, 6, 0, EnumSet.of(WeaponType.SLASH),
			Skills.BROAD_SWORD, Material.IRON),

	/* polearms */
	/* spear-type */

	/* +1 large */
	PARTISAN(new Weapon(), 42, "partisan", "vulgar polearm", false, false,
			true, 5, 80, 10, 6, 6, 0, EnumSet.of(WeaponType.PIERCE),
			Skills.POLEARMS, Material.IRON),

	/* +d4 both */
	RANSEUR(new Weapon(), 43, "ranseur", "hilted polearm", false, false, true,
			5, 50, 6, 4, 4, 0, EnumSet.of(WeaponType.PIERCE), Skills.POLEARMS,
			Material.IRON),

	/* +1 small, +d6 large */
	SPETUM(new Weapon(), 44, "spetum", "forked polearm", false, false, true, 5,
			50, 5, 6, 6, 0, EnumSet.of(WeaponType.PIERCE), Skills.POLEARMS,
			Material.IRON),

	GLAIVE(new Weapon(), 45, "glaive", "single-edged polearm", false, false,
			true, 8, 75, 6, 6, 10, 0, EnumSet.of(WeaponType.SLASH),
			Skills.POLEARMS, Material.IRON),

	LANCE(new Weapon(), 46, "lance", null, true, false, false, 4, 180, 10, 6,
			8, 0, EnumSet.of(WeaponType.PIERCE), Skills.LANCE, Material.IRON),

	/* axe-type */

	/* +1d6 large */
	HALBERD(new Weapon(), 47, "halberd", "angled poleaxe", false, false, true,
			8, 150, 10, 10, 6, 0, EnumSet.of(WeaponType.PIERCE,
					WeaponType.SLASH), Skills.POLEARMS, Material.IRON),

	/* +1d4 small, +2d4 large */
	BARDICHE(new Weapon(), 48, "bardiche", "long poleaxe", false, false, true,
			4, 120, 7, 4, 4, 0, EnumSet.of(WeaponType.SLASH), Skills.POLEARMS,
			Material.IRON),

	/* +d4 both */
	VOULGE(new Weapon(), 49, "voulge", "pole cleaver", false, false, true, 4,
			125, 5, 4, 4, 0, EnumSet.of(WeaponType.SLASH), Skills.POLEARMS,
			Material.IRON),

	DWARVISH_MATTOCK(new Weapon(), 50, "dwarvish mattock", "broad pick", false,
			false, true, 13, 120, 50, 12, 8, -1, EnumSet
					.of(WeaponType.BLUDGEON), Skills.PICK_AXE, Material.IRON),

	/* curved/hooked */

	FAUCHARD(new Weapon(), 51, "fauchard", "pole sickle", false, false, true,
			6, 60, 5, 6, 8, 0, EnumSet.of(WeaponType.PIERCE, WeaponType.SLASH),
			Skills.POLEARMS, Material.IRON),

	/* +1d4 small */
	GUISARME(new Weapon(), 52, "guisarme", "pruning hook", false, false, true,
			6, 80, 5, 4, 8, 0, EnumSet.of(WeaponType.SLASH), Skills.POLEARMS,
			Material.IRON),

	/* +1d4 small */
	BILL_GUISARME(new Weapon(), 53, "bill-guisarme", "hooked polearm", false,
			false, true, 4, 120, 7, 4, 10, 0, EnumSet.of(WeaponType.PIERCE,
					WeaponType.SLASH), Skills.POLEARMS, Material.IRON),

	/* other */

	/* +1d4 small */
	LUCERN_HAMMER(new Weapon(), 54, "lucern hammer", "pronged polearm", false,
			false, true, 5, 150, 7, 4, 6, 0, EnumSet.of(WeaponType.BLUDGEON,
					WeaponType.PIERCE), Skills.POLEARMS, Material.IRON),

	BEC_DE_CORBIN(new Weapon(), 55, "bec de corbin", "beaked polearm", false,
			false, true, 4, 100, 8, 8, 6, 0, EnumSet.of(WeaponType.BLUDGEON,
					WeaponType.PIERCE), Skills.POLEARMS, Material.IRON),

	/* bludgeons */

	/* +1 small */
	MACE(new Weapon(), 56, "mace", null, true, false, false, 40, 30, 5, 6, 6,
			0, EnumSet.of(WeaponType.BLUDGEON), Skills.MACE, Material.IRON),

	/* +d4 small, +1 large */
	MORNING_STAR(new Weapon(), 57, "morning star", null, true, false, false,
			12, 120, 10, 4, 6, 0, EnumSet.of(WeaponType.BLUDGEON),
			Skills.MORNING_STAR, Material.IRON),

	/* +1 small */
	WAR_HAMMER(new Weapon(), 58, "war hammer", null, true, false, false, 15,
			50, 5, 4, 4, 0, EnumSet.of(WeaponType.BLUDGEON), Skills.HAMMER,
			Material.IRON),

	CLUB(new Weapon(), 59, "club", null, true, false, false, 12, 30, 3, 6, 3,
			0, EnumSet.of(WeaponType.BLUDGEON), Skills.CLUB, Material.WOOD),

	RUBBER_HOSE(new Weapon(), 60, "rubber hose", null, true, false, false, 0,
			20, 3, 4, 3, 0, EnumSet.of(WeaponType.BLUDGEON), Skills.WHIP,
			Material.PLASTIC),

	QUARTERSTAFF(new Weapon(), 61, "quarterstaff", "staff", false, false, true,
			11, 40, 5, 6, 6, 0, EnumSet.of(WeaponType.BLUDGEON),
			Skills.QUARTERSTAFF, Material.WOOD),

	/* two-piece */

	AKLYS(new Weapon(), 62, "aklys", "thonged club", false, false, false, 8,
			15, 4, 6, 3, 0, EnumSet.of(WeaponType.BLUDGEON), Skills.CLUB,
			Material.IRON),

	/* +1 small, +1d4 large */
	FLAIL(new Weapon(), 63, "flail", null, true, false, false, 40, 15, 4, 6, 4,
			0, EnumSet.of(WeaponType.BLUDGEON), Skills.FLAIL, Material.IRON),

	/* misc */

	BULLWHIP(new Weapon(), 64, "bullwhip", null, true, false, false, 2, 20, 4,
			2, 1, 0, null, Skills.WHIP, Material.LEATHER),

	BOW,

	ELVEN_BOW,

	ORCISH_BOW,

	YUMI,

	SLING,

	CROSSBOW,

	ELVEN_LEATHER_HELM,

	ORCISH_HELM,

	DWARVISH_IRON_HELM,

	FEDORA,

	CORNUTHAUM,

	DUNCE_CAP,

	DENTED_POT,

	HELMET,

	HELM_OF_BRILLIANCE,

	HELM_OF_OPPOSITE_ALIGNMENT,

	HELM_OF_TELEPATHY,

	GRAY_DRAGON_SCALE_MAIL,

	SILVER_DRAGON_SCALE_MAIL,

	RED_DRAGON_SCALE_MAIL,

	WHITE_DRAGON_SCALE_MAIL,

	ORANGE_DRAGON_SCALE_MAIL,

	BLACK_DRAGON_SCALE_MAIL,

	BLUE_DRAGON_SCALE_MAIL,

	GREEN_DRAGON_SCALE_MAIL,

	YELLOW_DRAGON_SCALE_MAIL,

	GRAY_DRAGON_SCALES,

	SILVER_DRAGON_SCALES,

	RED_DRAGON_SCALES,

	WHITE_DRAGON_SCALES,

	ORANGE_DRAGON_SCALES,

	BLACK_DRAGON_SCALES,

	BLUE_DRAGON_SCALES,

	GREEN_DRAGON_SCALES,

	YELLOW_DRAGON_SCALES,

	PLATE_MAIL,

	CRYSTAL_PLATE_MAIL,

	BRONZE_PLATE_MAIL,

	SPLINT_MAIL,

	BANDED_MAIL,

	DWARVISH_MITHRIL_COAT,

	ELVEN_MITHRIL_COAT,

	CHAIN_MAIL,

	ORCISH_CHAIN_MAIL,

	SCALE_MAIL,

	STUDDED_LEATHER_ARMOR,

	RING_MAIL,

	ORCISH_RING_MAIL,

	LEATHER_ARMOR,

	LEATHER_JACKET,

	HAWAIIAN_SHIRT,

	T_SHIRT,

	MUMMY_WRAPPING,

	ELVEN_CLOAK,

	ORCISH_CLOAK,

	DWARVISH_CLOAK,

	OILSKIN_CLOAK,

	ROBE,

	ALCHEMY_SMOCK,

	LEATHER_CLOAK,

	CLOAK_OF_PROTECTION,

	CLOAK_OF_INVISIBILITY,

	CLOAK_OF_MAGIC_RESISTANCE,

	CLOAK_OF_DISPLACEMENT,

	SMALL_SHIELD,

	ELVEN_SHIELD,

	URUK_HAI_SHIELD,

	ORCISH_SHIELD,

	LARGE_SHIELD,

	DWARVISH_ROUNDSHIELD,

	SHIELD_OF_REFLECTION,

	LEATHER_GLOVES,

	GAUNTLETS_OF_FUMBLING,

	GAUNTLETS_OF_POWER,

	GAUNTLETS_OF_DEXTERITY,

	LOW_BOOTS,

	IRON_SHOES,

	HIGH_BOOTS,

	SPEED_BOOTS,

	WATER_WALKING_BOOTS,

	JUMPING_BOOTS,

	ELVEN_BOOTS,

	KICKING_BOOTS,

	FUMBLE_BOOTS,

	LEVITATION_BOOTS,

	RIN_ADORNMENT(new Ring(), 150, "adornment", Property.ADORNED, "wooden",
			100, true, true, 2, Material.WOOD),

	RIN_GAIN_STRENGTH(new Ring(), 151, "gain strength", null, "granite", 150,
			true, true, 7, Material.MINERAL),

	RIN_GAIN_CONSTITUTION(new Ring(), 152, "gain constitution", null, "opal",
			150, true, true, 7, Material.MINERAL),

	RIN_INCREASE_ACCURACY(new Ring(), 153, "increase accuracy", null, "clay",
			150, true, true, 4, Material.MINERAL),

	RIN_INCREASE_DAMAGE(new Ring(), 154, "increase damage", null, "coral", 150,
			true, true, 4, Material.MINERAL),

	RIN_PROTECTION(new Ring(), 155, "protection", Property.PROTECTION,
			"black onyx", 100, true, true, 7, Material.MINERAL),

	RIN_REGENERATION(new Ring(), 156, "regeneration", Property.REGENERATION,
			"moonstone", 200, true, false, 6, Material.MINERAL),

	RIN_SEARCHING(new Ring(), 157, "searching", Property.SEARCHING,
			"tiger eye", 200, true, false, 6, Material.GEMSTONE),

	RIN_STEALTH(new Ring(), 158, "stealth", Property.STEALTH, "jade", 100,
			true, false, 6, Material.GEMSTONE),

	RIN_SUSTAIN_ABILITY(new Ring(), 159, "sustain ability",
			Property.FIXED_ABIL, "bronze", 100, true, false, 4, Material.COPPER),

	RIN_LEVITATION(new Ring(), 160, "levitation", Property.LEVITATION, "agate",
			200, true, false, 7, Material.GEMSTONE),

	RIN_HUNGER(new Ring(), 161, "hunger", Property.HUNGER, "topaz", 100, true,
			false, 8, Material.GEMSTONE),

	RIN_AGGRAVATE_MONSTER(new Ring(), 162, "aggravate monster",
			Property.AGGRAVATE_MONSTER, "sapphire", 150, true, false, 9,
			Material.GEMSTONE),

	RIN_CONFLICT(new Ring(), 163, "conflict", Property.CONFLICT, "ruby", 300,
			true, false, 9, Material.GEMSTONE),

	RIN_WARNING(new Ring(), 164, "warning", Property.WARNING, "diamond", 100,
			true, false, 10, Material.GEMSTONE),

	RIN_POISON_RESISTANCE(new Ring(), 165, "poison resistance",
			Property.POISON_RES, "pearl", 150, true, false, 4, Material.IRON),

	RIN_FIRE_RESISTANCE(new Ring(), 166, "fire resistance", Property.FIRE_RES,
			"iron", 200, true, false, 5, Material.IRON),

	RIN_COLD_RESISTANCE(new Ring(), 167, "cold resistance", Property.COLD_RES,
			"brass", 150, true, false, 4, Material.COPPER),

	RIN_SHOCK_RESISTANCE(new Ring(), 168, "shock resistance",
			Property.SHOCK_RES, "copper", 150, true, false, 3, Material.COPPER),

	RIN_FREE_ACTION(new Ring(), 169, "free action", Property.FREE_ACTION,
			"twisted", 200, true, false, 6, Material.IRON),

	RIN_SLOW_DIGESTION(new Ring(), 170, "slow digestion",
			Property.SLOW_DIGESTION, "steel", 200, true, false, 8,
			Material.IRON),

	RIN_TELEPORTATION(new Ring(), 171, "teleportation", Property.TELEPORT,
			"silver", 200, true, false, 3, Material.SILVER),

	RIN_TELEPORT_CONTROL(new Ring(), 172, "teleport control",
			Property.TELEPORT_CONTROL, "gold", 300, true, false, 3,
			Material.GOLD),

	RIN_POLYMORPH(new Ring(), 173, "polymorph", Property.POLYMORPH, "ivory",
			300, true, false, 4, Material.BONE),

	RIN_POLYMORPH_CONTROL(new Ring(), 174, "polymorph control",
			Property.POLYMORPH_CONTROL, "emerald", 300, true, false, 8,
			Material.GEMSTONE),

	RIN_INVISIBILITY(new Ring(), 175, "invisibility", Property.INVIS, "wire",
			150, true, false, 5, Material.IRON),

	RIN_SEE_INVISIBLE(new Ring(), 176, "see invisible", Property.SEE_INVIS,
			"engagement", 150, true, false, 5, Material.IRON),

	RIN_PROTECTION_FROM_SHAPE_CHAN(new Ring(), 177,
			"protection from shape changers",
			Property.PROT_FROM_SHAPE_CHANGERS, "shiny", 100, true, false, 5,
			Material.IRON),

	AMULET_OF_ESP(new Amulet(), 178, "amulet of ESP", "circular",
			Property.TELEPAT, 175),

	AMULET_OF_LIFE_SAVING(new Amulet(), 179, "amulet of life saving",
			"spherical", Property.LIFESAVED, 75),

	AMULET_OF_STRANGULATION(new Amulet(), 180, "amulet of strangulation",
			"oval", Property.STRANGLED, 135),

	AMULET_OF_RESTFUL_SLEEP(new Amulet(), 181, "amulet of restful sleep",
			"triangular", Property.SLEEPING, 135),

	AMULET_VERSUS_POISON(new Amulet(), 182, "amulet versus poison",
			"pyramidal", Property.POISON_RES, 165),

	AMULET_OF_CHANGE(new Amulet(), 183, "amulet of change", "square", null, 130),

	AMULET_OF_UNCHANGING(new Amulet(), 184, "amulet of unchanging", "concave",
			Property.UNCHANGING, 45),

	AMULET_OF_REFLECTION(new Amulet(), 185, "amulet of reflection",
			"hexagonal", Property.REFLECTING, 75),

	AMULET_OF_MAGICAL_BREATHING(new Amulet(), 186,
			"amulet of magical breathing", "octagonal",
			Property.MAGICAL_BREATHING, 65),

	FAKE_AMULET_OF_YENDOR(187,
			"cheap plastic imitation of the Amulet of Yendor",
			"Amulet of Yendor", false, false, true, false, false, false, false,
			false, false, false, 0, null, null, Material.PLASTIC, null,
			ObjectClass.AMULET, 0, 0, 20, 0, 0, 0, 0, 0, 1),

	AMULET_OF_YENDOR(188, "Amulet of Yendor", /* note: description == name */
	"Amulet of Yendor", false, false, true, false, true, false, true, true,
			false, false, 0, null, null, Material.MITHRIL, null,
			ObjectClass.AMULET, 0, 0, 20, 30000, 0, 0, 0, 0, 20),

	LARGE_BOX,

	CHEST,

	ICE_BOX,

	SACK,

	OILSKIN_SACK,

	BAG_OF_HOLDING,

	BAG_OF_TRICKS,

	SKELETON_KEY,

	LOCK_PICK,

	CREDIT_CARD,

	TALLOW_CANDLE,

	WAX_CANDLE,

	BRASS_LANTERN,

	OIL_LAMP,

	MAGIC_LAMP,

	EXPENSIVE_CAMERA,

	MIRROR,

	CRYSTAL_BALL,

	LENSES,

	BLINDFOLD,

	TOWEL,

	SADDLE,

	LEASH,

	STETHOSCOPE,

	TINNING_KIT,

	TIN_OPENER,

	CAN_OF_GREASE,

	FIGURINE,

	MAGIC_MARKER,

	LAND_MINE,

	BEARTRAP,

	TIN_WHISTLE,

	MAGIC_WHISTLE,

	WOODEN_FLUTE,

	MAGIC_FLUTE,

	TOOLED_HORN,

	FROST_HORN,

	FIRE_HORN,

	HORN_OF_PLENTY,

	WOODEN_HARP,

	MAGIC_HARP,

	BELL,

	BUGLE,

	LEATHER_DRUM,

	DRUM_OF_EARTHQUAKE,

	PICK_AXE,

	GRAPPLING_HOOK,

	UNICORN_HORN,

	CANDELABRUM_OF_INVOCATION,

	BELL_OF_OPENING,

	/* Comestibles ... */

	/* meat */

	TRIPE_RATION(new Food(), 239, "tripe ration", 140, 2, 10, false,
			Material.FLESH, 200),

	CORPSE(new Food(), 240, "corpse", 0, 1, 0, false, Material.FLESH, 0),

	EGG(new Food(), 241, "egg", 85, 1, 1, true, Material.FLESH, 80),

	MEATBALL(new Food(), 242, "meatball", 0, 1, 1, false, Material.FLESH, 5),

	MEAT_STICK(new Food(), 243, "meat stick", 0, 1, 1, false, Material.FLESH, 5),

	HUGE_CHUNK_OF_MEAT(new Food(), 244, "huge chunk of meat", 0, 20, 400,
			false, Material.FLESH, 2000),

	/* special case because it's not mergable */

	MEAT_RING(245, "meat ring", null, true, false, false, false, false, false,
			false, false, false, false, 0, null, Skills.NONE, Material.FLESH,
			null, ObjectClass.FOOD, 0, 1, 5, 1, 0, 0, 0, 0, 5),

	/* fruits & veggies */

	KELP_FROND(new Food(), 246, "kelp frond", 0, 1, 1, false, Material.VEGGY,
			30),

	EUCALYPTUS_LEAF(new Food(), 247, "eucalyptus leaf", 3, 1, 1, false,
			Material.VEGGY, 30),

	APPLE(new Food(), 248, "apple", 15, 1, 2, false, Material.VEGGY, 50),

	ORANGE(new Food(), 249, "orange", 10, 1, 2, false, Material.VEGGY, 80),

	PEAR(new Food(), 250, "pear", 10, 1, 2, false, Material.VEGGY, 50),

	MELON(new Food(), 251, "melon", 10, 1, 5, false, Material.VEGGY, 100),

	BANANA(new Food(), 252, "banana", 10, 1, 2, false, Material.VEGGY, 80),

	CARROT(new Food(), 253, "carrot", 15, 1, 2, false, Material.VEGGY, 50),

	SPRIG_OF_WOLFSBANE(new Food(), 254, "sprig of wolfsbane", 7, 1, 1, false,
			Material.VEGGY, 40),

	CLOVE_OF_GARLIC(new Food(), 255, "clove of garlic", 7, 1, 1, false,
			Material.VEGGY, 40),

	SLIME_MOLD(new Food(), 256, "slime mold", 75, 1, 5, false, Material.VEGGY,
			250),

	/* people food */

	LUMP_OF_ROYAL_JELLY(new Food(), 257, "lump of royal jelly", 0, 1, 2, false,
			Material.VEGGY, 200),

	CREAM_PIE(new Food(), 258, "cream pie", 25, 1, 10, false, Material.VEGGY,
			100),

	CANDY_BAR(new Food(), 259, "candy bar", 13, 1, 2, false, Material.VEGGY,
			100),

	FORTUNE_COOKIE(new Food(), 260, "fortune cookie", 55, 1, 1, false,
			Material.VEGGY, 40),

	PANCAKE(new Food(), 261, "pancake", 25, 2, 2, false, Material.VEGGY, 200),

	LEMBAS_WAFER(new Food(), 262, "lembas wafer", 20, 2, 5, false,
			Material.VEGGY, 800),

	CRAM_RATION(new Food(), 263, "cram ration", 20, 3, 15, false,
			Material.VEGGY, 600),

	FOOD_RATION(new Food(), 264, "food ration", 380, 5, 20, false,
			Material.VEGGY, 800),

	K_RATION(new Food(), 265, "K-ration", 0, 1, 10, false, Material.VEGGY, 400),

	C_RATION(new Food(), 266, "C-ration", 0, 1, 10, false, Material.VEGGY, 300),

	TIN(new Food(), 267, "tin", 75, 0, 10, true, Material.METAL, 0),

	/* potions ... */

	POT_GAIN_ABILITY,

	POT_RESTORE_ABILITY,

	POT_CONFUSION,

	POT_BLINDNESS,

	POT_PARALYSIS,

	POT_SPEED,

	POT_LEVITATION,

	POT_HALLUCINATION,

	POT_INVISIBILITY,

	POT_SEE_INVISIBLE,

	POT_HEALING,

	POT_EXTRA_HEALING,

	POT_GAIN_LEVEL,

	POT_ENLIGHTENMENT,

	POT_MONSTER_DETECTION,

	POT_OBJECT_DETECTION,

	POT_GAIN_ENERGY,

	POT_SLEEPING,

	POT_FULL_HEALING,

	POT_POLYMORPH,

	POT_BOOZE,

	POT_SICKNESS,

	POT_FRUIT_JUICE,

	POT_ACID,

	POT_OIL,

	POT_WATER,

	SCR_ENCHANT_ARMOR,

	SCR_DESTROY_ARMOR,

	SCR_CONFUSE_MONSTER,

	SCR_SCARE_MONSTER,

	SCR_REMOVE_CURSE,

	SCR_ENCHANT_WEAPON,

	SCR_CREATE_MONSTER,

	SCR_TAMING,

	SCR_GENOCIDE,

	SCR_LIGHT,

	SCR_TELEPORTATION,

	SCR_GOLD_DETECTION,

	SCR_FOOD_DETECTION,

	SCR_IDENTIFY,

	SCR_MAGIC_MAPPING,

	SCR_AMNESIA,

	SCR_FIRE,

	SCR_EARTH,

	SCR_PUNISHMENT,

	SCR_CHARGING,

	SCR_STINKING_CLOUD,

	SCR_MAIL,

	SCR_BLANK_PAPER,

	SPE_DIG,

	SPE_MAGIC_MISSILE,

	SPE_FIREBALL,

	SPE_CONE_OF_COLD,

	SPE_SLEEP,

	SPE_FINGER_OF_DEATH,

	SPE_LIGHT,

	SPE_DETECT_MONSTERS,

	SPE_HEALING,

	SPE_KNOCK,

	SPE_FORCE_BOLT,

	SPE_CONFUSE_MONSTER,

	SPE_CURE_BLINDNESS,

	SPE_DRAIN_LIFE,

	SPE_SLOW_MONSTER,

	SPE_WIZARD_LOCK,

	SPE_CREATE_MONSTER,

	SPE_DETECT_FOOD,

	SPE_CAUSE_FEAR,

	SPE_CLAIRVOYANCE,

	SPE_CURE_SICKNESS,

	SPE_CHARM_MONSTER,

	SPE_HASTE_SELF,

	SPE_DETECT_UNSEEN,

	SPE_LEVITATION,

	SPE_EXTRA_HEALING,

	SPE_RESTORE_ABILITY,

	SPE_INVISIBILITY,

	SPE_DETECT_TREASURE,

	SPE_REMOVE_CURSE,

	SPE_MAGIC_MAPPING,

	SPE_IDENTIFY,

	SPE_TURN_UNDEAD,

	SPE_POLYMORPH,

	SPE_TELEPORT_AWAY,

	SPE_CREATE_FAMILIAR,

	SPE_CANCELLATION,

	SPE_PROTECTION,

	SPE_JUMPING,

	SPE_STONE_TO_FLESH,

	SPE_BLANK_PAPER,

	SPE_BOOK_OF_THE_DEAD,

	WAN_LIGHT,

	WAN_SECRET_DOOR_DETECTION,

	WAN_ENLIGHTENMENT,

	WAN_CREATE_MONSTER,

	WAN_WISHING,

	WAN_NOTHING,

	WAN_STRIKING,

	WAN_MAKE_INVISIBLE,

	WAN_SLOW_MONSTER,

	WAN_SPEED_MONSTER,

	WAN_UNDEAD_TURNING,

	WAN_POLYMORPH,

	WAN_CANCELLATION,

	WAN_TELEPORTATION,

	WAN_OPENING,

	WAN_LOCKING,

	WAN_PROBING,

	WAN_DIGGING,

	WAN_MAGIC_MISSILE,

	WAN_FIRE,

	WAN_COLD,

	WAN_SLEEP,

	WAN_DEATH,

	WAN_LIGHTNING,

	GOLD_PIECE(new Coin(), 390, "gold piece", 1000, Material.GOLD, 1),

	DILITHIUM_CRYSTAL,

	DIAMOND,

	RUBY,

	JACINTH,

	SAPPHIRE,

	BLACK_OPAL,

	EMERALD,

	TURQUOISE,

	CITRINE,

	AQUAMARINE,

	AMBER,

	TOPAZ,

	JET,

	OPAL,

	CHRYSOBERYL,

	GARNET,

	AMETHYST,

	JASPER,

	FLUORITE,

	OBSIDIAN,

	AGATE,

	JADE,

	/* #define WORTHLESS_PIECE_OF_WHITE_GLASS 413 */

	/* #define WORTHLESS_PIECE_OF_BLUE_GLASS 414 */

	/* #define WORTHLESS_PIECE_OF_RED_GLASS 415 */

	/* #define WORTHLESS_PIECE_OF_YELLOWISH_BROWN_GLASS 416 */

	/* #define WORTHLESS_PIECE_OF_ORANGE_GLASS 417 */

	/* #define WORTHLESS_PIECE_OF_YELLOW_GLASS 418 */

	/* #define WORTHLESS_PIECE_OF_BLACK_GLASS 419 */

	/* #define WORTHLESS_PIECE_OF_GREEN_GLASS 420 */

	/* #define WORTHLESS_PIECE_OF_VIOLET_GLASS 421 */

	LUCKSTONE,

	LOADSTONE,

	TOUCHSTONE,

	FLINT,

	ROCK,

	BOULDER(427, "boulder", null, true, false, false, false, false, false,
			false, false, true, false, 0, null, Skills.NONE, Material.MINERAL,
			null, ObjectClass.ROCK, 100, 0, 6000, 0, 20, 20, 0, 0, 2000),

	STATUE,

	HEAVY_IRON_BALL,

	IRON_CHAIN,

	BLINDING_VENOM,

	ACID_VENOM,

	LAST_GEM,

	MAXSPELL;

	private static class Amulet {
	}

	private class Bow {
	}

	private static class Coin {
	}

	private static class Food {
	}

	private class Projectile {
	}

	private static class Ring {
	}

	private static class Weapon {
	}

	@Stub
	public static ObjectName getRandom(final ObjectClass aClass,
			final WebhackRandom random) {
		final int prob = random.rnd(1000);

		if (aClass == null) {
			switch (random.rn2(3)) {
			case 0:
				return getRandom(ObjectClass.RING, random);
			case 1:
				return getRandom(ObjectClass.FOOD, random);
			case 2:
				return getRandom(ObjectClass.AMULET, random);
			}
		}

		switch (aClass) {
		case FOOD:
			return randomInRange(prob, TRIPE_RATION, TIN);
		case RING:
			return randomInRange(prob, RIN_ADORNMENT,
					RIN_PROTECTION_FROM_SHAPE_CHAN);
		case AMULET:
			return randomInRange(prob, AMULET_OF_ESP, AMULET_OF_YENDOR);
		}

		return null;
	}

	private static ObjectName randomInRange(int prob, final ObjectName start,
			final ObjectName finish) {
		final Set<ObjectName> s = EnumSet.range(start, finish);
		for (final ObjectName o : s) {
			prob -= o.prob;
			if (prob > 0) {
				continue;
			}
			return o;
		}
		return finish;
	}

	public int idx;
	public String name;
	String description;
	boolean isNameKnown;
	boolean shouldMerge;
	boolean useKnown;
	boolean isContainer;
	boolean isMagic;
	boolean canCharge;
	boolean isUnique;
	boolean noWish;
	boolean isBig;
	boolean isTough;
	int dir;
	EnumSet<WeaponType> weapontype;
	Skills sub;
	Material mtrl;
	Property prp;
	ObjectClass sym;
	int prob;
	int dly;
	int wt;
	int cost;

	int sdam;

	int ldam;

	int oc1;

	int oc2;

	int nut;

	public long quan;

	final static int HARDGEM = 8;

	ObjectName() {
	}

	ObjectName(final Amulet amulet, final int idx, final String name,
			final String desc, final Property power, final int prob) {
		this(idx, name, desc, false, false, false, false, true, false, false,
				false, false, false, 0, null, Skills.NONE, Material.IRON,
				power, ObjectClass.AMULET, prob, 0, 20, 150, 0, 0, 0, 0, 20);
	}

	ObjectName(final Bow bow, final int idx, final String name,
			final String app, final boolean kn, final int prob, final int wt,
			final int cost, final int hitbon, final Material metal,
			final Skills sub) {
		this(idx, name, app, kn, false, true, false, false, true, false, false,
				false, false, 0, null, sub, metal, null, ObjectClass.WEAPON,
				prob, 0, wt, cost, 2, 2, hitbon, 0, wt);
	}

	/**
	 * Constructor for Coin Class items.
	 * 
	 * @param coin
	 * @param idx
	 * @param name
	 * @param prob
	 * @param metal
	 * @param worth
	 */
	ObjectName(final Coin coin, final int idx, final String name,
			final int prob, final Material metal, final int worth) {
		this(idx, name, null, false, true, false, false, false, false, false,
				false, false, false, 0, null, Skills.NONE, metal, null,
				ObjectClass.COIN, prob, 0, 1, worth, 0, 0, 0, 0, 0);
	}

	ObjectName(final Food food, final int idx, final String name,
			final int prob, final int delay, final int wt, final boolean unk,
			final Material tin, final int nutrition) {
		this(idx, name, null, true, true, unk, false, false, false, false,
				false, false, false, 0, null, Skills.NONE, tin, null,
				ObjectClass.FOOD, prob, delay, wt, nutrition / 20 + 5, 0, 0, 0,
				0, nutrition);
	}

	ObjectName(final int idx, final String name, final String desc,
			final boolean nmkn, final boolean mrg, final boolean uskn,
			final boolean ctnr, final boolean mgc, final boolean chrg,
			final boolean uniq, final boolean nwsh, final boolean big,
			final boolean tuf, final int dir,
			final EnumSet<WeaponType> weapontype, final Skills sub,
			final Material mtrl, final Property prp, final ObjectClass sym,
			final int prob, final int dly, final int wt, final int cost,
			final int sdam, final int ldam, final int oc1, final int oc2,
			final int nut) {

		this.idx = idx;
		this.name = name;
		this.description = desc;
		this.isNameKnown = nmkn;
		this.shouldMerge = mrg;
		this.useKnown = uskn;
		this.isContainer = ctnr;
		this.isMagic = mgc;
		this.canCharge = chrg;
		this.isUnique = uniq;
		this.noWish = nwsh;
		this.isBig = big;
		this.isTough = tuf;
		this.dir = dir;
		this.weapontype = weapontype;
		this.sub = sub;
		this.mtrl = mtrl;
		this.prp = prp;
		this.sym = sym;
		this.prob = prob;
		this.dly = dly;
		this.wt = wt;
		this.cost = cost;
		this.sdam = sdam;
		this.ldam = ldam;
		this.oc1 = oc1;
		this.oc2 = oc2;
		this.nut = nut;

	}

	ObjectName(final Projectile projectile, final int idx, final String name,
			final String app, final boolean kn, final int prob, final int wt,
			final int cost, final int sdam, final int ldam, final int hitbon,
			final Material metal, final Skills sub) {
		this(idx, name, app, kn, true, true, false, false, true, false, false,
				false, false, 0, EnumSet.of(WeaponType.PIERCE), sub, metal,
				null, ObjectClass.WEAPON, prob, 0, wt, cost, sdam, ldam,
				hitbon, 0, wt);
	}

	ObjectName(final Ring ring, final int idx, final String name,
			final Property power, final String stone, final int cost,
			final boolean mgc, final boolean spec, final int mohs,
			final Material metal) {
		this(idx, name, stone, false, false, spec, false, mgc, spec, false,
				false, false, (mohs >= HARDGEM), 0, null, Skills.NONE, metal,
				power, ObjectClass.RING, 0, 0, 3, cost, 0, 0, 0, 0, 15);
	}

	ObjectName(final Weapon weapon, final int idx, final String name,
			final String app, final boolean kn, final boolean mg,
			final boolean bi, final int prob, final int wt, final int cost,
			final int sdam, final int ldam, final int hitbon,
			final EnumSet<WeaponType> typ, final Skills sub,
			final Material metal) {
		this(idx, name, app, kn, mg, true, false, false, true, false, false,
				bi, false, 0, typ, sub, metal, null, ObjectClass.WEAPON, prob,
				0, wt, cost, sdam, ldam, hitbon, 0, wt);
	}
}
