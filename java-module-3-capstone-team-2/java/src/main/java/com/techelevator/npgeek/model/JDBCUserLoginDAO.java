package com.techelevator.npgeek.model;
import javax.sql.DataSource;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



public class JDBCUserLoginDAO {

	@Component
	public class JDBCUserDAO implements UserDAO {
	private JdbcTemplate jdbcTemplate;
    private PasswordHasher passwordHasher;
		
		/*************************
		 * UserLoginDAO AUTOWIRE *
		 ************************/
		
		@Autowired
		public JDBCUserDAO(DataSource dataSource, PasswordHasher passwordHasher) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.passwordHasher = passwordHasher; 
		}
		@Override
		public User saveUser(String userName, String password, String hint, String email) {
		
			byte[] salt = passwordHasher.generateRandomSalt();
	        String hashedPassword = passwordHasher.computeHash(password, salt);
	        String saltString = new String(Base64.encode(salt));
	        long newId = jdbcTemplate.queryForObject(
	                "INSERT INTO users(username, password, hint, email, salt) VALUES (?, ?, ?, ?, ?) RETURNING id", Long.class,
	                userName, hashedPassword, hint, email, saltString);

	        User newUser = new User();
	        newUser.setUserID(newId);
	        newUser.setUserName(userName);
	        newUser.setPasswordHint(hint);
	        newUser.setEmail(email);
	        
	        return newUser;
			
			
			
		}
		@Override
	    public User getValidUserWithPassword(String userName, String password) {
	        String sqlSearchForUser = "SELECT * FROM users WHERE UPPER(username) = ?";

	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase());
	        if (results.next()) {
	            String storedSalt = results.getString("salt");
	            String storedPassword = results.getString("password");
	            String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
	            if (storedPassword.equals(hashedPassword)) {
	                return mapResultToUser(results);
	            } else {
	                return null;
	            }
	        } else {
	            return null;
	        }
		}
		@Override
		public User getPasswordHint(String userName) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String changePassword(String userName, String password) {
			// TODO Auto-generated method stub
			return null;
		}
	
		 private User mapResultToUser(SqlRowSet results) {
		        User user = new User();
		        user.setUserID(results.getLong("id"));
		        user.setUserName(results.getString("username"));
		        user.setPasswordHint(results.getString("hint"));
		        user.setEmail(results.getString("email"));
		        return user;
		    }
}
}

