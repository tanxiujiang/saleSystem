package sale.xiao.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sale.xiao.entity.AdminEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;
import sale.xiao.factory.SessionFactory;
import sale.xiao.mapper.AdminMapper;

/**
 * 
 * <class description> 管理员业务处理类
 * 
 * @author: harrytan
 * @version: 1.0, Mar 24, 2015
 */
public class AdminService {

    SqlSessionFactory sqlSessionFactory = null;
    SqlSession        session           = null;
    AdminMapper       adminMapper       = null;



    public AdminService() {
        sqlSessionFactory = SessionFactory.GetSqlSessionFactory();
        session = sqlSessionFactory.openSession();
        adminMapper = session.getMapper(AdminMapper.class);
    }



    /**
     * 
     * <method description> 管理员信息登录
     * 
     * @param email
     * @param pwd
     * @return
     */
    public boolean login(String email, String pwd) {
        AdminEntity admin = adminMapper.GetAdmin(email);
        if (null != admin && admin.getPwd().equals(pwd)) {
            return true;
        }

        return false;
    }



    /**
     * 
     * <method description> 添加职工记录
     * 
     * @param staff
     * @return
     */
    public boolean AddStaff(StaffEntity staff) {
        boolean b = false;
        try {
            b = adminMapper.AddStaff(staff);
        } catch (Exception e) {
            session.rollback();
            System.err.println("添加员工信息失败，执行回滚操作：" + e.getMessage());
        } finally {
            session.commit();
        }
        return b;
    }



    /**
     * 
     * <method description> 添加分店信息
     * 
     * @param store
     * @return
     */
    public boolean AddStore(StoreEntity store) {
        boolean b = false;
        try {
            b = adminMapper.AddStore(store);
        } catch (Exception e) {
            session.rollback();
            System.err.println("添加分店失败，执行回滚操作：" );
            e.printStackTrace();
        } finally {
            session.commit();
        }

        return b;
    }

    /**
     * 
    * <method description>
    * 管理员添加产品入库
    * @param product
    * @return
     */
    public boolean AddProducts(ProductEntity product){
        boolean b = false;
        try {
            b = adminMapper.AddProducts(product);
        } catch (Exception e) {
            session.rollback();
            System.err.print("添加商品入库失败,执行回滚操作");
            e.printStackTrace();
        }
        finally{
            session.commit();
        }
        
        return b;
    }
}