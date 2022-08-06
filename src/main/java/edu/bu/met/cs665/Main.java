package edu.bu.met.cs665;

import edu.bu.met.cs665.enhancements.CriticalHit;
import edu.bu.met.cs665.enhancements.DamageBoost;
import edu.bu.met.cs665.enhancements.MagicDamage;
import edu.bu.met.cs665.enhancements.NoEnhancement;
import edu.bu.met.cs665.materialtype.Aluminum;
import edu.bu.met.cs665.materialtype.Gold;
import edu.bu.met.cs665.materialtype.Iridium;
import edu.bu.met.cs665.materialtype.Wood;

public class Main {

  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {

    // create material inventory instance
    MaterialInventory inventory = MaterialInventory.getInstance();

    // create shop (subject)
    Shop shop = new Shop();

    // create observers
    Blacksmith tess = new Blacksmith("Tess");
    Blacksmith christine = new Blacksmith("Christine");

    // attach observers
    shop.attach(tess);
    shop.attach(christine);

    // check inventory stock for wood, remove wood inventory, and check stock again
    System.out.println("Inventory stock for Wood: " + inventory.checkInventory("Wood"));
    System.out.println("========================");
    System.out.println("Removing 7 wood inventory stock...");
    inventory.removeInventory("Wood", 7);
    System.out.println("========================");
    System.out.println("Inventory stock for Wood: " + inventory.checkInventory("Wood"));
    System.out.println("========================");

    // create order1 of Iridium Spear
    Material iridium = new Iridium();
    WeaponOrder order1 = new WeaponOrder();
    order1.createWeaponOrder("Spear", iridium);
    order1.processOrder();
    WeaponOrderWithEnhancement finOrder;
    Enhancement magic = new MagicDamage();
    finOrder = order1.createFinalOrderWithEnhancement(magic);
    if (finOrder == null) {
      System.out.println("Please choose a new material for your weapon, we cannot "
          + "process your order otherwise.");
    } else {
      finOrder.setCustomerName("Cecilia");
      finOrder.getFinalOrderType();
      finOrder.finalWeaponDetail();
    }

    // create order2 of Aluminum Sword
    WeaponOrder order2 = new WeaponOrder();
    Material alu = new Aluminum();
    order2.createWeaponOrder("Sword", alu);
    order2.processOrder();
    Enhancement none = new NoEnhancement();
    WeaponOrderWithEnhancement finOrder2;
    finOrder2 = order2.createFinalOrderWithEnhancement(none);
    if (finOrder2 == null) {
      System.out.println("Please choose a new material for your weapon, we cannot process your "
          + "order otherwise.");
    } else {
      finOrder2.setCustomerName("Trish");
      finOrder2.getFinalOrderType();
      finOrder2.finalWeaponDetail();
    }

    // create order3 of Gold Dagger
    Material gold = new Gold();
    WeaponOrder order3 = new WeaponOrder();
    order3.createWeaponOrder("Dagger", gold);
    order3.processOrder();
    Enhancement criticalHit = new CriticalHit();
    WeaponOrderWithEnhancement finOrder3;
    finOrder3 = order3.createFinalOrderWithEnhancement(criticalHit);
    if (finOrder3 == null) {
      System.out.println("Please choose a new material for your weapon, we cannot process "
          + "your order otherwise.");
    } else {
      finOrder3.setCustomerName("Paige");
      finOrder3.getFinalOrderType();
      finOrder3.finalWeaponDetail();
    }

    // notify all observers of order requests
    // order > total Observers
    shop.addOrder(finOrder);
    shop.addOrder(finOrder2);
    shop.addOrder(finOrder3);

    // assign blacksmiths to each order
    shop.assignBlacksmith(finOrder);
    shop.assignBlacksmith(finOrder2);
    shop.assignBlacksmith(finOrder3);

    // tess blacksmith done
    shop.doneOrder(tess);
    shop.assignBlacksmith(finOrder3);

    // check inventory stock of Iridium, Aluminum, and Gold
    System.out.println("Inventory stock for Iridium: " + inventory.checkInventory("Iridium"));
    System.out.println("========================");
    System.out.println("Inventory stock for Aluminum: "
        + inventory.checkInventory("Aluminum"));
    System.out.println("========================");
    System.out.println("Inventory stock for Gold: " + inventory.checkInventory("Gold"));

    // created order4 of Wood Sword
    System.out.println("========================");
    Material wood = new Wood();
    WeaponOrder order4 = new WeaponOrder();
    order4.createWeaponOrder("Sword", wood);
    order4.processOrder();
    Enhancement damageBoost = new DamageBoost();
    WeaponOrderWithEnhancement finOrder4;
    finOrder4 = order4.createFinalOrderWithEnhancement(damageBoost);
    if (finOrder4 == null) {
      System.out.println("Please choose a new material for your weapon, we cannot process "
          + "your order otherwise.");
    } else {
      finOrder4.setCustomerName("Zach");
      finOrder4.getFinalOrderType();
      finOrder4.finalWeaponDetail();
    }

    // no observers available
    shop.addOrder(finOrder4);
    shop.assignBlacksmith(finOrder4);

    // total observers > order
    shop.doneOrder(christine);
    Blacksmith heather = new Blacksmith("Heather");
    Blacksmith jason = new Blacksmith("Jason");
    shop.attach(heather);
    shop.attach(jason);

    // assign blacksmiths to order
    shop.assignBlacksmith(finOrder4);
    shop.assignBlacksmith(finOrder4);

    // create order5 of Iridium Dagger
    WeaponOrder order5 = new WeaponOrder();
    order5.createWeaponOrder("Dagger", iridium);
    order5.processOrder();
    WeaponOrderWithEnhancement finOrder5;
    finOrder5 = order5.createFinalOrderWithEnhancement(magic);
    if (finOrder5 == null) {
      System.out.println("Please choose a new material for your weapon, we cannot process "
          + "your order otherwise.");
    } else {
      finOrder5.setCustomerName("Rose");
      finOrder5.getFinalOrderType();
      finOrder5.finalWeaponDetail();
    }

    // notify all blacksmiths
    shop.addOrder(finOrder5);
    shop.assignBlacksmith(finOrder5);

    // check inventory stock for wood, remove wood inventory, and check stock again
    System.out.println("Inventory stock for Wood: " + inventory.checkInventory("Wood"));
    System.out.println("========================");
    System.out.println("Removing 8 wood inventory stock...");
    // no negative stock, if current stock - value <= 0, then stock inventory is 0
    inventory.removeInventory("Wood", 8);
    System.out.println("========================");
    System.out.println("Inventory stock for Wood: " + inventory.checkInventory("Wood"));
    System.out.println("========================");

    // create order6 of Wood Sword
    // wood is out of stock; prints statement stating that user needs to pick new material
    WeaponOrder order6 = new WeaponOrder();
    order6.createWeaponOrder("Sword", wood);
    order6.processOrder();
    WeaponOrderWithEnhancement finOrder6;
    finOrder6 = order6.createFinalOrderWithEnhancement(magic);
    if (finOrder6 == null) {
      System.out.println("No order has been processed, please pick a new material.");
      System.out.println("========================");
    } else {
      finOrder6.setCustomerName("Lily");
      finOrder6.getFinalOrderType();
      finOrder6.finalWeaponDetail();
    }

    shop.doneOrder(tess);
    shop.doneOrder(heather);

  }
}




//}
