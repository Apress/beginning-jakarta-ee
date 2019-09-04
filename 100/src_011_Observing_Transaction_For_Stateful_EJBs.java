...
import javax.ejb.SessionSynchronization;
...
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SomeEjb implements SessionSynchronization {
    @Override
    public void afterBegin() {
        // A transaction has started
        ...
    }

    @Override
    public void beforeCompletion() {
        // A transaction is about to be finished
        ...
    }

    @Override
    public void afterCompletion(boolean committed) {
        // A transaction has finished
        ...
    }
}
