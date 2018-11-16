package Ex2;

import java.util.Random;

public class BubbleSort {
    public static double[] arr = new double[1000];
    public static int size = 1000;

    public static void random(){
        Random random = new Random();
        for(int i = 0; i < size; i++){
            double num = random.nextDouble();
            arr[i] = num;
        }
    }

    public static void bubbleSort(double[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = arr[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        random();
        bubbleSort(arr);
        for (int i = 0 ; i < size; i++){
            System.out.println(i);
            System.out.println(arr[i]);
        }
    }
}
