public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
      
    public void insertCoin(int v){
        System.out.println("Please wait, we're already giving you a gumball!");
    }
       
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank!");
    }
 
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

	public void dispense() {
        if (gumballMachine.getCount() > 0) {
            gumballMachine.releaseBall();
            if (gumballMachine.getCoins() > 0) {
                int valueOfInsertedCoins = gumballMachine.getCoins();
                System.out.println("\nYour " + valueOfInsertedCoins + " cents returned." );
                gumballMachine.setCoins(0);
                }
            gumballMachine.setState(gumballMachine.getNotEnoughCoinState());             
        } 
        else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
 
    public String toString() {
        return "releasing a gumball...";
    }
}


