  public interface InvoiceLocal {
      ... abstract interface methods
  }
  public interface InvoiceRemote {
      ... abstract interface methods
  }

  @Stateless  
  @Local(InvoiceLocal.class)
  @Remote(InvoiceRemote.class)
  public Invoice 
        implements InvoiceLocal, 
                   InvoiceRemote {
      ... implementation
  }
