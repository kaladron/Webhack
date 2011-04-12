package net.webhack.game.shared;

public enum RoomType {

	/** Ordinary Room */
	OROOM,

	/** Contains a throne */
	COURT,

	/** contains pools */
	SWAMP,

	/** contains piles of gold */
	VAULT,

	/** contains killer bees and royal jelly */
	BEEHIVE,

	/** contains corpses, undead and ghosts */
	MORGUE,

	/* contains soldiers and their gear */
	BARRACKS,

	/** floor covered with treasure and monsters */
	ZOO,

	/** contains Oracle and peripherals */
	DELPHI,

	/** contains a shrine */
	TEMPLE,

	/** leprechaun hall (Tom Proudfoot) */
	LEPREHALL,

	/** cockatrice nest (Tom Proudfoot) */
	COCKNEST,

	/** ants (Tom Proudfoot) */
	ANTHOLE,

	/** everything above this is a shop */
	SHOPBASE,

	/** specific shop defines for level compiler */
	ARMORSHOP,

	SCROLLSHOP,

	POTIONSHOP,

	WEAPONSHOP,

	FOODSHOP,

	RINGSHOP,

	WANDSHOP,

	TOOLSHOP,

	BOOKSHOP,

	/** shops here & above not randomly gen'd. */
	UNIQUESHOP,

	CANDLESHOP,
}
