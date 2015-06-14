package deneme.spring.maven.model;


import junit.framework.TestCase;
import info.spring.maven.Model.Users;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserModelTest extends TestCase {

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
	public void test() {
		Users user=new Users();
		user.setName("deneme");
		user.setSurname("deneme2");
		user.setPhone("321654987");

		fail("Not yet implemented");
	}

}
