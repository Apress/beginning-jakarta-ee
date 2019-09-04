    @EJB
    private NameEjbLocal nameEjb;
    ...

    public String getGreetingTxt() {
        return nameEjb.hello("User");
    }
