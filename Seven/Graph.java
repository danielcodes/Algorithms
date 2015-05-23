//initially I'd planned to create an array of vertices
//but putting them into a graph is more compact

public class Graph
{
    private Vertex[] vertices;
    private double[][] adjMatrix; //basically contains edges

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
        int nextVertex = getNextVertex();

        //iterative case
        while(nextVertex != -1) //this means, there are still vertices to be expanded
        {
            expandVertex(nextVertex);
            nextVertex = getNextVertex();
        }

        printInfo();

        //reset works
        resetVertices();
        printInfo();

    }

    //to finding the next vertex to expand
    private int getNextVertex()
    {
        //will return a negative value, if not next value is found
        int next = -1, counter = 0;
        boolean found = false;

        //the next index has not been found yet, once it has, break out of the loop
        while(!found)
        {
            //counter goes up to 5, and crashh
            if(vertices[counter].getExpanded() == false && counter < vertices.length)
            {
                next = counter;
                found = true;
            }
            else
            {
                counter++;
                //it has reached the end of the vertices array
                if(counter == vertices.length)
                {
                    found = true;
                }
            }
        }

        //can get ugly if it hits v[-1], need if else
        //at this point, next is still negative
        if(next < 0)
        {
            return next;
        }
        else
        {
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
        }

        return next;
    }

    //function to expand a vertex
    private void expandVertex(int index)
    {
        //set expanded, value does not change neither does parent
        vertices[index].setExpanded(true);

        //loop to travel the edges
        for(int i=0; i<vertices.length; i++)
        {
            //skip if there isn't an edge, or if the chosen vertex is the parent
            if( adjMatrix[index][i] == 0 || vertices[index].getParent() == i )
            {}
            else
            {
                //another check to see if there is a shorter path to other vertices
                if( vertices[index].getValue() + adjMatrix[index][i] < vertices[i].getValue() )
                {
                    vertices[i].setValue( vertices[index].getValue() + adjMatrix[index][i] );
                    vertices[i].setParent(index);
                }
            }
        }
    }

    //after filling the vertices's 3 variables, backtrack to find solution
    //just going to print the path
    public void printPath(int index)
    {
        System.out.print(index + " ");

        //print if the it doesn't get to the root (-1)
        int arrow = index; //follows the path
        while(vertices[arrow].getParent() != -1)
        {
            System.out.print(vertices[arrow].getParent() + " ");
            arrow = vertices[arrow].getParent();
        }
    }

    //to find shortest path for all pairs, the graph vertices have to be 'reseted'
    private void resetVertices()
    {
        for(int i=0; i<vertices.length; i++)
        {
            vertices[i].resetVertex();
        }
    }

    //need for a table that will print the status of the graph
    //keeping track of: expanded, value and parent
    public void printInfo()
    {
        for(int i=0; i<vertices.length; i++)
        {
            System.out.print("#" + i + " " + vertices[i].toString() + " PATH: ");
            printPath(i);
            System.out.println();
        }
    }

}
