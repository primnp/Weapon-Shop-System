package edu.bu.met.cs665.enhancements;

import edu.bu.met.cs665.Enhancement;

public class CriticalHit implements Enhancement {

  private static final double damageIncrease = 1;
  private static final double agilityIncrease = 0.5;
  private static final double accuracyIncrease = 2;
  private static final double price = 750;
  private static final double noChange = 0;

  /**
   * method to return damage dealt of an enhancement.
   * @return return double of ability value.
   */
  public double damageDealtVal() {
    return damageIncrease;
  }

  /**
   * method to return agility of an enhancement.
   * @return return double of ability value.
   */
  public double agilityVal() {
    return agilityIncrease;
  }

  /**
   * method to return accuracy of an enhancement.
   * @return return double of ability value.
   */
  public double accuracyVal() {
    return accuracyIncrease;
  }

  /**
   * method to return magic pierce of an enhancement.
   * @return return double of ability value.
   */
  public double magicPierceVal() {
    return noChange;
  }

  /**
   * method to get enhancement type.
   * @return return string of enhancement type.
   */
  public String getEnhancementType() {
    return "Critical Hit";
  }

  /**
   * method to get price of the enhancement.
   * @return return double of price.
   */
  public double getEnhancementPrice() {
    return price;
  }

}
