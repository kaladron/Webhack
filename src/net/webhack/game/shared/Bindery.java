package net.webhack.game.shared;

public class Bindery {
	final public Webhack webhack;
	final public WebhackRandom random;
	final public WebhackUI ui;
	final public Flags flags;
	final public InstanceFlags iflags = new InstanceFlags();
	public You you;
	final public Vision vision;
	public DungeonLevel dlevel;

	Bindery(final Webhack webhack, final WebhackRandom random,
			final WebhackUI ui, final Flags flags, final Vision vision) {
		this.webhack = webhack;
		this.random = random;
		this.ui = ui;
		this.flags = flags;
		this.vision = vision;
	}

	void registerDlevel(final DungeonLevel dlevel) {
		this.dlevel = dlevel;
	}

	void registerYou(final You you) {
		this.you = you;
	}
}
