/*
 * Maze3d
 * 
 * This class sets maze that 3d
 * 
 * Osher Kramer
 * 
 * 08/08/2015
 */

package algorithms.mazeGenerators;

import java.util.ArrayList;

public class Maze3d {
	
	//Data Members
	int maze3d[][][];
	int y,x,z;
	Position enter;
	Position exit;
	
	//C'tor
	public Maze3d(int x, int y, int z){
		//set x,y,z
		this.x = x;
		this.y = y;
		this.z = z;
		
		//build maze3d
		maze3d = new int[x][y][z];
		
		//get startPosition
		enter =null;
		exit = null;
		enter = getStartPosition();
		exit = getGoalPosition();
	}
		
	//create walls and spaces
	public void createGrid(){
		
		//call to creatWallAll
		createWallAll();
		
		//create space in the odd cells
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y; j++)
				for(int k = 0; k < z; k++)
					if((i%2 != 0) && (j%2 != 0) && (k%2 != 0))
						deleteWall(i,j,k);
	}
	
	//create all of the maze walls
	public void createWallAll(){
		for(int i = 0 ; i < x; i++)
			for(int j = 0 ; j < y; j++)
				for(int k = 0; k < z; k++)
					createWall(i,j,k);
	}
	
	//create wall in cell
	public void createWall(int x, int y, int z){
		if(y < this.y && x < this.x && z < this.z && y >= 0 && x >= 0 && z>= 0)
			maze3d[x][y][z] = 1;
	}
	
	//create space in cell
	public void deleteWall(int x, int y, int z){
		if(y < this.y && x < this.x && z < this.z && y >= 0 && x >= 0 && z>= 0)
			maze3d[x][y][z] = 0;
	}
	
	//create space in cell
	public boolean haveSpace(int x, int y, int z){
		return maze3d[x][y][z] == 0;
	}
	
	public Position deleteBetween(Position cell,Position nextCell){
		
		int x = cell.getX(), y = cell.getY(), z = cell.getZ();
		
		if(cell.getX() != nextCell.getX())
			if(cell.getX() > nextCell.getX())
				x--;
			else
				x++;
		else if(cell.getY() != nextCell.getY())
			if(cell.getY() > nextCell.getY())
				y--;
			else
				y++;
		else if(cell.getZ() != nextCell.getZ())
			if(cell.getZ() > nextCell.getZ())
				z--;
			else
				z++;
		
		this.deleteWall(x, y, z);
		
		return new Position(x,y,z);
	}
	
	//geter and seter
	public int[][][] getMaze3d() {
		return maze3d;
	}
	public void setMaze3d(int[][][] maze3d) {
		this.maze3d = maze3d;
	}	
	
	//create goal position
	public Position getGoalPosition() {
		if(exit == null){
			exit = createPosition();
			deleteWall(exit.getX(), exit.getY(), exit.getZ());
		}
		return exit;
	}
	
	//create start position
	public Position getStartPosition() {
		if(enter == null){
			enter = createPosition();
			deleteWall(enter.getX(), enter.getY(), enter.getZ());
		}
		return enter;
	}

	//geters for y,x,z of the maze
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public int getZ() {
		return z;
	}

	//getNeibhors - get all the position that they Neibhors
	public ArrayList<Position> getNeibhors(Position cell, boolean[][][] visitedCells){
		int x = cell.getX();
		int y = cell.getY();
		int z = cell.getZ();
		ArrayList<Position> arr = new ArrayList<Position>();
		
		
		if(x < this.x - 2)
			if(visitedCells[x+2][y][z] == false)
				arr.add(new Position(x+2,y,z));
		if(x-2 > 0)
			if(visitedCells[x-2][y][z] == false)
				arr.add(new Position(x-2,y,z));
		if(y < this.y - 2)
			if(visitedCells[x][y+2][z] == false)
				arr.add(new Position(x,y+2,z));
		if(y-2 > 0)
			if(visitedCells[x][y-2][z] == false)
				arr.add(new Position(x,y-2,z));
		if(z < this.z - 2)
			if(visitedCells[x][y][z+2] == false)
				arr.add(new Position(x,y,z+2));
		if(z-2 > 0)
			if(visitedCells[x][y][z-2] == false)
				arr.add(new Position(x,y,z-2));
			
		return arr;
	}

	//print all the cells of the maze
	public void print(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				for(int k = 0; k < z; k++)
					System.out.print(maze3d[i][j][k] + " ");
				System.out.println();
			}
			System.out.println();
		}		
	}

	//set new enter
	public void setEnter(Position enter) {
		createWall(enter.getX(), enter.getY(), enter.getZ());
		this.enter = enter;
		deleteWall(enter.getX(), enter.getY(), enter.getZ());
	}

	//set new exit
	public void setExit(Position exit) {
		createWall(exit.getX(), exit.getY(), exit.getZ());
		this.exit = exit;
		deleteWall(exit.getX(), exit.getY(), exit.getZ());
	}

	//getPossibaleMoves - call to getNeibhors and input the point in string
	public String[] getPossibleMoves(Position cell){
		int x = cell.getX(), y = cell.getY(), z = cell.getZ();
		ArrayList<String> arr = new ArrayList<String>();
		String[] str;
		
		//check the possible moves
		if(x + 1 <= this.x - 1 && haveSpace(x+1,y,z))
			arr.add("Move Up");
		if(x-1 >= 0 && haveSpace(x-1,y,z))
			arr.add("Move Down");
		if(y + 1 <= this.y - 1 && haveSpace(x,y + 1,z))
			arr.add("Move Forward");
		if(y-1 >= 0 && haveSpace(x,y - 1,z))
			arr.add("Move Back");
		if(z + 1 <= this.z - 1 && haveSpace(x,y,z + 1))
			arr.add("Move Left");
		if(z-1 >= 0 && haveSpace(x,y,z - 1))
			arr.add("Move Right");
		
		//create String array
		str = new String[arr.size()];
		
		//copy the string to the string array
		for(int i = 0; i < arr.size(); i++)
			str[i] = arr.get(i);
		
		return str;
	}
	
	//return maze2d by x
	public int[][] getCrossSectionByX(int num) throws IndexOutOfBoundsException{
		if(num < 0 || num > x - 1)
			throw new IndexOutOfBoundsException();
		
		int[][] maze2d = new int[y][z];
		
		for(int i = 0; i < y; i++)
			for(int j = 0; j < z; j++)
				maze2d[i][j] = maze3d[num][i][j];	
		
		return maze2d;
	}
	
	//return maze2d by y
	public int[][] getCrossSectionByY(int num) throws IndexOutOfBoundsException{
		if(num < 0 || num > y -1)
			throw new IndexOutOfBoundsException();
		
		int[][] maze2d = new int[x][z];
		for(int i = 0; i < x; i++)
			for(int j = 0; j < z; j++)
				maze2d[i][j] = maze3d[i][num][j];
		
		return maze2d;
	}
		
	//return maze2d by z
	public int[][] getCrossSectionByZ(int num) throws IndexOutOfBoundsException{
		if(num < 0 || num > z -1)
			throw new IndexOutOfBoundsException();
		
		int[][] maze2d = new int[x][y];
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				maze2d[i][j] = maze3d[i][j][num];
		
		return maze2d;
	}
		
	//create position in one of the edge
	public Position createPosition() {
		
		//Variables
		int x, y, z, edge;
		
		//get random cell (odd number for the enter/exit to the maze)
		x = (int)(Math.random()*this.x);
		if(x%2 == 0)
			if(x == this.x - 1)
				x--;
			else
				x++;
		y = (int)(Math.random()*this.y);
		if(y%2 == 0)
			if(y == this.y - 1)
				y--;
			else
				y++;
		z = (int)(Math.random()*this.z);
		if(z%2 == 0)
			if(z == this.z - 1)
				z--;
			else
				z++;
		
		//get random edge
		edge = (int)(Math.random()*6);
		
		//change the coordinates to the random edge
		switch (edge) {
		case 0:
			z = 0;
			break;
		case 1:
			z = this.z - 1;
			break;
		case 2:
			y = 0;
			break;
		case 3:
			y = this.y - 1;
			break;
		case 4:
			x = 0;
			break;
		case 5:
			x = this.x - 1;
			break;

		default:
			break;
		}
		
		return new Position(x,y,z);
	}
	
	//choose random cell that not visit
	public Position getRandUnVisited(boolean[][][] visitedCells){
		int x = 0, y = 0, z = 0;
		
		while(visitedCells[x][y][z] == true){
			x = 1 + (int)(Math.random()*(this.x-2));
			y = 1 + (int)(Math.random()*(this.y-2));
			z = 1 + (int)(Math.random()*(this.z-2));
		}
		
		return new Position(x,y,z);
		
	}
}
