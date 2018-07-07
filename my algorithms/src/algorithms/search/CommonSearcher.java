package algorithms.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * CommonSearcher Class - define the method of algorethems of search
 * this class implements the functional of Searcher Interface
 * @author Osher Kramer
 *
 * @param <T> - get type of the element that in the problem
 */

public abstract class CommonSearcher<T> implements Searcher<T> {

	protected PriorityQueue<State<T>> openList;
	private int evaluatedNodes;

	/**
	 * Default Constructor - define the way to compare between two states in
	 * the priority queue and initialize the evaluated nodes to zero
	 */
	public CommonSearcher(){
		
		openList = new PriorityQueue<State<T>>(new Comparator<State<T>>(){

			@Override
			public int compare(State<T> s1, State<T> s2) {
				return (int) (s1.getCost() - s2.getCost());
			}
			
		});
		
		evaluatedNodes = 0;
	}
	
	/**
	 * return the most state in the priority queue and return him
	 * also add one for the evaluated nodes
	 * @return the most state in the priority queue
	 */
	protected State<T> popOpenList(){
		evaluatedNodes++;
		return openList.poll();
	}
	
	/**
	 * add one state to the open list
	 * @param state - get one state to add
	 */
	protected void addToOpenList(State<T> state){
		openList.add(state);
	}
	
	/**
	 * check if state is contains to the open list
	 * @param state - get state to check if him contains in the open list
	 * @return - return true if it contains and false if not
	 */
	protected boolean openListContains(State<T> state){
		Iterator<State<T>> iterator = openList.iterator();
		while(iterator.hasNext()){
			State<T> temp = iterator.next();
			if(state.getState().equals(temp.getState()))
				return true;
		}
		return false;
	}
	
	/**
	 * check if state is contains to the closed set
	 * @param closedSet - get the closed set to check in
	 * @param state - get the state to check if it is in the closed set
	 * @return - return true if it contains and false if not
	 */
	protected boolean closedSetContians(HashSet<State<T>> closedSet, State<T> state){
		Iterator<State<T>> iterator = closedSet.iterator();
		while(iterator.hasNext()){
			State<T> temp = iterator.next();
			if(state.getState().equals(temp.getState()))
				return true;
		}
		return false;
	}
	
	/**
	 * return the trace of the solution of the problem
	 * @param goalState - the end state in the problem
	 * @param startState - the start state in the problem
	 * @return - Solution of the problem
	 */
	protected Solution<T> backTrace(State<T> goalState, State<T> startState){
		Solution<T> answer = new Solution<T>();
		
		while(startState != goalState){
			answer.add(goalState);
			goalState = goalState.getCameFrom();
		}
		
		answer.add(goalState);
		
		return answer;
	}
	
	
	/**
	 * search the state in the priority queue and if it exist there
	 * change the exist state with the new state
	 * @param state - get new state to input in the queue
	 */
	protected void adjustPriority(State<T> state){
		Iterator<State<T>> iterator = openList.iterator();
		State<T> checkState = null;
		
		while(iterator.hasNext()){
			checkState = iterator.next();
			if(checkState.getState().equals(state.getState())){
					openList.remove(checkState);
					calcCost(checkState);
					checkState.setCameFrom(state.getCameFrom());
					addToOpenList(checkState);
					return;
			}	
		}
	}
	
	/**
	 * calculate the cost of state and set him in the state
	 * @param state - get state to calculate for him
	 */
	protected abstract void calcCost(State<T> state);
	
	@Override
	public abstract Solution<T> search(Searchable<T> s);
	
	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
}
