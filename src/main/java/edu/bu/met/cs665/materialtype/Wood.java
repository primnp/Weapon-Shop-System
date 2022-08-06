package edu.bu.met.cs665.materialtype;

import edu.bu.met.cs665.Material;

public class Wood implements Material {

  private double price;
  private double damageDealt;
  private double agility;
  private double accuracy;
  private double magicPierce;

  /**
   * constructor for wood material.
   */
  public Wood() {
    this.price = 10;
    this.damageDealt = 1.5;
    this.agility = 8;
    this.accuracy = 5;
    this.magicPierce = 0;
  }

  /**
   * method to get material type.
   * @return return string of material type.
   */
  public String getMaterial() {
    return "Wood";
  }

  /**
   * method to return material price.
   * @return return double of price.
   */
  public double getMaterialPrice() {
    return this.price;
  }

  /**
   * method to get damage dealt value.
   * @return return double of the ability value.
   */
  public double getDamageDealt() {
    return this.damageDealt;
  }

  /**
   * method tho get agility value.
   * @return return double of the ability value.
   */
  public double getAgility() {
    return this.agility;
  }

  /**
   * method to get accuracy value.
   * @return return double of the ability value.
   */
  public double getAccuracy() {
    return this.accuracy;
  }

  /**
   * method to return magic pierce value.
   * @return return double of the ability value.
   */
  public double getMagicPierce() {
    return this.magicPierce;
  }


}
