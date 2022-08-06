package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.enhancements.DamageBoost;
import edu.bu.met.cs665.enhancements.MagicDamage;
import edu.bu.met.cs665.materialtype.Aluminum;
import edu.bu.met.cs665.materialtype.Wood;
import edu.bu.met.cs665.weapontype.Dagger;
import edu.bu.met.cs665.weapontype.Sword;
import org.junit.Test;

public class TestOrderRequest {

  public TestOrderRequest() {}

  @Test
  public void testAddAssignedBlacksmith() {
    // creates blacksmith, weapon order with enhancement, and order request
    OrderRequest req = new OrderRequest();
    Blacksmith charles = new Blacksmith("Charles");
    Blacksmith seb = new Blacksmith("Seb");
    Material alu = new Aluminum();
    Weapon sword = new Sword(alu);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);

    // assign blacksmith to order
    req.startOrder(charles, o1);
    req.startOrder(seb, o2);

    assertEquals(2, req.getAssignedBlacksmith());
  }

  @Test
  public void testRemoveAssignedBlacksmith() {
    // creates blacksmith, weapon order with enhancement, and order request
    OrderRequest req = new OrderRequest();
    Blacksmith charles = new Blacksmith("Charles");
    Blacksmith seb = new Blacksmith("Seb");
    Blacksmith daniel  = new Blacksmith("Daniel");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);

    // assign blacksmith to order
    req.startOrder(charles, o1);
    req.startOrder(seb, o2);
    req.startOrder(daniel, o3);

    // blacksmith finish crafting weapon, now available
    req.finishOrder(seb);

    assertEquals(2, req.getAssignedBlacksmith());
  }

  @Test
  public void testAddRemoveOrder() {
    // creates blacksmith, weapon order with enhancement, and order request
    OrderRequest req = new OrderRequest();
    Blacksmith charles = new Blacksmith("Charles");
    Blacksmith seb = new Blacksmith("Seb");
    Blacksmith daniel  = new Blacksmith("Daniel");
    Blacksmith mick  = new Blacksmith("Mick");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);
    WeaponOrderWithEnhancement o4 = new WeaponOrderWithEnhancement(dagger, damage);
    WeaponOrderWithEnhancement o5 = new WeaponOrderWithEnhancement(dagger, damage);

    // assign blacksmith to order
    req.startOrder(charles, o1);
    req.startOrder(seb, o2);
    req.startOrder(daniel, o3);
    req.startOrder(mick, o4);

    // blacksmiths finish crafting weapons, now available
    req.finishOrder(seb);
    req.finishOrder(daniel);

    // assign blacksmith to order
    req.startOrder(seb, o5);

    assertEquals(3, req.getAssignedBlacksmith());
  }

  @Test
  public void testNoDelivery() {
    // creates blacksmith, weapon order with enhancement, and order request
    OrderRequest req = new OrderRequest();
    Blacksmith charles = new Blacksmith("Charles");
    Blacksmith seb = new Blacksmith("Seb");
    Material wood = new Wood();
    Weapon sword = new Sword(wood);
    Weapon dagger = new Dagger(wood);
    Enhancement damage = new DamageBoost();
    Enhancement magic = new MagicDamage();
    WeaponOrderWithEnhancement o1 = new WeaponOrderWithEnhancement(sword, damage);
    WeaponOrderWithEnhancement o2 = new WeaponOrderWithEnhancement(sword, magic);
    WeaponOrderWithEnhancement o3 = new WeaponOrderWithEnhancement(dagger, magic);

    // assign blacksmith to order
    req.startOrder(charles, o1);
    req.startOrder(seb, o2);

    // assign blacksmith to order
    req.noBlacksmith(o3);

    assertEquals("No Blacksmith", o3.getBlacksmith());
  }

}
