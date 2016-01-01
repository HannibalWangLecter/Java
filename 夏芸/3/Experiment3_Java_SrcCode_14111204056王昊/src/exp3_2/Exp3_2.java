/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp3_2;

import java.io.*;

/**
 *
 * @author ACER
 */
public class Exp3_2 {

    public static void main(String[] args) {
        RandomAccessFile in_and_out = null;
        byte content[];
        StringBuffer buffer = new StringBuffer();
        try {
            content = "ABC你我他".getBytes();
            in_and_out = new RandomAccessFile("B.dat", "rw");
            in_and_out.write(content);
            in_and_out.seek(0);
            long m = in_and_out.length();
            System.out.println("文件长度:" + m + "字节");
            while (m >= 0) {
                m = m - 1;
                in_and_out.seek(m);
                byte a = in_and_out.readByte();
                if (a >= 0 && a <= 255) {
                    buffer.append(((char) a));
                    System.out.println("字符：" + ((char) a));
                } else {
                    m = m - 2;
                    in_and_out.seek(m);
                    byte[] c = new byte[3];
                    in_and_out.readFully(c);
                    buffer.append(new String(c));
                    System.out.println("字符：" + c[0] + "," + c[1] + "，" + c[2]);
                }
            }
            in_and_out.close();
            System.out.println(buffer);
        } catch (IOException e) {
            System.out.println(buffer);
        }
    }
}
