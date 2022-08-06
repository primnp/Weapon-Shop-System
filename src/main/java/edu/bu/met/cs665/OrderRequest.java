package edu.bu.met.cs665;

import java.util.ArrayList;

public class OrderRequest {

  private int count = 0;

  /**
   * count assigned blacksmiths.
   */
  public int addAssignedBlacksmith() {
    return this.count++;
  }

  /**
   * remove assigned blacksmiths.
   */
  public int removeAssignedBlacksmith() {
    return this.count--;
  }

  /**
   * method to get count for assigned blacksmiths (unavailable blacksmiths).
   */
  public int getAssignedBlacksmith() {
    return this.count;
  }

  /**
   * method to assign blacksmith to an order request.
   */
  public void startOrder(Observer obv, WeaponOrderWithEnhancement ord) {
    obv.setWorking(1);
    addAssignedBlacksmith();
    ord.orderFulfilled(1);
    ord.setBlacksmith(obv.getName());
    System.out.println("Blacksmith " + obv.getName() + " has been assigned order for: "
        + ord.getCustomerName());
  }

  /**
   * method to specify no order, no blacksmith available.
   */
  public void noBlacksmith(WeaponOrderWithEnhancement ord) {
    ord.setBlacksmith("No Blacksmith");
    ord.orderFulfilled(0);
  }

  /**
   * method to specify that blacksmith has finished crafting an order
   * and is now available again.
   */
  public void finishOrder(Observer obv) {
    removeAssignedBlacksmith();
    System.out.println("Blacksmith " + obv.getName() + " finished crafting the weapon order.");
  }

}
