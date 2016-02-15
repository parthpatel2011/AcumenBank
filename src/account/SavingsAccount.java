package account;

public class SavingsAccount {
	private String ownerName;
	private double principal;
	private double annualintrest;
	private double total;
	
	public SavingsAccount(String ownerName, double principal, double annualintrest) {
		this.ownerName = ownerName;
		this.principal = principal;
		this.annualintrest= annualintrest;
	}
	
	public void transfer(SavingsAccount destinationAccount, double amount) {
		destinationAccount.deposit(amount);
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.principal += amount;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public double getprincipal() {
		return this.principal;
	}
	
	public double getannualintrest() {
		return this.annualintrest;
	}
	
    public void applyInterest(int years){
        //F = P(1+i/n)(nt)
        this.total = principal*(1+annualintrest)*years;
        
    }
    
    public double getSavingBalance(){
    	return this.total;
    }
    
}
