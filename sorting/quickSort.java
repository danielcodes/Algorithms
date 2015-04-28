public class quickSort
{
    public static void main(String[] args)
    {
        int[] array = {41,56,33,22,17};

        quickSort(0, array.length - 1, array);

        for(int i=0; i<array.length; i++)
        {
            System.out.println(array[i] + " ");
        }

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

    public static void swap(int[] array, int i, int j)
	  {
    		int temp = array[i];
    		array[i] = array[j];
    		array[j] = temp;
	  }


    //partition
    public static int partition(int start, int end, int[] array)
    {
        //two counter i and j
        int pivot = array[end];
        int i = start - 1;

        for(int j=start; j<end; j++)
        {
            if(array[j] <= pivot)
            {
                i++;
                swap(array,i,j);
            }
        }

        swap(array, i+1, end);
        return i+1;
    }
}
