import java.util.Random;
import java.util.Scanner;

public class Merge {
    public static void load(int array[]){
        Random rand = new Random(); //fill array with 100 random numbers
        for(int i = 0; i<array.length;i++)
            array[i]= rand.nextInt();
    }

    public static void show(int arr[]) {
        System.out.println("Numbers in array are: ");
        for(int i = 0;i<arr.length;i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }

    public static void merge(int data[],int low, int mid, int high){
        int first = mid;
        int second = mid +1;
        int l = low;
        while((l<=first)&&(second<=high)){
            if (data[low] < data[second])
                low++;
            else{
                int temp = data[second];
                for(int j = second-1;j>=low;j--)
                    data[j+1]= data[j];
                data[low]= temp;
                low++;
                first++;
                second++;
            }

            }

    }

    public static void mergeSort(int data[],int low, int high){
        if(low>=high)
            return;  // base case
        int mid = (low+high)/2;
        mergeSort(data,low,mid);
        mergeSort(data,mid+1,high);
        merge(data,low,mid,high);
    }
    public static void main(String[]args){
        int [] data = new int[100];
        load(data); //load array with 100 random numbers
        show(data); //display array before sort
        mergeSort(data,0,99); //merge and sort array
        show(data); //display sorted array
    }

}
