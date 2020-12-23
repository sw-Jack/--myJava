public class Account { // Account.java --> Value Object
	// 멤버필드
	private String name; // 계좌 주인
	private long balance; // 계좌 잔액

	// 생성자
	Account() { }
	Account(String name) {
		this.name = name;
	}
	
	// 메서드
	public String getName() {
		return name;
	}
	public long getBalance() {
		return balance;
	}
	
	// 입금 메서드
	public void deposit(long amount) {
		balance += amount;
	}
	// 출금 메서드 
	public void withdraw(long amount) {
		if(balance < amount) 
			System.out.println("잔고가 부족합니다.");
		else 
			balance -= amount;
	}
}