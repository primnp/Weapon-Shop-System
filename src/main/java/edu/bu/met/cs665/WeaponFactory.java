package edu.bu.met.cs665;

import edu.bu.met.cs665.weapontype.Dagger;
import edu.bu.met.cs665.weapontype.Spear;
import edu.bu.met.cs665.weapontype.Sword;

public class WeaponFactory implements AbstractFactory {

  private static Weapon weapon;

  /**
   * abstract factory method to create a weapon.
   * @param type string type of weapon.
   * @param material material object of specific material type.
   * @return reutn the weapon object.
   */
  public static Weapon createWeapon(String type, Material material) {
    if (type == "Sword") {
      weapon = new Sword(material);
    } else if (type == "Dagger") {
      weapon = new Dagger(material);
    } else if (type == "Spear") {
      weapon = new Spear(material);
    }
    System.out.println("Weapon selected: " + type + ", Material selected: "
        + material.getMaterial());
    return weapon;
  }

}
