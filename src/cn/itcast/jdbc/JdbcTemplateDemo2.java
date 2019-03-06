package cn.itcast.jdbc;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo2 {
	
	//查询
	@Test
	public void query() {
		
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///Spring");
		dataSource.setUsername("root");
		dataSource.setPassword("lz123456");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		String sql = "select * from user where username=?";
		RowMapper<User> rowMapper = new MyRowMapper();
		User user = jdbcTemplate.queryForObject(sql, rowMapper ,"ccc");
		System.out.println(user + "..........." + user.getUsername() + "............" + user.getPassword());
	}
}


class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet arg0, int arg1) throws SQLException {
		String username = arg0.getString("username");
		String password = arg0.getString("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}

	


}
