package sale.xiao.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sale.xiao.entity.StaffEntity;
import sale.xiao.factory.SessionFactory;
import sale.xiao.mapper.StaffMapper;

/**
 * @descripton 用户信息逻辑处理
 * @author Administrator
 * 
 */
public class StaffService {

    // sqlSession工厂
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession        session           = null;
    StaffMapper       staffMapper       = null;



    public StaffService() {
        sqlSessionFactory = SessionFactory.GetSqlSessionFactory();
        session = sqlSessionFactory.openSession(true);
        staffMapper = session.getMapper(StaffMapper.class);
    }



    /**
     * @descripton 用户登录
     * @param name
     * @param pwd
     * @return
     */
    public int Login(String name, String pwd) {

        return 0;
    }



    /**
     * @descriptor:获取全部数据信息
     * @return
     */
    public List<StaffEntity> GetStafList() {

        List<StaffEntity> staffList = staffMapper.GetStaffList();
        return staffList;
    }



    /**
     * @descriptor:获取全部数据信息
     * @return
     */
    public StaffEntity GetStaffPerformanceById(String staffId) {
        StaffEntity staff = staffMapper.GetPerformanceByStaffId(Integer.valueOf(staffId));
        return staff;
    }



    /**
     * @descriptor:获取分页数据信息
     * @return
     */
    public List<StaffEntity> GetStafList(int pageSize) {

        return null;
    }



}
