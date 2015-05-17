//Weighted Interval Scheduling

public class five
{
    public static void main(String[] args)
    {
        System.out.println("*****************************************");
        System.out.println("DECLARING INTERVALS: ");

        Interval[] example = new Interval[4];
        example[0] = new Interval(1, 3, 4);
        example[1] = new Interval(2, 5, 8);
        example[2] = new Interval(6, 7, 10);
        example[3] = new Interval(8, 15, 10);

        System.out.println("*****************************************");


        sort(example);
        print(example);

        for(int i=0; i<example.length; i++)
        {
            System.out.print(p(example, i) + " ");
        }

        //now always sort the intervals, before running the p function


    }

    //assums intervals have been sorted
    public static void print(Interval[] intervals)
    {
        System.out.println("*****************************************");
        System.out.println("PRINTING INTERVALS: ");
        //to visually see the intervals
        int space, dash;

        for(int i=0; i<intervals.length; i++)
        {
            space = intervals[i].getStart();
            dash = intervals[i].getFinish() - intervals[i].getStart() + 1;

            //spaces
            for(int j=0; j<space; j++)
              System.out.print(" ");

            //dashes
            for(int k=0; k<dash; k++)
              System.out.print("-");

            System.out.println();
        }

        System.out.println("*****************************************");
    }

    //need p function that gives the leftmost interval
    //enter the set of intervals, and the interval index
    //p will be tailored to work only on an array of sorted intervals
    public static int p(Interval[] intervals, int index)
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
            while(intervals[before].getFinish() > intervals[index].getStart())
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
    public static void sort(Interval[] intervals)
    {
        //use insertion sort
        for(int i=1; i<intervals.length; i++)
        {
            Interval key = intervals[i];
            int j = i-1;

            while( j>=0 && intervals[j].getFinish() > key.getFinish() ){
                intervals[j+1] = intervals[j];
                intervals[j] = key;
                j = j-1;
            }
        }
    }

}
