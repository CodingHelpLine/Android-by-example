package com.youtube.tutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Bank
    private Bank bank;

    // Text Fields
    private EditText txtAccountNumber;
    private EditText txtAmount;
    private EditText txtBalance;

    // Radio Buttons
    private RadioButton radChecking;
    private RadioButton radSavings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bank = new Bank();

        txtAccountNumber = findViewById(R.id.txtAccountNumber);
        txtAmount = findViewById(R.id.txtAmount);
        txtBalance = findViewById(R.id.txtBalance);
        radChecking = findViewById(R.id.radChecking);
        radSavings = findViewById(R.id.radSavings);
    }

    /**
     * Withdraw function
     * @param view
     */
    public void doWithdraw(View view) {

        try
        {
            int accountNumber = Integer.parseInt(txtAccountNumber.getText().toString());
            double amount = Double.parseDouble(txtAmount.getText().toString());

            if(bank.withdraw(accountNumber, amount)) {
                Toast.makeText(this, "Transaction Successful!", Toast.LENGTH_LONG).show();
                this.txtBalance.setText(String.format("$%.2f", bank.getAccount(accountNumber).getBalance()));
                txtAmount.setText("");
            } else {
                Toast.makeText(this, "Transaction failed", Toast.LENGTH_LONG).show();
            }

        } catch(Exception e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Deposit funds
     * @param view
     */
    public void doDeposit(View view) {

        try
        {
            int accountNumber = Integer.parseInt(txtAccountNumber.getText().toString());
            double amount = Double.parseDouble(txtAmount.getText().toString());

            if(bank.deposit(accountNumber, amount)) {
                Toast.makeText(this, "Transaction Successful!", Toast.LENGTH_LONG).show();
                this.txtBalance.setText(String.format("$%.2f", bank.getAccount(accountNumber).getBalance()));
                txtAmount.setText("");
            } else {
                Toast.makeText(this, "Transaction failed", Toast.LENGTH_LONG).show();
            }

        } catch(Exception e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Check Balance
     * @param view
     */
    public void checkBalance(View view) {

        try
        {
            int accountNumber = Integer.parseInt(txtAccountNumber.getText().toString());
            this.txtBalance.setText(String.format("$%.2f", bank.getAccount(accountNumber).getBalance()));
            txtAmount.setText("");
        } catch(Exception e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Function to create Account based on selection of radio button
     *
     * @param view
     */
    public void createAccount(View view) {

        Account account = null;

        // check radiobutton selection
        if(this.radChecking.isChecked()) {
            account = new CheckingAccount(Bank.getNextAccountNumber(), 1.75);
        } else {
            account = new SavingsAccount(Bank.getNextAccountNumber(), 0.05);
        }

        bank.addAccount(account);

        // notify user
        Toast.makeText(this, "Account has been created - Account Number: " + account.getAccountNumber(),
                Toast.LENGTH_LONG).show();

        txtAmount.setText("");
        txtBalance.setText("");
        txtAccountNumber.setText("");
    }



}