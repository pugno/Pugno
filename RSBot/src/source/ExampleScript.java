package source;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import source.resource.TaskFactory;
import source.resource.component.*;
import source.resource.component.components.*;
import source.resource.execution.Task;
@Manifest(authors = { "Pugno" }, description = "ex", name = "ex")
public class ExampleScript extends ActiveScript implements PaintListener, MouseListener{
	TaskFactory taskFactory;
	Panel panel;
	Button resizeBtn, hideBtn, pauseBtn, moveBtn;
	boolean isStarted = false; //debugging
	/* 
	 *startUp() hacky mainly for debugging and prevention of NPE's
	 */
	public void startUp(){
		taskFactory = new TaskFactory();
		panel = new Panel(new Plane(10, 10, 100, 100));
		resizeBtn = new ResizeButton(new Plane(5, 5, 20, 20), panel);
		hideBtn = new HideButton(new Plane(25, 5, 20, 20), panel);
		pauseBtn = new PauseButton(new Plane(5, 25, 20, 20), panel);
		moveBtn = new MoveButton(new Plane(25, 25, 20, 20), panel);
		
		panel.getComponents().give(resizeBtn).give(hideBtn).give(pauseBtn).give(moveBtn);//fuck yall varargs fags
		
		taskFactory.submit(new Task(){

			@Override
			public boolean validate() {
				return false;
			}

			@Override
			public void execute() {
				
			}
			
		});
	}
	
	@Override
	public int loop() {
		if(isStarted){
			taskFactory.launch();
		} else {
			startUp();
			isStarted = true;
		}
		return 600;
	}

	@Override
	public void onRepaint(Graphics g) {
		if(isStarted){
			panel.draw(g);
		}	
	}
	
	/*
	 * rushed through the mouse listening, didn't feel like writing a dynamic way of doing it, (loop through components and go from there)
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		resizeBtn.mousePressed(e);
		hideBtn.mousePressed(e);
		pauseBtn.mousePressed(e);
		moveBtn.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		resizeBtn.mouseReleased();
		hideBtn.mouseReleased();
		pauseBtn.mouseReleased();
		moveBtn.mouseReleased();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }

}
