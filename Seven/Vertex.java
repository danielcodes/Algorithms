public class Vertex
{
    //difference between visited and expanded
    //expanded means that we're looking at the neighboring edges of the vertex
    private boolean expanded;
    private double value;
    private int parent; //initially wanted a vertex, but it'll be easier with an int

    //constructor
    public Vertex()
    {
        this.expanded = false;
        this.value = Double.POSITIVE_INFINITY;
        this.parent = -1;
    }

    //************ GETTERS *****************
    public boolean getExpanded()
    {
        return expanded;
    }

    public double getValue()
    {
        return value;
    }

    public int getParent()
    {
        return parent;
    }

    //************ SETTERS *****************
    public void setExpanded(boolean expanded)
    {
        this.expanded = expanded;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public void setParent(int parent)
    {
        this.parent = parent;
    }


    public String toString()
    {
        return "VERTEX, expanded:" + expanded + " value:" + value + " parent:" + parent;
    }
}
