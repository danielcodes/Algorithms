public class twoSort
{
    public static void main(String[] args)
    {
        //method that combines merge and insertion sort
        //for better efficiency
        System.out.println("TESTING");

        int[] numbers = {5,3,45,9,10,6,81,51,36,45};

        merSort(numbers, 0, 10);

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
  			merSort(array, start, mid);
  			merSort(array, mid+1, end);

  			//merge the two sorted parts
  			merge(array, start, mid, end);

  		}

  	}

    public static void merge(int[] array, int start, int mid, int end)
    {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        //new arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //get first half
        for(int i=0; i<n1; i++)
        {
            L[i] = array[start+i];
        }

        //second half
        for(int j=0; j<n2; j++)
        {
            R[j] = array[mid+j+1];
        }


        int i = 0;
        int j = 0;

        for(int k = start; k<end; k++)
        {
            if(L[i] <= R[j])
            {
                array[k] = L[i];
                i++;
            }
            else
            {
                array[k] = R[j];
                j++;
            }

        }

    }

}
