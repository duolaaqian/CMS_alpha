package org.webframe.core;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @function:不接受参数，无返回值，适用于create和drop table。
	 * @author luqian   下午10:35:59
	 */
	public void execute(String sql){
		jdbcTemplate.execute(sql);
	}
	
	public List<Map<String,Object>> queryForList(String sql){
		return jdbcTemplate.queryForList(sql);
	}
	
	public Map<String,Object> queryForMap(String sql){
		return jdbcTemplate.queryForMap(sql);
	}
	
	/**
	 * @function:sql中可以使用?，并传入任意参数，返回受影响的行数
	 * @author luqian   下午10:34:35
	 */
	public int update(String sql,Object ... params){
		return jdbcTemplate.update(sql,params);
	}
	
}
