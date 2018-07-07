package algorithms.search;

/**
 * Class State - manage object that sets a state in the problem
 * 
 * @author Osher Kramer
 *
 * @param <T> - set the type of the state
 */

public class State<T> {
	
	private T state;
	private double cost;
	private State<T> cameFrom;
	
	/**
	 * Constructor - initialize data members of state
	 * @param state - get state of type T to initialize the State
	 */
	public State(T state){
		this.state = state;
		this.cost = 0;
		this.cameFrom = null;
	}
	
	/**
	 * return the state
	 * @return - return the value state, the type is T
	 */
	public T getState() {
		return state;
	}

	/**
	 * set the value of the State which type T
	 * @param state - get state which type T
	 */
	public void setState(T state) {
		this.state = state;
	}

	/**
	 * return the value of the cost of the State
	 * @return value of double
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * set the cost of the State
	 * @param cost - get double that set the cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * return the State that came from him to the current State
	 * @return State of type T
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}

	/**
	 * set the State which type T that came from him to current State
	 * @param cameFrome - get State which type T
	 */
	public void setCameFrom(State<T> cameFrome) {
		this.cameFrom = cameFrome;
	}

	/**
	 * equals between two States
	 */
	@SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object obj){
		
        return state.equals(((State<T>)obj).state);
    }
}
