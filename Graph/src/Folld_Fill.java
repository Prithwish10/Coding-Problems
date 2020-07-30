import java.util.LinkedList;
import java.util.Queue;

class Folld_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null)
            return new int[][]{{}};
        
        int r = image.length;
        int c = image[0].length;
            
        if(sr >= r || sc < 0)
            return new int[][]{{}};
        
        int visited[][] = new int[r][c];
        
        Queue<Pair> queue = new LinkedList<Pair>();
        
        queue.add(new Pair(sr, sc, image[sr][sc]));
        image[sr][sc] = newColor;
        visited[sr][sc] = 1;
        
        while(!queue.isEmpty()){
            
            Pair temp = queue.poll();
            
            int x = temp.x;
            int y = temp.y;
            int color = temp.color;
            
            if(isSafe(image, x, y + 1) && visited[x][y + 1] == 0 && (image[x][y + 1] == color)){
                
                queue.add(new Pair(x, y + 1, image[x][y + 1]));
                image[x][y + 1] = newColor;
                visited[x][y + 1] = 1;
            }
            
            if(isSafe(image, x, y - 1) && visited[x][y - 1] == 0 && (image[x][y - 1] == color)){
                
                queue.add(new Pair(x, y - 1, image[x][y - 1]));
                image[x][y - 1] = newColor;
                visited[x][y - 1] = 1;
            }
            
            if(isSafe(image, x - 1, y) && visited[x - 1][y] == 0 && (image[x - 1][y] == color)){
                
                queue.add(new Pair(x - 1, y, image[x - 1][y]));
                image[x - 1][y] = newColor;
                visited[x - 1][y] = 1;
            }
            
            if(isSafe(image, x + 1, y) && visited[x + 1][y] == 0 && (image[x + 1][y] == color)){
                
                queue.add(new Pair(x + 1, y, image[x + 1][y]));
                image[x + 1][y] = newColor;
                visited[x + 1][y] = 1;
            }
        }
        return image;
    }
    public boolean isSafe(int image[][], int x, int y){
        
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return false;
        return true;
    }
}
class Pair{
    
    int x, y, color;
    Pair(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
