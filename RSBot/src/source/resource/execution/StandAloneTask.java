package source.resource.execution;

public abstract class StandAloneTask extends Task {
	boolean isShutdown = false;
	Thread thread;
	
	@Override
	public void execute() {
		if(thread != null){
			if(!thread.isAlive()){
				
			}
		} else {
			thread = new Thread(new Runnable(){

				@Override
				public void run() {
					while(!isShutdown){
						if(validate()){
							delay(loop());
						}
					}
				}
			});
		}

	}
	
	protected abstract int loop();
	
	public boolean shutDown(){
		return isShutdown = true;
	}

	protected void delay(long millis){
		try {
			thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
