package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shop implements Subject {

  private ArrayList<WeaponOrderWithEnhancement> allOrder;
  private static final OrderRequest req = new OrderRequest();
  private int count = 0;
  private Queue<Observer> observers;

  /**
   * constructor for a shop object.
   */
  public Shop() {
    allOrder = new ArrayList<>();
    //observers = new ArrayList<>();
    observers = new LinkedList<>();
  }

  /**
   * add order requests and notify all available blacksmiths.
   */
  public void addOrder(WeaponOrderWithEnhancement order) {
    this.allOrder.add(order);
    System.out.println("Order request has been sent the system.");
    notifyRequest(order);
  }

  /**
   * subject method for attaching an object (in this case, adding a blacksmith).
   */
  public void attach(Observer obj) {
    this.observers.add(obj);
    System.out.println("Blacksmith " + obj.getName() + " is available.");
    System.out.println("========================");
  }

  /**
   * subject method for detaching an object (in this case, removing a blacksmith).
   */
  public void detach() {

    this.observers.remove();
  }

  /**
   * subject method for notifying all available blacksmiths of order request.
   */
  public void notifyRequest(Object obj) {
    for (Observer o: this.observers) {
      o.update(obj);
    }
    System.out.println("========================");
  }

  /**
   * method to call OrderRequest class to assign a blacksmith.
   * assign blacksmith based on first come first serves.
   */
  public void assignBlacksmith(WeaponOrderWithEnhancement ord) {
    System.out.println("Assigning Blacksmiths:");
    if (this.observers.isEmpty() == true) {
      System.out.println("All blacksmiths are busy.");
      req.noBlacksmith(ord);
    } else if (ord.getOrderStatus() == 1) {
      System.out.println("Order has already been assigned to blacksmith.");
    } else if (ord.getOrderStatus() == 0 && this.observers.isEmpty() == false) {
      for (Observer o: this.observers) {
        req.startOrder(o, ord);
        System.out.println("Total assigned blacksmiths: " + req.getAssignedBlacksmith());
        detach();
        break;
      }
    }
    System.out.println("========================");
  }

  /**
   * method to call OrderRequest class to remove assigned blacksmith.
   * add the blacksmith back to queue again.
   */
  public void doneOrder(Observer obv) {
    req.finishOrder(obv);
    attach(obv);
  }
}
