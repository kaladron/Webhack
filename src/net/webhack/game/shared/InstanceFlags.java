package net.webhack.game.shared;

public class InstanceFlags {
	/** hint: # of top lines to save */
	int msg_history = 50;
	/** use numbers for movement commands */
	boolean num_pad = false;
	/** print news */
	boolean news = true;
	/** true if init_nhwindows() completed */
	boolean window_inited = false;
	/** true if vision is ready */
	boolean vision_inited = false;
	/** Use tabs to separate option menu fields */
	boolean menu_tab_sep = false;
	/** Flag for overloaded use of 'm' prefix * on some non-move commands */
	boolean menu_requested = false;

	char num_pad_mode;
	/** ATR for menu headings */
	int menu_headings;
	/** # of dead monsters still on fmon list */
	int purge_monsters = 0;
	/** first travel step */
	boolean travel1 = false;
	/* coordinates for travel_cache */
	Coordinate travelcc = new Coordinate();

}
