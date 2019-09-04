  public interface InvoiceInterface {
      ... abstract interface methods
  }

  @Stateless  
  @Remote(InvoiceInterface.class)
  public Invoice 
        implements InvoiceInterface {
      ... implementation
  }
