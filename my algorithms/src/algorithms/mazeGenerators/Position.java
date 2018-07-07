/*
 * Position
 * 
 * Osher Kramer
 * 
 * 08/08/2015
 */

package algorithms.mazeGenerators;

public class Position {
	int x,y,z;
	
	//C'tor
	public Position(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//geters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}

	//seters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	//equal metehod
	@Override
	public boolean equals(Object obj){
		Position p = (Position)obj;
		return ((this.x == p.getX()) && (this.y == p.getY()) && (this.z == p.getZ()));
	}
	
	//print point
	public void print(){
		System.out.println("{" + this.x + ", " + this.y + ", " + this.z + "}");
	}
	
	//convert point to string
	public String toString(){
		return "{" + this.x + "," + this.y + "," + this.z + "}";
	}
}
