package algorithms.search;
/**
 * Interface Heuristic - define the format of the calculate the road
 * to the goal state for the AStar algorithm
 * @author Osher Kramer
 *
 * @param <T> - get the type of the problem to the search
 */
public interface Heuristic<T> {

	/**
	 * evaluate - define how to calculate the way that left
	 * @param state - get the current state in the problem
	 * @return - double that define the cost of the way that left
	 */
	double evaluate(State<T> state);

}
