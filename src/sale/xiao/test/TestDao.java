package sale.xiao.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import sale.xiao.entity.UserEntity;
import sale.xiao.factory.SessionFactory;
import sale.xiao.mapper.UserMapper;

public class TestDao {
	SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void initFactory() throws Exception
	{
		sqlSessionFactory = SessionFactory.GetSqlSessionFactory();
	}
	
	@Test
	public void GetUserList()
	{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserEntity> u = mapper.GetUserList();
		System.out.println(u.size());
	}
}
