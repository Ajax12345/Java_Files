public class Leader implements Comparable <Leader> {
  private String firstName;
  private String lastName;

  /** Initialize a Leader
      @param first firstName
      @param last lastName
    */
  public Leader(String first, String last) {
	  firstName = first;
	  lastName = last;
  }

  /** Mutator Method
      @param aName firstName
    */
  public void setFirstName(String aName) {
	  firstName = aName;
  }

  /** Accessor Method
      @return firstName of this Student
    */
  public String getFirstName() {
	  return firstName;
  }

  /** Mutator Method
      @param aName lastName
    */
  public void setLastName(String aName) {
  	  lastName = aName;
    }

  /** Accessor Method
      @return lastName of this Student
    */
  public String getLastName() {
  	  return lastName;
  }

  @Override
  public String toString() {
	  String str = "";
	  str += (lastName + "," + firstName);
	  return str;
  }

  /* this version overloads the equals method (note the
     signature of this method).
   */
  public boolean equals(Leader s) {
  	  return ( (this.lastName.equalsIgnoreCase(s.lastName)) &&
  	           (this.firstName.equalsIgnoreCase(s.firstName)));

  }

  /* We need to override this method so indexOf and
     contains methods work.  Both of them use this version
     equals method
   */
  @Override
  public boolean equals(Object obj) {
	     if (obj == null) return false;
	     if (obj == this) return true;
	     if (!(obj instanceof Leader)) return false;
	     else {
			 Leader s = (Leader) obj;
			 return ( this.equals(s));  // calls the equals(Student) method
	     }
  }

  /**
    @return
    a negative integer if "s1 < s2"; 0 if "s1 == s2"
    a positive integer if "s1 > s2"
  */
  @Override
  public int compareTo(Leader s) {
	  int result = lastName.compareToIgnoreCase(s.lastName);
	  if (result != 0) return result;
	  else
		  return (firstName.compareToIgnoreCase(s.firstName));
  }
}
