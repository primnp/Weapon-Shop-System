package edu.bu.met.cs665;

public class Blacksmith implements Observer {

  private String name;
  private int working;

  /**
   * constructor for a blacksmith object.
   */
  public Blacksmith(String name) {

    this.name = name;
    this.working = 0;

  }

  /**
   * get blacksmith name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * set working parameters. If 0, blacksmith is available if 1, blacksmith is unavailable.
   */
  public void setWorking(int num) {
    this.working = num;
  }

  /**
   * return working parameter.
   */
  public int getWorking() {
    return this.working;
  }

  /**
   * return all order requests.
   */
  public void update(Object obj) {
    System.out.println("Blacksmith " + name + " receives order request:: " + obj);
  }


}
