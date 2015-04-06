package sale.xiao.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sale.xiao.entity.AdminEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;
import sale.xiao.factory.SessionFactory;
import sale.xiao.mapper.AdminMapper;
import sale.xiao.util.SaleUtil;

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
    public StaffEntity login(final AdminEntity admin) {
        StaffEntity o = adminMapper.GetAdmin(admin.getEmail());
        if (null != o && o.getPwd().equals(admin.getPwd())) {
            return o;
        }

        return null;
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
            System.err.println("添加分店失败，执行回滚操作：");
            e.printStackTrace();
        } finally {
            session.commit();
        }

        return b;
    }



    /**
     * 
     * <method description> 管理员添加产品入库
     * 
     * @param product
     * @return
     */
    public boolean AddProducts(ProductEntity product) {
        boolean b = false;
        try {
            b = adminMapper.AddProducts(product);
        } catch (Exception e) {
            session.rollback();
            System.err.print("添加商品入库失败,执行回滚操作");
            e.printStackTrace();
        } finally {
            session.commit();
        }

        return b;
    }



    /**
     * 
     * <method description> 加载商店全部信息
     * 
     * @return
     */
    public String GetStores() {
        List<StoreEntity> stores = adminMapper.GetStores();
        if (null != stores) {
            return SaleUtil.GetGsonStr(stores);
        }
        
        return SaleUtil.GetGsonStr("error");
    }
    
    /**
     * 
    * <method description>
    * 加载职工列表
    * @return
     */
    public List<StaffEntity> GetStaffs(){
        List<StaffEntity> stores = adminMapper.GetStaffs();
        return stores;
    }
    
    /**
     * 
    * <method description>
    * 加载产品列表
    * @return
     */
    public List<ProductEntity> GetProducts(){
        List<ProductEntity> products = adminMapper.GetProducts();
        return products;
    }
    
    /**
     * 
    * <method description>
    * 加载员工产品销售量
    * @param staffId
    * @return
     */
    public String LoadPerformanceByStaffId(String staffId){
        int id = Integer.valueOf(staffId);
        List<StaffEntity> staffs = adminMapper.GetPerformanceByStaffId(id);
        return SaleUtil.GetGsonStr(staffs);
    }
    
    /**
     * 
    * <method description>
    *   删除产品信息
    * @param id
     */
    public void DeleteProduct(String id){
        adminMapper.DeleteProduct(id);
        session.commit();
    }
    
    /**
     * 删除职工信息
    * <method description>
    *@param id
     */
    public void DeleteStaff(String id){
        int staffId = Integer.valueOf(id);
        adminMapper.DeleteStaff(staffId);
        session.commit();
    }
    
    /**
     * 模糊查询产品信息
     * @return
     */
    public List<ProductEntity> QueryProductsByLike(String name){
    	return adminMapper.QueryProductsByLike(name);
    }
    
    /**
     * 职工模糊搜索查询
     * @param email
     * @return
     */
    public List<StaffEntity> QueryStaffsByLike(String email){
    	return adminMapper.QueryStaffsByLike(email);
    }
 }
