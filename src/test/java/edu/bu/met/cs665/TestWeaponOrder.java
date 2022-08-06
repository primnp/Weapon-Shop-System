package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.enhancements.DamageBoost;
import edu.bu.met.cs665.enhancements.MagicDamage;
import edu.bu.met.cs665.materialtype.Aluminum;
import edu.bu.met.cs665.materialtype.Iridium;
import edu.bu.met.cs665.materialtype.Wood;
import org.junit.Before;
import org.junit.Test;

public class TestWeaponOrder {

  public TestWeaponOrder() {}

  MaterialInventory inventory;

  @Before
  public void initialize() {
    inventory = MaterialInventory.getInstance();
  }

  @Test
  public void testCreateWeaponOrder() {
    Material alu = new Aluminum();
    WeaponOrder order = new WeaponOrder();

    order.createWeaponOrder("Dagger", alu);

    assertEquals("Aluminum Dagger", order.getWeaponOrderType());

  }

  @Test
  public void testMaterialInventory() {
    //MaterialInventory inventory = MaterialInventory.getInstance();
    assertEquals(10, inventory.checkInventory("Aluminum"));
  }

  @Test
  public void testAddInventory() {
    //MaterialInventory inventory = MaterialInventory.getInstance();
    inventory.addInventory("Gold", 5);
    assertEquals(15, inventory.checkInventory("Gold"));
  }

  @Test
  public void testProcessOrder() {
    Material iridium = new Iridium();
    WeaponOrder order = new WeaponOrder();

    order.createWeaponOrder("Sword", iridium);
    order.processOrder();

    assertEquals(1, order.getStatus());

  }


  @Test
  public void testProcessOrderMaterialOutOfStock() {
    Material iridium = new Iridium();
    WeaponOrder order = new WeaponOrder();
    //MaterialInventory inventory = MaterialInventory.getInstance();

    inventory.removeInventory("Iridium", 10);

    order.createWeaponOrder("Sword", iridium);
    order.processOrder();

    assertEquals(0, order.getStatus());

  }

  @Test
  public void testCreateFinalOrderWithEnhancement() {
    Material alu = new Aluminum();
    WeaponOrder order = new WeaponOrder();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement finOrder;

    order.createWeaponOrder("Spear", alu);
    order.processOrder();
    finOrder = order.createFinalOrderWithEnhancement(magic);

    assertEquals(17, finOrder.magicPierceFinalVal(), 0.01d);

  }

  @Test
  public void testCreateFinalOrderWithEnhancementMaterialOutOfStock() {
    Material wood = new Wood();
    WeaponOrder order = new WeaponOrder();
    Enhancement damageBoost = new DamageBoost();
    //MaterialInventory inventory = MaterialInventory.getInstance();

    inventory.removeInventory("Wood", 10);

    order.createWeaponOrder("Spear", wood);
    order.processOrder();
    order.createFinalOrderWithEnhancement(damageBoost);

    assertEquals(null, order.getOrderRequestEnhancement());

  }



}
