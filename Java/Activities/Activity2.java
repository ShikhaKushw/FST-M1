package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] arr = {10, 77, 10, 54, -11, 10};
        int numsearch=10;
        int sumsearch=30;
        System.out.println("Result= " + result(arr,numsearch, sumsearch ));

    }
    public static boolean result (int[] number, int x, int y){
        int sum=0;
        for (int numbers : number){
            if(numbers==10) {
                sum = sum+numbers;
            }
            if (sum>y) {
                break;
            }
        }
        return sum == y;
    }

}
