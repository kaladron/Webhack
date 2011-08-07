package net.webhack.game.shared;

public class Obj {
	enum Position {
		/** not on any list */
		FREE,
		/** fobj, level.locations[][] chains (use remove_object) */
		FLOOR,
		/** cobj chain of container object */
		CONTAINED,
		/** hero's invent chain (use freeinv) */
		INVENT,
		/** monster's invent chain */
		MINVENT,
		/** migrating chain */
		MIGRATING,
		/** level.buriedobjs chain */
		BURIED,
		/** on billobjs chain */
		ONBILL
	}

	public final ObjectName otyp;
	public long quan = 1;
	public int x, y;
	public Position where;
	private final Bindery bindery;

	@Stub
	Obj(final Bindery bindery, final ObjectName otyp, final boolean init,
			final boolean artifact) {
		this.otyp = otyp;
		this.bindery = bindery;

		// TODO(jeffbailey): Set this correctly.
		this.where = Position.FLOOR;
	}

	@Stub
	public void extract_self() {
		switch (where) {
		case FLOOR:
			bindery.dlevel.remove_object(this);
		}
	}

	@Stub
	String doName() {
		return otyp.name;
	}

}
