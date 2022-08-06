package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.enhancements.CriticalHit;
import edu.bu.met.cs665.enhancements.DamageBoost;
import edu.bu.met.cs665.enhancements.MagicDamage;
import edu.bu.met.cs665.enhancements.NoEnhancement;
import edu.bu.met.cs665.materialtype.Aluminum;
import edu.bu.met.cs665.materialtype.Gold;
import edu.bu.met.cs665.materialtype.Iridium;
import edu.bu.met.cs665.materialtype.Wood;
import edu.bu.met.cs665.weapontype.Dagger;
import edu.bu.met.cs665.weapontype.Spear;
import edu.bu.met.cs665.weapontype.Sword;
import org.junit.Test;

public class TestWeaponOrderWithEnhancement {

  public TestWeaponOrderWithEnhancement() {}

  @Test
  public void testGetTotalPrice() {
    Material wood = new Wood();
    Weapon spear = new Spear(wood);
    Enhancement critical = new CriticalHit();

    WeaponOrderWithEnhancement order = new WeaponOrderWithEnhancement(spear, critical);

    assertEquals(910, order.getTotalPrice(), 0.01d);

  }

  @Test
  public void testDamageDealtFinalVal() {
    Material alu = new Aluminum();
    Weapon sword = new Sword(alu);
    Enhancement damage = new DamageBoost();

    WeaponOrderWithEnhancement order = new WeaponOrderWithEnhancement(sword, damage);

    assertEquals(19.5, order.damageDealtFinalVal(), 0.01d);
  }

  @Test
  public void testAgilityFinalVal() {
    Material gold = new Gold();
    Weapon dagger = new Dagger(gold);
    Enhancement magic = new MagicDamage();

    WeaponOrderWithEnhancement order = new WeaponOrderWithEnhancement(dagger, magic);

    assertEquals(14.5, order.agilityFinalVal(), 0.01d);
  }

  @Test
  public void testAccuracyFinalVal() {
    Material iridium = new Iridium();
    Weapon dagger = new Dagger(iridium);
    Enhancement none = new NoEnhancement();

    WeaponOrderWithEnhancement order = new WeaponOrderWithEnhancement(dagger, none);

    assertEquals(17, order.accuracyFinalVal(), 0.01d);
  }

  @Test
  public void testMagicPierceFinalVal() {
    Material wood = new Wood();
    Weapon spear = new Dagger(wood);
    Enhancement none = new NoEnhancement();

    WeaponOrderWithEnhancement order = new WeaponOrderWithEnhancement(spear, none);

    assertEquals(2, order.magicPierceFinalVal(), 0.01d);
  }

  @Test
  public void testSetCustomerName() {
    Material wood = new Wood();
    Weapon spear = new Dagger(wood);
    Enhancement none = new NoEnhancement();

    WeaponOrderWithEnhancement order = new WeaponOrderWithEnhancement(spear, none);
    order.setCustomerName("Lilith");

    assertEquals("Lilith", order.getCustomerName());
  }

}
