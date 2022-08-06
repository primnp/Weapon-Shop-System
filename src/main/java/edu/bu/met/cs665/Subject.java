package edu.bu.met.cs665;

public interface Subject {

  public void attach(Observer o);

  public void detach();

  public void notifyRequest(Object ob);

}
