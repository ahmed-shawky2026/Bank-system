package ui;

import model.BankAccount;

import javax.swing.*;
import java.awt.*;

public class BankGUI extends JFrame {

    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public BankGUI() {

        account = new BankAccount("Client");

        setTitle("Banking System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ===== Top =====
        JLabel title = new JLabel("Banking System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        // ===== Center =====
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        balanceLabel = new JLabel("Balance: 0.0 $", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        amountField = new JTextField();
        amountField.setHorizontalAlignment(JTextField.CENTER);

        centerPanel.add(balanceLabel);
        centerPanel.add(amountField);

        add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom =====
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");

        depositBtn.addActionListener(e -> deposit());
        withdrawBtn.addActionListener(e -> withdraw());

        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void deposit() {
        double amount = Double.parseDouble(amountField.getText());
        account.deposit(amount);
        updateBalance();
    }

    private void withdraw() {
        double amount = Double.parseDouble(amountField.getText());
        if (!account.withdraw(amount)) {
            JOptionPane.showMessageDialog(this, "Insufficient Balance");
        }
        updateBalance();
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: " + account.getBalance() + " $");
        amountField.setText("");
    }
}

