package sale.xiao.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import sale.xiao.entity.OrderEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;
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

    public void init(){
        sqlSessionFactory = SessionFactory.GetSqlSessionFactory(true);
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
        this.init();
        List<StaffEntity> staffList = staffMapper.GetStaffList();
        return staffList;
    }


    /**
     * @descriptor:根据商店编号去加载员工信息
     * @return
     */
    public List<StaffEntity> GetStafList(int store_id) {
        this.init();
        List<StaffEntity> staffList = staffMapper.loadStaffs(store_id);
        return staffList;
    }
    
    /**
     * 
    * <method description>
    * 加载商店下来列表信息
    * @return
     */
    public List<StoreEntity> GetStoreList(){
        this.init();
        List<StoreEntity> storeList = staffMapper.loadStores();
        return storeList;
    }
    
    /**
     * @descriptor:获取全部数据信息
     * @return
     */
    public StaffEntity GetStaffPerformanceById(String staffId) {
        this.init();
        StaffEntity staff = staffMapper.GetPerformanceByStaffId(Integer.valueOf(staffId));
        return staff;
    }



    /**
     * 
     * <method description> 根据Id查询产品
     * 
     * @param productId
     * @return
     */
    public ProductEntity QueryProductById(String productId) {
        this.init();
        ProductEntity product = null;
        try {
             product = staffMapper.GetProductById(productId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return product;
    }



    /**
     * 
     * <method description> 添加订单，修改产品是数量
     * 
     * @param order
     * @param qty
     * @return
     * @throws SQLException
     */
    public boolean AddOrderAndUpdateProductAmount(OrderEntity order) throws SQLException {
        this.init();
        // 事务工厂
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Transaction newTransaction = transactionFactory.newTransaction(session.getConnection());
        
        boolean b = false;
        try {
            staffMapper.AddOrder(order);
            staffMapper.UpdateProductAmount(order.getProduct_id(), order.getAmount());
            b = true;
        } catch (Exception e) {
            newTransaction.rollback();
            e.printStackTrace();
        } finally {
            session.commit();
            newTransaction.close();
        }

        return b;
    }

   /**
    * 根据员工编号加载产品销售量信息
    * @param staffId
    * @param queryDate
    * @return
    */
    public List<Map<String,Object>> loadStatisticByStaffId(String staffId,String queryDate){
    	this.init();
    	if(null != queryDate && !queryDate.equals("")){
    		return staffMapper.loadStatisticByStaffId(Integer.valueOf(staffId), queryDate);
    	}
    	else
    	{
    		return staffMapper.loadStatisticByStaffId(Integer.valueOf(staffId), null);
    	}
    }
    
    /**
     * 
    * <method description>
    * 根据月份查询统计每月各种产品的销售量和销售总金额
    * @param queryDate
    * @return
     */
    public List<Map<String,Object>> LoadProductStatisticsByMonth(String queryDate){
        this.init();
        return staffMapper.LoadProductStatisticsByMonth(queryDate);
    }
}
