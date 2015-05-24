public class Graph
{
    private Vertex[] vertices;
    private int[][] adjMatrix; //int now since it is an unweighted graph

    public Graph(int number, int[][] adjMatrix)
    {
        this.vertices = new Vertex[number];

        for(int i=0; i<number; i++)
        {
            vertices[i] = new Vertex();
        }

        this.adjMatrix = adjMatrix;
    }

    //*************** GREEDY GRAPH COLORING **********************
    //mainly one function
    //to find an uncolored vertex, and color it based on checks

    public void colorGraph(int start)
    {
        //chosen vertex set to 0
        vertices[start].sethasColor(true);
        vertices[start].setColor(0);

        

    }
}
