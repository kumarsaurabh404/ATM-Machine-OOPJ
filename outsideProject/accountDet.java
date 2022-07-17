package outsideProject;
import java.text.DecimalFormat;
import java.util.Scanner;

public class accountDet{
    Scanner input=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

    // set customer number

    public int setCustomerNumber(int customerNumber){
        this.customerNumber= customerNumber;
        return customerNumber;
    }

    //get customer number
    public int setCustomerNumber(){
        return customerNumber;
    }

    // set pin no.

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    // get pin no.
    public int setPinNumber(){
        return pinNumber;
    }

    //get checking balance
    public double getCheckingBalance(){
        return checkingBalance;
    }

    // get saving balance
    public double getSavingBalance(){
        return savingBalance;
    }

    //calculate checking account withdrawal

    public double calcCheckingWithdraw(double amount){
        checkingBalance=(checkingBalance - amount);
        return checkingBalance;
    }
    //calculate saving account withdrawal

    public double calcSavingWithdraw(double amount){
        savingBalance=(savingBalance - amount);
        return savingBalance;
    }

    //calculate Checking Account Deposit

    public double calcCheckingDeposit(double amount){
        checkingBalance=(checkingBalance + amount);
        return checkingBalance;
    }

    //calculate Saving Account Deposit

    public double calcSavingDeposit(double amount){
        savingBalance=(savingBalance +amount);
        return savingBalance;
    }

    // checking account withdraw input

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.print("Amount to withdraw from Checking Account: ");
        double amount=input.nextDouble();

        if((checkingBalance-amount)>=0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(checkingBalance)+"\n");
        }else{
            System.out.println("Insufficient Funds"+"\n");
        }
    }

    // saving account withdraw input

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
        System.out.print("Amount to withdraw from Saving Account: ");
        double amount=input.nextDouble();

        if((savingBalance-amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: "+ savingBalance + "\n");
        }else{
            System.out.println("Insufficient Funds"+"\n");
        }
    }

    //checking amount deposit input

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        System.out.print("Amount to deposit from checking account: ");
        double amount= input.nextDouble();
        if((checkingBalance + amount)>=0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Insufficient Funds "+"\n");
        }
    }


    //checking amount deposit input

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.print("Amount to deposit from saving account: ");
        double amount= input.nextDouble();
        if((savingBalance + amount)>=0){
            calcCheckingDeposit(amount);
            System.out.println("New Saving Account Balance: "+ moneyFormat.format(savingBalance));
        }else{
            System.out.println("Insufficient Funds "+"\n");
        }
    }
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance=0;
    private double savingBalance=0;

}
