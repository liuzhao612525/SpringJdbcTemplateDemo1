package cn.itcast.jdbc;

import java.awt.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

	//添加
	@Test
	public void add() {
		
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///Spring");
		dataSource.setUsername("root");
		dataSource.setPassword("lz123456");
		
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		String sql = "insert into user value(?,?)";
		int rows = jdbcTemplate.update(sql, "ccc" ,"333");
		
		System.out.println(rows);
	}
	
	
	
	//更新
	@Test
	public void update() {
		
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///Spring");
		dataSource.setUsername("root");
		dataSource.setPassword("lz123456");
		
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		String sql = "update user set password=? where username=?";
		int rows = jdbcTemplate.update(sql, "5555555" ,"ccc");
		
		System.out.println(rows);
	}
	
	
	//删除
		@Test
		public void delete() {
			
			//设置数据库信息
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///Spring");
			dataSource.setUsername("root");
			dataSource.setPassword("lz123456");
			
			//创建jdbcTemplate对象，设置数据源
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			
			//调用jdbcTemplate对象里面的方法实现操作
			String sql = "delete from user where username=?";
			int rows = jdbcTemplate.update(sql, "ccc");
			
			System.out.println(rows);
		}
		
		
		
		
}
