
public class Account {
    private static int balance=0;
    private String[] history;
	private byte count;
    public byte getCount() {
		return count;
	}
	
    
    private byte i;
    private byte x;
    private byte y;
    public String[] getHistory() {
		return history;
	}


	public byte getY() {
		return y;
	}


	private static int operation;
	public void setOperation(int op) {
		operation = op;
	}


	public int getOperation() {
		return operation;
	}


    public Account(){
        this.count=-1;
        this.y=-1;
        history=new String[5];
        history[0]=null;
    }
    public void balanceinquiry() {
    	 if(count<4) {
             this.history[count+1]="Balance Inquiry: "+balance+"";
             this.count++;
             y=count;
             
             }
             else {
             	for(i=0;i<4;i++) {
             		this.history[i]=this.history[i+1];
             	}
             	this.history[4]="Balance Inquiry: "+balance+"";
             }
    }
    public void Deposit(int amount){
        balance=balance+amount;
        if(count<4) {
        this.history[count+1]="Deposit: "+amount+"";
        this.count++;
        y=count;
        
        }
        else {
         	for(i=0;i<4;i++) {
          		this.history[i]=this.history[i+1];
           	}
           	this.history[4]="Deposit: "+amount+"";
           	y=4;
        }
    }
    public void Withdraw(int amount){
            balance=balance-amount;
            if(count<4) {
            this.history[count+1]="Withdrawal: "+amount+"";
            count++;
            y=count;
            
            }
            else {
            	for(i=0;i<4;i++) {
            		this.history[i]=this.history[i+1];
            	}
            	this.history[4]="Withdrawal: "+amount+"";
            }
    }
    public String prev(){
    	if(y>=1&&y<=5) {
    		x=y;
    		y--;
            return this.history[x-1];
    	}
    	else {
    		y=-1;
    		i=-1;
    		return "no previous transactions";
    	}
    }
    public String next(){
        if(i==-1&&y==-1&&history[0]!=null) {
    		y++;
    		i--;
    		return this.history[0];
    	}
    	else if(y<=3&&y>=0&&y<=(count-1)) {
    		x=y;
    		y++;
            return this.history[x+1];
    	}
    	else {
    		y=count;
    		y++;
    		return "no further transactions";
    	}
    }
    public boolean valid(String cardnumber) {
    	if(cardnumber.equals("123456789"))
    		return true;
    	else
    		return false;
    	
    }
    

    public int getBalance() {
        return balance;
    }
}

