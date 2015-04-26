public class quickSort
{
    public static void main(String[] args)
    {
        System.out.println("hello noob");

        int[] array = {4,5,3,2,1};

        quickSort(array, 0, 4);

        for(int i=0; i<array.length; i++)
        {
            System.out.println(array[i] + " ");
        }

    }

    //parameters, the array,, beginning and # of ele - 1
    //end is array.length - 1
    public static void quickSort(int start, int end, int[] array)
    {
        int pivot = partition(start, end, array);
        quickSort(start, pivot - 1, array);
        quickSort(pivot + 1, end, array);
    }

    //partition
    public static int partition(int start, int end, int[] array)
    {
        //i and j, start at the beginning
        //loop ends when j reaches the end-1, and the pivot is then
        //swapped with i's last position
        int i = 0, j = 0;
        int temp;
        int pivot = array[end];

        



    }
}
