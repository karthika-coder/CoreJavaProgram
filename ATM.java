package Basics;

import java.util.Scanner;

public class ATM 
{
	Scanner sc = new Scanner(System.in);
	
	void Choice()
	{
		int balance = 100000, withdraw, deposit;
		int n;
		
		while(true)
		{
			System.out.println("Automatic Teller Machine");
			System.out.println("1 for Deposit money");
			System.out.println("2 for withdraw money");
			System.out.println("3 for check balance");
			System.out.println("4 for exit");
			System.out.println("Enter the choice");
			n = sc.nextInt();
		
		switch(n)
		{
		case 1:
			System.out.println("Enter the Money for Deposit :");
			deposit = sc.nextInt();
			balance = balance+deposit;
			System.out.println("Your Money has been deposited successfully");
			System.out.println(" ");
			break;
		case 2:
			System.out.println("Enter the Money for Withdraw :");
			withdraw = sc.nextInt();
			
			if(balance >= withdraw)
			{
				balance = balance - withdraw;
				System.out.println("Please Collect Your Money");
			}
			else
			{
				System.out.println("Insufficient Balance");
			}
			System.out.println(" ");
			break;
		case 3:
			System.out.println("Your Balance is : "+balance);
			System.out.println(" ");
			break;
		case 4:
            System.exit(0);			
            break;
		default:
			System.out.println("Invalid Input");
			System.out.println(" ");
			break;
		}
		}

	}

	public static void main(String[] args)
	{
		ATM a = new ATM();
		a.Choice();
	}

}
