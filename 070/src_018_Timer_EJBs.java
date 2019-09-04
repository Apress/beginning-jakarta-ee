@Stateless
public class SomeEjb {
  @Schedule(minute="*", hour="0", persistent=false)
  // every minute during the hour between 00:00 and 01:00
  public void timeout1() {
    System.err.println("Timeout-1 from " + getClass());	
  } 
}
