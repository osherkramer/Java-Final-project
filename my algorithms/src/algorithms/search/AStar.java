package algorithms.search;
/**
 * AStar Class - search the solution of the problem with A* Algorithm
 * @author Osher Kramer
 *
 * @param <T>
 */
public class AStar<T> extends BFS<T> {
	
	private Heuristic<T> heuristic;
	
	/**
	 * Constructor of A* 
	 * @param h - get heuristic to the calculate of the cost of the state
	 */
	public AStar(Heuristic<T> h){
		this.heuristic = h;
	}
	
	@Override
	protected void calcCost(State<T> state){
		state.setCost(state.getCost() + state.getCameFrom().getCost() + heuristic.evaluate(state));
	}

}
