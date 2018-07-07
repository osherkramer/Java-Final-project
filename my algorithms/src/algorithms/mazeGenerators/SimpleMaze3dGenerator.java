/*
 * SimpaleMaze3dGenerator
 * 
 * create a simpale maze
 * 
 * Osher Kramer
 * 
 * 08/08/2015
 */

package algorithms.mazeGenerators;

public class SimpleMaze3dGenerator extends Maze3dAbstract {
	
	@Override
	public Maze3d generate(int x, int y, int z) {
		
		//Variables
		Maze3d maze3d = new Maze3d(x,y,z);
		int step = 0;
				
		//Get enter to the maze
		Position enter = maze3d.getStartPosition();
		Position exit = maze3d.getGoalPosition();
		
		//Random diffuser walls
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				for(int k = 0; k < z; k++)
					if(Math.random() > 0.5)
						maze3d.createWall(i, j, k);
					else
						maze3d.deleteWall(i, j, k);
			
		//Get the coordinates of the enter
		int goY = enter.getY();
		int goX = enter.getX();
		int goZ = enter.getZ();
		
		
		/*
		 * Go with goX, goY, goZ in random from the enter to the exit
		 * random one of the axis and check if the point is left or right from the exit, and go to 
		 * the direction of the exit.
		 */
		while(goY != exit.getY() && goX != exit.getX() && goZ !=exit.getZ())
		{
			step = (int)(Math.random() * 3 + 1);
			switch (step) {
			case 1:
				if(goY < exit.getY())
					goY++;
				else
					goY--;
									
				break;
			case 2:
				if(goX < exit.getX())
					goX++;
				else
					goX--;				
				break;
			case 3:
				if(goZ < exit.getZ())
					goZ++;
				else
					goZ--;				
				break;
			default:
				break;
			}
			
			maze3d.deleteWall(goX, goY, goZ);
		}
		
		return maze3d;
	}

}
