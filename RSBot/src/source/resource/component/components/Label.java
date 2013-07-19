package source.resource.component.components;

import java.awt.Graphics;

import source.resource.component.Component;
import source.resource.component.Plane;

public class Label extends Component {
	private String label;
	
	public Label(Plane plane, Component container, String label) {
		super(plane, container);
		setLabel(label);
	}

	@Override
	public void draw(Graphics g) {
		if(getPanel() != null){
			getPanel().drawStringOn(label, g, getPlane().getX(), getPlane().getY());
		}
	}
	
	public String setLabel(String label){
		return this.label = label;
	}
	
	public String getLabel(){
		return label;
	}


}
