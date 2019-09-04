@Singleton
@Startup
public class Timer1 {	
  @Resource
  private SessionContext context;

  @PostConstruct
  public void go() {
    context.getTimerService().
          createSingleActionTimer(5000, new TimerConfig());
  }
	
  @Timeout
  public void timeout(Timer timer) {
    System.err.println("Hello from " + getClass());
  }
}
