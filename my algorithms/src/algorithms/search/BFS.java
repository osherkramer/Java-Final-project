package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
/**
 * BFS - Best First Solution Class
 * search the solution of the problem with BFS Algorithm
 * @author Osher Kramer
 *
 * @param <T> - get type of the element that in the problem
 */
public class BFS<T> extends CommonSearcher<T> {
	
	@Override
	public Solution<T> search(Searchable<T> s) {
		
		addToOpenList(s.getStartState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();
		
		while(openList.size() > 0){
			State<T> n = popOpenList();
			closedSet.add(n);
			
			if(n.equals(s.getGoalState()))
			{
				return backTrace(n, s.getStartState());
			}
			
			ArrayList<State<T>> successors = s.getAllPossibleStates(n);
			
			for(State<T> state : successors){				
				if(!closedSetContians(closedSet, state) && !openListContains(state)){
					state.setCameFrom(n);
					calcCost(state);
					addToOpenList(state);
				}
				else{					
					if(state.getCost() < n.getCost() + s.advenceCost())
					{
						if(!openListContains(state)){
							calcCost(state);
							addToOpenList(state);
						}
						else{				
							adjustPriority(state);
						}	
					}
				}
			}
		}
		return null;
	}

	@Override
	protected void calcCost(State<T> state){
		state.setCost(state.getCameFrom().getCost() + state.getCost());
   
	}

}
