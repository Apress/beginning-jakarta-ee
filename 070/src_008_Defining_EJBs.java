  public interface InvoiceInterface {
      ... abstract interface methods
  }

  @Stateless  
  @Local(InvoiceInterface.class)
  @Remote(InvoiceInterface.class)
  public Invoice implements InvoiceInterface {
      ... implementation
  }
