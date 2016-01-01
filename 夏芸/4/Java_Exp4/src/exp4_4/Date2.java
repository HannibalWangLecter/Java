package exp4_4;

import java.util.Scanner;

class DateException extends Exception {

    String message;

    public DateException(int y, int m, int d) {
        message = y + "." + m + "." + d + " is not a valid date";
    }

    @Override
    public String toString() {
        return message;
    }
}

public class Date2 {

    private int year, month, day;                  //私有的成员变量

    public Date2(int y, int m, int d) //指定参数的构造方法
    {
        try {
            set(y, m, d);
            System.out.println(year + "年" + month + "月" + day + "日，日期合法！");
        } catch (DateException e) {
            System.out.println(e);
        }
    }

    public void set(int y, int m, int d) throws DateException //公有的成员方法，设置日期值，请补充代码
    {
        boolean flag = false;
        if (d < 0) {
            flag = true;
        }
        if (m < 0 && m > 12) {
            flag = true;
        } else if (m == 2) {
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                if (d > 29) {
                    flag = true;
                }
            } else {
                if (d > 28) {
                    flag = true;
                }
            }
        } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            if (d > 31) {
                flag = true;
            }
        } else {
            if (d > 30) {
                flag = true;
            }
        }
        if (flag) {
            throw new DateException(y, m, d);
        } else {
            year = y;
            month = m;
            day = d;
        }
    }

    public static void main(String[] args) {
        int y, m, d;
        Scanner input = new Scanner(System.in);
        y = input.nextInt();
        m = input.nextInt();
        d = input.nextInt();
        Date2 test = new Date2(y, m, d);
        input.close();
    }

}
