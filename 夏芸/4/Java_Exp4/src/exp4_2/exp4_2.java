package exp4_2;

import java.io.*;

public class exp4_2 {

    public static void main(String args[]) throws IOException {
        int[] ko = new int[15];
        int n, a;
        String x;
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an integer:");
        x = keyin.readLine();
        n = Integer.parseInt(x);
        try {
            a = 110 / n;
            ko[15] = 100;
            System.out.println("此描述无法执行！");
        } catch (ArithmeticException e) {
            System.out.println("除数为0的错误");
        } catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("数组索引值大于数组长度的错误!");
        }
        System.out.println("执行完catch的描述!!!");
    }
}
