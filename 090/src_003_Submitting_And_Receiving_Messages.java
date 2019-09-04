@Singleton
@Startup
public class TopicSender {

  @Resource(lookup = "jms/TestTopic")
  private Topic topic;

  @Inject
  private JMSContext jmsContext;
	
  @Resource
  private SessionContext context; // needed for the timer

  @PostConstruct
  public void go() {
    // schedule the timer with a 5 secs delay
    context.getTimerService().createSingleActionTimer(
          5000, new TimerConfig());
  }
	
  @Timeout // called when the timer fires
  public void programmaticTimeout(Timer timer) {
    String msg = "My JMS Message";
    jmsContext.createProducer().send(topic, msg);
  }
}
