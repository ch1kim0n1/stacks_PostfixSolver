package com.mycompany.test;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Vlad
 */
public class MainWindow extends javax.swing.JFrame {
    
    public MainWindow() {
        initComponents();
        String ExampleCase = "9 3 / 2 * 7 9 * + 4 -";
        MainWindow_TextField_Equaiton.setText(ExampleCase);
    }

    
   // class InvalidEquationException extends Exception {
   public void InvalidEquationException(String message) {
       JOptionPane.showMessageDialog(MainWindow.this, "ERROR: "+message);
   }
    
    public double Postfix(String equation) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < equation.length(); i+=2) { //i+=2 in order to use examples cases that were shown in the document
            char c = equation.charAt(i);

            if (Character.isDigit(c)) {
                stack.push((double) (c - '0')); 
            } 
            else if(Character.isLetter(c)){
                InvalidEquationException("Cant use letters in the equation");
                return -1;
            }
            else
            {
                if(stack.isEmpty()){
                    InvalidEquationException("Empty stack, can't take 1st operand");
                    return -1;
                }
                double operand2 = stack.pop();
                if(stack.isEmpty()){
                    InvalidEquationException("Empty stack, can't take 2nd operand");
                    return -1;
                }
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
        if (stack.size() != 1) {
            InvalidEquationException("Stack size is not correct (above or bellow 1)");
            return -1;
        } 
        else{
            return stack.pop();
        }
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
        MainWindow_Label_Name.setText("Stacks - PostFix Calculator (Vlad)");

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

        MainWindow_TextField_Equaiton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainWindow_TextField_EquaitonMouseClicked(evt);
            }
        });
        MainWindow_TextField_Equaiton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainWindow_TextField_EquaitonActionPerformed(evt);
            }
        });

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
                        .addGap(121, 121, 121)
                        .addComponent(MainWindow_Button_SOLVE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(MainWindow_Label_Answer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(MainWindow_Label_Number2)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(MainWindow_TextField_Equaiton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(MainWindow_Label_Name)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(MainWindow_Label_Name)
                .addGap(37, 37, 37)
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
        double result = Postfix(equation);
        if(result == -1){
            MainWindow_TextArea_Answer.setText("");
            MainWindow_TextField_Equaiton.setText("");
        }
        else{
            MainWindow_TextArea_Answer.setText(Double.toString(result));
        }
    }//GEN-LAST:event_MainWindow_Button_SOLVEActionPerformed

    private void MainWindow_TextField_EquaitonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainWindow_TextField_EquaitonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainWindow_TextField_EquaitonActionPerformed

    private void MainWindow_TextField_EquaitonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainWindow_TextField_EquaitonMouseClicked

    }//GEN-LAST:event_MainWindow_TextField_EquaitonMouseClicked

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
