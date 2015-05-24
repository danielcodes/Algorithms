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

        printInfo();

        int nextVertex = getNextVertex();

        while(nextVertex != -1)
        {
            colorVertex(nextVertex);
            nextVertex = getNextVertex();
        }

        printInfo();

    }

    //need to find next vertex to color
    public int getNextVertex()
    {
        //will return a negative value, if no next value is found
        int next = -1, counter = 0;
        boolean found = false;

        //the next index has not been found yet, once it has, break out of the loop
        while(!found)
        {
            //counter goes up to 5, and crashh
            if(vertices[counter].gethasColor() == false)
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

        return next;
    }

    //method to color a vertex
    public void colorVertex(int index)
    {
        //idea is to check neighboring vertices first
        //set to first color, check for adjacent vertices, if there is a clash, add up
        vertices[index].sethasColor(true);

        int current = 0;
        vertices[index].setColor(current); //set to 0 first, can change

        for(int i=0; i<vertices.length; i++)
        {
            //check if there is an edges first
            if(adjMatrix[index][i] == 1)
            {
                //compare color
                if(vertices[index].getColor() == vertices[i].getColor())
                {
                    //bump up the color
                    vertices[index].setColor(++current);
                }
            }
        }

    }

    //a method to retrieve info
    public void printInfo()
    {
        for(int i=0; i<vertices.length; i++)
        {
            System.out.println("#" + i + " " + vertices[i].toString());
        }
        System.out.println();
    }

}
