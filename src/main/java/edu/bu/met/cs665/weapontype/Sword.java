package edu.bu.met.cs665.weapontype;

import edu.bu.met.cs665.Material;
import edu.bu.met.cs665.Weapon;

public class Sword implements Weapon {

  private Material mainMaterial;
  private static final double price = 200;
  private static final double damageDealt = 10;
  private static final double agility = 8;
  private static final double accuracy = 8;
  private static final double magicPierce = 2;
  private String weaponType;

  public Sword(Material mainMaterial) {
    this.mainMaterial = mainMaterial;
  }

  public String getWeaponType() {
    weaponType = mainMaterial.getMaterial() + " Sword";
    return weaponType;
  }

  public double getWeaponPrice() {
    return mainMaterial.getMaterialPrice() + price;
  }

  public double damageDealtVal() {
    return mainMaterial.getDamageDealt() + damageDealt;
  }

  public double agilityVal() {
    return mainMaterial.getAgility() + agility;
  }

  public double accuracyVal() {
    return mainMaterial.getAccuracy() + accuracy;
  }

  public double magicPierceVal() {
    return mainMaterial.getMagicPierce() + magicPierce;
  }


}
