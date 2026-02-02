package model;

    public class BankAccount {

        private String ownerName;
        private double balance;

        public BankAccount(String ownerName) {
            this.ownerName = ownerName;
            this.balance = 0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public double getBalance() {
            return balance;
        }

        public String getOwnerName() {
            return ownerName;
        }
    }


