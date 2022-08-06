package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBlacksmith {

  public TestBlacksmith() {}

  @Test
  public void testDriverConstructorName() {
    Blacksmith daniel = new Blacksmith("Daniel");

    assertEquals("Daniel", daniel.getName());
  }

  @Test
  public void testGetWorking() {
    Blacksmith rue = new Blacksmith("Rue");

    assertEquals(0, rue.getWorking());
  }

  @Test
  public void testSetWorkingOtherNo() {
    Blacksmith tia = new Blacksmith("Tia");
    tia.setWorking(2);

    assertEquals(2, tia.getWorking());
  }



}
