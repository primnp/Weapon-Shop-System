package edu.bu.met.cs665.materialtype;

import edu.bu.met.cs665.Material;

public class Iridium implements Material {

  private double price;
  private double damageDealt;
  private double agility;
  private double accuracy;
  private double magicPierce;

  /**
   * constructor for iridium material.
   */
  public Iridium() {
    this.price = 1000;
    this.damageDealt = 10;
    this.agility = 8;
    this.accuracy = 9;
    this.magicPierce = 0;
  }

  /**
   * method to get material type.
   * @return return string of material type.
   */
  public String getMaterial() {
    return "Iridium";
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
