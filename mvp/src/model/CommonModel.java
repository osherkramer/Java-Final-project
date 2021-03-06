package model;

import java.util.HashMap;
import java.util.Observable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Presenter;
import presenter.Properties;
/**
 * CommonModel implements Model interface
 * abstract class of the model
 */

public abstract class CommonModel extends Observable implements Model {
	
	Presenter presenter;
	HashMap<String, Maze3d> hashMaze;
	HashMap<Maze3d, Solution<Position>> hashSolution;
	/**
	 * constructor for common model
	 */
	public CommonModel() {
		hashMaze = new HashMap<String,Maze3d>();
		hashSolution = new HashMap<Maze3d, Solution<Position>>();
	}

	@Override	
	public Solution<Position> getSolution(String name){
		return hashSolution.get(hashMaze.get(name));
	}
	@Override
	public abstract void generate(String name, int x, int y, int z);


	@Override
	public abstract void getMazeByName(String name);
	
	@Override
	public abstract void createSolution(String name);
	
	@Override
	public abstract void crossBy(String by, int index, String name);
	
	@Override
	public abstract void saveMaze(String arg);
	
	@Override
	public abstract void loadMaze(String arg);
	
	@Override
	public abstract void mazeSizeMemory(String name);

	@Override
	public abstract void mazeSizeFile(String name);
	
	@Override
	public abstract void exit();
	
	@Override
	public abstract void save();
	
	@Override
	public abstract void setProperties(Properties properties);
	
	@Override
	public abstract void setxSize(int xSize);

	@Override
	public abstract void setySize(int ySize);

	@Override
	public abstract void setzSize(int zSize);

	@Override
	public abstract void setAlgorithemForSolution(String algorithemForSolution);

	@Override
	public abstract void setAlgorithemForCreate(String algorithemForCreate);
	
	@Override
	public abstract void generate();
}
