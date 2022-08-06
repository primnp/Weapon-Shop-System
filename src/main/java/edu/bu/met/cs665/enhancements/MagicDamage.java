package edu.bu.met.cs665.enhancements;

import edu.bu.met.cs665.Enhancement;

public class MagicDamage implements Enhancement {

  private static final double magicIncrease = 10;
  private static final double price = 1250;
  private static final double noChange = 0;

  /**
   * method to return damage dealt of an enhancement.
   * @return return double of ability value.
   */
  public double damageDealtVal() {
    return noChange;
  }

  /**
   * method to return agility of an enhancement.
   * @return return double of ability value.
   */
  public double agilityVal() {
    return noChange;
  }

  /**
   * method to return accuracy of an enhancement.
   * @return return double of ability value.
   */
  public double accuracyVal() {
    return noChange;
  }

  /**
   * method to return magic pierce of an enhancement.
   * @return return double of ability value.
   */
  public double magicPierceVal() {
    return magicIncrease;
  }

  /**
   * method to get enhancement type.
   * @return return string of enhancement type.
   */
  public String getEnhancementType() {
    return "Magic Damage";
  }

  /**
   * method to get price of the enhancement.
   * @return return double of price.
   */
  public double getEnhancementPrice() {
    return price;
  }

}
