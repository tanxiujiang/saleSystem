package sale.xiao.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import sale.xiao.entity.OrderEntity;
import sale.xiao.entity.ProductEntity;
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



    /**
     * 
     * <method description> 根据Id查询产品
     * 
     * @param productId
     * @return
     */
    public ProductEntity QueryProductById(String productId) {
        int id = Integer.valueOf(productId);
        ProductEntity product = staffMapper.GetProductById(id);
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
    public boolean AddOrderAndUpdateProductAmount(OrderEntity order, String qty) throws SQLException {

        // 事务工厂
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Transaction newTransaction = transactionFactory.newTransaction(session.getConnection());
        boolean b = false;
        try {
            staffMapper.AddOrder(order);
            staffMapper.UpdateProductAmount(order.getId(), Integer.valueOf(qty));
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

}
