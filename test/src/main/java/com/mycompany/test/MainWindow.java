package com.mycompany.test;

import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vlad
 */
public class MainWindow extends javax.swing.JFrame {
    
    public MainWindow() {
        initComponents();
    }

    
   // class InvalidEquationException extends Exception {
   public void InvalidEquationException(String message) {
       JOptionPane.showMessageDialog(MainWindow.this, "ERROR: "+message);
   }
    
    public static double evaluatePostfix(String equation) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < equation.length(); i+=2) {
            char c = equation.charAt(i);

            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                double result = 0;
                switch (c) {
                    case '+' -> result = operand1 + operand2;
                    case '-' -> result = operand1 - operand2;
                    case '*' -> result = operand1 * operand2;
                    case '/' -> result = operand1 / operand2;
                }

                stack.push(result);
            }
        }
        //if (stack.size() != 1) {
       //      InvalidEquationException("Invalid equation");
       // }

        return stack.pop();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MainWindow_Label_Name = new javax.swing.JLabel();
        MainWindow_Label_Number2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainWindow_TextArea_Answer = new javax.swing.JTextArea();
        MainWindow_Label_Answer = new javax.swing.JLabel();
        MainWindow_Button_SOLVE = new javax.swing.JButton();
        MainWindow_TextField_Equaiton = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainWindow_Label_Name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MainWindow_Label_Name.setText("Stacks - PostFix Calculator");

        MainWindow_Label_Number2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MainWindow_Label_Number2.setText("Write the equation here:");

        MainWindow_TextArea_Answer.setColumns(20);
        MainWindow_TextArea_Answer.setRows(5);
        jScrollPane1.setViewportView(MainWindow_TextArea_Answer);

        MainWindow_Label_Answer.setText("Answer");

        MainWindow_Button_SOLVE.setText("SOLVE");
        MainWindow_Button_SOLVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainWindow_Button_SOLVEActionPerformed(evt);
            }
        });

        MainWindow_TextField_Equaiton.setText("Ex: 5 6 7 * 3 - 4 3 +");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(MainWindow_Label_Name))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(MainWindow_Label_Number2)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainWindow_TextField_Equaiton))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(MainWindow_Button_SOLVE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(MainWindow_Label_Answer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(MainWindow_Label_Name)
                .addGap(35, 35, 35)
                .addComponent(MainWindow_Label_Number2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainWindow_TextField_Equaiton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(MainWindow_Button_SOLVE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainWindow_Label_Answer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainWindow_Button_SOLVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainWindow_Button_SOLVEActionPerformed
        String equation = MainWindow_TextField_Equaiton.getText();
        double result = evaluatePostfix(equation);
        MainWindow_TextArea_Answer.setText(Double.toString(result));
    }//GEN-LAST:event_MainWindow_Button_SOLVEActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new MainWindow().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MainWindow_Button_SOLVE;
    private javax.swing.JLabel MainWindow_Label_Answer;
    private javax.swing.JLabel MainWindow_Label_Name;
    private javax.swing.JLabel MainWindow_Label_Number2;
    private javax.swing.JTextArea MainWindow_TextArea_Answer;
    private javax.swing.JTextField MainWindow_TextField_Equaiton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
