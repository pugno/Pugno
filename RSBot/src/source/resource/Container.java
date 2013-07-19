package source.resource;

import java.util.ArrayList;

public class Container<E> extends ArrayList<E>{
	
	public Container<E> give(E element){
		add(element);
		return this;
	}
	
	public Container<E> add(E...elements){
		for(E element : elements){
			if(element != null && !contains(element)){
				add(element);
			}
		}
		return this;
	}

}
