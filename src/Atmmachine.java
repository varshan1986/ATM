import java.util.Scanner;
public class Atmmachine {
	private static Scanner in;
	private static float balance=0;//Initial Balance
	private static int anothertransaction;
	private static int Depositfre=4;//Frequency 
	private static float Depositpertransaction=40000;
	private static float Depositperday=150000;
	private static int Withdrwalfre=3;//Withdrwal Frequency 
	private static float Withdrawamountperday=50000;
	private static float Withdrawpertransaction=20000;
		public static void main(String[] args) {
		in=new Scanner(System.in);
		transaction();//Getting the options 
	}
	private static void transaction(){
		int choice;
		System.out.println("*********Enter Menu options***********");
		System.out.println("1.Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdrawal");
		System.out.println("4.Quit");
		choice=in.nextInt();
		switch(choice){
		case 1://Balance Case
			System.out.println("CURRENT BALANCE IS "+balance+"\n");
			anothertransaction();
		case 2://Deposit Section 
			float depositamount;
			int Depositfre = 0;
			int tempDepositfre;
			System.out.println("DEPOSIT");
			System.out.println("Current Balance"+balance);
			System.out.println("Enter amount to deposit");
			depositamount=in.nextFloat();
			if(depositamount<=Depositpertransaction && balance <=Depositperday){
			balance=depositamount+balance;
			System.out.println("You had deposited "+depositamount+"New balance is "+balance+"\n");
			tempDepositfre=Depositfre+1;
			System.out.println("The Frequency is "+tempDepositfre);
			}else{
				System.out.println("Please enter below this amount"+Depositpertransaction);
			}
			anothertransaction();
			break;
		case 3://Withdrwal 
			float withdrawamount;
			int Withdrwalfrequency=0;
			int tempwithdrwaltfre;
			System.out.println("WITHDRAWAL");
			System.out.println("Current Balance"+balance);
			System.out.println("Enter withdrawal amount");
			withdrawamount=in.nextFloat();
			if(withdrawamount >balance || withdrawamount==0 || withdrawamount >Withdrawpertransaction){
				System.out.println("Your balance is "+balance+"\nYou cant withdrawal");
				anothertransaction();
			}
			else if(Withdrwalfre > Withdrwalfrequency){
				balance=balance-withdrawamount;
				tempwithdrwaltfre=Withdrwalfre+1;
				System.out.println("You have withdrawan "+withdrawamount+"and your balance is " +balance);
				System.out.println("The Frequency is "+tempwithdrwaltfre);
				anothertransaction();
			}
			else{
				System.out.println("You have execited the limit");
			}
			break;
		case 4://QUIT
			 int decision;
			 boolean yn;
			System.out.println("QUIT");
			System.out.println("Are you sure you want to quit?(1 for Exit /0 for continue to use)");
			decision = in.nextInt();
			if(decision==1){
				 yn = false;
				 System.out.println("You are successfully closed the options");
				 break;
			}
			else{
				yn=true;
				anothertransaction();
			}
		default: 
	        System.out.println("Invalid response"); 
		}		
		}
	/* It is for calling the menu again*/
	public static void anothertransaction(){
		System.out.println("Do you want to Continue ?Press \n1 for another transaction\n5 To exit");
		anothertransaction=in.nextInt();
		if(anothertransaction == 1){
            transaction(); // call transaction method
        } else if(anothertransaction == 5){
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anothertransaction();
        }
    }
		
	}

