public class twoSort
{
    public static void main(String[] args)
    {
        //method that combines merge and insertion sort
        //for better efficiency
        System.out.println("TESTING");

        int[] numbers = new int[10];

        numbers = {5,3,45,9,10,6,81,51,36,45};

    }

    public static void merSort(int[] array, int start, int end)
  	{

  		//check that the array is not empty
  		//enter if index is correct

  		//save some space for the optimization

  		if(start < end)
  		{
  			//create a midpoint
  			int mid = (start + end) / 2;

  			//two recursive calls
  			merSort(int[] array, start, mid);
  			merSort(int[] array, mid+1, end);

  			//merge the two sorted parts
  			merge(int[] array, start, mid, end);

  		}

  	}

    public static void merge(int[] array, int start, int mid, int end)
    {

      

    }

}
