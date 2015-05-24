//Dijkstra's shortest path algorithm
//this will have to be done for all vertices since we want shortest path for all pairs

public class seven
{
    public static void main(String[] args)
    {

        //adjacency matrix, with weights, 0 for no edge
        double[][] matrix = { {0,2,2,3,4},
                              {2,0,5,2,4},
                              {2,5,0,3,1},
                              {3,2,3,0,0},
                              {4,4,1,0,0}
                            };

        //first param is # of vertices
        Graph g = new Graph(5, matrix);

        g.getAllPairs();

    }
}
