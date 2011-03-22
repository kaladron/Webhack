/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import java.util.Date;
import java.util.HashMap;

import net.webhack.game.shared.monsters.Monster;
import net.webhack.game.shared.race.Race;
import net.webhack.game.shared.role.Role;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class You {
	public enum Attribute {
		STR, INT, WIS, DEX, CON, CHA;
	}

	public class Conduct {
		/** eaten any animal */
		long unvegetarian;
		/** ... or any animal byproduct */
		long unvegan;
		/** ... or any comestible */
		long food;
		/** used prayer, priest, or altar */
		long gnostic;
		/** hit a monster with a weapon */
		long weaphit;
		/** killed a monster yourself */
		long killer;
		/** read something (other than BotD) */
		long literate;
		/** polymorphed an object */
		long polypiles;
		/** transformed yourself */
		long polyselfs;
		/** used a wish */
		long wishes;
		/** wished for an artifact */
		long wisharti;

	}

	public class Event {
		/** received at least 1 cheap oracle */
		boolean minor_oracle;
		/** " expensive oracle */
		boolean major_oracle;
		/** called by Quest leader to do task */
		boolean qcalled;
		/** expelled from the Quest dungeon */
		boolean qexpelled;
		/** successfully completed Quest task */
		boolean qcompleted;
		/** 1=know about, 2=heard passtune */
		int uheard_tune;
		/** opened the drawbridge */
		boolean uopened_dbridge;

		/** invoked Gate to the Sanctum level */
		boolean invoked;
		/** entered Gehennom via Valley */
		boolean gehennom_entered;
		/** became Hand of Elbereth */
		int uhand_of_elbereth;
		/** killed the wiz */
		boolean udemigod;
		/** has offered the Amulet */
		boolean ascended;

	}

	public class Have {
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

	public int ux;
	public int uy;
	/** direction of move (or zap or ... ) */
	public int dx;
	public int dy;
	int dz;
	/** direction of FF */
	int di;
	/** destination of travel */
	public int tx;
	public int ty;
	/** initial position FF */
	int ux0, uy0;
	/** your level on this turn */
	DLevel uz = new DLevel(1, 1);
	/** Level on the previous turn */
	DLevel uz0;
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

	// struct prop uprops[LAST_PROP+1];

	Room[] ushops_entered[]; /* ditto, shops entered this turn */
	Room[] ushops_left[]; /* ditto, shops exited this turn */
	int uhunger; /* refd only in eat.c and shk.c */

	int uhs; /* hunger state - see eat.c */
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

	PM umonster; /* hero's "real" monster num */
	PM umonnum; /* current monster number */

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

	int udg_cnt; /* how long you have been demigod */

	You.Event youEvent = new You.Event(); /* certain events have happened */

	You.Have youHave = new You.Have(); /* you're carrying special objects */

	You.Conduct youConduct = new You.Conduct(); /* KMH, conduct */
	// struct attribs acurr, /* your current attributes (eg. str)*/
	// aexe, /* for gain/loss via "exercise" */
	// abon, /* your bonus attributes (eg. str) */
	// amax, /* your max attributes (eg. str) */
	// atemp, /* used for temporary loss/gain */
	// atime; /* used for loss/gain countdown */
	// align ualign; /* character alignment */
	// aligntyp ualignbase[CONVERT]; /* for ualign conversion record */
	// schar uluck, moreluck; /* luck and luck bonus */
	int uhitinc;
	int udaminc;
	int uac;
	int uspellprot; /* protection by SPE_PROTECTION */
	int usptime; /* #moves until uspellprot-- */
	int uspmtime; /* #moves between uspellprot-- */
	public int uhp;
	public int uhpmax;
	int uen, uenmax; /* magical energy - M. Stephenson */
	int ugangr; /* if the gods are angry at you */
	int ugifts; /* number of artifacts bestowed */
	int ublessed, ublesscnt; /* blessing/duration from #pray */
	long umoney0;
	long uexp, urexp;
	long ucleansed; /* to record moves when player was cleansed */
	long usleep; /* sleeping; monstermove you last started */
	int uinvault;
	MonsterClass stuck;
	MonsterClass steed;
	long ugallop;
	int urideturns;
	int umortality; /* how many times you died */
	int ugrave_arise; /* you die and become something aside from a ghost */
	Date ubirthday; /* real world time when game began */

	int weapon_slots; /* unused skill slots */
	int skills_advanced; /* # of advances made so far */
	// xchar skill_record[P_SKILL_LIMIT]; /* skill advancements */
	// struct skills weapon_skills[P_NUM_SKILLS];
	boolean twoweap; /* KMH -- Using two-weapon combat */

	public long ugold;

	public Role role;
	Race race;
	Gender gender;

	Monster youmonst;
	private final Bindery bindery;

	HashMap<Character, Obj> invent = new HashMap<Character, Obj>();

	public You(final Role role, final Race race, final Gender gender,
			final Bindery bindery) {
		this.role = role;
		this.race = race;
		this.gender = gender;
		this.bindery = bindery;
		bindery.registerYou(this);
		// artifacts_init
		// u_init

		// TODO(jeffbailey): STUB, access this through a gendered API
		umonnum = umonster = role.monster[0];
		youmonst = this.role.getMonster(gender);

		uhp = uhpmax = newhp();

	}

	public void attack(final Monster mtmp) {
		final int tmp = 1;
		hitum(mtmp, tmp, youmonst.mattk);
	}

	public void hitum(final Monster mon, final int tmp,
			final Monster.Attack uattk) {
		final boolean mhit = true;
		known_hitum(mon, mhit, uattk);
	}

	public void hmon(final Monster mon, final Obj obj, final boolean thrown) {
		hmon_hitmon(mon, obj, thrown);
	}

	public void hmon_hitmon(final Monster mon, final Obj obj,
			final boolean thrown) {
		mon.mhp--;
		bindery.ui.pline("You hit the " + mon.mname);
		if (mon.mhp < 1) {
			xkilled(mon, 0);
		}
	}

	public void known_hitum(final Monster mon, final boolean tmp,
			final Monster.Attack uattk) {
		final Obj uwep = null;
		hmon(mon, uwep, false);
	}

	/**
	 * Initializes hit points at character generation, gain level or lose level.
	 * 
	 * @return hit points
	 */
	@Stub
	public int newhp() {
		int hp;

		if (ulevel == 0) {
			hp = role.hpadv.infix; // + race.hpadv.infix;
			if (role.hpadv.inrnd > 0) {
				hp += bindery.random.rnd(role.hpadv.inrnd);
			}
			// if (urace.hpadv.inrnd > 0) hp += rnd(urace.hpadv.inrnd);

			return hp;
		}

		return 0;
	}

	public void newPos(final Coordinate c) {
		ux = c.x;
		uy = c.y;
	}

	@Stub
	public void xkilled(final Monster mon, final int dest) {
		bindery.ui.pline("You kill it!");
		mondead(mon);
	}

	@Stub
	Obj addInv(final Obj obj) {
		// The implementation here is slightly different than NetHack
		// because we have HashMaps.

		if (bindery.flags.invlet_constant) {
			assignInvlet(obj);
		}
		return obj;
	}

	@Stub
	void assignInvlet(final Obj obj) {
		invent.put('a', obj);
	}

	@Stub
	boolean inEndGame() {
		return false;
	}

	@Stub
	private void mondead(final Monster mtmp) {
		// Should call m_detach, instead we do:

		bindery.webhack.dungeon.dlevel.monlist.remove(mtmp);
		bindery.webhack.dungeon.dlevel.removeMonster(mtmp.mx, mtmp.my);
		bindery.ui.newsym(mtmp.mx, mtmp.my);

	}

}
