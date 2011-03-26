package net.webhack.game.shared;

public enum Skills {
	NONE,

	DAGGER,

	KNIFE,

	AXE,

	PICK_AXE,

	SHORT_SWORD,

	BROAD_SWORD,

	LONG_SWORD,

	TWO_HANDED_SWORD,

	SCIMITAR,

	SABER,

	/** Heavy-shafted bludgeon */
	CLUB,

	MACE,

	/** Spiked bludgeon */
	MORNING_STAR,

	/** Two pieces hinged or chained together */
	FLAIL,

	/** Heavy head on the end */
	HAMMER,

	/** Long-shafted bludgeon */
	QUARTERSTAFF,

	POLEARMS,

	SPEAR,

	JAVELIN,

	TRIDENT,

	LANCE,

	BOW,

	SLING,

	CROSSBOW,

	DART,

	SHURIKEN,

	BOOMERANG,

	WHIP,

	UNICORN_HORN,

	/* Spell Skills added by Larry Stewart-Zerba */

	ATTACK_SPELL,

	HEALING_SPELL,

	DIVINATION_SPELL,

	ENCHANTMENT_SPELL,

	CLERIC_SPELL,

	ESCAPE_SPELL,

	MATTER_SPELL,

	/* Other types of combat */

	/*
	 * Role distinguishes, but otherwise bare handed and marital arts are the
	 * same
	 */
	BARE_HANDED_COMBAT,

	MARTIAL_ARTS,

	TWO_WEAPON_COMBAT,

	/** How well you control your steed */
	RIDING,

	/*
	 * These are the standard weapon skill levels. It is important that the
	 * lowest "valid" skill be be . The code calculates the previous amount to
	 * practice by calling practice_needed_to_advance() with the current skill-.
	 * To work out for the UNSKILLED case, a value of needed.
	 */

	ISRESTRICTED,

	UNSKILLED,

	BASIC,

	SKILLED,

	EXPERT,

	/** Unarmed combat/martial arts only */
	MASTER,

	/** Unarmed combat/martial arts only */
	GRAND_MASTER;

	// FIRST_WEAPON DAGGER

	// LAST_WEAPON UNICORN_HORN

	// FIRST_SPELL ATTACK_SPELL

	// LAST_SPELL MATTER_SPELL

	// LAST_H_TO_H RIDING

	// FIRST_H_TO_H BARE_HANDED_COMBAT

}
