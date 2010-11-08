package net.webhack.game.shared.monsters;

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

}
