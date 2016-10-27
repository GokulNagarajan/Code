package com.mindtree.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindtree.entity.User;

public class UserDao {
	public JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	public int saveUser(User user)
	{
		String query="INSERT INTO USER (id,name,age) "
				+"values ('"+user.getId()+"','"+user.getName()+"','"+user.getAge()+"')";
		return jdbctemplate.update(query);
	}
	public int updateUser(User user)
	{
		String query="UPDATE USER "
				+"SET name = '"+user.getName()+"' , age = '"+user.getAge()
				+"' where id = '"+user.getId()+"'";
		return jdbctemplate.update(query);
	}
	public int deleteUser(User user)
	{
		String query="DELETE FROM USER "
				+"where id = '"+user.getId()+"'";
		return jdbctemplate.update(query);
	}
	public List<User> getAllUsers()
	{
		String query="Select * from user";
		return jdbctemplate.query(query, new ResultSetExtractor<List<User>>()
				{
				public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException{  
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User u=new User();  
			    u.setId(rs.getInt(1));  
		        u.setName(rs.getString(2));  
		        u.setAge(rs.getInt(3));  
		        list.add(u);  
		        }  
		        return list;  
				}
				});
	}
}
