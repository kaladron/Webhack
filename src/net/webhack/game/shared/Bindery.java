package net.webhack.game.shared;

public class Bindery {
	final public Webhack webhack;
	final public WebhackRandom random;
	final public WebhackUI ui;
	final public Flags flags;

	Bindery(final Webhack webhack, final WebhackRandom random,
			final WebhackUI ui, final Flags flags) {
		this.webhack = webhack;
		this.random = random;
		this.ui = ui;
		this.flags = flags;
	}
}
