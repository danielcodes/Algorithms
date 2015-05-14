//Weighted Interval Scheduling

public class five
{
    public static void main(String[] args)
    {
        Interval[] example = new Interval[3];
        example[0] = new Interval(1, 3, 4);
        example[1] = new Interval(2, 5, 8);
        example[2] = new Interval(6, 7, 10);


        System.out.println(p(example,0));
        System.out.println(p(example,1));
        System.out.println(p(example,2));


    }



    //need p function that gives the leftmost interval
    //enter the set of intervals, and the interval index
    public static int p(Interval[] Intervals, int index)
    {

        //find values of the index's interval whose finish value
        //is less than the index's start value

        //set first element as the result and swap as you move through the array
        int result = 0;

        //condition is finish < index.start
        for(int i=1; i<Intervals.length; i++)
        {
            if((Intervals[i].getFinish() > Intervals[result].getFinish()) && (Intervals[index].getStart() > Intervals[i].getFinish()) )
            {
                result = i;
            }
        }

        return result;
    }
}
