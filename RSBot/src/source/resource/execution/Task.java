package source.resource.execution;
public abstract class Task {
	protected boolean isShutdown = false;
	
	public boolean shutDown(){
		return isShutdown = true;
	}
	
	public abstract boolean validate();
	public abstract void execute();
	
}
