import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Di4 {
    public static int[] dijkstra(List<List<int[]>> graph, int start)
    {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty())
        {
            int[] current = pq.poll();
            int v = current[0];
            int currentdist = current[1];

            if(currentdist != dist[v]) continue;
            for(int[] edge : graph.get(v))
            {
                int u = edge[0];
                int weight = edge[1];

                int newdist = dist[v] + weight;

                if(newdist < dist[u])
                {
                    dist[u] = newdist;
                    pq.add(new int[]{u,newdist});
                }
            }
        }
        return dist;
    }
    static int[] bellmanFord(int start, int n, Edge[] edges) {
    int[] dist = new int[n];
    Arrays.fill(dist, INF);

    dist[start] = 0;

    for (int i = 0; i < n - 1; i++) {
        boolean changed = false;

        for (Edge edge : edges) {
            if (dist[edge.from] != INF &&
                dist[edge.from] + edge.weight < dist[edge.to]) {

                dist[edge.to] =
                        dist[edge.from] + edge.weight;

                changed = true;
            }
        }

        if (!changed) {
            break;
        }
    }

    return dist;
}
}
