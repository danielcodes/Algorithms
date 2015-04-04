public class insertionSort
{
  public static void main(String[] args)
  {

      swapSort(10);
  }

  //function that creates a random array (1-100) with given size
  //then sorts it
  public static void swapSort( int size ) {

      int[] array = new int[size];
      System.out.println("SIZE OF THE ARRAY: " + size);

      //populate and print random array
      for(int i=0; i<array.length; i++){
        array[i] += Math.random() * 100;
        System.out.print(array[i] + " ");
      }
      System.out.print('\n');


      //counter, for # of steps
      int steps = 0;

      //sort it, using insertion sort
      for(int i=1; i<array.length; i++){

          int key = array[i];
          int j = i-1;
          steps = steps + 2;

          while( j>=0 && array[j] > key ){
              array[j+1] = array[j];
              array[j] = key;
              j = j-1;
              steps = steps + 3;
          }

      }

      System.out.println("THE NUMBER OF STEP IS: " + steps);

      //print sorted array
      for(int i=0; i<array.length; i++){
        System.out.print(array[i] + " ");
      }
      System.out.println();
  }

}
