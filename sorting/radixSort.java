public class radixSort
{
    public static void main(String[] args)
    {
        System.out.println("hello noob");

        int[] array = {41,52,31,27,18};

        radsort(array);

        for(int i=0; i<array.length; i++)
        {
            System.out.println(array[i] + " ");
        }


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
