package source.resource.component;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import source.resource.component.components.Panel;

public abstract class Component {
	private Plane plane;
	private Component container;
	private Panel panel;
	public Component(Plane plane){
		this.plane = setPlane(plane);
	}
	
	public Component(Plane plane, Component container){
		this(plane);
		setContainer(container);
	}

	public Plane setPlane(Plane plane){
		return this.plane = plane;
	}
	
	public Plane getPlane(){
		return plane;
	}
	
	public Component setContainer(Component container){
		return this.container = container;
	}
	
	public Component getContainer(){
		return container;
	}
	
	public abstract void draw(Graphics g);
	
	protected Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch(IOException e) {
			return null;
		}
	}

	public Panel getPanel(){
		if(panel == null){
			if(container != null){
				if(container instanceof Panel){
					return setPanel((Panel)container);
				} else {
					if(container.getContainer() != null){
						getPanel();
					}
				}
			}
		} else {
			return panel;
		}
		return null;
	}
	
	public Panel setPanel(Panel panel){
		return this.panel = panel;
	}
}
