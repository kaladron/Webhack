package net.webhack.game.shared;

import net.webhack.game.shared.role.Role;

public class Flags {
	boolean autodig; /* MRKR: Automatically dig */
	boolean autoquiver; /* Automatically fill quiver */
	boolean beginner;
	boolean botl; /* partially redo status line */
	boolean botlx; /* print an entirely new bottom line */
	boolean confirm; /* confirm before hitting tame monsters */
	public boolean debug = true; /* in debugging mode */
	boolean end_own; /* list all own scores */
	boolean explore; /* in exploration mode */
	boolean female;
	boolean forcefight;
	boolean friday13; /* it's Friday the 13th */
	boolean help; /* look in data file for info about stuff */
	boolean ignintr; /* ignore interrupts */
	boolean ins_chkpt; /* checkpoint as appropriate */
	/** let objects keep their inventory symbol */
	boolean invlet_constant = true;
	boolean legacy; /* print game entry "story" */
	boolean lit_corridor = false; /* show a dark corr as lit if it is in sight */
	boolean made_amulet;
	boolean mon_moving; /* monsters' turn to move */
	boolean move;
	boolean mv;
	boolean bypasses; /* bypass flag is set on at least one fobj */
	boolean nap; /* `timed_delay' option for display effects */
	public boolean nopick; /* do not pickup objects (as when running) */
	boolean perm_invent; /* keep full inventories up until dismissed */
	public boolean pickup; /* whether you pickup or move and look */

	boolean pushweapon; /* When wielding, push old weapon into second slot */
	boolean rest_on_space; /* space means rest */
	boolean safe_dog; /* give complete protection to the dog */
	boolean silent; /* whether the bell rings or not */
	boolean sortpack; /* sorted inventory */
	boolean soundok; /* ok to tell about sounds heard */
	boolean sparkle; /* show "resisting" special FX (Scott Bigham) */
	boolean standout; /* use standout for --More-- */
	boolean time; /* display elapsed 'time' */
	boolean tombstone; /* print tombstone */
	boolean toptenwin; /* ending list in window instead of stdout */
	boolean verbose; /* max battle info */
	boolean prayconfirm; /* confirm before praying */
	int end_top, end_around; /* describe desired score list */
	int ident; /* social security number for each monster */
	int moonphase;
	long suppress_alert;
	int no_of_wizards; /* 0, 1 or 2 (wizard and his shadow) */
	public boolean travel; /* find way automatically to u.tx,u.ty */
	public int run; /* 0: h (etc), 1: H (etc), 2: fh (etc) */
	/* 3: FH, 4: ff+, 5: ff-, 6: FF+, 7: FF- */
	/* 8: travel */
	long warntype; /* warn_of_mon monster type M2 */
	int warnlevel;
	int djinni_count, ghost_count; /* potion effect tuning */
	int pickup_burden; /* maximum burden before prompt */
	// TODO(jeffbailey):
	// char inv_order[MAXOCLASSES];
	// char pickup_types[MAXOCLASSES];
	// char end_disclose[NUM_DISCLOSURE_OPTIONS + 1]; /* disclose various info
	// upon exit */
	// char menu_style; /* User interface style setting */
	/*
	 * KMH, role patch -- Variables used during startup.
	 * 
	 * If the user wishes to select a role, race, gender, and/or alignment
	 * during startup, the choices should be recorded here. This might be
	 * specified through command-line options, environmental variables, a popup
	 * dialog box, menus, etc.
	 * 
	 * These values are each an index into an array. They are not characters or
	 * letters, because that limits us to 26 roles. They are not booleans,
	 * because someday someone may need a neuter gender. Negative values are
	 * used to indicate that the user hasn't yet specified that particular
	 * value. If you determine that the user wants a random choice, then you
	 * should set an appropriate random value; if you just left the negative
	 * value, the user would be asked again!
	 * 
	 * These variables are stored here because the u structure is cleared during
	 * character initialization, and because the flags structure is restored for
	 * saved games. Thus, we can use the same parameters to build the role entry
	 * for both new and restored games.
	 * 
	 * These variables should not be referred to after the character is
	 * initialized or restored (specifically, after role_init() is called).
	 */
	public Role initrole; /* starting role (index into roles[]) */
	int initrace; /* starting race (index into races[]) */
	int initgend; /* starting gender (index into genders[]) */
	int initalign; /* starting alignment (index into aligns[]) */
	int randomall; /* randomly assign everything not specified */
	int pantheon; /* deity selection for priest character */

	/** Player's name */
	public String plname;

}
