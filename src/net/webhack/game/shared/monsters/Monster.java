package net.webhack.game.shared.monsters;

import java.util.LinkedList;
import java.util.List;

import net.webhack.game.shared.Bindery;
import net.webhack.game.shared.Coordinate;
import net.webhack.game.shared.Location;
import net.webhack.game.shared.LocationType.Door;
import net.webhack.game.shared.ObjectName;
import net.webhack.game.shared.Stub;
import net.webhack.game.shared.Webhack;

public class Monster {

	/**
	 * This structure covers all attack forms. aatyp is the gross attack type
	 * (eg. claw, bite, breath, ...) adtyp is the damage type (eg. physical,
	 * fire, cold, spell, ...) damn is the number of hit dice of damage from the
	 * attack. damd is the number of sides on each die.
	 * 
	 * Some attacks can do no points of damage. Additionally, some can have
	 * special effects *and* do damage as well. If damn and damd are set, they
	 * may have a special meaning. For example, if set for a blinding attack,
	 * they determine the amount of time blinded.
	 */
	public class Attack {
		int aatyp;
		int adtyp, damn, damd;
	}

	/** glyph Index number. */
	public final int idx;
	/** full name */
	public final String mname;
	/** symbol */
	final char mlet;
	/** base monster level */
	final int mlevel;
	/** move speed */
	final int mmove;
	/** (base) armor class */
	final int ac;
	/** (base) magic resistance */
	final int mr;
	/** basic monster alignment */
	final int maligntyp;
	/** creation/geno mask value */
	final int geno;
	/** attacks matrix */
	public Attack mattk = new Attack();
	/** weight of corpse */
	final int cwt;
	/** its nutritional value */
	final int cnutrit;
	/** length of extension */
	final int pxlth;
	/** noise it makes (6 bits) */
	final int msound;
	/** physical size (3 bits) */
	final int msize;
	/** resistances */
	final int mresists;
	/** conveyed by eating */
	final int mconveys;

	/** hit points */
	public int mhp;
	public int mhpmax;

	/** is peaceful */
	public boolean mpeaceful;

	/** boolean bitflags */
	final int mflags1;
	/** more boolean bitflags */
	final int mflags2;
	/** yet more boolean bitflags */
	final int mflags3;

	/** X Coordinate where the monster thinks it is. */
	public int mx;

	/** Y Coordinate where the monster thinks it is. */
	public int my;

	/** X Coordinate where the monster thinks you are. */
	public int mux;

	/** Y Coordinate where the monster thinks you are. */
	public int muy;
	private final Bindery bindery;

	public Monster(final Bindery bindery, final int idx, final String mname,
			final char mlet, final int mlevel, final int mmove, final int ac,
			final int mr, final int maligntyp, final int geno, final int cwt,
			final int cnutrit, final int pxlth, final int msound,
			final int msize, final int mresists, final int mconveys,
			final int mflags1, final int mflags2, final int mflags3) {
		this.idx = idx;
		this.mname = mname;
		this.mlet = mlet;
		this.mlevel = mlevel;
		this.mmove = mmove;
		this.ac = ac;
		this.mr = mr;
		this.maligntyp = maligntyp;
		this.geno = geno;
		// struct attack mattk[NATTK];
		this.cwt = cwt;
		this.cnutrit = cnutrit;
		this.pxlth = pxlth;
		this.msound = msound;
		this.msize = msize;
		this.mresists = mresists;
		this.mconveys = mconveys;
		this.mflags1 = mflags1;
		this.mflags2 = mflags2;
		this.mflags3 = mflags3;

		this.bindery = bindery;

		mhpmax = mhp = bindery.random.d(mlevel, 8);
	}

