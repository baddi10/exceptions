package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Login login = new Login();

        login.setUsername("user12");
        login.setPassword("password123");

        Withdraw withdraw = new Withdraw();
        withdraw.setUsername(login.getUsername());
        withdraw.setAmount(10000.0);

        Balance balance = new Balance();
        balance.setUsername(withdraw.getUsername());
        balance.setBalance(50000.0);
        //System.out.println( "Hello World!" );
        try{
            if(!login.getUsername().equals("user123") || !login.getPassword().equals("password123")){
                throw new NewExc("Invalid login credentials");
            }
            if(withdraw.getAmount() > balance.getBalance()){
                throw new Exception("Insufficient balance for withdrawal");
            }
//            balance.setBalance(balance.getBalance() - withdraw.getAmount());
            System.out.println("Withdrawal successful! balance: " + balance.getBalance());
        }
        catch(NewExc a){
            System.out.println("An error occurred: " + a.getMessage());
        }
        catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("username:" + login.getUsername() +" " + "password:" + login.getPassword());
        System.out.println("Withdrawal amount: " + withdraw.getAmount());
        System.out.println("Your account balance is:" + balance.getBalance());
    }
}
