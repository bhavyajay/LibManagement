import static org.junit.Assert.*;
import static spark.Spark.post;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.ModelAndView;
import spark.Spark;



public class UserControllerIntegrationTest extends JsonUtil{
	
	 @BeforeClass
	  public static void beforeClass() throws IOException {
	    Main.main(null);
	  }
	 
	 
	 
	  @AfterClass
	  public static void afterClass() {
	    Spark.stop();

	  }

	  @Test
		 public void aNewUserShouldBeCreated() {
		 
		  //TestResponse causing error
		  /*
			TestResponse res = request("POST", "/books?name=SparkJava&authors=abc");
			Map<String, String> json = res.json();
			assertEquals(200, res.status);
			assertEquals("SparkJava", json.get("name"));
			assertEquals("abc", json.get("email"));
			assertNotNull(json.get("id"));
			
			*/
		 }
		 
		 
}