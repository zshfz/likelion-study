package workshop.com.work6;

public class AccountTest {

	public static void main(String[] args) {
		Account[] a = new Account[] {
				new Account("221-0101-2111", 100000, 4.5),
				new Account("221-0101-2111", 100000, 4.5),
				new Account("221-0101-2111", 100000, 4.5),
				new Account("221-0101-2111", 100000, 4.5),
				new Account("221-0101-2111", 100000, 4.5),
		};
		
		for(Account account : a) {
			account.accountInfo();
		}
		
		for(Account account : a) {
			account.setInterestRate(3.7);
		}
		
		System.out.println();
		
		for(Account account : a) {
			account.accountInfo();
			System.out.println(" 이자 : " + (int)account.calculateInterest());
		}
		
	}

}

class Account{
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {
		
	}
	
	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		return getBalance() * (getInterestRate() / 100);
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int money) {
		if(this.balance < money ) {
			System.out.println("출금 할 수 없습니다");
		}else {
			this.balance -= money;
		}
	}
	
	public void accountInfo() {
		System.out.println("계좌번호 : " + account + " 잔액 : " + balance + " 이자율 : " + interestRate + "%");
	}

	public int getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	

//	@Override
//	public String toString() {
//		return String.format("계좌번호: %s, 잔액: %,d원", account, balance);
//	}
	
	
	
}