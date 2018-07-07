package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

/**
 * MazeDomain Class - define Object Adapter for Maze3d to change him to
 * object that Searchable.
 * @author Osher Kramer
 *
 */
public class MazeDomain implements Searchable<Position> {
	
	private Maze3d maze3d;
	private State<Position> startPositon;
	private State<Position> goalPosition;
	
	/**
	 * Constructor - get Maze3d object and define the start data to define
	 * Maze3d to Searchable
	 * @param maze
	 */
	public MazeDomain(Maze3d maze){
		this.maze3d = maze;
		this.startPositon = new State<Position>(maze3d.getStartPosition());
		this.goalPosition = new State<Position>(maze3d.getGoalPosition());
	}

	@Override
	public State<Position> getStartState() { return startPositon; }

	@Override
	public State<Position> getGoalState() { return goalPosition; }

	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		//Variable
		Position p = s.getState();	
		String[] possible = maze3d.getPossibleMoves(p);
		ArrayList<State<Position>> possibleStates = new ArrayList<State<Position>>();
		State<Position> tempState = null;
		
		//run all of the possible moves and check who is the possible moves and create
		//State of the possible moves to return all the possible moves like State
		for(String str : possible){
			switch (str) {
			case "Move Up":
				tempState = new State<Position>(new Position(p.getX() + 1, p.getY(), p.getZ()));
				break;
			case "Move Down":
				tempState = new State<Position>(new Position(p.getX() - 1, p.getY(), p.getZ()));
				break;
			case "Move Forward":
				tempState = new State<Position>(new Position(p.getX(), p.getY() + 1, p.getZ()));
				break;
			case "Move Back":
				tempState = new State<Position>(new Position(p.getX(), p.getY() - 1, p.getZ()));
				break;
			case "Move Left":
				tempState = new State<Position>(new Position(p.getX(), p.getY(), p.getZ() + 1));
				break;
			case "Move Right":
				tempState = new State<Position>(new Position(p.getX(), p.getY(), p.getZ() - 1));
				break;
			default:
				break;
			}
			
			//define the came from, cost and add the state to the possible states arraay
			tempState.setCameFrom(s);
			tempState.setCost(advenceCost());
			possibleStates.add(tempState);
		}
		
		return possibleStates;
	}

	@Override
	public double advenceCost() {
		return 10;
	}

}
