@Singleton
@Startup
public class QueueSender {
    @Resource(lookup = "jms/TestQueue")
    private Queue queue;
	
    @Inject
    private JMSContext jmsContext;
	 	
    @PostConstruct
    public void go() {
      String msg = "My JMS Message";
      jmsContext.createProducer().send(queue, msg);		
    }
}
