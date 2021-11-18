import java.util.Scanner;
public class Kattis_Easiest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        while(in!=0){
            int num = in;
            int sum1 = 0;
            while(num>9){
                sum1+=num%10;
                num/=10;
            }
            sum1+=num;
            
            for (int i = 11; i <= 100; i++) {
                int mN = in * i;
                int sum2 = 0;
                while(mN>9){
                    sum2+=mN%10;
                    mN/=10;
                }
                sum2+=mN;
                if(sum1==sum2){
                    System.out.println(i);
                    break;
                }
            }
            
            
            in = input.nextInt();
            
        }


    }    
}
