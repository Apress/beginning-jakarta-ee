... (inside the Calypso class!)
private static class Member 
      implements Comparable<Member>{
  public String firstName;
  public String lastName;
  public String birthday;
  public int id;
  public static Member UNKNOWN = 
        new Member("","","",0);
  public Member(String firstName, 
        String lastName, String birthday, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.id = id;
  }
  @Override
  public int compareTo(Member o) {
    if(o.birthday.compareTo(birthday) != 0)
      return o.birthday.compareTo(birthday);
    if(o.lastName.compareTo(lastName) != 0)
      return -o.lastName.compareTo(lastName);
    return -o.firstName.compareTo(firstName);
  }
}
...
