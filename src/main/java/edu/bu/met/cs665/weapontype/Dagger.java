package edu.bu.met.cs665.weapontype;

import edu.bu.met.cs665.Material;
import edu.bu.met.cs665.Weapon;

public class Dagger implements Weapon {

  private Material mainMaterial;
  private static final double price = 95;
  private static final double damageDealt = 5;
  private static final double agility = 9.5;
  private static final double accuracy = 8;
  private static final double magicPierce = 2;
  private String weaponType;

  public Dagger(Material mainMaterial) {
    this.mainMaterial = mainMaterial;
  }

  public String getWeaponType() {
    weaponType = mainMaterial.getMaterial() + " Dagger";
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
