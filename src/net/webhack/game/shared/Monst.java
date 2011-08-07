package net.webhack.game.shared;

public class Monst {

	final Bindery bindery;

	MonsterName mtyp;

	int mhp, mhpmax;

	public Monst(final Bindery bindery, final MonsterName mtyp) {
		this.bindery = bindery;
		this.mtyp = mtyp;
	}
}
