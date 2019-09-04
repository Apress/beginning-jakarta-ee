class DOMIterator {
  private int i = 0;
  private Node n;
  public DOMIterator(Node n) { this.n = n; }
  public Stream<Node> stream() {
    NodeList nl = n.getChildNodes();
    int len = nl.getLength();
    return len == 0 ?
      Stream.empty()
      : Stream.iterate(nl.item(0), n2 -> { 
        i++; return nl.item(i); }).limit(len); 
  }
  public static Stream<Node> stream(Node n) {
    return new DOMIterator(n).stream();
  }
}
