package sale.xiao.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;
import sale.xiao.factory.SessionFactory;
import sale.xiao.mapper.StaffMapper;
import sale.xiao.service.AdminService;
import sale.xiao.util.SaleUtil;

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
	
	@Test
	public void AddStore(){
	    AdminService admin = new AdminService();
	    StoreEntity s = new StoreEntity();
	    s.setAddress("成都西门车站");
	    s.setIntroduce("中国100强");
	    s.setStore_name("红旗超市2");
	    admin.AddStore(s);
	}
	
	@Test
	public void Addproduct(){
	    AdminService admin = new AdminService();
	    ProductEntity p = new ProductEntity();
	    p.setFactory_price(120);
	    p.setSell_price(150);
	    p.setTotal_amount(100);
	    p.setRemain_amount(100);
	    p.setIntroduction("跳楼价，赶紧抢购吧。");
	    p.setProduct_name("纯棉超薄羽绒服");
	    p.setImage_url("");
	    admin.AddProducts(p);
	}
	
	@Test
	public void GetMap(){
	    SqlSession session = sqlSessionFactory.openSession();
        StaffMapper mapper = session.getMapper(StaffMapper.class);
        List<Map<String,Object>> map = mapper.loadStatisticByStaffId(10,null);
        System.out.println(SaleUtil.GetGsonStr(map));
	}
	
}
