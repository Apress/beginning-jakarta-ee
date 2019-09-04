    ...
    Member m = new Member();
    m.setFirstName(firstName);
    m.setLastName(lastName);
    m.setBirthday(birthday);
		
    Set<Status> status = new HashSet<>();
    status.add(new Status("Platinum"));
    status.add(new Status("Priority"));
    m.setStatus(status);
	
    em.persist(m);
    ...
