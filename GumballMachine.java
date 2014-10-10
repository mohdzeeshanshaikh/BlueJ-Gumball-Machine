
public class GumballMachine implements IGumballMachine {
 
	State soldOutState;
	State enoughCoinsState;
	State notEnoughCoinsState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;
	int valueOfCoins = 0 ;
	int totalGumballsInSlot = 0;
 
	public GumballMachine(int initialNumberOfGumballs) {
		soldOutState = new SoldOutState(this);
		notEnoughCoinsState = new NotEnoughCoinsState(this);
		enoughCoinsState = new EnoughCoinsState(this);
		soldState = new SoldState(this);

		this.count = initialNumberOfGumballs;
 		if (initialNumberOfGumballs > 0) {
			state = notEnoughCoinsState;
		} 
	}
    
    public void insertNickel(){
        state.insertCoin(5);
    }
	
    public void insertDime(){
        state.insertCoin(10);
    }
 
	public void insertQuarter() {
		state.insertCoin(25);
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
    
	public void ejectCoin() {
		state.ejectCoin();
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
			totalGumballsInSlot += 1;
			valueOfCoins = valueOfCoins - 50;
		}
		System.out.println("\nThere is/are " + totalGumballsInSlot +" gumball(s) in the slot!!");  
	}  
 
	int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count = count;
		state = notEnoughCoinsState;
	}

    public State  getState() {
        return state;
    }

	void setState(State state) {
		this.state = state;
	}

    public State  getSoldOutState() {
        return soldOutState;
    }

    public State  getNotEnoughCoinState() {
        return notEnoughCoinsState;
    }

    public State  getEnoughCoinState() {
        return enoughCoinsState;
    }

    public State  getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
	
	public void setCoins(int v){
	    valueOfCoins = v;
	}
	
    public int getCoins() {
        return valueOfCoins;
    }
    
    public boolean isGumballInSlot(){
        if (totalGumballsInSlot > 0) 
			return true;
        else 
			return false;
    }
    
	public void takeGumballFromSlot(){
	   if(isGumballInSlot()){
	       System.out.println("You have picked "+ totalGumballsInSlot + " gumball(s) from the slot!!");
	       totalGumballsInSlot = 0; 
	   }
	   else 
	       System.out.println("There are no gumballs in the slot");
    }
	 
}
