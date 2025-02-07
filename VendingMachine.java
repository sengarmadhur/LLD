import java.util.*;

//machine will have all states
// states will have machine
//cycle dependency can be achieved by passing (this) in constructor
public class Main {
    public static void main(String[] args) {
      VendingMachine machine = new VendingMachine();
      machine.currentState.start();
      machine.currentState.selectItem();
      machine.currentState.insertCoin();
      machine.currentState.dispenseItem();
      machine.currentState.returnChange();
  }
}

// class Item {
//   public String productName;
//   public int price;
//   public int quantity;
//   public Item(String name, int price, int quantity) {
//     productName = name;
//     price = price;
//     quantity = quantity;
//   }
  
//   @Override
//   public String toString() {
//     return "Name: " + productName + " price: " + price + " quantity: " + quantity;
//   }
// }

class VendingMachine {
  
  
  public State selectItemState;
  public State idleState;
  public State insertCoinState;
  public State returnRefundState;
  public State dispenseItemState;
  public State currentState;
  
  public VendingMachine() {
    selectItemState = new SelectItemState(this);
    idleState = new IdleState(this);
    insertCoinState = new InsertCoinState(this);
    returnRefundState = new ReturnRefundState(this);
    dispenseItemState = new DispenseItemState(this);
    currentState = idleState;
  }
  
}

abstract class State {
  
  VendingMachine machine;
  
  public void start() {
    System.out.println("Invalid operation");
  }
  
  
  public void selectItem() {
    System.out.println("Invalid operation");
  }
  public void insertCoin(){
    System.out.println("Invalid operation");
  }
  public void returnChange(){
    System.out.println("Invalid operation");
  }
  public void dispenseItem(){
    System.out.println("Invalid operation");
  }
  public void cancel(){
    System.out.println("Invalid operation");
  }
}

class SelectItemState extends State {
  
  public SelectItemState(VendingMachine machine) {
    this.machine = machine;
  }
  
  @Override
  public void selectItem() {
    System.out.println("Select items and quantity");
    machine.currentState = machine.insertCoinState;
  }
}


class InsertCoinState extends State {
  public InsertCoinState(VendingMachine machine) {
    this.machine = machine;
  }
  
  public void insertCoin() {
    System.out.println("Coin added");
    machine.currentState = machine.dispenseItemState;
  }
}

class IdleState extends State {
  public IdleState(VendingMachine machine) {
    this.machine = machine;
  }
  
  public void start() {
    System.out.println("Process started");
    machine.currentState = machine.selectItemState;
  }
}

class ReturnRefundState extends State {
  public ReturnRefundState(VendingMachine machine) {
    this.machine = machine;
  }
  
  public void returnChange() {
    System.out.println("Change returned");
    machine.currentState = machine.idleState;
  }
}

class DispenseItemState extends State {
  public DispenseItemState(VendingMachine machine) {
    this.machine = machine;
  }
  
  public void dispenseItem() {
    System.out.println("Item dispensed");
    machine.currentState = machine.returnRefundState;
  }
}
