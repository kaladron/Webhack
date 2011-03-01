package net.webhack.game.shared;

public class Obj {

	public final ObjectName otyp;
	public long quan = 1;
	public int x, y;

	Obj(final ObjectName otyp, final boolean init, final boolean artifact) {
		this.otyp = otyp;
	}

	@Stub
	String doName() {
		return otyp.name;
	}

}
