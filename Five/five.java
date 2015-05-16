//Weighted Interval Scheduling

public class five
{
    public static void main(String[] args)
    {
        Interval[] example = new Interval[3];
        example[2] = new Interval(1, 3, 4);
        example[1] = new Interval(2, 5, 8);
        example[0] = new Interval(6, 7, 10);

        sort(example);
        for(int i=0; i<example.length; i++)
        {
            System.out.print(example[i].getValue() + " ");
        }


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

    //write a sort function, makes it easier on p function
    public static void sort(Interval[] Intervals)
    {
        //use insertion sort
        for(int i=1; i<Intervals.length; i++)
        {
            Interval key = Intervals[i];
            int j = i-1;

            while( j>=0 && Intervals[j].getFinish() > key.getFinish() ){
                Intervals[j+1] = Intervals[j];
                Intervals[j] = key;
                j = j-1;
            }
        }
    }

}
