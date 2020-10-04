//There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 
//
//Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
//
//Initially, all the rooms start locked (except for room 0). 
//
//You can walk back and forth between rooms freely.
//
//Return true if and only if you can enter every room.
//
//Example 1:
//
//Input: [[1],[2],[3],[]]
//Output: true
//Explanation:  
//We start in room 0, and pick up key 1.
//We then go to room 1, and pick up key 2.
//We then go to room 2, and pick up key 3.
//We then go to room 3.  Since we were able to go to every room, we return true.
//Example 2:
//
//Input: [[1,3],[3,0,1],[2],[0]]
//Output: false
//Explanation: We can't enter the room with number 2.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Is_Possible_To_Visit_All_Rooms {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        if(rooms == null || rooms.size() == 0)
            return false;
        
        Set<Integer> visited = new HashSet<>();
        
        dfs_helper(rooms, 0, visited);
        
        if(visited.size() == rooms.size())
            return true;
        
        return false;
    }
    private void dfs_helper(List<List<Integer>> rooms, int currentRoom, Set<Integer> visited){
        
        visited.add(currentRoom);
        
        List<Integer> neighbour = rooms.get(currentRoom);
        
        for(int room : neighbour){
            
            if(!visited.contains(room))
                dfs_helper(rooms, room, visited);
        }
    }
}
