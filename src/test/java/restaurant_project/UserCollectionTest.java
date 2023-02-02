package restaurant_project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserCollectionTest {

	private UserCollection uc;
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private int userId;
	private final int USERCOLLECTION_SIZE = 3;
	
	@BeforeEach
	void setUp() throws Exception {
		uc = new UserCollection();
		userId = (3);
		u1 = new User( 1, "james", "123","james@gmail.com", "97889009");
		u2 = new User( 2,  "Tommy", "123","Tommy@gmail.com", "97920384");
		u3 = new User( 3, "Pearl", "123","Pearl@gmail.com", "97328920");
		uc.addUser(u1);
		uc.addUser(u2);
		uc.addUser(u3);
		uc.getUsers();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUsers() {
		List<User> testuc = uc.getUsers();
		assertEquals(testuc.size(), USERCOLLECTION_SIZE);
	}

	@Test
	void testAddUser() {
		List<User> ucsize = uc.getUsers();
		//assert that song collection is equals to songs collection size 4
		assertEquals(ucsize.size(), USERCOLLECTION_SIZE);
		uc.addUser(u4);
		List<User> testuc = uc.getUsers();
		int totalFinalUsers = USERCOLLECTION_SIZE + 1;
		//Assert song collection is equals to song collection size 4+1
		assertEquals(testuc.size(), totalFinalUsers);
	}

	@Test
	void testFindUserById() {
		User testuc = uc.findUserById(userId);
		
		testuc = new User(1, "james", "123","james@gmail.com", "97889009");
		testuc = new User(3, "Pearl", "123","Pearl@gmail.com", "97328920");
		
		assertEquals(userId, testuc.id);
	}
		
	@Test
	void testDeleteUser() {
		assertEquals(uc.getUsers().size(),USERCOLLECTION_SIZE);
		uc.deleteUser(u1);
		assertEquals(uc.getUsers().size(),USERCOLLECTION_SIZE-1);
	}
	
	@Test
    public void testSettersGetters() {
        u1.setid();
        u1.setusername();
        u1.setpassword();
        u1.setemail();
        u1.setmobile_number();
         
        assertEquals(1, u1.getid());
        assertEquals("james", u1.getusername());
        assertEquals("123", u1.getpassword());
        assertEquals("james@gmail.com", u1.getemail());
        assertEquals("97889009", u1.getmobile_number());        
    }
	
	

}
