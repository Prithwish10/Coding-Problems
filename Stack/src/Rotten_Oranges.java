//In a given grid, each cell can have one of three values:
//the value 0 representing an empty cell;
//the value 1 representing a fresh orange;
//the value 2 representing a rotten orange.
//Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
//Return the minimum number of minutes that must elapse until no cell has a fresh orange.
//If this is impossible, return -1 instead.

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {

	class Object{
		
		int time;
		int x, y;
		
		Object(int time, int x, int y){
			this.time = time;
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) {
		
		int eggs[][] = {{1, 1, 0, 2, 1},
						{1, 0, 1, 1, 1},
						{1, 0, 0, 2, 1}};
		
		Rotten_Oranges rot = new Rotten_Oranges();
		System.out.println(rot.findTime(eggs));
	}
	
	public boolean findTime(int eggs[][]) {
		
		Queue<Object> queue = new LinkedList<Object>();
		
		for(int i = 0; i < eggs.length; i++) {
			
			for(int j = 0; j < eggs[i].length; j++) {
				
				if(eggs[i][j] == 2) {
					
					queue.add(new Object(0, i, j));
				}
			}
		}
		
		int rows = eggs.length;
		int cols = eggs[0].length;
		
		int max = 0;
		
		while(!queue.isEmpty()) {
			
			Object temp = queue.poll();
			
			if(temp.time > max)
				max = temp.time;
			
			if(temp.x + 1 < rows && eggs[temp.x + 1][temp.y] == 1) {	// DOWN
				queue.add(new Object(temp.time + 1, temp.x + 1, temp.y));
				eggs[temp.x + 1][temp.y] = 2;
			}
			
			if(temp.x - 1 >= 0 && eggs[temp.x - 1][temp.y] == 1) {	// UP
				queue.add(new Object(temp.time + 1, temp.x - 1, temp.y));
				eggs[temp.x - 1][temp.y] = 2;
			}
			
			if(temp.y + 1 < cols && eggs[temp.x][temp.y + 1] == 1) {
				queue.add(new Object(temp.time + 1, temp.x, temp.y + 1));
				eggs[temp.x][temp.y + 1] = 2;
			}
			
			if(temp.y - 1 >= 0 && eggs[temp.x][temp.y - 1] == 1) {
				queue.add(new Object(temp.time + 1, temp.x, temp.y - 1));
				eggs[temp.x][temp.y - 1] = 2;
			}
		}
		for(int i = 0; i < eggs.length; i++) {
			
			for(int j = 0; j < eggs[i].length; j++) {
				
				if(eggs[i][j] == 1)
					return false;
			}
			
		}
		
		System.out.println("Max time to convert all the fresh ornges to rotten orange is : "+ max);
		return true;
	}
}
