//Graph coloring (greedy algorithm)

public class six
{
    public static void main(String[] args)
    {
        //adjacency matrix, 1s and 0s to represent an edge
        int[][] matrix = {
                          {0,1,1,1},
                          {1,0,1,0},
                          {1,1,0,1},
                          {1,0,1,0}
                         };

        Graph g = new Graph(4, matrix);

        g.colorGraph(0);


    }
}
