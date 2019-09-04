@MessageDriven(
  activationConfig = { 
    @ActivationConfigProperty(
      propertyName = "destinationType", 
      propertyValue = "javax.jms.Topic")
  }, 
  mappedName = "jms/TestTopic")
public class TestTopicReceiverEJB 
      implements MessageListener {

  @Resource
  private MessageDrivenContext mdc;
		
  @Override
  public void onMessage(Message message) {
    try {
      System.err.println("!#!#!#! TOPIC " + 
            ((TextMessage)message).getText());
    } catch (JMSException e) {
      e.printStackTrace(System.err);
    }
  }
}
