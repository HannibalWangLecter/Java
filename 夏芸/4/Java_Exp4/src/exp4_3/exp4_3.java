/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp4_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ACP134
 */
public class exp4_3 {

    public static void main(String[] args) {
        File file = new File("prime.dat");
        Thread t1, t2, t3;
        Vector pl = new Vector();
        t1 = new Thread(new FindPrime(2, 10000, pl));
        t2 = new Thread(new FindPrime(10001, 20000, pl));
        t3 = new Thread(new FindPrime(20001, 30000, pl));
        try {
            t1.start();
            t2.start();
            t3.start();
        } catch (Exception e) {
            System.out.println("Can't start threads");
            return;
        }
        try {
            Writer writer = new FileWriter(file);
           while (true) {
                if (!t1.isAlive() && !t2.isAlive() && !t3.isAlive()) {
                    break;
                }
            }
            Collections.sort(pl, new SortNumber());
            for(int i = 0;i<pl.size();i++){
                writer.write((pl.get(i)).toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }

    }
}

class SortNumber implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int a = (int) o1;
        int b = (int) o2;
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

}
