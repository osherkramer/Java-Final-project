package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * MazeManhattanDistance Class - define the calculate the Heuristic
 * of AStar. Calculate with absolute distance from the coordinate
 * to the goal state
 * @author Osher Kramer
 *
 */

public class MazeManhattanDistance implements Heuristic<Position> {

	private Position goalState;
	
	/**
	 * Constructor - set the goal state of the maze
	 * @param goalState - get the goal state of the maze
	 */
	public MazeManhattanDistance(State<Position> goalState) {
		this.goalState = goalState.getState();
	}
	
	@Override
	public double evaluate(State<Position> s) {
		Position state = s.getState();
		double count = 0;
		
		count += Math.abs(this.goalState.getX() - state.getX());
		count += Math.abs(this.goalState.getY() - state.getY());
		count += Math.abs(this.goalState.getZ() - state.getZ());
		return count*10;
	}

}
