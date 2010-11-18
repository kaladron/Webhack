package net.webhack.game.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.UIObject;

public class WebhackGnome extends UIObject {
	interface MyUiBinder extends UiBinder<DivElement, WebhackGnome> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	public WebhackGnome() {
		setElement(uiBinder.createAndBindUi(this));
	}

}
