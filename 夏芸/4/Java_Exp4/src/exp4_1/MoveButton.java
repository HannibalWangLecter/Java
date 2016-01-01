package exp4_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveButton extends JFrame implements Runnable, ActionListener {

    Thread first, second, third;//用Thread类声明first,second两个线程对象
    JButton redButton, greenButton, blueButton, startButton;
    int distance = 10;

    MoveButton() {
        first = new Thread(this); //创建first线程，当前窗口做为该线程的目标对象
        second = new Thread(this); //创建second线程，当前窗口做为该线程的目标对象
        third = new Thread(this);
        redButton = new JButton();
        greenButton = new JButton();
        blueButton = new JButton();
        redButton.setBackground(Color.red);
        greenButton.setBackground(Color.green);
        blueButton.setBackground(Color.blue);//blue
        startButton = new JButton("start");
        startButton.addActionListener(this);
        setLayout(null);
        add(redButton);
        redButton.setBounds(10, 60, 15, 15);
        add(greenButton);
        greenButton.setBounds(100, 60, 15, 15);
        add(blueButton);
        blueButton.setBounds(200, 60, 15, 15);//blue
        add(startButton);
        startButton.setBounds(10, 100, 100, 30);
        setBounds(0, 0, 300, 200);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
    }

    public void actionPerformed(ActionEvent e) {
        try {
            first.start();
            second.start();
            third.start();
        } catch (Exception exp) {
        }
    }

    public void run() {
        while (true) {
            if (Thread.currentThread() == first) //判断当前占有CPU资源的线程是否是first
            {
                moveComponent(redButton);
                try {
                    Thread.sleep(20);
                } catch (Exception exp) {
                }
            }
            if (Thread.currentThread() == second) //判断当前占有CPU资源的线程是否是second
            {
                moveComponent(greenButton);
                try {
                    Thread.sleep(10);
                } catch (Exception exp) {
                }
            }
            if (Thread.currentThread() == third) //判断当前占有CPU资源的线程是否是third
            {
                moveComponent(blueButton);
                try {
                    Thread.sleep(5);
                } catch (Exception exp) {
                }
            }
        }
    }

    public synchronized void moveComponent(Component b) {
        if (Thread.currentThread() == first) {
            while (distance > 100 && distance <= 300) {
                try {
                    wait();
                } catch (Exception exp) {
                }
            }
            distance = distance + 1;
            b.setLocation(distance, 60);
            if (distance >= 100) {
                b.setLocation(10, 60);
                notifyAll();
            }
        }
        if (Thread.currentThread() == second) {
            while ((distance >= 10 && distance < 100) || (distance >= 200 && distance < 300)) {
                try {
                    wait();
                } catch (Exception exp) {
                }
            }
            distance = distance + 1;
            b.setLocation(distance, 60);
            if (distance >= 200) {
                b.setLocation(100, 60);
                notifyAll();
            }
        }
        if (Thread.currentThread() == third) {
            while (distance >= 10 && distance < 200) {
                try {
                    wait();
                } catch (Exception exp) {
                }
            }
            distance = distance + 1;
            b.setLocation(distance, 60);
            if (distance > 300) {
                distance = 10;
                b.setLocation(200, 60);
                notifyAll();
            }
        }
    }
}
