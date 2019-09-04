  package book.jakarta8.mbean;

  import java.lang.management.ManagementFactory;

  import javax.annotation.PostConstruct;
  import javax.annotation.PreDestroy;
  import javax.ejb.Singleton;
  import javax.ejb.Startup;
  import javax.management.MBeanServer;
  import javax.management.ObjectName;

  @Singleton
  @Startup
  public class App {
      private final static String OBJECT_NAME =
            "book.jakarta8:type=Time";

      @PostConstruct
      public void postConstruct() { 
          System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
          System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
          System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
          try {
            MBeanServer mbs = ManagementFactory.
                  getPlatformMBeanServer(); 
            ObjectName name = new ObjectName(OBJECT_NAME);
            TimeMBean mbean = new Time(); 
            mbs.registerMBean(mbean, name);
          }catch(Exception e) {
            e.printStackTrace(Systm.err);
          }
      }

      @PreDestroy
      public void preDestroy() {
          try {
            MBeanServer mbs = ManagementFactory.
                  getPlatformMBeanServer(); 
            ObjectName name = new ObjectName(OBJECT_NAME);
            mbs.unregisterMBean(name);
          }catch(Exception e) {
            e.printStackTrace(Systm.err);
          }
      }
  }
