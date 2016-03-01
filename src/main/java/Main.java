import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
 
    	System.out.println("in main");
    	new UserController(new UserService());

    }
}