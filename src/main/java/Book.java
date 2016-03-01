
public class Book {
 
  private int id;
  private String name;
  private String authors;
  private String userName;
  static int count;
  public boolean checkedOut;
  
  public Book(){ Book.count++;}
  
  public void setId(int newid){id = newid;}
  public int getId(){return id;}
  
  public void setName(String newName){name = newName;}
  public String getName(){return name;}
  
  public void setUserName(String newName){userName = newName;}
  public String getUserName(){return userName;}

  public void addAuthor(String newName){authors = newName;}
  public String getAuthors(){return authors;}
  
  
}

