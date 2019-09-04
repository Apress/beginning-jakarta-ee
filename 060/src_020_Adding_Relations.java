@ManyToMany
@JoinTable(
  name = "MTM_A_B",
  joinColumns = @JoinColumn( 
    name = "ID_A",
    referencedColumnName="ID"),
  inverseJoinColumns = @JoinColumn(
    name = "ID_B",
    referencedColumnName="ID"))
private Set<B> b;
