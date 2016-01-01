/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp3_3;

import java.io.*;

/**
 *
 * @author ACER
 */
public class SafeCopy {

    public static void copyFile(DataInputStream in,
            DataOutputStream out) throws IOException {
        try {
            while (true) {
                out.writeByte(in.readByte());
            }
        } catch (EOFException eof) {
            return;
        }
    }

    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Usage:java SafeCopy sourceFile TargetFile");
        } else {
            String inFileName = args[0], outFileName = args[1];
            File inFile = new File(inFileName);
            File outFile = new File(outFileName);
            if (!inFile.exists()) {
                System.out.println(inFileName + " does not exist.");
            } else if (outFile.exists()) {
                System.out.println(outFileName + " already exist.");
            } else {
                try {
                    DataInputStream in = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(inFileName)));
                    DataOutputStream out = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(outFileName)));
                    copyFile(in, out);
                    in.close();
                    out.close();
                } catch (IOException ioe) {
                    System.out.println("Unknown error:" + ioe);
                }
            }
        }
    }
}
