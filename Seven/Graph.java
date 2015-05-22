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

    //*************** DIJKSTRA'S SHORTEST PATH **********************
    //the implementation will be broken down into two parts
    //first run an algorithm to visit, expand vertices and assign values and parents
    //second part is to backtrack the parents, to find the shortest path

    public void runDijkstra(int start)
    {
        //vertex variable to work with: expanded, value and parent
        vertices[start].setExpanded(true);
        vertices[start].setValue(0);

        //travel first set of edges, set values and parents at those edges
        for(int i=0; i<adjMatrix[start].length; i++)
        {
            //set values if there is an edge (not 0 on matrix)
            if(adjMatrix[start][i] > 0)
            {
                //set value and parent at vertex i
                vertices[i].setValue( adjMatrix[start][i] );
                vertices[i].setParent(start);
                //System.out.println(i + " " + vertices[i].getValue() + " " + vertices[i].getParent());
            }
        }

        //need to create a function to see which vertex to expand next







    }

    //to finding the next vertex to expand
    public int getNextVertex()
    {
        int next;

        //need to first set the first instance of next
        //loop that runs through the vertices's expandable variable
        for(int i=0; i<vertices.length; i++)
        {
            if(vertices[i].getExpanded() == false)
            {
                //first instace of a 0
                next = i;
            }
            //exit loop
            break;
        }

        //run the same loop but now find the lowest non-expanded vertex
        for(int i=0; i<vertices.length; i++)
        {
            //check if it has been expanded
            if(vertices[i].getExpanded() == false)
            {
                //check whether next needs to be updated
                if(vertices[i].getValue() < vertices[next].getValue())
                {
                    next = i;
                }
            }
        }

        return next;

    }

















    //insertion sortt, might need it for later
    public void swapSort(int[] array)
    {
        //sort it, using insertion sort
        for(int i=1; i<array.length; i++)
        {

            int key = array[i];
            int j = i-1;

            while( j>=0 && array[j] > key )
            {
                array[j+1] = array[j];
                array[j] = key;
                j = j-1;
            }

        }
    }





}
