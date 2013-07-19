package source.resource.component.components;

import java.awt.Image;

import source.resource.component.Component;
import source.resource.component.Plane;

public class HideButton extends Button {
	Image minimizeImg = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/minimizefw_zps8d3c2b2f.png"),
			maximizeImg = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/maximizefw_zps1f6b6038.png");
	public HideButton(Plane plane, Component container) {
		super(plane, container);
		setImage(minimizeImg);
	}

	@Override
	public void onAction() {
		if(getPanel() != null){
			getPanel().show(!getPanel().isShown());
			if(getPanel().isShown()){
				setImage(minimizeImg);
			} else {
				setImage(maximizeImg);
			}
		}
	}
}
