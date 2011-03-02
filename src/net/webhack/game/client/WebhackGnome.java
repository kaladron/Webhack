package net.webhack.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WebhackGnome extends Composite {
	interface MyUiBinder extends UiBinder<Widget, WebhackGnome> {
	}

	@UiField
	SpanElement heading1;

	@UiField
	SpanElement hitpoints;

	@UiField
	SpanElement gold;

	@UiField
	CanvasElement canvas;

	@UiField
	DivElement plineContainer;

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	public WebhackGnome() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	void setGold(final Long in) {
		gold.setInnerText(in.toString());
	}

	void setHeadingOne(final String in) {
		heading1.setInnerText(in);
	}

	void setHitPoints(final String in) {
		hitpoints.setInnerText(in);
	}
}
