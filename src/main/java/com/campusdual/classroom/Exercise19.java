package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {

        int rows =intArrayTri[0].length;
        int columns = intArrayTri[0][0].length;

        int[][] flattedArray = new int [rows][columns];

      for(int[][] layer: intArrayTri){
          for(int i=0;i<rows;i++){
              for(int j=0; j<columns;j++){
                  flattedArray[i][j]+= layer[i][j];
              }
          }
      }
      return flattedArray;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder biArrayString = new StringBuilder();

        for(int[] row : intArrayBi){
            for(int j=0; j<row.length; j++){
                biArrayString.append(row[j]);
                if(j<row.length-1){
                    biArrayString.append(" ");
                }
            }
            biArrayString.append("\n");
        }
        return  biArrayString.toString().trim();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder arrayString = new StringBuilder();

        for(int value : uniArray){
            arrayString.append(value).append(" ");
        }
        return arrayString.toString().trim();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int [] array = new int [columns];

        for(int i=0; i<columns; i++){
            array[i]= i+1;
        }
        return array;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int [][] arrayBi = new int [rows] [columns];

        int value=1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arrayBi[i][j] = value++;
            }
        }
        return arrayBi;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int [][][] arrayTri = new int [depth][rows][columns];

        int value=1;
        for(int i=0; i<depth;i++){
            for(int j=0; j<rows; j++){
                for(int k=0; k<columns; k++){
                    arrayTri[i][j][k]=value++;
                }
            }
        }
        return arrayTri;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
