/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.command;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public abstract class Command {

	/** Callback for multi-stage commands. */
	public boolean callback(final int cmdKey) {
		return false;
	}

	/** Executes the command. */
	public abstract void execute();
}
