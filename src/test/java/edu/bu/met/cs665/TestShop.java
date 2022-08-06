package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.enhancements.DamageBoost;
import edu.bu.met.cs665.enhancements.MagicDamage;
import edu.bu.met.cs665.materialtype.Wood;
import edu.bu.met.cs665.weapontype.Dagger;
import edu.bu.met.cs665.weapontype.Sword;
import org.junit.Test;

public class TestShop {

  public TestShop() {}

  @Test
  public void testOrderStatus() {
    // creates shop, blacksmith, and weapon order with enhancement
    Shop shop = new Shop();
    Blacksmith daniel = new Blacksmith("Daniel");
    Blacksmith seb = new Blacksmith("Seb");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Enhancement damage = new DamageBoost();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);

    // attach blacksmith (observers) to a subject
    shop.attach(daniel);
    shop.attach(seb);

    // notify all attached blacksmiths of order requests, and assign a blacksmith to o1
    shop.addOrder(o1);
    shop.assignBlacksmith(o1);

    assertEquals(1, o1.getOrderStatus());
  }

  @Test
  public void testAssignDrivers() {
    // creates shop, blacksmith, weapon order with enhancement, and order request
    Shop shop = new Shop();
    Blacksmith daniel = new Blacksmith("Daniel");
    Blacksmith seb = new Blacksmith("Seb");
    Blacksmith mick = new Blacksmith("Mick");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);
    OrderRequest req = new OrderRequest();

    // attach blacksmiths (observers) to a subject
    shop.attach(daniel);
    shop.attach(seb);
    shop.attach(mick);

    // notify all attached blacksmiths of order requests
    shop.addOrder(o1);
    shop.addOrder(o2);
    shop.addOrder(o3);

    // assign a blacksmith to each order
    req.startOrder(daniel, o1);
    req.startOrder(seb, o2);
    req.startOrder(mick, o3);

    assertEquals(3, req.getAssignedBlacksmith());
  }

  @Test
  public void testRemoveDrivers() {
    // creates shop, blacksmith, weapon order with enhancement, and order request
    Shop shop = new Shop();
    Blacksmith daniel = new Blacksmith("Daniel");
    Blacksmith seb = new Blacksmith("Seb");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    OrderRequest req = new OrderRequest();

    // attach blacksmiths (observers) to a subject
    shop.attach(daniel);
    shop.attach(seb);

    // notify all attached blacksmiths of order requests
    shop.addOrder(o1);
    shop.addOrder(o2);

    // assign a blacksmith to each order
    req.startOrder(daniel, o1);
    req.startOrder(seb, o2);

    // makes blacksmith available again
    req.finishOrder(daniel);

    assertEquals(1, req.getAssignedBlacksmith());
  }

  @Test
  public void testMoreOrdersThanDrivers() {
    // creates shop, blacksmith, weapon order with enhancement
    Shop shop = new Shop();
    Blacksmith daniel = new Blacksmith("Daniel");
    Blacksmith seb = new Blacksmith("Seb");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);

    // attach blacksmiths (observers) to a subject
    shop.attach(daniel);
    shop.attach(seb);

    // notify all attached blacksmiths of order requests
    shop.addOrder(o1);
    shop.addOrder(o2);
    shop.addOrder(o3);

    // assign a blacksmith to each order
    shop.assignBlacksmith(o1);
    shop.assignBlacksmith(o2);
    shop.assignBlacksmith(o3);

    assertEquals(0, o3.getOrderStatus());
  }

  @Test
  public void testMoreOrdersDriversFinish() {
    // creates shop, blacksmith, weapon order with enhancement, and order request
    Shop newShop = new Shop();
    Blacksmith valerie = new Blacksmith("Valerie");
    Blacksmith yb = new Blacksmith("YB");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);
    OrderRequest req = new OrderRequest();

    newShop.attach(valerie);
    newShop.attach(yb);

    newShop.addOrder(o1);
    newShop.addOrder(o2);
    newShop.addOrder(o3);

    newShop.assignBlacksmith(o1);
    newShop.assignBlacksmith(o2);
    newShop.assignBlacksmith(o3);

    newShop.doneOrder(yb);
    newShop.assignBlacksmith(o3);

    assertEquals("YB", o3.getBlacksmith());
  }

  @Test
  public void testMoreDriversThanOrders() {
    // creates shop, blacksmith, weapon order with enhancement
    Shop shop = new Shop();
    Blacksmith daniel = new Blacksmith("Daniel");
    Blacksmith seb = new Blacksmith("Seb");
    Blacksmith mick = new Blacksmith("Mick");
    Blacksmith charles = new Blacksmith("Charles");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);

    // attach blacksmiths (observers) to a subject
    shop.attach(daniel);
    shop.attach(seb);
    shop.attach(mick);
    shop.attach(charles);

    // notify all attached blacksmiths of order requests
    shop.addOrder(o1);
    shop.addOrder(o2);
    shop.addOrder(o3);

    // assign a blacksmith to each order
    shop.assignBlacksmith(o1);
    shop.assignBlacksmith(o2);
    shop.assignBlacksmith(o3);

    assertEquals(0, charles.getWorking());
  }

    @Test
  public void testMoreDriversAddOrdersLater() {
    // creates shop, blacksmith, weapon order with enhancement
    Shop shop = new Shop();
    Blacksmith daniel = new Blacksmith("Daniel");
    Blacksmith seb = new Blacksmith("Seb");
    Blacksmith mick = new Blacksmith("Mick");
    Blacksmith charles = new Blacksmith("Charles");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);
    WeaponOrderWithEnhancement o4 = new WeaponOrderWithEnhancement(dagger, damage);


    // attach blacksmiths (observers) to a subject
    shop.attach(daniel);
    shop.attach(seb);
    shop.attach(mick);
    shop.attach(charles);

    // notify all attached blacksmiths of order requests
    shop.addOrder(o1);
    shop.addOrder(o2);
    shop.addOrder(o3);

    // assign a blacksmith to each order
    shop.assignBlacksmith(o1);
    shop.assignBlacksmith(o2);
    shop.assignBlacksmith(o3);

   // notify attached blacksmiths of new order request
    shop.addOrder(o4);
    shop.assignBlacksmith(o4);

    assertEquals("Charles", o4.getBlacksmith());
  }


}
