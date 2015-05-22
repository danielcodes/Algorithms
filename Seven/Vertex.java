public class Vertex
{
    //difference between visited and expanded
    //expanded means that we're looking at the neighboring edges of the vertex
    private boolean expanded;
    private int value;
    private int parent; //initially wanted a vertex, but it'll be easier with an int

    //constructor
    public Vertex(boolean expanded, int value, int parent)
    {
        this.expanded = expanded;
        this.value = value;
        this.parent = parent;
    }

    public boolean getExpanded()
    {
        return expanded;
    }

    public int getValue()
    {
        return value;
    }

    public int getParent()
    {
        return parent;
    }

    public String toString()
    {
        return "VERTEX, expanded:" + expanded + " value:" + value + " parent:" + parent;
    }
}
