package deneme.spring.maven.controller;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import info.spring.maven.Controller.HomeController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;


public class UserControllerTest {

	  HomeController con=new HomeController();
	//  private UserService usersService=null;
	  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void userListTest() {
		
		
		con.getUserLists(new Model() {
			
			@Override
			public Model mergeAttributes(Map<String, ?> arg0) {
				fail("Not yet implemented");
				return null;
			}
			
			@Override
			public boolean containsAttribute(String arg0) {
				fail("Not yet implemented");
				return false;
			}
			
			@Override
			public Map<String, Object> asMap() {
				fail("Not yet implemented");
				return null;
			}
			
			@Override
			public Model addAttribute(String arg0, Object arg1) {
				fail("Not yet implemented");
				return null;
			}
			
			@Override
			public Model addAttribute(Object arg0) {
				fail("Not yet implemented");
				return null;
			}
			
			@Override
			public Model addAllAttributes(Map<String, ?> arg0) {
				fail("Not yet implemented");
				return null;
			}
			
			@Override
			public Model addAllAttributes(Collection<?> arg0) {
				fail("Not yet implemented");
				return null;
			}
		});
		fail("Not yet implemented");
	}
	
	@Test
	public void addUserTest(Model model,HttpServletRequest req){
	req=null;	
	con.addUser(req);
	fail("Not yet implemented");
	
}
	@Test
	public void deleteUser(HttpServletRequest req){

		req.getParameter("123");
		con.deleteUser(req);
		fail("Not yet implemented");
	}
	@Test
	public void updateUser(HttpServletRequest req){
		
		req.getParameter("0");
		con.updateUser(req);
	fail("Not yet implemented");
	}
	
	
}
