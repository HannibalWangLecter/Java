//Compute.java
package exp2_1;
public class Compute
{
        int count;
        double[] num;
        double sum;
        double ave;
        Compute()
        {
                count = 0;
                num = null;
                ave = 0;
                sum = 0;
        }
        void setnum(String s)
        {
                String[] a = s.split("[^0123456789.]+");
                int n = a.length;
                num = new double[n]; //分配内存空间
                count = 0; //初始化
                for (int i = 0; i < n; i++)
                        try {
                                num[i] = Integer.valueOf(a[i]); //把字符数组的内容转换成数字
                                count++; //计数器+1
                        } catch (Exception e) {
                                num[i] = 0;
                                count++; //无法转换的字符串算作0，而且计数器也要+1
                        }
        }
        void add_aver()
        {
                sum = 0;
                for (int i = 0; i < count; i++) {
                        sum += num[i]; //总数加上数组里面的有效数字
                }
                ave = sum / count; //计算平均数
        }
}

//ComputeWindows.java
package exp2_1;
import java.awt.FlowLayout;
import javax.swing.*;
public class ComputeWindow extends JFrame
{
        JTextArea text_input, text_result;
        TextListener changetxtlistener;
        Compute cp;
        void init()
        {
                cp = new Compute(); //新建Compute对象
                text_input = new JTextArea(6, 20); //新建JTextArea对象
                text_result = new JTextArea(6, 20);
                this.setLayout(new FlowLayout());
                this.add(new JScrollPane(text_input));
                this.add(new JScrollPane(text_result)); //让text_result带滚动条
                text_result.setEditable(false);
                changetxtlistener = new TextListener(); //新建TextListener
                changetxtlistener.setInputText(text_input); //把text_input传递到changetxtlistener里
                changetxtlistener.setShowText(text_result);//同上
                changetxtlistener.setCompute(cp);//同上
                (text_input.getDocument()).addDocumentListener(changetxtlistener);
        }//给text_input添加监听器
        ComputeWindow()
        {
                init();
                this.setTitle("计算");
                this.setBounds(100, 100, 400, 300);
                this.setVisible(true);
                this.validate();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}

//Exp2_1.java
package exp2_1;
public class Exp2_1
{
        public static void main(String[] args)
        {
                // TODO code application logic here
                ComputeWindow win = new ComputeWindow();//新建窗体对象
        }

}

//TextListener.java
package exp2_1;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class TextListener implements DocumentListener
{
        JTextArea inputText, showText;
        Compute cmp;
        public void setInputText(JTextArea text)
        {
                inputText = text; //inputText指向text对应的对象
        }
        public void setShowText(JTextArea text)
        {
                showText = text; //ishowText指向text对应的对象
        }
        public void setCompute(Compute cp)
        {
                cmp = cp; //cmp指向cp对应的对象
        }
        public void changedUpdate(DocumentEvent e)
        {
                String text = inputText.getText(); //获取inputText的内容
                cmp.setnum(text); //获取数值
                cmp.add_aver(); //计算和、平均值
                showText.setText(null);
                showText.append("\n和：" + cmp.sum); //显示和
                showText.append("\n平均值：" + cmp.ave); //显示平均值
        }
        public void removeUpdate(DocumentEvent e)
        {
                changedUpdate(e); //当字符被删除时调用changedUpdate函数
        }
        public void insertUpdate(DocumentEvent e)
        {
                changedUpdate(e); //当字符被插入的时候调用changedUpdate函数
        }
}
//MainFrame.java
package exp2_3;
public class MainFrame extends javax.swing.JFrame
{
        Generator gen;
        int total;
        int correct;
        public MainFrame()
        {
                initComponents();
                jTextNum1.setEditable(false);
                jTextNum2.setEditable(false);
        }

