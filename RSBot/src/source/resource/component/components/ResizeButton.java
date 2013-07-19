package source.resource.component.components;
import source.resource.component.Component;
import source.resource.component.Plane;

public class ResizeButton extends Button {

	public ResizeButton(Plane plane, Component container) {
		super(plane, container);
		setImage("http://i591.photobucket.com/albums/ss356/pugnoses/resizefw_zpsb26dc936.png");
	}

	@Override
	public void onAction() {
		if(getPanel() != null){
			getPanel().setIsResizing(true);
		}
	}


}
