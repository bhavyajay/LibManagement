import static spark.Spark.*;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;


public class UserController extends JsonUtil
{
	
	int user_id = 0;
	public UserController(final UserService userService) throws IOException
	{
		
		 // Configure that static files directory.
    	Spark.staticFileLocation("/public");
 
        // This will configure the view directory.
        Configuration viewDir = new Configuration();
        viewDir.setClassForTemplateLoading(Main.class, "/views");
 
     
       //create user
        post("/users", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            userService.createUser(request.body());
            //viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "index.ftl");
        }, new FreeMarkerEngine(viewDir));
	
        //update user
        post("/update", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            userService.updateUser(request.body(), user_id);
            //viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "index.ftl");
        }, new FreeMarkerEngine(viewDir));
	
        //specify user to update
        post("/users/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            User user = userService.getUser(request.body());
            user_id = user.getId();
            model.put("id", user.getId());
            model.put("firstName", user.getFirstName());
            model.put("middleName", user.getMiddleName());
            model.put("lastName", user.getLastName());
            model.put("age", user.getAge());
            model.put("gender", user.getGender());
            model.put("phone", user.getPhone());
            model.put("zip", user.getZip());
            viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "DisplayUser.ftl");
        }, new FreeMarkerEngine(viewDir));
	
        //home page
        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            response.type("text/html");
            viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "index.ftl");
        }, new FreeMarkerEngine(viewDir));
		
        //user list
      /*  get("/users", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<User> userList = userService.getAllUsers();
            model.put( "userList", userList );
            viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "UserList.ftl");
        }, new FreeMarkerEngine(viewDir));
       */ 
        get("/users", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<User> userList = userService.getAllUsers();
            Collections.sort(userList);
            model.put( "userList", userList );
            viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "UserList.ftl");
        }, new FreeMarkerEngine(viewDir));
		
        //book list
        get("/books", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Book> bookList = userService.getAllBooks();
            model.put( "bookList", bookList );
            viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "BookList.ftl");
        }, new FreeMarkerEngine(viewDir));
		
        //create book
        post("/books", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
			try {
				userService.addBook(request.body());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			viewDir.setClassForTemplateLoading(Main.class, "/views");
			return new ModelAndView(model, "index.ftl");
        }, new FreeMarkerEngine(viewDir));
		
        // find book by name
        post("/books/:name", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            Book book;
			try {
				book = userService.findBookByName(request.body());
				model.put("id", book.getId());
	            model.put("name", book.getName());
	            System.out.println(book.getAuthors());
	            model.put("authors", book.getAuthors());
	            model.put("userName", book.getUserName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//viewDir.setClassForTemplateLoading(Main.class, "/views");
            return new ModelAndView(model, "DisplayBook.ftl");
        }, new FreeMarkerEngine(viewDir));
		
	//checkout book
		post("/checkedOut", (req, res) -> userService.checkOutBook(req.body()), json());
		
		}
}