package classes;

public class Arc {
	
	private int weight;
	private Place place;
	private Transition transition;
	

	public Arc(int weight, Place place, Transition transition) {
		this.weight = weight;
		this.place = place;
		this.transition = transition;
	}
	
	public Place getPlace() {
		return this.place;
		
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public Transition getTransition() {
		return this.transition;
	}
}
	