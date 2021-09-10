import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class FrameDesign extends JFrame {
    JLabel balanceLabel = new JLabel("Loan Balance");
    JTextField balanceTextField = new JTextField();

    JLabel interestLabel = new JLabel("Interest Rate");
    JTextField interestTextField = new JTextField();

    JLabel monthsLabel = new JLabel("Number of payments");
    JTextField monthsTextField = new JTextField();

    JLabel paymentLabel = new JLabel("Monthly Payment");
    JTextField paymentTextField = new JTextField();

    JButton computeButton = new JButton("Compute Monthly Payments");
    JButton newLoanButton = new JButton("New Loan Analysis");

    JButton monthsButton = new JButton("X");
    JButton paymentButton = new JButton("X");

    JLabel analysisLabel = new JLabel("Loan Analysis");
    JTextArea analysisTextArea = new JTextArea();
    JButton exitButton = new JButton("Exit");
    Color lightYellow = new Color(255,255,188);
    boolean computePayment;




    Font myFont = new Font("Arial", Font.PLAIN,16);


        FrameDesign() {
            this.getContentPane().setLayout(new GridBagLayout());
            GridBagConstraints gridConstraints;


            balanceLabel.setFont(myFont);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = 0;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,0);
            getContentPane().add(balanceLabel,gridConstraints);

            balanceTextField.setFont(myFont);
            balanceTextField.setPreferredSize(new Dimension(100,25));
            balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 1;
            gridConstraints.gridy = 0;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,10);
            getContentPane().add(balanceTextField,gridConstraints);
            balanceTextField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    balanceTextFieldActionPerformed(e);
                }

                private void balanceTextFieldActionPerformed(ActionEvent e) {
                    balanceTextField.transferFocus();
                }
            });



            interestLabel.setFont(myFont);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = 1;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,0);
            getContentPane().add(interestLabel,gridConstraints);

            interestTextField.setFont(myFont);
            interestTextField.setPreferredSize(new Dimension(100,25));
            interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 1;
            gridConstraints.gridy = 1;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,10);
            getContentPane().add(interestTextField,gridConstraints);
            interestTextField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interestTextFieldActionPerformed(e);

                }

                private void interestTextFieldActionPerformed(ActionEvent e) {
                    interestTextField.transferFocus();
                }
            });






            //new

            monthsLabel.setFont(myFont);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = 2;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,0);
            getContentPane().add(monthsLabel,gridConstraints);

            monthsTextField.setFont(myFont);
            monthsTextField.setPreferredSize(new Dimension(100,25));
            monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 1;
            gridConstraints.gridy = 2;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,10);
            getContentPane().add(monthsTextField,gridConstraints);
            monthsTextField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    monthsTextFieldActionPerformed(e);
                }

                private void monthsTextFieldActionPerformed(ActionEvent e) {
                    monthsTextField.transferFocus();
                }
            });




            paymentLabel.setFont(myFont);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = 3;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,0);
            getContentPane().add(paymentLabel,gridConstraints);

            paymentTextField.setFont(myFont);
            paymentTextField.setPreferredSize(new Dimension(100,25));
            paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 1;
            gridConstraints.gridy = 3;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(10,10,0,10);
            getContentPane().add(paymentTextField,gridConstraints);
            paymentTextField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    paymentTextFieldActionPerformed(e);
                }

                private void paymentTextFieldActionPerformed(ActionEvent e) {
                    paymentTextField.transferFocus();
                }
            });

            //Adding Buttons
            computeButton.setFont(myFont);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = 4;
            gridConstraints.gridwidth = 2;
