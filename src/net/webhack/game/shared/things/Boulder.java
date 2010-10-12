package net.webhack.game.shared.things;

import net.webhack.game.shared.Material;
import net.webhack.game.shared.ObjectClass;
import net.webhack.game.shared.Skills;

public class Boulder extends Thing {
	public Boulder() {
		super(427, "boulder", null, true, false, false, false, false, false,
				false, false, true, false, 0, Skills.NONE, Material.MINERAL, 0,
				ObjectClass.ROCK, 100, 0, 6000, 0, 20, 20, 0, 0, 2000);
	}
}
