/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 *
 */
public class PlayerMonster {
	static final int PLAYERMON = -1;
	static final int GIANT_ANT = 0;
	static final int KILLER_BEE = 1;
	static final int SOLDIER_ANT = 2;
	static final int FIRE_ANT = 3;
	static final int GIANT_BEETLE = 4;
	static final int QUEEN_BEE = 5;
	static final int ACID_BLOB = 6;
	static final int QUIVERING_BLOB = 7;
	static final int GELATINOUS_CUBE = 8;
	static final int CHICKATRICE = 9;
	static final int COCKATRICE = 10;
	static final int PYROLISK = 11;
	static final int JACKAL = 12;
	static final int FOX = 13;
	static final int COYOTE = 14;
	static final int WEREJACKAL = 15;
	static final int LITTLE_DOG = 16;
	static final int DOG = 17;
	static final int LARGE_DOG = 18;
	static final int DINGO = 19;
	static final int WOLF = 20;
	static final int WEREWOLF = 21;
	static final int WARG = 22;
	static final int WINTER_WOLF_CUB = 23;
	static final int WINTER_WOLF = 24;
	static final int HELL_HOUND_PUP = 25;
	static final int HELL_HOUND = 26;
	static final int GAS_SPORE = 27;
	static final int FLOATING_EYE = 28;
	static final int FREEZING_SPHERE = 29;
	static final int FLAMING_SPHERE = 30;
	static final int SHOCKING_SPHERE = 31;
	static final int KITTEN = 32;
	static final int HOUSECAT = 33;
	static final int JAGUAR = 34;
	static final int LYNX = 35;
	static final int PANTHER = 36;
	static final int LARGE_CAT = 37;
	static final int TIGER = 38;
	static final int GREMLIN = 39;
	static final int GARGOYLE = 40;
	static final int WINGED_GARGOYLE = 41;
	static final int HOBBIT = 42;
	static final int DWARF = 43;
	static final int BUGBEAR = 44;
	static final int DWARF_LORD = 45;
	static final int DWARF_KING = 46;
	static final int MIND_FLAYER = 47;
	static final int MASTER_MIND_FLAYER = 48;
	static final int MANES = 49;
	static final int HOMUNCULUS = 50;
	static final int IMP = 51;
	static final int LEMURE = 52;
	static final int QUASIT = 53;
	static final int TENGU = 54;
	static final int BLUE_JELLY = 55;
	static final int SPOTTED_JELLY = 56;
	static final int OCHRE_JELLY = 57;
	static final int KOBOLD = 58;
	static final int LARGE_KOBOLD = 59;
	static final int KOBOLD_LORD = 60;
	static final int KOBOLD_SHAMAN = 61;
	static final int LEPRECHAUN = 62;
	static final int SMALL_MIMIC = 63;
	static final int LARGE_MIMIC = 64;
	static final int GIANT_MIMIC = 65;
	static final int WOOD_NYMPH = 66;
	static final int WATER_NYMPH = 67;
	static final int MOUNTAIN_NYMPH = 68;
	static final int GOBLIN = 69;
	static final int HOBGOBLIN = 70;
	static final int ORC = 71;
	static final int HILL_ORC = 72;
	static final int MORDOR_ORC = 73;
	static final int URUK_HAI = 74;
	static final int ORC_SHAMAN = 75;
	static final int ORC_CAPTAIN = 76;
	static final int ROCK_PIERCER = 77;
	static final int IRON_PIERCER = 78;
	static final int GLASS_PIERCER = 79;
	static final int ROTHE = 80;
	static final int MUMAK = 81;
	static final int LEOCROTTA = 82;
	static final int WUMPUS = 83;
	static final int TITANOTHERE = 84;
	static final int BALUCHITHERIUM = 85;
	static final int MASTODON = 86;
	static final int SEWER_RAT = 87;
	static final int GIANT_RAT = 88;
	static final int RABID_RAT = 89;
	static final int WERERAT = 90;
	static final int ROCK_MOLE = 91;
	static final int WOODCHUCK = 92;
	static final int CAVE_SPIDER = 93;
	static final int CENTIPEDE = 94;
	static final int GIANT_SPIDER = 95;
	static final int SCORPION = 96;
	static final int LURKER_ABOVE = 97;
	static final int TRAPPER = 98;
	static final int WHITE_UNICORN = 99;
	static final int GRAY_UNICORN = 100;
	static final int BLACK_UNICORN = 101;
	static final int PONY = 102;
	static final int HORSE = 103;
	static final int WARHORSE = 104;
	static final int FOG_CLOUD = 105;
	static final int DUST_VORTEX = 106;
	static final int ICE_VORTEX = 107;
	static final int ENERGY_VORTEX = 108;
	static final int STEAM_VORTEX = 109;
	static final int FIRE_VORTEX = 110;
	static final int BABY_LONG_WORM = 111;
	static final int BABY_PURPLE_WORM = 112;
	static final int LONG_WORM = 113;
	static final int PURPLE_WORM = 114;
	static final int GRID_BUG = 115;
	static final int XAN = 116;
	static final int YELLOW_LIGHT = 117;
	static final int BLACK_LIGHT = 118;
	static final int ZRUTY = 119;
	static final int COUATL = 120;
	static final int ALEAX = 121;
	static final int ANGEL = 122;
	static final int KI_RIN = 123;
	static final int ARCHON = 124;
	static final int BAT = 125;
	static final int GIANT_BAT = 126;
	static final int RAVEN = 127;
	static final int VAMPIRE_BAT = 128;
	static final int PLAINS_CENTAUR = 129;
	static final int FOREST_CENTAUR = 130;
	static final int MOUNTAIN_CENTAUR = 131;
	static final int BABY_GRAY_DRAGON = 132;
	static final int BABY_SILVER_DRAGON = 133;
	static final int BABY_RED_DRAGON = 134;
	static final int BABY_WHITE_DRAGON = 135;
	static final int BABY_ORANGE_DRAGON = 136;
	static final int BABY_BLACK_DRAGON = 137;
	static final int BABY_BLUE_DRAGON = 138;
	static final int BABY_GREEN_DRAGON = 139;
	static final int BABY_YELLOW_DRAGON = 140;
	static final int GRAY_DRAGON = 141;
	static final int SILVER_DRAGON = 142;
	static final int RED_DRAGON = 143;
	static final int WHITE_DRAGON = 144;
	static final int ORANGE_DRAGON = 145;
	static final int BLACK_DRAGON = 146;
	static final int BLUE_DRAGON = 147;
	static final int GREEN_DRAGON = 148;
	static final int YELLOW_DRAGON = 149;
	static final int STALKER = 150;
	static final int AIR_ELEMENTAL = 151;
	static final int FIRE_ELEMENTAL = 152;
	static final int EARTH_ELEMENTAL = 153;
	static final int WATER_ELEMENTAL = 154;
	static final int LICHEN = 155;
	static final int BROWN_MOLD = 156;
	static final int YELLOW_MOLD = 157;
	static final int GREEN_MOLD = 158;
	static final int RED_MOLD = 159;
	static final int SHRIEKER = 160;
	static final int VIOLET_FUNGUS = 161;
	static final int GNOME = 162;
	static final int GNOME_LORD = 163;
	static final int GNOMISH_WIZARD = 164;
	static final int GNOME_KING = 165;
	static final int GIANT = 166;
	static final int STONE_GIANT = 167;
	static final int HILL_GIANT = 168;
	static final int FIRE_GIANT = 169;
	static final int FROST_GIANT = 170;
	static final int STORM_GIANT = 171;
	static final int ETTIN = 172;
	static final int TITAN = 173;
	static final int MINOTAUR = 174;
	static final int JABBERWOCK = 175;
	static final int KEYSTONE_KOP = 176;
	static final int KOP_SERGEANT = 177;
	static final int KOP_LIEUTENANT = 178;
	static final int KOP_KAPTAIN = 179;
	static final int LICH = 180;
	static final int DEMILICH = 181;
	static final int MASTER_LICH = 182;
	static final int ARCH_LICH = 183;
	static final int KOBOLD_MUMMY = 184;
	static final int GNOME_MUMMY = 185;
	static final int ORC_MUMMY = 186;
	static final int DWARF_MUMMY = 187;
	static final int ELF_MUMMY = 188;
	static final int HUMAN_MUMMY = 189;
	static final int ETTIN_MUMMY = 190;
	static final int GIANT_MUMMY = 191;
	static final int RED_NAGA_HATCHLING = 192;
	static final int BLACK_NAGA_HATCHLING = 193;
	static final int GOLDEN_NAGA_HATCHLING = 194;
	static final int GUARDIAN_NAGA_HATCHLING = 195;
	static final int RED_NAGA = 196;
	static final int BLACK_NAGA = 197;
	static final int GOLDEN_NAGA = 198;
	static final int GUARDIAN_NAGA = 199;
	static final int OGRE = 200;
	static final int OGRE_LORD = 201;
	static final int OGRE_KING = 202;
	static final int GRAY_OOZE = 203;
	static final int BROWN_PUDDING = 204;
	static final int BLACK_PUDDING = 205;
	static final int GREEN_SLIME = 206;
	static final int QUANTUM_MECHANIC = 207;
	static final int RUST_MONSTER = 208;
	static final int DISENCHANTER = 209;
	static final int GARTER_SNAKE = 210;
	static final int SNAKE = 211;
	static final int WATER_MOCCASIN = 212;
	static final int PIT_VIPER = 213;
	static final int PYTHON = 214;
	static final int COBRA = 215;
	static final int TROLL = 216;
	static final int ICE_TROLL = 217;
	static final int ROCK_TROLL = 218;
	static final int WATER_TROLL = 219;
	static final int OLOG_HAI = 220;
	static final int UMBER_HULK = 221;
	static final int VAMPIRE = 222;
	static final int VAMPIRE_LORD = 223;
	static final int VLAD_THE_IMPALER = 224;
	static final int BARROW_WIGHT = 225;
	static final int WRAITH = 226;
	static final int NAZGUL = 227;
	static final int XORN = 228;
	static final int MONKEY = 229;
	static final int APE = 230;
	static final int OWLBEAR = 231;
	static final int YETI = 232;
	static final int CARNIVOROUS_APE = 233;
	static final int SASQUATCH = 234;
	static final int KOBOLD_ZOMBIE = 235;
	static final int GNOME_ZOMBIE = 236;
	static final int ORC_ZOMBIE = 237;
	static final int DWARF_ZOMBIE = 238;
	static final int ELF_ZOMBIE = 239;
	static final int HUMAN_ZOMBIE = 240;
	static final int ETTIN_ZOMBIE = 241;
	static final int GIANT_ZOMBIE = 242;
	static final int GHOUL = 243;
	static final int SKELETON = 244;
	static final int STRAW_GOLEM = 245;
	static final int PAPER_GOLEM = 246;
	static final int ROPE_GOLEM = 247;
	static final int GOLD_GOLEM = 248;
	static final int LEATHER_GOLEM = 249;
	static final int WOOD_GOLEM = 250;
	static final int FLESH_GOLEM = 251;
	static final int CLAY_GOLEM = 252;
	static final int STONE_GOLEM = 253;
	static final int GLASS_GOLEM = 254;
	static final int IRON_GOLEM = 255;
	static final int HUMAN = 256;
	static final int HUMAN_WERERAT = 257;
	static final int HUMAN_WEREJACKAL = 258;
	static final int HUMAN_WEREWOLF = 259;
	static final int ELF = 260;
	static final int WOODLAND_ELF = 261;
	static final int GREEN_ELF = 262;
	static final int GREY_ELF = 263;
	static final int ELF_LORD = 264;
	static final int ELVENKING = 265;
	static final int DOPPELGANGER = 266;
	static final int NURSE = 267;
	static final int SHOPKEEPER = 268;
	static final int GUARD = 269;
	static final int PRISONER = 270;
	static final int ORACLE = 271;
	static final int ALIGNED_PRIEST = 272;
	static final int HIGH_PRIEST = 273;
	static final int SOLDIER = 274;
	static final int SERGEANT = 275;
	static final int LIEUTENANT = 276;
	static final int CAPTAIN = 277;
	static final int WATCHMAN = 278;
	static final int WATCH_CAPTAIN = 279;
	static final int MEDUSA = 280;
	static final int WIZARD_OF_YENDOR = 281;
	static final int CROESUS = 282;
	static final int GHOST = 283;
	static final int SHADE = 284;
	static final int WATER_DEMON = 285;
	static final int HORNED_DEVIL = 286;
	static final int SUCCUBUS = 287;
	static final int INCUBUS = 288;
	static final int ERINYS = 289;
	static final int BARBED_DEVIL = 290;
	static final int MARILITH = 291;
	static final int VROCK = 292;
	static final int HEZROU = 293;
	static final int BONE_DEVIL = 294;
	static final int ICE_DEVIL = 295;
	static final int NALFESHNEE = 296;
	static final int PIT_FIEND = 297;
	static final int BALROG = 298;
	static final int JUIBLEX = 299;
	static final int YEENOGHU = 300;
	static final int ORCUS = 301;
	static final int GERYON = 302;
	static final int DISPATER = 303;
	static final int BAALZEBUB = 304;
	static final int ASMODEUS = 305;
	static final int DEMOGORGON = 306;
	static final int DEATH = 307;
	static final int PESTILENCE = 308;
	static final int FAMINE = 309;
	static final int MAIL_DAEMON = 310;
	static final int DJINNI = 311;
	static final int SANDESTIN = 312;
	static final int JELLYFISH = 313;
	static final int PIRANHA = 314;
	static final int SHARK = 315;
	static final int GIANT_EEL = 316;
	static final int ELECTRIC_EEL = 317;
	static final int KRAKEN = 318;
	static final int NEWT = 319;
	static final int GECKO = 320;
	static final int IGUANA = 321;
	static final int BABY_CROCODILE = 322;
	static final int LIZARD = 323;
	static final int CHAMELEON = 324;
	static final int CROCODILE = 325;
	static final int SALAMANDER = 326;
	static final int LONG_WORM_TAIL = 327;
	static final int ARCHEOLOGIST = 328;
	static final int BARBARIAN = 329;
	static final int CAVEMAN = 330;
	static final int CAVEWOMAN = 331;
	static final int HEALER = 332;
	static final int KNIGHT = 333;
	static final int MONK = 334;
	static final int PRIEST = 335;
	static final int PRIESTESS = 336;
	static final int RANGER = 337;
	static final int ROGUE = 338;
	static final int SAMURAI = 339;
	static final int TOURIST = 340;
	static final int VALKYRIE = 341;
	static final int WIZARD = 342;
	static final int LORD_CARNARVON = 343;
	static final int PELIAS = 344;
	static final int SHAMAN_KARNOV = 345;
	static final int HIPPOCRATES = 346;
	static final int KING_ARTHUR = 347;
	static final int GRAND_MASTER = 348;
	static final int ARCH_PRIEST = 349;
	static final int ORION = 350;
	static final int MASTER_OF_THIEVES = 351;
	static final int LORD_SATO = 352;
	static final int TWOFLOWER = 353;
	static final int NORN = 354;
	static final int NEFERET_THE_GREEN = 355;
	static final int MINION_OF_HUHETOTL = 356;
	static final int THOTH_AMON = 357;
	static final int CHROMATIC_DRAGON = 358;
	static final int CYCLOPS = 359;
	static final int IXOTH = 360;
	static final int MASTER_KAEN = 361;
	static final int NALZOK = 362;
	static final int SCORPIUS = 363;
	static final int MASTER_ASSASSIN = 364;
	static final int ASHIKAGA_TAKAUJI = 365;
	static final int LORD_SURTUR = 366;
	static final int DARK_ONE = 367;
	static final int STUDENT = 368;
	static final int CHIEFTAIN = 369;
	static final int NEANDERTHAL = 370;
	static final int ATTENDANT = 371;
	static final int PAGE = 372;
	static final int ABBOT = 373;
	static final int ACOLYTE = 374;
	static final int HUNTER = 375;
	static final int THUG = 376;
	static final int NINJA = 377;
	static final int ROSHI = 378;
	static final int GUIDE = 379;
	static final int WARRIOR = 380;
	static final int APPRENTICE = 381;

	static final int NUMMONS = 382;
}
