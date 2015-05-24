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

        int nextVertex = getNextVertex();

        while(nextVertex != -1)
        {
            colorVertex(nextVertex);
            nextVertex = getNextVertex();
        }

        System.out.println("CHOSEN VERTEX: " + start);
        printInfo();

    }

    //method to color from all vertices
    public void colorAll()
    {
        System.out.println("************************ START *******************************");
        System.out.println("GRAPH COLORING USING A GREEDY ALGORITHM\n");
        for(int i=0; i<vertices.length; i++)
        {
            colorGraph(i);
            resetVertices();
        }
        System.out.println("************************ FINISH *******************************");
    }

    //need to find next vertex to color
    private int getNextVertex()
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
    //fill the colors array with 1s to indicate it has been used
    //run through the array to find a 0, that is your new color
    private void colorVertex(int index)
    {
        //idea is to check neighboring vertices first
        //set to first color, check for adjacent vertices, if there is a clash, add up
        vertices[index].sethasColor(true);

        //had to bump up the array size by one
        int[] colors = new int[vertices.length];

        for(int i=0; i<vertices.length; i++)
        {
            //check if there is an edges first
            if(adjMatrix[index][i] == 1)
            {
                //bump up the used colors
                colors[ vertices[i].getColor() ] = 1;
            }
        }

        //find the first 0
        boolean found = false;
        int counter = 0;

        while(!found)
        {
            if(colors[counter] == 0)
            {
                //set the index to said color
                vertices[index].setColor(counter);
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

    }

    //reset to reuse
    private void resetVertices()
    {
        for(int i=0; i<vertices.length; i++)
        {
            vertices[i].resetVertex();
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
