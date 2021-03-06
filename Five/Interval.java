public class Interval
{
    //a counter
    public static int count = 0;

    private int start;
    private int finish;
    private int value;

    //Intervals must be filled when declared
    public Interval(int start, int finish, int value)
    {
        this.start = start;
        this.finish = finish;
        this.value = value;
        System.out.println("INTERVAL " + count + " | "+ this.start + " " + this.finish + " " + this.value);

        //increase count
        count++;
    }

    //only needs getters for the values of the intervals
    public int getStart()
    {
        return start;
    }

    public int getFinish()
    {
        return finish;
    }

    public int getValue()
    {
        return value;
    }

}
