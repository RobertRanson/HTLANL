import java.util.*;


public class ArrayExample {

    static int arraySize = 4;

    static int[] sumArray = new int[arraySize];
    static int[][] numberArray = new int[arraySize][arraySize];

    public static void addFirstElement() {
        Random rand = new Random();
        int max = 10;
        int min = 1;
        // int mynumber = rand.nextInt((max - min) + 1) + min;

        for(int i = 0; i< numberArray.length;i++){
            numberArray[i][0]= rand.nextInt((max - min) + 1) + min;
        }
    }

    public static void multiply(int num) {
        
        for(int i = 0; i < numberArray.length;i++){
            int element = numberArray[i][0];
            for (int j = 1; j<numberArray[0].length;j++){
                numberArray[i][j]=element*num;
                element = numberArray[i][j];
            }
        }        
    }

    public static void addition(int num) {
        for(int i = 0; i < numberArray.length;i++){
            int element = numberArray[i][0];
            for (int j = 1; j<numberArray[0].length;j++){
                numberArray[i][j]=element+num;
                element = numberArray[i][j];
            }
        }        
    }

    public static void sumUpArray() {
        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 0; j < numberArray.length; j++) {
                sumArray[i]+=numberArray[i][j];
            }
        }
    }

    public static void printArray() {
        for(int i = 0; i < numberArray.length;i++){
            System.out.println(Arrays.toString(numberArray[i]) + " = "+sumArray[i]);
        }
       
    }
    public static void main(String[] args) {
        
        addFirstElement();
        
        multiply(3);
        sumUpArray();
        printArray();

        System.out.println("");

        addition(2);
        sumUpArray();
        printArray();
    }    
}
