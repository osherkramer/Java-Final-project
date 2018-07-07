package algorithms.search;


import java.util.LinkedList;

/**
 * Class Solution - manage the solution of the problem
 * 
 * @author Osher Kramer
 *
 * @param <T> - get type to work with him
 */
public class Solution<T> {
	private LinkedList<State<T>> arr;
	
	/**
	 * Default Constructor - initialize the ArrayList of State<T> in the class
	 */
	public Solution(){
		arr = new LinkedList<State<T>>();
	}
	
	/**
	 * get the solution of the problem
	 * @return ArrayList of State which type T
	 */
	public LinkedList<State<T>> getSolution(){
		return arr;
	}
	
	
	/**
	 * add new State to index in the solution
	 * @param index - index at which the specified place is to be inserted 
	 * @param s - the State to be inserted
	 */
	
	public void add(State<T> s){
		arr.add(s);
	}
	
	/**
	 * return if specific State is contains in the solution
	 * @param s - the State to search in the solution
	 * @return true if this list contains the specified State
	 */
	public boolean contains(State<T> s){
		boolean isExist = arr.contains(s);
		
		return isExist;
	}
	
	/**
	 * return the index of the first occurrence of the specified State in the solution
	 * @param s - State to search it
	 * @return the index of the first place occurrence of the specified State, or -1 if it not in the solution
	 */
	public int indexOf(State<T> s){
		int place = arr.indexOf(s);
		
		return place;
	}
	
	/**
	 * remove the first occurrence of the specified State in the solution
	 * @param s - get the occurrence spcified State to remove
	 * @return true if success or false if not success
	 */
	public boolean remove(State<T> s){
		boolean isDelete = arr.remove(s);
		
		return isDelete;
	}
	
	
	/**
	 * Print the solution - print State after State
	 */
	public void print(){
		for(State<T> s:arr)
			System.out.print(s.getState() + " ");
		System.out.println("");
	}

}
