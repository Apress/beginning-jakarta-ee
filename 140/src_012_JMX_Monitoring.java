  package book.jakarta8.mbean;

  import java.time.Clock;

  public class Time implements TimeMBean {
      @Override
      public long getUtcTime() {
          return Clock.systemUTC().millis();
      }
  }
