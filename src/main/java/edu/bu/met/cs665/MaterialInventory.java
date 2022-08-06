package edu.bu.met.cs665;

import java.util.HashMap;

public class MaterialInventory {

  // Design Pattern: Singleton
  private HashMap<String, Integer> materialDB = new HashMap<String, Integer>();
  private String[] materialType = {"Wood", "Aluminum", "Gold", "Iridium"};
  private int[] amount = {10, 10, 10, 10};

  private static MaterialInventory materialInventoryInstance;
  private int instock;

  private MaterialInventory() {
    for (int i = 0; i < 4; i++) {
      materialDB.put(materialType[i], amount[i]);
    }
  }

  /**
   * singleton implementation, making sure that there is only one instance of MaterialInventory.
   * @return return MaterialInventory instance.
   */
  public static MaterialInventory getInstance() {
    if (materialInventoryInstance == null) {
      materialInventoryInstance = new MaterialInventory();
      System.out.println("Creating Inventory");
    }
    return materialInventoryInstance;
  }

  /**
   * method to add inventory of specified type and amount to the database.
   * @param type String of material type.
   * @param value integer value of amount of material.
   */
  public void addInventory(String type, int value) {
    materialDB.put(type, materialDB.get(type) + value);
    System.out.println("Adding " + value + " " + type + " to the inventory.");
  }

  /**
   * method to remove specific inventory type and amount.
   * @param type String of material type.
   * @param value integer value of amount of material.
   */
  public void removeInventory(String type, int value) {
    if (materialDB.get(type) - value <= 0) {
      materialDB.put(type, 0);
    } else {
      materialDB.put(type, materialDB.get(type) - value);
    }
  }

  /**
   * method to check how many inventory of specified type are left in stock.
   * @param type String of material type.
   * @return return integer of stock left of the specified material type.
   */
  public int checkInventory(String type) {
    return materialDB.get(type);
  }

  /**
   * method to validate that there is inventory in stock or not.
   * @param type String of material type.
   * @return return integer of in stock indication. 1 is in stock, 0 in out of stock.
   */
  public int inventoryValidation(String type) {
    if (checkInventory(type) != 0) {
      System.out.println(type + " inventory available.");
      this.instock = 1;
      removeInventory(type, 1);
    } else {
      System.out.println(type + " is out of stock.");
      this.instock = 0;
    }
    return this.instock;
  }

  /**
   * method for junit testing.
   * @return return integer of instock paramerter.
   */
  public int getInstock() {
    return this.instock;
  }
}
