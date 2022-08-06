package edu.bu.met.cs665;

public class WeaponOrderWithEnhancement {

  private Weapon weapon;
  private Enhancement enhancement;
  private String customerName;
  public int fulfilled;
  public String blacksmithName;


  /**
   * constructor for OrderRequestEnhancement object.
   * @param weapon weapon object.
   * @param enhancement enhancement object.
   */
  public WeaponOrderWithEnhancement(Weapon weapon, Enhancement enhancement) {
    this.enhancement = enhancement;
    this.weapon = weapon;
    this.customerName = null;
    this.fulfilled = 0;
    this.blacksmithName = "No Blacksmith";
  }

  /**
   * method to get final order type (weapon + enhancement).
   */
  public void getFinalOrderType() {
    System.out.println("Final order is " + weapon.getWeaponType() + " with "
        + enhancement.getEnhancementType() + " enhancement.");
  }

  /**
   * method to get the total price of the weapon with enhancement.
   * @return return double of price.
   */
  public double getTotalPrice() {
    return enhancement.getEnhancementPrice() + weapon.getWeaponPrice();
  }

  /**
   * method to get final value of damage dealt ability.
   * @return return double of ability value.
   */
  public double damageDealtFinalVal() {
    return enhancement.damageDealtVal() + weapon.damageDealtVal();
  }

  /**
   * method to get final value of agility ability.
   * @return return double of ability value.
   */
  public double agilityFinalVal() {
    return enhancement.agilityVal() + weapon.agilityVal();
  }

  /**
   * method to return the final value of accuracy ability.
   * @return return double of ability value.
   */
  public double accuracyFinalVal() {
    return enhancement.accuracyVal() + weapon.accuracyVal();
  }

  /**
   * method to return final value of magic pierce ability.
   * @return return double of ability value.
   */
  public double magicPierceFinalVal() {
    return enhancement.magicPierceVal() + weapon.magicPierceVal();
  }

  /**
   * method to prints out final weapon detail with enhancement value and total price.
   */
  public void finalWeaponDetail() {
    System.out.println("Customer name: " + customerName);
    System.out.println("Ability of " + weapon.getWeaponType() + " with "
        + enhancement.getEnhancementType() + ": ");
    System.out.println("  Damage Dealt: " + damageDealtFinalVal());
    System.out.println("  Agility: " + agilityFinalVal());
    System.out.println("  Accuracy: " + accuracyFinalVal());
    System.out.println("  Magic Pierce: " + magicPierceFinalVal());
    System.out.println("----------------");
    System.out.println("The total price is: " + getTotalPrice());
    System.out.println("========================");
  }

  /**
   * method to attach customer name to the OrderRequestEnhancement object.
   * @param name String name of the customer.
   */
  public void setCustomerName(String name) {
    this.customerName = name;
  }

  /**
   * method to get customer name.
   * @return return string of customer name.
   */
  public String getCustomerName() {
    return this.customerName;
  }

  /**
   * set parameter for order fulfilled.
   */
  public int orderFulfilled(int num) {
    return this.fulfilled = num;
  }

  /**
   * get status of an order, whether it's been fulfilled or not.
   */
  public int getOrderStatus() {
    return this.fulfilled;
  }

  /**
   * set order's blacksmith name.
   */
  public void setBlacksmith(String name) {
    this.blacksmithName = name;
  }

  /**
   * get blacksmith name for the order.
   */
  public String getBlacksmith() {
    return this.blacksmithName;
  }

  /**
   * print object with specified parameters.
   */
  @Override
  public String toString() {
    return "CUSTOMER=" + this.customerName + " ORDER=" + this.weapon.getWeaponType() + " with "
        + enhancement.getEnhancementType();
  }

}
