package net.webhack.game.shared;

public enum Material {
	LIQUID(1), /* currently only for venom */

	WAX(2),

	VEGGY(3), /* foodstuffs */

	FLESH(4), /* ditto */

	PAPER(5),

	CLOTH(6),

	LEATHER(7),

	WOOD(8),

	BONE(9),

	DRAGON_HIDE(10), /* not leather! */

	IRON(11), /* Fe - includes steel */

	METAL(12), /* Sn, &c. */

	COPPER(13), /* Cu - includes brass */

	SILVER(14), /* Ag */

	GOLD(15), /* Au */

	PLATINUM(16), /* Pt */

	MITHRIL(17),

	PLASTIC(18),

	GLASS(19),

	GEMSTONE(20),

	MINERAL(21);

	int idx;

	Material(final int idx) {
		this.idx = idx;
	}
}
