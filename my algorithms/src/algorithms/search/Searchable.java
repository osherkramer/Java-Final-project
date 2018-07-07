package algorithms.search;

import java.util.ArrayList;
/**
 * Interface Searchable - define the functional of searchable
 * @author Osher Kramer
 *
 * @param <T> - define the object that will be searchable
 */
public interface Searchable<T> {
	/**
	 * return the start state
	 * @return - State which type T
	 */
	State<T> getStartState();
	/**
	 * return the goal state
	 * @return - State which type T
	 */
	State<T> getGoalState();
	
	/**
	 * return all the possible states
	 * @param s - get specific state which type T
	 * @return - ArrayList of states that they are possible states
	 */
	ArrayList<State<T>> getAllPossibleStates(State<T> s);	
	
	/**
	 * define the cost of move
	 * @return - double that define the cost
	 */
	double advenceCost();
}
