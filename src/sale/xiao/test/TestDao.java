package sale.xiao.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import sale.xiao.entity.StaffEntity;
import sale.xiao.factory.SessionFactory;
import sale.xiao.mapper.StaffMapper;

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
		StaffMapper mapper = session.getMapper(StaffMapper.class);
		List<StaffEntity> u = mapper.GetStaffList();
		System.out.println(u.size());
	}
	
	@Test
	public void GetPerformanceByStaffId()
	{
	    SqlSession session = sqlSessionFactory.openSession();
        StaffMapper mapper = session.getMapper(StaffMapper.class);       
        StaffEntity staff = mapper.GetPerformanceByStaffId(1);
        
	}
	
}
