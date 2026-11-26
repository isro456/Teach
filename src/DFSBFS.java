import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DFSBFS 
{


    public boolean validPath(int n, int[][] edges, int source, int destination) 
    {
        Map<Integer, List<Integer>> graph = new HashMap<>();
         for(int[] edge : edges)
         {
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
         }
         boolean[] visited = new boolean[n];
         boolean[] visited = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();

    queue.offer(source);
    visited[source] = true;

    while (!queue.isEmpty()) {
        int current = queue.poll();

        if (current == destination) {
            return true;
        }

        for (int neighbor : graph.getOrDefault(current, List.of())) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }

    return false;

         return dfs(source,destination, graph, visited);
    }
    private boolean dfs(int current, int destination, Map<Integer, List<Integer>> graph, boolean[] visited)
    {
        if(current == destination) return true;
        visited[current] = true;

        for(int neighboor : graph.get(current))
        {
            if(visited[neighboor]) continue;
            
            boolean found = dfs(neighboor,destination,graph,visited);
            if(found) return true;
            if(!found) continue;

        }



        return false;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int oldColor = image[sr][sc];

        if (oldColor == color) return image;

        dfs(image,sr,sc,oldColor,color);
        
        return image;
    }
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) 
    {
    if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) return;
    if (image[row][col] != oldColor) return;
    
    image[row][col] = newColor;
    
    dfs(image, row + 1, col, oldColor, newColor);
    dfs(image, row - 1, col, oldColor, newColor);
    dfs(image, row, col + 1, oldColor, newColor);
    dfs(image, row, col - 1, oldColor, newColor); 
    }
    
}
public int numIslands(char[][] grid) 
    {
        int count = 0;

        for(int row = 0; row < grid.length; row ++)
        {
            for(int col = 0; col < grid[0].length; col ++)
            {
                if(grid[row][col] == '1')
                {
                    count++;
                    dfs(grid,row,col);
                }
            }
        }

        return count;
    }
    private void dfs(char[][] grid, int row, int col)
    {
         if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
         if(grid[row][col] != '1') return;
         grid[row][col] = '0';
         dfs(grid, row + 1, col);
         dfs(grid, row - 1, col);
         dfs(grid, row, col + 1);
         dfs(grid, row, col - 1); 
    }
public int maxAreaOfIsland(int[][] grid) 
    {
        int max = 0;

        for(int row = 0; row < grid.length; row ++)
        {
            for(int col = 0; col < grid[0].length; col ++)
            {
                if(grid[row][col] == 1)
                {
                    max = Math.max(max,dfs(grid,row,col));
                }
            }
        }
        return max;   
    }
public int dfs(int[][] grid, int row, int col)
    {
        int area = 0;
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;
        if(grid[row][col] !=  1) return 0;
        area ++;
        grid[row][col] = 0;
        area +=dfs(grid, row + 1, col);
        area +=dfs(grid, row - 1, col);
        area +=dfs(grid, row, col + 1);
        area +=dfs(grid, row, col - 1);

        return area;
    }
public int findCircleNum(int[][] isConnected)
    {
        boolean[] visited = new boolean[isConnected.length];
        
        int count = 0;

        for(int city = 0; city < isConnected.length; city ++)
        {
            if(!visited[city])
            {
                count++;
                dfs(isConnected,visited,city);
            }
        }

        return count;
    }
    public void dfs(int[][] isConnected,boolean[] visited, int city)
    {
        visited[city] = true;

        for(int neighbor = 0; neighbor < isConnected.length; neighbor++)
        {
            if(isConnected[city][neighbor] == 1 && !visited[neighbor])
            {
                dfs(isConnected,visited,neighbor);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
         boolean[] visited = new boolean[rooms.size()];      
         
         dfs(rooms,0,visited);

         for(boolean xuy: visited)
         {
            if(!xuy) return false;
         }
         return true;
    }
    public void dfs(List<List<Integer>> rooms, int room, boolean[] visited)
    {
        visited[room] = true;

        for(int neighbor : rooms.get(room))
        {
            if(visited[neighbor]) continue;
            dfs(rooms,neighbor,visited);
        }
    }
    public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int count1 = 0;

    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[row][col] == 2) queue.offer(new int[]{row, col});
            if (grid[row][col] == 1) count1++;
        }
    }

    int minutes = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // проверка соседа СНИЗУ
            if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                count1--;
                queue.offer(new int[]{row + 1, col});
            }
            
            // проверка соседа СВЕРХУ
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2;
                count1--;
                queue.offer(new int[]{row - 1, col});
            }
            
            // проверка соседа СПРАВА
            if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                count1--;
                queue.offer(new int[]{row, col + 1});
            }
            
            // проверка соседа СЛЕВА
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                count1--;
                queue.offer(new int[]{row, col - 1});
            }
        }
        minutes++;
    }
    
    return count1 == 0 ? minutes : -1;
}