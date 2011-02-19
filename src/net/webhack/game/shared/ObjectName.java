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

	SPEAR,

	ELVEN_SPEAR,

	ORCISH_SPEAR,

	DWARVISH_SPEAR,

	SILVER_SPEAR,

	JAVELIN,

	TRIDENT,

	DAGGER,

	ELVEN_DAGGER,

	ORCISH_DAGGER,

	SILVER_DAGGER,

	ATHAME,

	SCALPEL,

	KNIFE,

	STILETTO,

	WORM_TOOTH,

	CRYSKNIFE,

	AXE,

	BATTLE_AXE,

	SHORT_SWORD,

	ELVEN_SHORT_SWORD,

	ORCISH_SHORT_SWORD,

	DWARVISH_SHORT_SWORD,

	SCIMITAR,

	SILVER_SABER,

	BROADSWORD,

	ELVEN_BROADSWORD,

	LONG_SWORD,

	TWO_HANDED_SWORD,

	KATANA,

	TSURUGI,

	RUNESWORD,

	PARTISAN,

	RANSEUR,

	SPETUM,

	GLAIVE,

	LANCE,

	HALBERD,

	BARDICHE,

	VOULGE,

	DWARVISH_MATTOCK,

	FAUCHARD,

	GUISARME,

	BILL_GUISARME,

	LUCERN_HAMMER,

	BEC_DE_CORBIN,

	MACE,

	MORNING_STAR,

	WAR_HAMMER,

	CLUB,

	RUBBER_HOSE,

	QUARTERSTAFF,

	AKLYS,

	FLAIL,

	BULLWHIP,

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

	RIN_ADORNMENT,

	RIN_GAIN_STRENGTH,

	RIN_GAIN_CONSTITUTION,

	RIN_INCREASE_ACCURACY,

	RIN_INCREASE_DAMAGE,

	RIN_PROTECTION,

	RIN_REGENERATION,

	RIN_SEARCHING,

	RIN_STEALTH,

	RIN_SUSTAIN_ABILITY,

	RIN_LEVITATION,

	RIN_HUNGER,

	RIN_AGGRAVATE_MONSTER,

	RIN_CONFLICT,

	RIN_WARNING,

	RIN_POISON_RESISTANCE,

	RIN_FIRE_RESISTANCE,

	RIN_COLD_RESISTANCE,

	RIN_SHOCK_RESISTANCE,

	RIN_FREE_ACTION,

	RIN_SLOW_DIGESTION,

	RIN_TELEPORTATION,

	RIN_TELEPORT_CONTROL,

	RIN_POLYMORPH,

	RIN_POLYMORPH_CONTROL,

	RIN_INVISIBILITY,

	RIN_SEE_INVISIBLE,

	RIN_PROTECTION_FROM_SHAPE_CHAN,

	AMULET_OF_ESP,

	AMULET_OF_LIFE_SAVING,

	AMULET_OF_STRANGULATION,

	AMULET_OF_RESTFUL_SLEEP,

	AMULET_VERSUS_POISON,

	AMULET_OF_CHANGE,

	AMULET_OF_UNCHANGING,

	AMULET_OF_REFLECTION,

	AMULET_OF_MAGICAL_BREATHING,

	FAKE_AMULET_OF_YENDOR,

	AMULET_OF_YENDOR,

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
			false, false, false, false, 0, Skills.NONE, Material.FLESH, 0,
			ObjectClass.FOOD, 0, 1, 5, 1, 0, 0, 0, 0, 5),

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
			false, false, true, false, 0, Skills.NONE, Material.MINERAL, 0,
			ObjectClass.ROCK, 100, 0, 6000, 0, 20, 20, 0, 0, 2000),

	STATUE,

	HEAVY_IRON_BALL,

	IRON_CHAIN,

	BLINDING_VENOM,

	ACID_VENOM,

	LAST_GEM,

	MAXSPELL;

	private static class Coin {
	}

	private static class Food {
	}

	@Stub
	public static ObjectName getRandom(final ObjectClass aClass,
			final WebhackRandom random) {
		// Assume food for now
		int prob = random.rnd(1000);

		// while((prob -= objects[i].oc_prob) > 0) i++;
		final Set<ObjectName> s = EnumSet.range(TRIPE_RATION, TIN);
		for (final ObjectName o : s) {
			prob -= o.prob;
			if (prob > 0) {
				continue;
			}
			return o;
		}

		return TIN;
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
	Skills sub;
	Material mtrl;
	int prp;
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

	ObjectName() {
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
				false, false, false, 0, Skills.NONE, metal, 0,
				ObjectClass.COIN, prob, 0, 1, worth, 0, 0, 0, 0, 0);
	}

	ObjectName(final Food food, final int idx, final String name,
			final int prob, final int delay, final int wt, final boolean unk,
			final Material tin, final int nutrition) {
		this(idx, name, null, true, true, unk, false, false, false, false,
				false, false, false, 0, Skills.NONE, tin, 0, ObjectClass.FOOD,
				prob, delay, wt, nutrition / 20 + 5, 0, 0, 0, 0, nutrition);
	}

	ObjectName(final int idx, final String name, final String desc,
			final boolean nmkn, final boolean mrg, final boolean uskn,
			final boolean ctnr, final boolean mgc, final boolean chrg,
			final boolean uniq, final boolean nwsh, final boolean big,
			final boolean tuf, final int dir, final Skills sub,
			final Material mtrl, final int prp, final ObjectClass sym,
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

}
