package sale.xiao.mapper;

import java.awt.Stroke;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import sale.xiao.entity.AdminEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;

/**
 * 
* <class description>
*	管理员model	
* @author: harrytan
* @version: 1.0, Mar 24, 2015
 */
public interface AdminMapper {
    
    /**
     * 
    * <method description>
    *   加载管理员信息
    * @param email
    * @return
     */
    public AdminEntity GetAdmin(@Param("email") String email);
    
    /**
     * 
    * <method description>
    *   管理员添加商店
    * @param store
    * @return
     */
    public boolean AddStore(@Param("store")StoreEntity store);
    
    
    /**
     * 
    * <method description>
    *  管理员添加职工角色  外键存入商店主键
    * @param staff
    * @return
     */
    public boolean AddStaff(@Param("staff")StaffEntity staff);
    
    /**
     * 
    * <method description>
    *   添加产品入库
    * @param product
    * @return
     */
    public boolean AddProducts(@Param("product")ProductEntity product);
    
    
    /**
     * 
    * <method description>
    *  加载商店列表信息
    * @return
     */
    public List<StoreEntity> GetStores();
    
    
}
