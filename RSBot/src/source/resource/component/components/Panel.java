package source.resource.component.components;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import org.powerbot.game.api.methods.input.Mouse;

import source.resource.Container;
import source.resource.component.Component;
import source.resource.component.Plane;
public class Panel extends Component {
	private Container<Component> components;
	private Image image = getImage("http://i591.photobucket.com/albums/ss356/pugnoses/transparentboxfw_zps79b4d40b.png");
	private boolean isRepositioning = false, isResizing = false, isShown = true, isPaused = false;
	
	public Panel(Plane plane){
		super(plane);
		setComponents(new Container<Component>());
	}

	@Override
	public void draw(Graphics g) {
		if(isRepositioning){
			getPlane().setWidth((int) Mouse.getX());
			getPlane().setHeight((int) Mouse.getY());
		}
		if(isResizing){
			getPlane().setX((int) Mouse.getX()-getPlane().getWidth());
			getPlane().setY((int) Mouse.getY() - getPlane().getHeight());
		}
		for(Component component : components){
			if(component != null){
				if(component instanceof ResizeButton || component instanceof HideButton 
						|| component instanceof PauseButton || component instanceof MoveButton){
					component.draw(g);
				} else {
					if(isShown){
						component.draw(g);
					}
				}
			}
		}
		if(isShown){
			if(getPlane().getWidth() == -1){
				g.drawImage(image, getPlane().getX(), getPlane().getY(), null);
			} else {
				g.drawImage(image, getPlane().getX(), getPlane().getY(), getPlane().getWidth(), getPlane().getHeight(), null);
			}
		}
	}

	public void drawImageOn(Image image, Graphics g, int x, int y, int width, int height){
		g.drawImage(image, (getPlane().getX() + x), (getPlane().getY() + y + 10), width, height, null);
	}

	public void drawStringOn(String string, Graphics g, int x, int y){
		int stringWidth;
		if((stringWidth = g.getFontMetrics().stringWidth(string)) >= getPlane().getWidth()){
			getPlane().setWidth(stringWidth + 15);
		}
		g.drawString(string, (getPlane().getX() + x), (getPlane().getY() + y +10));
	}

	public Container<Component> getComponents(){
		return components;
	}

	public Container<Component> setComponents(Container<Component> components){
		return this.components = components;
	}

	public boolean setIsRepositioning(boolean isRepositioning){
		return this.isRepositioning = isRepositioning;
	}
	
	public boolean setIsResizing(boolean isResizing){
		return this.isResizing = isResizing;
	}
	
	public boolean show(boolean show){
		return isShown = show;
	}
	
	public boolean isShown(){
		return isShown;
	}
	
	public boolean pause(boolean pause){
		return isPaused = pause;
	}
	
	public boolean isPaused(){
		return isPaused;
	}
}
