package net.webhack.game.shared.monsters;

import java.util.LinkedList;
import java.util.List;

import net.webhack.game.shared.Coordinate;
import net.webhack.game.shared.Location;
import net.webhack.game.shared.LocationMap;
import net.webhack.game.shared.LocationType.Door;
import net.webhack.game.shared.Stub;
import net.webhack.game.shared.Webhack;

public class Monster {
	/** glyph Index number. */
	public final int idx;
	/** full name */
	final String mname;
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
	// struct attack mattk[NATTK];
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
	/** boolean bitflags */
	final int mflags1;
	/** more boolean bitflags */
	final int mflags2;
	/** yet more boolean bitflags */
	final int mflags3;

	public int mx;
	public int my;

	public Monster(final int idx, final String mname, final char mlet,
			final int mlevel, final int mmove, final int ac, final int mr,
			final int maligntyp, final int geno, final int cwt,
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
	public List<Coordinate> findPosition(final LocationMap map) {
		final List<Coordinate> aList = new LinkedList<Coordinate>();

		final int maxX = Math.min(mx + 1, Webhack.COLNO - 1);
		final int maxY = Math.min(my + 1, Webhack.ROWNO - 1);

		for (int nx = Math.max(1, mx - 1); nx <= maxX; nx++) {
			for (int ny = Math.max(0, my - 1); ny <= maxY; ny++) {
				if (nx == mx && ny == my) {
					continue;
				}

				final Location loc = map.getLoc(nx, ny);

				if (loc.typ.isRock()) {
					continue;
				}

				if (loc.typ.isDoor()
						&& (loc.doormask == Door.CLOSED || loc.doormask == Door.LOCKED)) {
					continue;
				}

				if (map.youAt(nx, ny)) {
					continue;
				}

				if (map.monAt(nx, ny)) {
					continue;
				}

				aList.add(new Coordinate(nx, ny));
			}
		}
		return aList;
	}

}
