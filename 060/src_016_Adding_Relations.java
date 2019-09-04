@OneToMany
@JoinColumn(name="ID_A")  // In table B!
private Set<B> b;
