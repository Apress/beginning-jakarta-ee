@MessageDriven(
  activationConfig = { 
    @ActivationConfigProperty(
      propertyName = "destinationType", 
      propertyValue = "javax.jms.Queue")
  }, 
  mappedName = "jms/TestQueue")
public class TestQueueReceiverEJB 
      implements MessageListener {

  @Resource
  private MessageDrivenContext mdc;

  @Override
  public void onMessage(Message message) {
    try {
      System.err.println("!#!#!#! QUEUE " + 
            ((TextMessage)message).getText());
    } catch (JMSException e) {
      e.printStackTrace(System.err);
    }    
  }
}
