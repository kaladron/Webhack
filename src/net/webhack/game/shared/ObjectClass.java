package net.webhack.game.shared;

public enum ObjectClass {
	RANDOM(0), /* used for generating random objects */

	ILLOBJ(1),

	WEAPON(2),

	ARMOR(3),

	RING(4),

	AMULET(5),

	TOOL(6),

	FOOD(7),

	POTION(8),

	SCROLL(9),

	SPBOOK(10), /* actually SPELL-book */

	WAND(11),

	COIN(12),

	GEM(13),

	ROCK(14),

	BALL(15),

	CHAIN(16),

	VENOM(17),

	MAXOCLASSES(18);

	int idx;

	ObjectClass(final int idx) {
		this.idx = idx;
	}
}