        private void initComponents()
        {

                jTextNum1 = new javax.swing.JTextField();
                jLabelOp = new javax.swing.JLabel();
                jTextNum2 = new javax.swing.JTextField();
                jLabelEqual = new javax.swing.JLabel();
                jTextResult = new javax.swing.JTextField();
                jButtonProblem = new javax.swing.JButton();
                jButtonOK = new javax.swing.JButton();
                jLabelState = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jTextNum1.setMinimumSize(new java.awt.Dimension(100, 25));
                jTextNum1.setPreferredSize(new java.awt.Dimension(100, 25));
                jTextNum1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextNum1ActionPerformed(evt);
                        }
                });

                jLabelOp.setText("+");
                jLabelOp.setMaximumSize(new java.awt.Dimension(8, 15));
                jLabelOp.setMinimumSize(new java.awt.Dimension(8, 15));
                jLabelOp.setPreferredSize(new java.awt.Dimension(8, 15));

                jTextNum2.setMinimumSize(new java.awt.Dimension(100, 25));
                jTextNum2.setPreferredSize(new java.awt.Dimension(100, 25));

                jLabelEqual.setText("=");
                jLabelEqual.setMaximumSize(new java.awt.Dimension(8, 15));
                jLabelEqual.setMinimumSize(new java.awt.Dimension(8, 15));
                jLabelEqual.setPreferredSize(new java.awt.Dimension(8, 15));

                jTextResult.setMinimumSize(new java.awt.Dimension(100, 25));
                jTextResult.setPreferredSize(new java.awt.Dimension(100, 25));

                jButtonProblem.setText("出题");
                jButtonProblem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonProblemActionPerformed(evt);
                        }
                });

                jButtonOK.setText("确认");
                jButtonOK.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonOKActionPerformed(evt);
                        }
                });

                jLabelState.setText("<html>\n总题目数：<br>\n正确题目数：\n</html>");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                  .addGap(12, 12, 12)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButtonProblem)
                                            .addGroup(layout.createSequentialGroup()
                                                      .addComponent(jTextNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                      .addComponent(jLabelOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                      .addComponent(jTextNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                      .addComponent(jLabelEqual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelState, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonOK)
                                            .addComponent(jTextResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                  .addContainerGap(16, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                  .addGap(46, 46, 46)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabelEqual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jTextResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jTextNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jTextNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                  .addComponent(jLabelState, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(49, 49, 49)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonProblem)
                                            .addComponent(jButtonOK))
                                  .addGap(58, 58, 58))
                );

                pack();
        }// </editor-fold>

        private void jTextNum1ActionPerformed(java.awt.event.ActionEvent evt)
        {
                // TODO add your handling code here:

        }

        private void jButtonProblemActionPerformed(java.awt.event.ActionEvent evt)
        {
                // TODO add your handling code here:
                if (gen == null) {
                        gen = new Generator();
                }
                gen_Problem();
                total = 0;
                correct = 0;
                set_Labels();
        }
        private void gen_Problem()
        {
                gen.Generate();
                jTextNum1.setText(Integer.toString(gen.getNum1()));
                jTextNum2.setText(Integer.toString(gen.getNum2()));
                jLabelOp.setText(gen.getOp());
        }
        private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt)
        {
                // TODO add your handling code here:
                if (gen == null) {
                        return;
                } else {
                        if (!jTextResult.getText().isEmpty() && Integer.valueOf(jTextResult.getText()) == gen.getResult()) {
                                correct++;
                        }
                }
                total++;
                set_Labels();
                gen_Problem();
        }
        private void set_Labels()
        {
                jLabelState.setText("<html> 总题目数：" + total + "<br> 正确题目数：" + correct + "</html>");
                jTextResult.setText("");
        }
        try
        {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                break;
                        }
                }
        } catch (ClassNotFoundException ex)
        {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
                public void run() {
                        new MainFrame().setVisible(true);
                }
        });
}

// Variables declaration - do not modify
private javax.swing.JButton jButtonOK;
private javax.swing.JButton jButtonProblem;
private javax.swing.JLabel jLabelEqual;
private javax.swing.JLabel jLabelOp;
private javax.swing.JLabel jLabelState;
private javax.swing.JTextField jTextNum1;
private javax.swing.JTextField jTextNum2;
private javax.swing.JTextField jTextResult;
// End of variables declaration
}

//Generator.java
package exp2_3;
public class Generator
{
        int num1, num2;
        int result;
        String operator;
        Random rand;
        public Generator()
        {
                rand = new Random();
        }
        void Generate()
        {
                num1 = 0;
                num2 = 0;
                int index;
                index = rand.nextInt(4);
                switch (index) {
                case 0:
                        operator = "+";
                        num1 = rand.nextInt(100);
                        num2 = rand.nextInt(100);
                        result = num1 + num2;
                        break;
                case 1:
                        operator = "-";
                        num1 = rand.nextInt(100);
                        num2 = rand.nextInt(100);
                        result = num1 - num2;
                        break;
                case 2:
                        operator = "*";
                        num1 = rand.nextInt(100);
                        num2 = rand.nextInt(100);
                        result = num1 * num2;
                        break;
                case 3:
                        operator = "/";
                        while (num1 == 0) {
                                num1 = rand.nextInt(10);
                        }
                        while (num2 == 0) {
                                num2 = rand.nextInt(10);
                        }
                        result = num1 * num2;
                        int temp = num1;
                        num1 = result;
                        result = temp;
                        break;
                }
        }
        int getNum1()
        {
                return num1;
        }
        int getNum2()
        {
                return num2;
        }
        String getOp()
        {
                return operator;
        }
        int getResult()
        {
                return result;
        }
}
