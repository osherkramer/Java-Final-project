/*
 * MyMaze3dGenerator
 * 
 * Recursive backtracker
 * 
 * Osher Kramer
 * 
 * 08/08/2015
 */

package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Stack;

public class MyMaze3dGenerator extends Maze3dAbstract {
	
	@Override
	public Maze3d generate(int x, int y, int z) {
		
		//Variables
		Maze3d maze = new Maze3d(x,y,z);
		boolean visitedCells[][][] = new boolean[x][y][z];
		
		int allCelles = (x/2)*(y/2)*(z/2);
		int numOfVisit = 0;
		
		Position cell;	
		
		Stack<Position> positionStack = new Stack<Position>();
		ArrayList<Position> neibhors;

		//create grid for the mazes
		maze.createGrid(); 
		
		//get the start position
		Position tempCell = maze.getStartPosition();
		maze.deleteWall(tempCell.getX(), tempCell.getY(), tempCell.getZ());
		
		//in start position we have one coordinate that is even (the egde that use to enter). check who is it
		//and then check if the even is in the cell 0, or in the end cell. set the cell we start from him to the
		//cell near the enter - cell that all the coordinates is odd.
		if(tempCell.getX() % 2 == 0)
			if(tempCell.getX() == 0)
				cell = new Position(tempCell.getX() + 1,tempCell.getY(),tempCell.getZ());
			else
				cell = new Position(tempCell.getX() - 1,tempCell.getY(),tempCell.getZ());
		else if(tempCell.getY() % 2 == 0)
			if(tempCell.getY() == 0)
				cell = new Position(tempCell.getX(),tempCell.getY() + 1,tempCell.getZ());
			else
				cell = new Position(tempCell.getX(),tempCell.getY() - 1,tempCell.getZ());
		else
			if(tempCell.getZ() == 0)
				cell = new Position(tempCell.getX(),tempCell.getY(),tempCell.getZ() + 1);
			else 
				cell = new Position(tempCell.getX(),tempCell.getY(),tempCell.getZ() - 1);
		
		visitedCells[cell.getX()][cell.getY()][cell.getZ()] = true;
		numOfVisit++;
					
		while(numOfVisit < allCelles){
			//get all neibhors of current cell
			neibhors = maze.getNeibhors(cell,visitedCells);
			
			//check if current cell have neibhors
			if(neibhors.size() > 0){
				
				//get random cell from the neibhors
				int random = (int)(Math.random()*neibhors.size());
				Position nextCell = neibhors.get(random);
				
				//delete the wall beteewn two cells
				maze.deleteBetween(cell,nextCell);
				
				//enter the current cell to the stack
				positionStack.push(cell);
				
				
				//current cell is the neibhor new
	            cell = nextCell;
	            visitedCells[cell.getX()][cell.getY()][cell.getZ()] = true;
	            
	            //count the num of visit until now
	            numOfVisit++;
			}
			
			//if we don't have neibhers we come back to the last position in the stack - if the stack not empty
			else if(!positionStack.empty())
				cell = positionStack.pop();
			
			//if the stack is empty we chose new random neibors
			else{
				cell = maze.getRandUnVisited(visitedCells);
				visitedCells[cell.getX()][cell.getY()][cell.getZ()] = true;
				numOfVisit++;
			}
				
		}
		
		tempCell = maze.createPosition();
		maze.setExit(tempCell);
		
		
//		//after the algoretem end, check where is the cell, near at which egde, and set the cell
//		//that in the edge, near the last current cell, to be the exit, and delete the wall there
//		if(maze.getX() - cell.getX() == 1){
//			maze.setExit(new Position(cell.getX() + 1, cell.getY(), cell.getZ()));
//			maze.deleteWall(cell.getX() + 1, cell.getY(), cell.getZ());
//		}
//		
//		else if(cell.getX() == 1){
//			maze.setExit(new Position(cell.getX() - 1, cell.getY(), cell.getZ()));
//			maze.deleteWall(cell.getX() - 1, cell.getY(), cell.getZ());
//		}
//		
//		else if(maze.getY() - cell.getY() == 1){
//			maze.setExit(new Position(cell.getX(), cell.getY() + 1, cell.getZ()));
//			maze.deleteWall(cell.getX(), cell.getY() + 1, cell.getZ());
//		}
//		
//		else if(cell.getY() == 1){
//			maze.setExit(new Position(cell.getX(), cell.getY() - 1, cell.getZ()));
//			maze.deleteWall(cell.getX(), cell.getY() - 1, cell.getZ());
//		}
//		
//		else if(maze.getZ() - cell.getZ() == 1){
//			maze.setExit(new Position(cell.getX(), cell.getY(), cell.getZ() + 1));
//			maze.deleteWall(cell.getX(), cell.getY(), cell.getZ() + 1);
//		}
//		
//		else if(cell.getZ() == 1){
//			maze.setExit(new Position(cell.getX(), cell.getY(), cell.getZ() - 1));
//			maze.deleteWall(cell.getX(), cell.getY(), cell.getZ() - 1);
//		}
		
	
		return maze;
	}

}
