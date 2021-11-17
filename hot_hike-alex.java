package kattis_hothike;
import java.util.*;
public class Kattis_Hothike {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int index = 0;
        int minMaxPair = Math.max(arr[0], arr[2]);
        
        for (int i = 1; i < n-2; i++) {
            if(minMaxPair>Math.max(arr[i],arr[i+2])){
                minMaxPair = Math.max(arr[i],arr[i+2]);
                index = i;
            }
            
        }
        
        System.out.println((index+1)+" "+minMaxPair);

    }    
}
