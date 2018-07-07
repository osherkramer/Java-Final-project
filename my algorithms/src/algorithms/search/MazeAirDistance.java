package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * MazeAirDistance Class - define the calculate the Heuristic
 * of AStar. Calculate with air distance between the current state
 * to the goal state
 * @author Osher Kramer
 *
 */
public class MazeAirDistance implements Heuristic<Position> {

	private Position goalState;
	/**
	 * Constructor - set the goal state of the maze
	 * @param goalState - get the goal state of the maze
	 */
	public MazeAirDistance(State<Position> goalState) {
		this.goalState = goalState.getState();
	}
	
	@Override
	public double evaluate(State<Position> s) {
		Position state = s.getState();
		double count;
		
		int x = Math.abs(this.goalState.getX() - state.getX());
		int y = Math.abs(this.goalState.getY() - state.getY());
		int z = Math.abs(this.goalState.getZ() - state.getZ());
		
		count = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		
		return count*10;
	}
	

}
