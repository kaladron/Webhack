package net.webhack.game.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

public class WebhackGnome extends Composite {
	interface MyUiBinder extends UiBinder<Widget, WebhackGnome> {
	}

	interface WebhackStyle extends CssResource {
		String gameCanvas();
	}

	@UiField
	SpanElement xp;

	@UiField
	SpanElement heading1;

	@UiField
	SpanElement hitpoints;

	@UiField
	SpanElement gold;

	@UiField
	FocusPanel bottompart;

	@UiField
	DivElement plineContainer;

	@UiField
	WebhackStyle style;

	Canvas gameCanvas;

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	public WebhackGnome() {
		initWidget(uiBinder.createAndBindUi(this));

		final int gameCanvasWidth = 1280;
		final int gameCanvasHeight = 336;

		gameCanvas = Canvas.createIfSupported();
		gameCanvas.setHeight(gameCanvasHeight + "px");
		gameCanvas.setWidth(gameCanvasWidth + "px");
		bottompart.add(gameCanvas);
		gameCanvas.setCoordinateSpaceWidth(gameCanvasWidth);
		gameCanvas.setCoordinateSpaceHeight(gameCanvasHeight);
		gameCanvas.getCanvasElement().addClassName(style.gameCanvas());

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

	void setXp(final Long in) {
		xp.setInnerText(in.toString());
	}
}
