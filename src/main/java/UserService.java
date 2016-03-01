import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UserService {
	
	List<User> userList = new ArrayList<User>();
	List<Book> bookList = new ArrayList<Book>();
	

	// returns a list of all users
	public List<User> getAllUsers() 
	{  
		//System.out.println("in get");
		return userList;
	}
	
	// creates a new user
	public User createUser(String request_data) 
	{
		User user = new User();
		int id = User.count;
		user.setId(id);
		String[] args_list = request_data.split("&");
		List<String> arguments = Arrays.asList(args_list);
		
		Iterator<String> iterator = arguments.iterator(); 
		user.setMiddleName(" ");user.setZip(" ");
		 while(iterator.hasNext())
		 {
			 
			 String[] value = iterator.next().split("=");
			 if(value[0].equals("first_name")){user.setFirstName(value[1]);}
			 if(value[0].equals("middle_name") && value.length!=1)
			 {user.setMiddleName(value[1]);}
			 if(value[0].equals("last_name")){user.setLastName(value[1]);}
			 if(value[0].equals("age")){user.setAge(value[1]);}
			 if(value[0].equals("gender")){user.setGender(value[1]);}
			 if(value[0].equals("phone")){user.setPhone(value[1]);}
			 if(value[0].equals("zip") && value.length!=1){user.setZip(value[1]);}	
			
		 }
		 
		userList.add(user);
		return user;				
	}
	
	
	// updates an existing user
	public User updateUser(String request_data, int user_id) 
	{
		//System.out.println(request_data);
		String[] args_list = request_data.split("&");
		
		int id = user_id;
		 Iterator<User> iterator = userList.iterator(); 
		 while(iterator.hasNext())
		 {
			User user = iterator.next();
			if(user.getId() == id)
			{
				for(int i=0;i<args_list.length;i++)
				 {
					 String[] value = args_list[i].split("=");
					 if(value[0].equals("first_name") && value.length!=1){user.setFirstName(value[1]);}
					 if(value[0].equals("middle_name") && value.length!=1){user.setMiddleName(value[1]);}
					 if(value[0].equals("last_name")&& value.length!=1){user.setLastName(value[1]);}
					 if(value[0].equals("age")&& value.length!=1){user.setAge(value[1]);}
					 if(value[0].equals("gender")&& value.length!=1){user.setGender(value[1]);}
					 if(value[0].equals("phone")&& value.length!=1){user.setPhone(value[1]);}
					 if(value[0].equals("zip")&& value.length!=1){user.setZip(value[1]);}	 
				 }
			
				 return user;
			}	
		 }
		return null;
	
	}
	
	public User getUser(String request_data) 
	{
		String[] args_list = request_data.split("&");
		String[] id_key_value = args_list[0].split("=");
		String s_id = id_key_value[1];
		int id = Integer.parseInt(s_id);
	
		 Iterator<User> iterator = userList.iterator(); 
		 while(iterator.hasNext())
		 {
			User user = iterator.next();
			
			if(user.getId() == id)
			{
				 return user;
			}	
		 }
		return null;
		
	}
	
	// returns a list of all books
		public List<Book> getAllBooks() 
		{  
			//System.out.println("in get");
			return bookList;
		}
	
		// creates a new book
		public Book addBook(String request_data) throws UnsupportedEncodingException 
		{
			Book book = new Book();
			int id = Book.count;
			book.setId(id);
			String[] args_list = request_data.split("&");
			List<String> arguments = Arrays.asList(args_list);
			
			Iterator<String> iterator = arguments.iterator(); 
			 while(iterator.hasNext())
			 {
				 
				 String[] value = iterator.next().split("=");
				 if(value[0].equals("name") && value.length!=1)
				 {
					 String result = java.net.URLDecoder.decode(value[1], "UTF-8");
					 book.setName(result); 
				 }
				 if(value[0].equals("user_name") && value.length!=1){book.setUserName(value[1]);}
				 if(value[0].equals("authors") && value.length!=1)
				 {
					 String result = java.net.URLDecoder.decode(value[1], "UTF-8");
					 //System.out.println(result);
					 book.addAuthor(result);
				 }
				 book.setUserName(" ");
			 }
			 
			bookList.add(book);
			return book;				
		}
		
		//	findBookByName
		public Book findBookByName(String request_data) throws UnsupportedEncodingException 
		{
			String name[] = request_data.split("=");
			 String result = java.net.URLDecoder.decode(name[1], "UTF-8");

			Iterator<Book> iterator = bookList.iterator(); 
			 while(iterator.hasNext())
			 {
				Book book = iterator.next();
				if(book.getName().equals(result)){return book;}
			 }
			return null;
			
		}
		
		
//		check out a book
			public String checkOutBook(String request_data) 
			{
				String arguments[] = request_data.split("&");
				String[] user_id = arguments[1].split("=");
				String[] book_id = arguments[0].split("=");
				int b_id = Integer.parseInt(book_id[1]);
				int u_id = Integer.parseInt(user_id[1]);
				
				Iterator<Book> iterator = bookList.iterator(); 
				 while(iterator.hasNext())
				 {
					Book book = iterator.next();
					if(book.getId() == b_id)
					{
						if(!book.checkedOut)
						{
							Iterator<User> uiterator = userList.iterator(); 
							 while(uiterator.hasNext())
							 {
								User user = uiterator.next();
								if(user.getId() == u_id)
								{
									String user_name = user.getFirstName()+" "+user.getLastName();
									book.setUserName(user_name);
									book.checkedOut = true;
									return ("Book successfully checked out!");
								}
								
							 }
							
						}
						else
							return ("Book already checked out!");
						
					}
				 }
				return ("No such user or book!");
			
				
			}
			
}
