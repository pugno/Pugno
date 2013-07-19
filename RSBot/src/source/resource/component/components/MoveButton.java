package source.resource.component.components;

import source.resource.component.Component;
import source.resource.component.Plane;

public class MoveButton extends Button {

	public MoveButton(Plane plane, Component container) {
		super(plane, container);
		setImage("http://i591.photobucket.com/albums/ss356/pugnoses/movefw_zps04827c76.png");
	}

	@Override
	public void onAction() {
		if(getPanel() != null){
			getPanel().setIsRepositioning(true);
		}
	}


}
