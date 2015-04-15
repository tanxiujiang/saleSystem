package sale.xiao.serviceInter;

import java.util.List;

import sale.xiao.entity.AdminEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;

/**
 * 
 * @author Administrator spring 接口注入
 */
public interface AdminServiceInter {

    public StaffEntity login(final AdminEntity admin);



    /**
     * 
     * <method description> 添加职工记录
     * 
     * @param staff
     * @return
     */
    public boolean AddStaff(StaffEntity staff);



    /**
     * 
     * <method description> 添加分店信息
     * 
     * @param store
     * @return
     */
    public boolean AddStore(StoreEntity store);



    /**
     * 
     * <method description> 管理员添加产品入库
     * 
     * @param product
     * @return
     */
    public boolean AddProducts(ProductEntity product);



    /**
     * 
     * <method description> 加载商店全部信息
     * 
     * @return
     */
    public String GetStores();



    /**
     * 
     * <method description> 加载职工列表
     * 
     * @return
     */
    public List<StaffEntity> GetStaffs(int pageNo, int pageSize);



    /**
     * 
     * <method description> 加载产品列表
     * 
     * @return
     */
    public List<ProductEntity> GetProducts(int pageNo, int pageSize);



    /**
     * 
     * <method description> 加载员工产品销售量
     * 
     * @param staffId
     * @return
     */
    public String LoadPerformanceByStaffId(String staffId);



    /**
     * 
     * <method description> 删除产品信息
     * 
     * @param id
     */
    public void DeleteProduct(String id);



    /**
     * 删除职工信息 <method description>
     * 
     * @param id
     */
    public void DeleteStaff(String id);



    /**
     * 模糊查询产品信息
     * 
     * @return
     */
    public List<ProductEntity> QueryProductsByLike(String name, int pageNo, int pageSize);



    /**
     * 职工模糊搜索查询
     * 
     * @param email
     * @return
     */
    public List<StaffEntity> QueryStaffsByLike(String email, int pageNo, int pageSize);



    /**
     * 
     * <method description> 获取产品记录总数
     * 
     * @return
     */
    public int GetProductsCount(String name);



    /**
     * 
     * <method description> 获取职工记录条数
     * 
     * @param email
     * @return
     */
    public int GetStaffCount(String email);
}
