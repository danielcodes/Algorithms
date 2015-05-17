//Weighted Interval Scheduling

public class five
{
    public static void main(String[] args)
    {
        Interval[] example = new Interval[5];
        example[1] = new Interval(1, 3, 4);
        example[2] = new Interval(2, 5, 8);
        example[0] = new Interval(6, 7, 10);
        example[3] = new Interval(8, 15, 10);
        example[4] = new Interval(7, 8, 10);

        sort(example);
        for(int i=0; i<example.length; i++)
        {
            System.out.print(p(example, i) + " ");
        }

        //now always sort the intervals, before running the p function


    }



    //need p function that gives the leftmost interval
    //enter the set of intervals, and the interval index
    //p will be tailored to work only on an array of sorted intervals
    public static int p(Interval[] Intervals, int index)
    {
        int result;

        if(index == 0)
        {
            return 0;
        }
        else
        {
            int before = index-1;
            //error here A[-1]
            while(Intervals[before].getFinish() > Intervals[index].getStart())
            {
                before--;
                //ugly solution, but at current time could not think of a better way
                //break away, as soon as the counter turns negative to avoid outofbounds error
                if(before < 0)
                  before = 0;
                  break;
            }
            result = before;
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
