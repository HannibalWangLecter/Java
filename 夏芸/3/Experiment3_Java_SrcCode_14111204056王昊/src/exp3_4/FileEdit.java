/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp3_4;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author ACER
 */
public class FileEdit {
    String filename;
    File f;
    JTextArea text;
    public void init(String s){
        filename = s;
        f = new File(filename);
    }
    public void setTextArea(JTextArea t){
        text = t;
    }
    public void readFile(){
        //to do
        try(FileInputStream fis = new FileInputStream(f)){
            int n = -1;
            byte[] a = new byte[256];
            String content="";
            while((n = fis.read(a,0,256))!=-1){
                String append = new String(a,0,n);
                content += append;
            }
            text.setText(content);
            fis.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "打开文件失败："+e,"错误",JOptionPane.OK_OPTION);
        }
    }
    public void writeFile(){
        try{
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            String s;
            s = text.getText();
            byte []a = s.getBytes();
            bos.write(a);
            bos.close();
            fos.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "保存文件失败："+e,"错误",JOptionPane.OK_OPTION);
        }
    }
}
