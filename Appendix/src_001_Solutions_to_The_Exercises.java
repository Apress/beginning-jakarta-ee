  package book.jakarta8.hacc.jsfgui.listeners;

  import javax.faces.event.PhaseEvent;
  import javax.faces.event.PhaseId;
  import javax.faces.event.PhaseListener;

  public class MyPhaseListener 
      implements PhaseListener{

    @Override
    public void 
    afterPhase(PhaseEvent event) {
        System.err.println("AFTER PHASE - " + 
        event.getPhaseId().getName());		
    }

    @Override
    public void 
    beforePhase(PhaseEvent event) {
        System.err.println("BEFORE PHASE - " + 
        event.getPhaseId().getName());		
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
