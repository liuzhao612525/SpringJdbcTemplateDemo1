package cn.itcast.jdbc;

import java.util.List;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo3 {
	
	//查询
	@Test
	public void query1() {
		
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///Spring");
		dataSource.setUsername("root");
		dataSource.setPassword("lz123456");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		String sql = "select * from user";
		List<User> users = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(users);
	}
}

