package net.webhack.game.shared.things;

import net.webhack.game.shared.Material;
import net.webhack.game.shared.ObjectClass;
import net.webhack.game.shared.Skills;

public class Coin extends Thing {

	public Coin(final int idx, final String name, final int prob,
			final Material material, final int worth) {
		super(idx, name, null, false, true, false, false, false, false, false,
				false, false, false, 0, Skills.NONE, material, 0,
				ObjectClass.COIN, prob, 0, 1, worth, 0, 0, 0, 0, 0);
	}
}
