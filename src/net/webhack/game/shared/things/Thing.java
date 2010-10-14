package net.webhack.game.shared.things;

import net.webhack.game.shared.Material;
import net.webhack.game.shared.ObjectClass;
import net.webhack.game.shared.Skills;
import net.webhack.game.shared.Stub;

public class Thing {
	final public int idx;
	final String name;
	final String description;
	final boolean isNameKnown;
	final boolean shouldMerge;
	final boolean useKnown;
	final boolean isContainer;
	final boolean isMagic;
	final boolean canCharge;
	final boolean isUnique;
	final boolean noWish;
	final boolean isBig;
	final boolean isTough;
	final int dir;
	final Skills sub;
	final Material mtrl;
	final int prp;
	final ObjectClass sym;
	final int prob;
	final int dly;
	final int wt;
	final int cost;
	final int sdam;
	final int ldam;
	final int oc1;
	final int oc2;
	final int nut;

	public long quan;

	Thing(final int idx, final String name, final String desc,
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

	@Stub
	public int getWeight() {
		return 1;
	}
}
