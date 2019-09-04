  public class Person {
      private String lastName;
      private String firstName;
      private boolean smoker;
      private int age;

      public String getFirstName() {
        return firstName;
      }
      public void setFirstName(String firstName) {
        this.firstName = firstName;
      }

      public String getLastName() {
        return lastName;
      }
      public void setLastName(String lastName) {
        this.lastName = lastName;
      }

      public int getAge() {
        return age;
      }
      public void setAge(int age) {
        this.age = age;
      }

      public boolean isSmoker() {
        return smoker;
      }
      public void setSmoker(boolean smoker) {
        this.smoker = smoker;
      }
  }
