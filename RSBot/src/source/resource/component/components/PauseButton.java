package source.resource.component.components;
import java.awt.Image;

import source.resource.component.Component;
import source.resource.component.Plane;
public class PauseButton extends Button {
	public Image pauseImg = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/pauseButtonfw_zpsd954de1a.png"),
				playImg = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/playButtonfw_zpsfc265ca5.png");
	public PauseButton(Plane plane, Component container) {
		super(plane, container);
		setImage(pauseImg);
	}

	@Override
	public void onAction() {
		if(getPanel() != null){
			getPanel().pause(!getPanel().isPaused());
			if(getPanel().isPaused()){ 
				setImage(playImg);
			} else {
				setImage(pauseImg);
			}
						
		}

	}


}
