import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class All_Paths_From_Source_To_Target {

public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(graph == null || graph.length == 0)
            return res;
        
       
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        dfs(graph, res, 0, visited, list);
        
        return res;
    }
    private void dfs(int graph[][], List<List<Integer>> res, int currentNode, Set<Integer> visited, List<Integer> list){
        
        visited.add(currentNode);
        list.add(currentNode);
        
        if(currentNode == graph.length - 1){
            res.add(new ArrayList<>(list));
            return;
        }
        
        //List<Integer> neighbour = graph.get(currentNode);
        
        for(int i = 0; i < graph[currentNode].length; i++){
            
            if(!visited.contains(graph[currentNode][i])){
                dfs(graph, res, graph[currentNode][i], visited, list);
                list.remove(list.size() - 1);
                visited.remove(graph[currentNode][i]);
            }
        }
    }
}
