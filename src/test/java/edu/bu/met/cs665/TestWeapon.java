package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.materialtype.Aluminum;
import edu.bu.met.cs665.materialtype.Gold;
import edu.bu.met.cs665.materialtype.Iridium;
import edu.bu.met.cs665.materialtype.Wood;
import org.junit.Test;

public class TestWeapon {

  public TestWeapon() {}

  @Test
  public void testCreateWeaponSwordWoodGetWeaponType() {
    Weapon weapon;
    Material wood = new Wood();

    weapon = WeaponFactory.createWeapon("Sword", wood);

    assertEquals("Wood Sword", weapon.getWeaponType());

  }

  @Test
  public void testCreateWeaponSpearAluminumGetWeaponPrice() {
    Weapon weapon;
    Material alu = new Aluminum();

    weapon = WeaponFactory.createWeapon("Spear", alu);

    assertEquals(250, weapon.getWeaponPrice(), 0.01d);

  }

  @Test
  public void testCreateWeaponDaggerGoldDamageDealtVal() {
    Weapon weapon;
    Material gold = new Gold();

    weapon = WeaponFactory.createWeapon("Dagger", gold);

    assertEquals(12, weapon.damageDealtVal(), 0.01d);

  }

  @Test
  public void testCreateWeaponSwordIridiumAgilityVal() {
    Weapon weapon;
    Material iridium = new Iridium();

    weapon = WeaponFactory.createWeapon("Sword", iridium);

    assertEquals(16, weapon.agilityVal(), 0.01d);

  }

  @Test
  public void testSpearWoodAccuracyVal() {
    Weapon weapon;
    Material wood = new Wood();

    weapon = WeaponFactory.createWeapon("Spear", wood);

    assertEquals(9, weapon.accuracyVal(), 0.01d);

  }

  @Test
  public void testDaggerAluminumMagicPierceVal() {
    Weapon weapon;
    Material alu = new Aluminum();

    weapon = WeaponFactory.createWeapon("Spear", alu);

    assertEquals(7, weapon.magicPierceVal(), 0.01d);

  }

}
