package net.webhack.game.shared;

public class EngravingRumor {

	/** random engravings */
	static private String random_mesg[] = { "Elbereth",
	/* trap engravings */
	"Vlad was here", "ad aerarium",
	/* take-offs and other famous engravings */
	"Owlbreath", "Galadriel", "Kilroy was here",
	/* Journey to the Center of the Earth */
	"A.S. ->", "<- A.S.",
	/* Adventure */
	"You won't get it up the steps",
	/* Inferno */
	"Lasciate ogni speranza o voi ch'entrate.",
	/* Prisoner */
	"Well Come",
	/* So Long... */
	"We apologize for the inconvenience.",
	/* Thriller */
	"See you next Wednesday",
	/* Smokey Stover */
	"notary sojak", "For a good time call 8?7-5309",
	/* Various zoos around the world */
	"Please don't feed the animals.",
	/* A palindrome */
	"Madam, in Eden, I'm Adam.",
	/* Siskel & Ebert */
	"Two thumbs up!",
	/* The First C Program */
	"Hello, World!",
	/* Clueless */
	"As if!" };

	static String getRandomEngraving(final WebhackRandom random) {
		return random_mesg[random.rnd(random_mesg.length)];
	}

	@Stub
	static String wipeoutText(final String engr, final int cnt) {
		return engr;
	}

}
