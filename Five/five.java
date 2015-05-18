//Weighted Interval Scheduling

public class five
{
    public static void main(String[] args)
    {
        System.out.println("*****************************************");
        System.out.println("DECLARING INTERVALS: ");
        System.out.println("INTERVAL # | " +  "start | finish | value");
        //interval estimates created from the slides, to facilitate simulation of values
        Interval[] example = new Interval[6];
        //gotta initiate the first one to nothing otherwise null pointer exception
        example[0] = new Interval(0, 0, 0);
        example[1] = new Interval(1, 4, 10);
        example[2] = new Interval(3, 10, 20);
        example[3] = new Interval(6, 11, 5);
        example[4] = new Interval(8, 15, 20);
        example[5] = new Interval(12, 20, 15);

        System.out.println("*****************************************");

        print(example);

        // for(int i=1; i<example.length; i++)
        // {
        //     System.out.print(p(example, i) + " ");
        // }

        //no create array with the optimal solutions
        int[] opt = new int[6];
        opt[0] = 0;

        for(int j=1; j<opt.length; j++)
        {
            //compare value[j] + opt[p(j)] and opt[j-1]
            opt[j] = Math.max(example[j].getValue() + opt[p(example, j)] , opt[j-1]);
        }

        System.out.print("Optimal solution array: ");
        for(int k=1; k<example.length; k++)
        {
            System.out.print(opt[k] + " ");
        }
        System.out.println();

        //backtrack to find solution
        System.out.print("Backtracking from optimal solution array to find the intervals: ");
        getSolution(example, 5, opt);

    }

    //assums intervals have been sorted
    public static void print(Interval[] intervals)
    {
        System.out.println("*****************************************");
        System.out.println("PRINTING INTERVALS: ");
        //to visually see the intervals
        int space, dash;

        for(int i=1; i<intervals.length; i++)
        {
            space = intervals[i].getStart();
            dash = intervals[i].getFinish() - intervals[i].getStart() + 1;

            //spaces
            for(int j=0; j<space; j++)
              System.out.print(" ");

            //dashes
            for(int k=0; k<dash; k++)
              System.out.print("-");

            System.out.println(" #" + i + " value: " + intervals[i].getValue());
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
                //System.out.println("BEFORE FINISH: " + intervals[before].getFinish() + " INDEX START: " + intervals[index].getStart());
                before--;
                //ugly solution, but at current time could not think of a better way
                //break away, as soon as the counter turns negative to avoid outofbounds error
                if(before < 0)
                {
                  before = 0;
                  break;
                }
            }
            result = before;
        }

        return result;
    }

    //backtrack for solution function
    public static void getSolution(Interval[] intervals, int index, int[] opt)
    {
        //base case
        if(index > 0)
        {
            if( (intervals[index].getValue() + opt[p(intervals,index)]) >= opt[index-1] )
            {
                System.out.print(index + " ");
                getSolution(intervals, p(intervals,index), opt);
            }
            else
            {
                getSolution(intervals, index-1, opt);
            }
        }
    }

}