//          gridConstraints.anchor = GridBagConstraints
            gridConstraints.insets = new Insets(10,0,0,0);
            computeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    computeButtonActionPerformed(e);
                }
                private void computeButtonActionPerformed(ActionEvent e) {
                    double balance, interest, payment;
                    int months;
                    double monthlyInterest, multiplier;
                    double loanBalance, finalPayment;
                    if (validateDecimalNumber(balanceTextField)) {
                        balance = Double.parseDouble(balanceTextField.getText());
                    }
                    else
                    { JOptionPane.showConfirmDialog(null, "Invalid Loan Balance Entry\nPlease correct", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                      return;}
                    if(validateDecimalNumber(interestTextField)) {

                        interest = Double.parseDouble(interestTextField.getText());
                    }
                    else {
                        JOptionPane.showConfirmDialog(null, "Invalid Interest Rate\nPlease correct", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    monthlyInterest = interest / 1200;
                    if (computePayment) {
                        if(validateDecimalNumber(monthsTextField)){
                        //compute loan payment
                        months = Integer.parseInt(monthsTextField.getText());}
                        else {
                            JOptionPane.showConfirmDialog(null, "Invalid Number of Payments\nPlease correct", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            return;}
                        if(interest == 0){
                            payment = balance / months;
                        }
                        else {


                            multiplier = Math.pow(1 + monthlyInterest, months);
                            payment = balance * monthlyInterest * multiplier / (multiplier - 1);
                        }
                        paymentTextField.setText(new DecimalFormat("0.00").format(payment));
                    }
                    else {
                        //compute number of payments
                        if(validateDecimalNumber(paymentTextField)) {
                            payment = Double.parseDouble(paymentTextField.getText());
                            if(payment <= (balance * monthlyInterest + 1.0)){
                                if(JOptionPane.showConfirmDialog(null, "Minimum Payment Must be ₹" + new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\nDo you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                                    paymentTextField.setText(new DecimalFormat("0.00").format((int) (balance * monthlyInterest + 1.0)));
                                    payment = Double.parseDouble(paymentTextField.getText());
                                }
                                else{
                                    paymentTextField.requestFocus();
                                    return;
                                }
                            }
                        }
                        else{
                            JOptionPane.showConfirmDialog(null, "Invalid Monthly Payment entry\nPlease correct", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if(interest ==0){
                            months = (int)(balance / payment);
                        }
                        else {
                            months = (int) ((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
                        }
                        monthsTextField.setText(String.valueOf(months));
                    }
                    //reset payment prior to analysis to fix at two decimals
                    payment = Double.parseDouble(paymentTextField.getText());
                    //Show analysis
                    analysisTextArea.setText("Loan Balance: ₹" + new DecimalFormat("0.00").format(balance));
                    analysisTextArea.setText("\nInterest Rate" + new DecimalFormat("0.00").format(interest) + "%");
                    //process all but last payment
                    loanBalance = balance;
                    for(int paymentNumber = 1; paymentNumber <= months-1; paymentNumber++){
                        loanBalance += loanBalance * monthlyInterest - payment;
                    }
                    //find final payment
                    finalPayment = loanBalance;
                    if(finalPayment>payment){
                        //apply one more payment
                        loanBalance += loanBalance * monthlyInterest - payment;
                        finalPayment = loanBalance;
                        months++;
                        monthsTextField.setText(String.valueOf(months));

                    }
                    analysisTextArea.append("\n\n" + (months - 1) + " Payments of ₹" + new DecimalFormat("0.00").format(payment));
                    analysisTextArea.append("\n" + "Final Payment of: ₹" + new DecimalFormat("0.00").format(finalPayment));
                    analysisTextArea.append("\n" + "Total Payments: ₹" + new DecimalFormat("0.00").format((months-1)* payment + finalPayment));
                    analysisTextArea.append(("\n" + "Interest Paid: ₹" + new DecimalFormat("0.00").format((months -1) * payment + finalPayment - balance)));
                    computeButton.setEnabled(false);
                    newLoanButton.setEnabled(true);
                    newLoanButton.requestFocus();
                }
            });
            getContentPane().add(computeButton, gridConstraints);

            newLoanButton.setFont(myFont);
            newLoanButton.setEnabled(true);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = 5;
            gridConstraints.gridwidth = 2;
            gridConstraints.insets = new Insets(10, 0 ,10 ,0 );
            newLoanButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    newLoanButtonActionPerformed(e);
                }
                private void newLoanButtonActionPerformed(ActionEvent e) {
                    newLoanButton.setEnabled(false);
                    computeButton.setEnabled(true);
                    balanceTextField.setText("");
                    interestTextField.setText("");
                    monthsTextField.setText("");
                    paymentTextField.setText("");
                    analysisTextArea.setText("");
                }
            });
            getContentPane().add(newLoanButton, gridConstraints);

            paymentButton.setFont(myFont);
            paymentButton.setFocusable(false);
//            paymentButton.setEnabled(false);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 2;
            gridConstraints.gridy = 3;
//            gridConstraints.gridwidth = 2;
            gridConstraints.insets = new Insets(10,0,10,0);
            paymentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    paymentButtonActionPerformed(e);
                }

                private void paymentButtonActionPerformed(ActionEvent e) {
                computePayment = true;
                paymentButton.setVisible(false);
                monthsButton.setVisible(true);
                monthsTextField.setEditable(true);
                monthsTextField.setBackground(Color.WHITE);
                monthsTextField.setFocusable(true);
                paymentTextField.setText("");
                paymentTextField.setEditable(false);
                paymentTextField.setFocusable(false);
                paymentTextField.setBackground(lightYellow);
                balanceTextField.requestFocus();
                computeButton.setText("Compute Monthly Payment");
                }
            });
            getContentPane().add(paymentButton, gridConstraints);

            monthsButton.setFont(myFont);
            monthsButton.setFocusable(false);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 2;
            gridConstraints.gridy = 2;
            gridConstraints.insets = new Insets(10,0,0,0);
            monthsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    monthsButtonActionPerformed(e);
                }

                private void monthsButtonActionPerformed(ActionEvent e) {
                    computePayment = false;
                    paymentButton.setVisible(true);
                    monthsButton.setVisible(false);
                    monthsTextField.setEditable(false);
                    monthsTextField.setText("");
                    monthsTextField.setBackground(lightYellow);
                    monthsTextField.setFocusable(false);
                    paymentTextField.setEditable(true);
                    paymentTextField.setBackground(Color.WHITE);
                    paymentTextField.setFocusable(true);
                    computeButton.setText("Compute Number of Payments");
                    balanceTextField.requestFocus();
                }
            });
            getContentPane().add(monthsButton, gridConstraints);
            this.getContentPane().setBackground(Color.LIGHT_GRAY);


            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                }
            });


            analysisLabel.setFont(myFont);
            analysisTextArea.setFocusable(false);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 3;
            gridConstraints.gridy = 0;
            gridConstraints.anchor = GridBagConstraints.WEST;
            gridConstraints.insets = new Insets(0,10,0,0);
            getContentPane().add(analysisLabel, gridConstraints);

            analysisTextArea.setPreferredSize(new Dimension(250,150));
            analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14 ));
            analysisTextArea.setEditable(false);
            analysisTextArea.setBackground(Color.WHITE);
            analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 3;
            gridConstraints.gridy = 1;
            gridConstraints.gridheight = 4;
            gridConstraints.insets = new Insets(0,10,0,10);
            getContentPane().add(analysisTextArea, gridConstraints);

            gridConstraints = new GridBagConstraints();
            exitButton.setFocusable(false);
            gridConstraints.gridx = 3;
            gridConstraints.gridy = 5;
            getContentPane().add(exitButton, gridConstraints);
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exitButtonActionPerformed(e);
                }

                private void exitButtonActionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });




            pack();

            Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds((int) (0.5 * (screen_size.width - getWidth())), (int) (0.5 * (screen_size.height - getHeight())), getWidth(), getHeight());
            this.setTitle("Consumer Loan Assistant");
            this.setVisible(true);    //Make it visible
            this.setResizable(false); //Prevent Frame from being resized
//            this.setSize(420, 420);
            //Change icon
            ImageIcon image = new ImageIcon("src/logo.png");  //Create image icon
            this.setIconImage(image.getImage());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            monthsButton.doClick();

        }

    public boolean validateDecimalNumber(JTextField tf){
            //checks to see if text field contains
            //valid decimal number with only digits and a single decimal point
        String s = tf.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;
        if(s.length() == 0) valid = false;
        else{
            for (int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c >= '0' && c<= '9'){
                    continue;
                }
                else if(c == '.'&& !hasDecimal){
                    hasDecimal = true;
                }
                else{
                    //invalid charecter found
                    valid = false;
                }
            }
        }
        tf.setText((s));
        if(!valid){
            tf.requestFocus();
        }
        return (valid);
    }



    private void exitForm(WindowEvent evt){
            System.exit(0);
            }



    public static void main(String[] args) {
        new FrameDesign();
    }
}

