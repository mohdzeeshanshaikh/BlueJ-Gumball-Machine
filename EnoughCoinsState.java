

import java.util.Random;

public class EnoughCoinsState implements State {
	GumballMachine gumballMachine; 
	public EnoughCoinsState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
    public void insertCoin(int v){
        if (v==5)
            System.out.println("You inserted a Nickel!");
        else if (v==10)
            System.out.println("You inserted a Dime!");
        else if (v==25)
            System.out.println("You inserted a Quarter!");
        else {
            System.out.println("Error!! You can insert only a Quarter, a Dime or a Nickel");           
            return;
        }
        gumballMachine.setCoins(gumballMachine.getCoins()+ v);
    }
        
	public void ejectCoin() {
        int valueOfInsertedCoins = gumballMachine.getCoins();
		System.out.println("Your " + valueOfInsertedCoins + " cents returned." );
	    gumballMachine.setCoins(0);
		gumballMachine.setState(gumballMachine.getNotEnoughCoinState());
	}
 
	public void turnCrank() {
		System.out.println("You turned the crank...");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed!!");
    }
 
	public String toString() {
		return "waiting for turn of crank...";
	}
}
