public class User implements Comparable{
 
  private int user_id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String age;
  private String gender;
  private String phone;
  private String zip;
  static int count = 0;

  public User(){ User.count++;}
  
  public void setId(int newid){user_id = newid;}
  public int getId(){return user_id;}
  
  public void setFirstName(String newName){firstName = newName;}
  public String getFirstName(){return firstName;}
  
  public void setMiddleName(String newName){middleName = newName;}
  public String getMiddleName(){return middleName;}

  public void setLastName(String newName){lastName= newName;}
  public String getLastName(){return lastName;}
  
  public void setAge(String newAge){age = newAge;}
  public String getAge(){return age;}
  
  public void setGender(String newGender){gender = newGender;}
  public String getGender(){return gender;}
  
  public void setPhone(String newPhone){phone = newPhone;}
  public String getPhone(){return phone;}
  
  public void setZip(String newZip){zip = newZip;}
  public String getZip(){return zip;}

@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	
	if(o instanceof User)
	{
		String name1 = this.getFirstName();
		String name2 = ((User) o).getFirstName();
		return (name1.compareTo(name2));
	}
	return -1;
}
  
  
  
}

