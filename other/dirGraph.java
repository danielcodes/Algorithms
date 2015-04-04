public class dirGraph
{
    public static void main(String[] args)
    {
      //an array for vertex values
      double[] vert = {3, 4, 5, 6};

      //a 2D array for prediction values
      double[][] pred = { {0, .2, .5, .8}, {0, 0, .7, 0}, {0, 0, 0, .9}, {0, 0, 0, 0} };

      int[] result = findIndices(vert, pred, 3);

      //to see that it has returned k values
      System.out.println("The result indices are: ");
      for(int i=0; i<result.length; i++){
          System.out.print(result[i] + " ");
      }
      System.out.println();

    }

    public static int[] findIndices( double[] vertices, double[][] preValues, int k)
    {
        System.out.println("FUNCTION BEGIN ****************************************");
        //print out vertices
        System.out.println("The vertices are: ");
        for(int i=0; i<vertices.length; i++){
            System.out.print(vertices[i] + " ");
        }
        System.out.println('\n');

        //print prediction values
        System.out.println("The prediction values are: ");

        for(int i=0; i<preValues.length; i++){
            for(int j=0; j<preValues[0].length; j++){

                System.out.print(preValues[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();

        //aggregate values
        double[] agrValues = new double[vertices.length];
        System.out.println("The aggregate values are: ");

        for(int i=0; i<vertices.length; i++){

            agrValues[i] = vertices[i];

            for(int j=0; j<preValues[0].length; j++){
                if(preValues[i][j] != 0){
                    agrValues[i] += vertices[j] * preValues[i][j];
                }
            }
            System.out.print(agrValues[i] + " ");
        }
        System.out.println('\n');

        //Sort aggregate values, but return indices, not values
        //this array will hold the positions of the sorted aggregate values
        int[] indices = new int[vertices.length];
        for(int i=0; i<vertices.length; i++){
            indices[i] = i;
        }

        for(int i=1; i<vertices.length; i++){

            int index = i;
            int j = i-1;

            while( j>=0 && agrValues[j] < agrValues[index] ){
                indices[j+1] = indices[j];
                indices[j] = index;
                j = j-1;
            }
        }


        System.out.println("The sorted indices are: ");
        for(int i=0; i<vertices.length; i++){
            System.out.print(indices[i] + " ");
        }
        System.out.println('\n');

        //return array, with k sorted aggregate values
        int[] sortedAgr = new int[k];
        for(int i=0; i<k; i++){
            sortedAgr[i] = indices[i];
        }

        System.out.println("FUNCTION END ******************************************" + '\n');

        return sortedAgr;

    }



}
