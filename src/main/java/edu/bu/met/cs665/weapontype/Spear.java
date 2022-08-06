package edu.bu.met.cs665.weapontype;

import edu.bu.met.cs665.Material;
import edu.bu.met.cs665.Weapon;

public class Spear implements Weapon {

  private Material mainMaterial;
  private static final double price = 150;
  private static final double damageDealt = 8;
  private static final double agility = 7;
  private static final double accuracy = 4;
  private static final double magicPierce = 7;
  private String weaponType;

  public Spear(Material mainMaterial) {
    this.mainMaterial = mainMaterial;
  }


  public String getWeaponType() {
    weaponType = mainMaterial.getMaterial() + " Spear";
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
