package algorithms.demo;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Solution;
import algorithms.search.State;

/**
 * Demo Class - manage the demo of create maze3d, and solution him
 * the class have method of Run that running the demo
 * 
 * @author Osher Kramer
 *
 */
public class Demo {
	
	/**
	 * Execute the demo of create and solution maze3d
	 */
	public void Run(){
		//create maze3d after generate
		Maze3d maze = new MyMaze3dGenerator().generate(5,13,13);
		
		//create objects of the searches algorithms
		BFS<Position> bfs = new BFS<Position>();
		AStar<Position> astarAirDistance = new AStar<Position>(new MazeAirDistance(new State<Position>(maze.getGoalPosition())));
		AStar<Position> astarManhattanDistance = new AStar<Position>(new MazeManhattanDistance(new State<Position>(maze.getGoalPosition())));
		
		//print data of the maze3d - the maze, start and goal positions.
		System.out.println("***** Print the 3D maze *****");
		maze.print();
		System.out.println("Start state: " + maze.getStartPosition());
		System.out.println("Goal state: " + maze.getGoalPosition());
		System.out.println("*****************************");
		
		//print the different between BFS and AStar
		System.out.println("******** BFS Vs. A* *********");
		
		//run search method of BFS and AStar and get the solution
		Solution<Position> bfsSolution = bfs.search(new MazeDomain(maze));
		Solution<Position> astarAir = astarAirDistance.search(new MazeDomain(maze));
		Solution<Position> astarManhattan = astarManhattanDistance.search(new MazeDomain(maze));
		
		//BFS solution data
		System.out.println("BFS Algorithm:");
		System.out.println("Solution:");
		bfsSolution.print();
		System.out.println("Number Of Nodes Evaluated: " + bfs.getNumberOfNodesEvaluated());
		
		//AStar with Air Distance data
		System.out.println("A* with Air Distance Algorithm:");
		System.out.println("Solution:");
		astarAir.print();
		System.out.println("Number Of Nodes Evaluated: " + astarAirDistance.getNumberOfNodesEvaluated());
		
		//AStar with Manhattan Distance data
		System.out.println("A* with Manhattan Distance Algorithm:");
		System.out.println("Solution:");
		astarManhattan.print();
		System.out.println("Number Of Nodes Evaluated: " + astarManhattanDistance.getNumberOfNodesEvaluated());
		
		System.out.println("*****************************");
		
		System.out.println();
	}

}
