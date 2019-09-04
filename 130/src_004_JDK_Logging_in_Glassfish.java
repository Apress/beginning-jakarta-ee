  ...
  public String someMethod(String p1, int p2) {
    LOG.entering(this.getClass().toString(),"someMethod",
        new Object[]{ p1, p2 });
    ...
    String res = ...;
    LOG.exiting(this.getClass().toString(),"someMethod",
        res);    
    return res;
  }
  ...
}
