package source.resource.component;

public class Plane {
	private int x, y, width = -1, height = -1;
	public Plane(int x, int y){
		this.x = setX(x);
		this.y = setY(y);
	}
	public Plane(int x, int y, int width, int height){
		this(x, y);
		setWidth(width);
		setHeight(height);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int setX(int x){
		return this.x = x;
	}
	
	public int setY(int y){
		return this.y = y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int setWidth(int width){
		return this.width = width;
	}
	
	public int setHeight(int height){
		return this.height = height;
	}

}
