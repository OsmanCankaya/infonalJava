package info.spring.maven.Service;


import info.spring.maven.Model.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;


@Repository
public class UserService implements IUserService{
	@Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "Users";
     
    /**
    * Adds a new user to database.
    * @param user The information of the person who will create.
    * @return  The created user.
    */
    public Users addUser(Users user) {
        if (!mongoTemplate.collectionExists(Users.class)) {
            mongoTemplate.createCollection(Users.class);
        }      
        user.setId(UUID.randomUUID().toString());
      mongoTemplate.insert(user, COLLECTION_NAME);
        
      	return user;
    }
     
    /**
     * Selects all users from database.
     * @return  List of users.
     */
    public List<Users> listUser() {
    	return mongoTemplate.findAll(Users.class, COLLECTION_NAME);
    }
     
    /**
     * Deletes a user from database.
     * @param id The identity of the user on database.
     * @return  The created person.
     */
    public void deleteUser(String id) {
    	DB db = mongoTemplate.getDb();
    	DBCollection collection = db.getCollection("Users");
    	BasicDBObject query = new BasicDBObject("_id", id);
    	collection.remove(query);
    }
     
    /**
     * Updates a user on database.
     * @param id The identity of the user
     * @param name The name of the user.
     * @param surname The surname of the user.
     * @param telephone The telephone of the user.
     */
    public void updateUser(String id, String name, String surname, String telephone) {
    	DB db = mongoTemplate.getDb();
    	DBCollection collection = db.getCollection("Users");
    	BasicDBObject newDocument = new BasicDBObject();
    	BasicDBObject query = new BasicDBObject("_id", id);
    	newDocument.put("name", name);
    	newDocument.put("surname", surname);
    	newDocument.put("phone", telephone);
    	  
        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        collection.update(query, updateObj, false, false);    	
    }

	
}
