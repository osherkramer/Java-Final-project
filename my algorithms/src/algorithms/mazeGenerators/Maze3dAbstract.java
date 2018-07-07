/*
 * Maze3dAbstract
 * 
 * This class is abstract and implements the Maze3dGenerator
 * 
 * Osher Kramer
 * 
 * 08/08/2015
 */

package algorithms.mazeGenerators;

public abstract class Maze3dAbstract implements Maze3dGenerator {

	@Override
	public abstract Maze3d generate(int x, int y, int z);
	
	//measureAlgorithmTime
	public String measureAlgorithmTime(int x, int y, int z) {

		//Variables
		long startTime = 0;
		long endTime = 0;
		long time = 0;
		String timeStr;
		
		//Get current time - start
		startTime = System.currentTimeMillis();
		
		//Call to generate to create maze
		generate(x, y, z);
		
		//Get current time - end
		endTime = System.currentTimeMillis();
		
		//calc the time to generate the maze
		time = endTime - startTime;
		
		//convert from long to string
		timeStr = "" + time;
		
		return timeStr;
	}

}
