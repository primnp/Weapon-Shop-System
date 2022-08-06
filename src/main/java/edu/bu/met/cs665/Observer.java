package edu.bu.met.cs665;

public interface Observer {

  public void update(Object o);

  public String getName();

  public void setWorking(int n);

  public int getWorking();

}