	/** return # of exp points for mtmp after nk killed */
	public int experience() {
		final int tmp = 1;
		// int i, tmp, tmp2;
		//
		// tmp = 1 + m_lev * m_lev;
		//
		// /* For higher ac values, give extra experience */
		// if ((i = find_mac()) < 3) {
		// tmp += (7 - i) * ((i < 0) ? 2 : 1);
		// }
		//
		// /* For very fast monsters, give extra experience */
		// if (data.mmove > NORMAL_SPEED) {
		// tmp += (data.mmove > (3 * NORMAL_SPEED / 2)) ? 5 : 3;
		// }
		//
		// /* For each "special" attack type give extra experience */
		// for (i = 0; i < NATTK; i++) {
		// tmp2 = data.mattk[i].aatyp;
		// if (tmp2 > AT_BUTT) {
		//
		// if (tmp2 == AT_WEAP) {
		// tmp += 5;
		// } else if (tmp2 == AT_MAGC) {
		// tmp += 10;
		// } else {
		// tmp += 3;
		// }
		// }
		// }
		//
		// /* For each "special" damage type give extra experience */
		// for (i = 0; i < NATTK; i++) {
		// tmp2 = data.mattk[i].adtyp;
		// if (tmp2 > AD_PHYS && tmp2 < AD_BLND) {
		// tmp += 2 * m_lev;
		// } else if ((tmp2 == AD_DRLI) || (tmp2 == AD_STON)
		// || (tmp2 == AD_SLIM)) {
		// tmp += 50;
		// } else if (tmp != AD_PHYS) {
		// tmp += m_lev;
		// }
		// /* extra heavy damage bonus */
		// if ((int) (ptr.mattk[i].damd * ptr.mattk[i].damn) > 23) {
		// tmp += m_lev;
		// }
		// if (tmp2 == AD_WRAP && mlet == S_EEL && !Amphibious) {
		// tmp += 1000;
		// }
		// }
		// /* For certain "extra nasty" monsters, give even more */
		// if (extra_nasty(data)) {
		// tmp += (7 * m_lev);
		// }
		//
		// /* For higher level monsters, an additional bonus is given */
		// if (m_lev > 8) {
		// tmp += 50;
		// }

		return (tmp);
	}

	/**
	 * Returns a list of possible directions the monster can move in.
	 * 
	 * Was mfndpos.
	 * 
	 * @param map
	 * @return
	 */
	@Stub
	public List<Coordinate> findPosition() {
		final List<Coordinate> aList = new LinkedList<Coordinate>();

		final int maxX = Math.min(mx + 1, Webhack.COLNO - 1);
		final int maxY = Math.min(my + 1, Webhack.ROWNO - 1);

		for (int nx = Math.max(1, mx - 1); nx <= maxX; nx++) {
			for (int ny = Math.max(0, my - 1); ny <= maxY; ny++) {
				if (nx == mx && ny == my) {
					continue;
				}

				final Location loc = bindery.dlevel.getLoc(nx, ny);

				if (loc.typ.isRock()) {
					continue;
				}

				if (loc.typ.isDoor()
						&& (loc.doormask == Door.CLOSED || loc.doormask == Door.LOCKED)) {
					continue;
				}

				if (bindery.dlevel.youAt(nx, ny)) {
					continue;
				}

				if (bindery.dlevel.monAt(nx, ny)) {
					continue;
				}

				final boolean checkobj = loc.obj_at();

				if (checkobj & loc.sobj_at(ObjectName.BOULDER) != null) {
					continue;
				}

				aList.add(new Coordinate(nx, ny));
			}
		}
		return aList;
	}

	/**
	 * Return values: 0: did not move, but can still attack and do other stuff.
	 * 1: moved, possibly can attack. 2: monster died. 3: did not move, and
	 * can't do anything else either.
	 * 
	 * @param dungeonLevel
	 *            TODO
	 * @param after
	 *            TODO
	 */
	@Stub
	public int move(final int after) {
		final int omx = mx;
		final int omy = my;

		bindery.dlevel.set_apparxy(this);

		final int gx = mux;
		final int gy = muy;

		int nix = omx;
		int niy = omy;

		final List<Coordinate> moveOptions = findPosition();
		// pick one and move to it.
		if (moveOptions.isEmpty()) {
			return 0;
		}

		boolean mmoved = false;

		int nidist = dist2(nix, niy, gx, gy);

		for (final Coordinate option : moveOptions) {
			final int nx = option.x;
			final int ny = option.y;

			final int ndist = dist2(nx, ny, gx, gy);

			final boolean nearer = (ndist < nidist);

			if (nearer) {
				nix = nx;
				niy = ny;
				nidist = ndist;
				mmoved = true;
			}
		}

		if (mmoved) {
			bindery.dlevel.removeMonster(omx, omy);
			bindery.dlevel.placeMonster(this, nix, niy);

			bindery.ui.newsym(omx, omy); /* update the old position */

			bindery.ui.newsym(nix, niy);
		}

		return 1;
	}

	/** square of euclidean distance between pair of pts */
	private int dist2(final int x0, final int y0, final int x1, final int y1) {
		final int dx = x0 - x1, dy = y0 - y1;
		return dx * dx + dy * dy;
	}

}
