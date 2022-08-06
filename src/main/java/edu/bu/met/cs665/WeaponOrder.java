package edu.bu.met.cs665;

public class WeaponOrder {

  MaterialInventory inventory = MaterialInventory.getInstance();

  private Weapon weapon;
  private Material material;
  private String materialType;
  private int validate;
  private int status;
  private WeaponOrderWithEnhancement finalOrder = null;

  /**
   * method to create a weapon order as specified with weapon type and material by customer.
   * @param type String of weapon type.
   * @param material Material object of material type.
   */
  public void createWeaponOrder(String type, Material material) {
    System.out.println("--Weapon Selection--");
    this.weapon = WeaponFactory.createWeapon(type, material);
    this.material = material;
    this.materialType = this.material.getMaterial();
  }

  /**
   * method to check if the material inventory is still available or not.
   * @return return validation integer. 1 if material is available, 0 if out of stock.
   */
  public int checkWeaponMaterialValidity() {
    return inventory.inventoryValidation(this.materialType);
  }

  /**
   * method to process initial order of type of weapon and material.
   */
  public void processOrder() {
    if (checkWeaponMaterialValidity() == 1) {
      System.out.println("You can now choose enhancement for your weapon.");
      this.status = 1;
    } else {
      System.out.println("Please choose new material for your weapon.");
      this.status = 0;
    }
    System.out.println("----------------");
  }

  /**
   * method to return weapon with all upgraded ability values.
   * @param enhancement Enhancement object type.
   * @return return OrderRequestEnhancement object.
   */
  public WeaponOrderWithEnhancement createFinalOrderWithEnhancement(Enhancement enhancement) {
    if (this.status != 1) {
      System.out.println("Unable to add enhancement, please choose a new material for "
          + "your weapon first.");
    } else {
      finalOrder = new WeaponOrderWithEnhancement(this.weapon, enhancement);
    }
    return finalOrder;
  }

  /**
   * for junit testing to test processOrder method.
   * @return return int of status.
   */
  public int getStatus() {
    return this.status;
  }

  /**
   * for junit testing to test createWeaponOrder method.
   * @return return string of weapon type.
   */
  public String getWeaponOrderType() {
    return this.weapon.getWeaponType();
  }

  /**
   * for junit testing to test createFinalOrderWithEnhancement method.
   * @return return OrderRequestEnhancement object.
   */
  public WeaponOrderWithEnhancement getOrderRequestEnhancement() {
    return this.finalOrder;
  }



}
