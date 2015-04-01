import java.util.Scanner;

public class twoSort
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a size: ");
        int size = in.nextInt();

        System.out.println("Please enter # of times to run comparison: ");
        int times = in.nextInt();

        for(int i=0; i<times; i++)
        {
            sortCompare(size);
        }

    }

    public static void sortCompare( int size )
    {
        //since arrays are passed by reference
        //we need two equivalent, to be sorted by merge and insertion
        //then compare

        int[] meSorted = new int[size];
        int[] inSorted = new int[size];
        int[] optSorted = new int[size];

        for(int i=0; i<size; i++)
        {
            //fill up arrays with random numbers
            //the plus is to fix some type problem doublet to int and blah blah
            meSorted[i] += Math.random() * 100;
            inSorted[i] += Math.random() * 100;
            optSorted[i] += Math.random() * 100;
        }

        //now sort and find running time of each sort

        long startTime = System.nanoTime();
        inSort(inSorted);
        long endTime = System.nanoTime() - startTime;
        System.out.println("The running time of INSERTION is: " + endTime);

        long startTime_1 = System.nanoTime();
        merSort(meSorted, 0, meSorted.length-1 );
        long endTime_1 = System.nanoTime() - startTime_1;
        System.out.println("The running time of MERGESORT is: " + endTime_1);

        long startTime_2 = System.nanoTime();
        optSort(optSorted, 0, optSorted.length-1);
        long endTime_2 = System.nanoTime() - startTime_2;
        System.out.println("The running time of OPTIMIZED is: " + endTime_2 + '\n');

    }

    //OPTIMIZED SORT ********************************************************
    public static void optSort(int[] array, int start, int end)
    {
        //from experiment, the threshold size was 60
        //where insertion sort is for the most part faster than merge
        if(array.length < 60)
        {
            inSort(array);
        }
        else if(start < end) //do merge
      	{
      		//create a midpoint
      		int mid = (start + end) / 2;

      		//two recursive calls
      		merSort(array, start, mid);
      		merSort(array, mid+1, end);

      		//merge the two sorted parts
      		merge(array, start, mid, end);
      	}
        else{}

    }

    //MERGESORT METHOD *******************************************************
    public static void merSort(int[] array, int start, int end)
  	{

      	//save some space for the optimization

      	if(start < end)
      	{
      		//create a midpoint
      		int mid = (start + end) / 2;

      		//two recursive calls
      		merSort(array, start, mid);
      		merSort(array, mid+1, end);

      		//merge the two sorted parts
      		merge(array, start, mid, end);
      	}

  	}

    //MERGE METHOD *********************************************************
    public static void merge(int[] array, int start, int mid, int end)
    {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        //new arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        //get first half
        for(int i=0; i<n1; i++)
        {
            left[i] = array[start+i];
        }

        //second half
        for(int j=0; j<n2; j++)
        {
            right[j] = array[mid+j+1];
        }

        int i = 0;
        int j = 0;

        for(int k = start; k <= end; k++)
        {
      	    //check whether the arrays have already been used
      	    //left is fully used
      	    if(i == n1)
      	    {
      	    	  array[k] = right[j];
                j++;
      	    }
      	    else if(j == n2) //right side is all used
      	    {
      	 	      array[k] = left[i];
                i++;
       	    }
            else if(left[i] <= right[j])
            {
                array[k] = left[i];
                i++;
            }
            else
            {
                array[k] = right[j];
                j++;
            }
        }
    }

    //INSERTION SORT METHOD *********************************************
    public static void inSort( int[] array ) {

        //sort it, using insertion sort
        for(int i=1; i<array.length; i++){

            int key = array[i];
            int j = i-1;

            while( j>=0 && array[j] > key ){
                array[j+1] = array[j];
                array[j] = key;
                j = j-1;
            }
        }

    }


}
