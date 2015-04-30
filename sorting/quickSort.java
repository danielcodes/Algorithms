public class quickSort
{
    public static void main(String[] args)
    {
        int[] array = {41,56,33,22,17};
        int[] array1 = {41,56,33,22,17};


        long startTime = System.nanoTime();
        quickSort(0, array.length - 1, array);
        long endTime = System.nanoTime() - startTime;
        System.out.println("The running time of INSERTION is: " + endTime);

        long startTime1 = System.nanoTime();
        radsort(array1);
        long endTime1 = System.nanoTime() - startTime1;
        System.out.println("The running time of INSERTION is: " + endTime1);

    }

    //parameters, the array,, beginning and # of ele - 1
    //end is array.length - 1
    public static void quickSort(int start, int end, int[] array)
    {
        if(start < end)
        {
            int p = partition(start, end, array);
            quickSort(start, p - 1, array);
            quickSort(p + 1, end, array);
        }

    }

    //swap method
    public static void swap(int[] array, int i, int j)
	  {
    		int temp = array[i];
    		array[i] = array[j];
    		array[j] = temp;
	  }

    //partition
    public static int partition(int start, int end, int[] array)
    {
        //select the pivot (last ele), set i to the beginning - 1
        int pivot = array[end];
        int i = start - 1;

        //j is a counter, when it encounters a number smaller than the pivot
        //i moves forward and i and j swap places
        //this serves to place elements smaller than the pivot on the left side
        for(int j=start; j<end; j++)
        {
            if(array[j] <= pivot)
            {
                i++;
                swap(array,i,j);
            }
        }

        //by the end, i contains the last element smaller than the pivot
        //so we swap with i+1 and the pivot, now it is in the correct location
        swap(array, i+1, end);
        return i+1;
    }

    public static void radsort( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;

        //a count sort is performed for the most # of digits allowed
        //stored in b and then passed back to a
        int[] b = new int[10];

        //this first loop finds sets m to the largest number in the
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];

        //it iterates until the highest number is exhausted
        //154, get divided 3 times, by 1, 10 and 100 before finally hitting 0
        while (m / exp > 0)
        {
            //buckets are initiated at every stage as it moves through the digits
            int[] bucket = new int[10];

            //place the respective last digits in the buckets
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;

            //reorganize the buckets into increments that keep the count
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];

            //the a[i]/exp, finds which part of the numebr we want
            //get the last digit by using %10, which in turn finds the bucket
            //the bucket array is organized in a way, that finding the bucket value
            //minus 1, gives its sorted position in the b array
            //it works because, it will always hit only that bucket, and subtracted by one
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];

            //b somewhat contains the sorted values, passed into a
            for (i = 0; i < n; i++)
                a[i] = b[i];

            //increase by a 10th
            exp *= 10;
        }
    }
}
