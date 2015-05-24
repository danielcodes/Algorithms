public class Vertex
{
    private boolean hasColor;
    private int color;

    public Vertex()
    {
        this.hasColor = false;
        this.color = 0;
    }

    //************ GETTERS *****************
    public boolean gethasColor()
    {
        return hasColor;
    }

    public int color()
    {
        return color;
    }

    //************ SETTERS *****************
    public void sethasColor(boolean hasColor)
    {
        this.hasColor = hasColor;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public String toString()
    {
        return "Vertex, hasColor: " + hasColor + " | color:" + color;
    }

}
