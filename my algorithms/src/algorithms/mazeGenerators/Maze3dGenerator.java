/*
 * Maze3dGenerator
 * 
 * This interface sets the functional of the maze generator
 * 
 * Osher Kramer
 * 
 * 08/08/2015
 */

package algorithms.mazeGenerators;

public interface Maze3dGenerator {
	Maze3d generate(int x, int y, int z);
	String measureAlgorithmTime(int x, int y, int z);
}
