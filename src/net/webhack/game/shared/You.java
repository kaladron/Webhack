/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class You {
	int ux, uy;
	/** direction of move (or zap or ... ) */
	int dx, dy, dz;
	/** direction of FF */
	int di;
	/** destination of travel */
	int tx, ty;
	/** initial position FF */
	int ux0, uy0;
	/** your level on this and the previous turn */
	DLevel uz, uz0;
	/** level monster teleported you to, or uz */
	DLevel utolev;
	/** bitmask of goto_level() flags for utolev */
	int utotype;
	/** changed map location (post-move) */
	boolean umoved;
	/**
	 * 0: none, 1: half turn, 2: full turn +: turn right, -: turn left
	 */
	int last_str_turn;
	/** 1 to MAXULEV */
	int ulevel;
	int ulevelmax;
	/** trap timeout */
	int utrap;
	/** defined if utrap nonzero */
	int utraptype;

	Room[] urooms; /* rooms (roomno + 3) occupied now */
	Room[] urooms0[]; /* ditto, for previous position */
	Room[] uentered[]; /* rooms (roomno + 3) entered this turn */
	Room[] ushops[]; /* shop rooms (roomno + 3) occupied now */
	Room[] ushops0[]; /* ditto, for previous position */
	Room[] ushops_entered[]; /* ditto, shops entered this turn */
	Room[] ushops_left[]; /* ditto, shops exited this turn */

	int uhunger; /* refd only in eat.c and shk.c */
	int uhs; /* hunger state - see eat.c */

	// struct prop uprops[LAST_PROP+1];

	int umconf;
	char usick_cause[]; /* sizeof "unicorn horn named "+1 */
	int usick_type;

	/* These ranges can never be more than MAX_RANGE (vision.h). */
	int nv_range; /* current night vision range */
	int xray_range; /* current xray vision range */

	/*
	 * These variables are valid globally only when punished and blind.
	 */
	int bglyph; /* glyph under the ball */
	int cglyph; /* glyph under the chain */
	int bc_order; /* ball & chain order [see bc_order() in ball.c] */
	int bc_felt; /* mask for ball/chain being felt */

	int umonster; /* hero's "real" monster num */
	int umonnum; /* current monster number */

	int mh, mhmax, mtimedone; /* for polymorph-self */
	// struct attribs macurr, /* for monster attribs */
	// mamax; /* for monster attribs */
	int ulycn; /* lycanthrope type */

	int ucreamed;
	int uswldtim; /* time you have been swallowed */

	boolean uswallow; /* true if swallowed */
	boolean uinwater; /*
					 * if you're currently in water (only underwater possible
					 * currently)
					 */
	boolean uundetected; /* if you're a hiding monster/piercer */
	boolean mfemale; /* saved human value of flags.female */
	boolean uinvulnerable; /* you're invulnerable (praying) */
	boolean uburied; /* you're buried */
	boolean uedibility; /* blessed food detection; sense unsafe food */
	/* 1 free bit! */

	int udg_cnt; /* how long you have been demigod */
	// struct u_event uevent; /* certain events have happened */
	You.YouHave youHave = new You.YouHave(); /* you're carrying special objects */

	// struct u_have uhave; /* you're carrying special objects */
	// struct u_conduct uconduct; /* KMH, conduct */
	// struct attribs acurr, /* your current attributes (eg. str)*/
	// aexe, /* for gain/loss via "exercise" */
	// abon, /* your bonus attributes (eg. str) */
	// amax, /* your max attributes (eg. str) */
	// atemp, /* used for temporary loss/gain */
	// atime; /* used for loss/gain countdown */
	// align ualign; /* character alignment */
	public You() {

	}

	boolean inEndGame() {
		// TODO(jeffbailey): Stub!
		return false;
	}

	public class YouHave {
		/** carrying Amulet */
		boolean amulet;
		/** carrying Bell */
		boolean bell;
		/** carrying Book */
		boolean book;
		/** carrying Candelabrum */
		boolean menorah;
		/** carrying the Quest Artifact */
		boolean questart;
	}

}
