//initially I'd planned to create an array of vertices
//but putting them into a graph is more compact

public class Graph
{
    private Vertex[] vertices;
    private double[][] adjMatrix;

    //the graph will start with a set of vertices and an adjacency matrix
    public Graph(int number, double[][] adjMatrix)
    {
        //creates a graph with 'number' vertices
        this.vertices = new Vertex[number];

        //vertices must also be initialized
        for(int i=0; i<number; i++)
        {
            vertices[i] = new Vertex();
            //System.out.println(vertices[i].toString());
        }

        //set matrix
        this.adjMatrix = adjMatrix;
    }



}
