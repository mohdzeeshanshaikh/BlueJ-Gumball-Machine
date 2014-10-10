

public class NotEnoughCoinsState implements State {
    GumballMachine gumballMachine;
    public NotEnoughCoinsState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertCoin(int v) {
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
        int valueOfInsertedCoins=gumballMachine.getCoins();
        if (valueOfInsertedCoins>=50){
            gumballMachine.setState(gumballMachine.getEnoughCoinState());
            System.out.println("Total amount is "+ valueOfInsertedCoins +" cents.");
            System.out.println("Please turn the crank.");
        }
        else
            System.out.println("Please insert "+ (50-valueOfInsertedCoins) +" cents more.");
    }   
       
    public void ejectCoin() {
        int valueOfInsertedCoins=gumballMachine.getCoins();
        if (valueOfInsertedCoins>0){
            System.out.println("Your " + valueOfInsertedCoins + " cents returned." );
            gumballMachine.setCoins(0);
        } 
        else
            System.out.println("Insert a coin first!!");
    }
 
    public void turnCrank() {
        int valueOfInsertedCoins=gumballMachine.getCoins();
        System.out.println("Cost of a gumball is 50 cents, you need "+ (50-valueOfInsertedCoins) +" cents more to dispense a gumball!");
     }
 
    public void dispense() {
        System.out.println("You need to pay enough amount first!!");
    } 
 
    public String toString() {
        return "waiting for more money...";
    }
}
