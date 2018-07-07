package algorithms.search;
/**
 * Interface Searcher<T> - defines search functionality
 * @author Osher Kramer
 *
 * @param <T> - get type of the element that in the problem
 */
public interface Searcher<T> {
	/**
	 * search is run the algorithm that search the solution of the problem
	 * @param s - get Searchable
	 * @return Solution of the search
	 */
	public Solution<T> search(Searchable<T> s);
	
	/**
	 * return the number of the nodes evaluated in the search
	 * @return number of the nodes evaluated
	 */
	public int getNumberOfNodesEvaluated();

}
