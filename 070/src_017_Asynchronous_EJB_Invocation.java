...
@EJB
private SomeEjb someEjb;
...
Future<String> f = someEjb.tellMeLater();
try {
    // Example only: block until the result
    // is available:
    String s = f.get();
    System.err.println(s);
} catch (Exception e) {
    e.printStackTrace(System.err);
}
