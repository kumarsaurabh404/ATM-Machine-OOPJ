package Project;
//Main class
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class options extends outsideProject.accountDet{
    int selection;
    Scanner menuInput=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data =new HashMap<Integer,Integer>();


    // Validation of Customer no. and pin no.

    public void getLogin(){
        System.out.println("Welcome to Atm");
        System.out.println("Choose an option");
        System.out.println("1.Create An Account");
        System.out.println("2.Login to existing Account");
        System.out.println("3.Check Existing accounts");
        selection=menuInput.nextInt();
        Thread t=Thread.currentThread();
        int cus,pin;
        boolean flag=false;
        switch (selection){

            case 1:
                System.out.println("Enter a customer no.");
                System.out.println("Enter a pin");
                try {
                    cus = menuInput.nextInt();
                    pin = menuInput.nextInt();
                    data.put(cus, pin);
                    System.out.println("account with customer no."+ cus +" created \n \n");
                    getLogin();

                }catch (Exception e){
                    System.out.println("Invalid Customer no. or PIN");
                    getLogin();
                }

            case 2:
                System.out.println("Enter Customer Number");
                setCustomerNumber(menuInput.nextInt());


                System.out.println("Enter Your Pin");
                setPinNumber(menuInput.nextInt());
                System.out.print("Validating Your credentials");
                try{
                    for (int i=0;i<=2;i++){
                        System.out.print(".");
                        Thread.sleep(1000);
                    }
                }
                catch(InterruptedException e){
                    System.out.println("Main Thread Interrupted");
                }
                System.out.println("\n");
                for(HashMap.Entry<Integer,Integer> entry : data.entrySet()){
                    if(entry.getKey()==setCustomerNumber() && entry.getValue()==setPinNumber()){
                        flag=true;
                        getAccountType();
                    }
                }
                if(!flag){
                    System.out.println("Invalid Credentials");
                }
                getLogin();

            case 3:
                int ct=1;
                if(data.size()>0){
                    System.out.println(data.size()+" accounts found" );
                    for(HashMap.Entry<Integer,Integer> entry : data.entrySet()){
                        System.out.println(ct+"- "+entry.getKey());
                        ct++;
                    }
                    System.out.println("\n \n \n");
                }
                else{
                    System.out.println("No Accounts found \n \n \n");
                }
                getLogin();
        }




    }
    //Account Type
    public void getAccountType(){
        System.out.println("Select the type of account");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice: ");

        selection=menuInput.nextInt();
        switch (selection){
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for your Time.Please Do Visit Again :) \n \n");
                break;

            default:
                System.out.println("Invalid Choice"+"\n");
                getAccountType();
        }
    }

    // display checking account with options
    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        selection=menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: "+moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You For Your Time.Please Do Visit Again :)");
                break;

            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getChecking();
        }
    }

    // display saving account with options
    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");
        selection=menuInput.nextInt();
        switch(selection){
            case 1:
                System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for your Time.Please Do Visit Again :) \n \n \n");
                break;

            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getSaving();
        }

    }

}
