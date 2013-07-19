package source.resource.component.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import source.resource.component.Component;
import source.resource.component.Plane;

public abstract class Button extends Component {
	protected Image image;
	protected boolean isClicked = false;
	public Button(Plane plane, Component container) {
		super(plane, container);
	}

	@Override
	public void draw(Graphics g) {
		if(image != null){
			if(getPanel() != null){
				getPanel().drawImageOn(image, g, getPlane().getX(), getPlane().getY(), getPlane().getWidth(), getPlane().getHeight());
			}
		}
	}
	
	public abstract void onAction();

	public Image setImage(final String URL){
		return setImage(getImage(URL));
	}
	
	public Image setImage(Image image){
		return this.image = image;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void mousePressed(MouseEvent e){
		int mouseX = e.getX(), 
				mouseY = e.getY();
		if(getPanel() != null){
			if(mouseX > (getPanel().getPlane().getX() + getPlane().getX()) 
					&& mouseX < (getPanel().getPlane().getX() + getPlane().getX() + getPlane().getWidth())
					&& mouseY > (getPanel().getPlane().getY() + getPlane().getY())
					&& mouseY < (getPanel().getPlane().getY() + getPlane().getY() + getPlane().getHeight())){
					onAction();
			}
		}
		isClicked = true;
	}
	
	public void mouseReleased(){
		isClicked = false;
		if(getPanel() != null){
			getPanel().setIsRepositioning(false);
			getPanel().setIsResizing(false);
		}
	}


}
