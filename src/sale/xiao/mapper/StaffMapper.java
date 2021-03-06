package sale.xiao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import sale.xiao.entity.OrderEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;

/**
 * 
* <class description>
*		
* @author: harrytan
* @version: 1.0, Mar 20, 2015
 */
public interface StaffMapper {
	public List<StaffEntity> GetStaffList();
	public List<StaffEntity> GetStaffById(@Param("id")Integer id);
	public List<StaffEntity> GetStaffByName(@Param("name")String name);
	
	/**
	 * 
	* <method description>
	* 查询职工业绩
	* @param id
	* @return
	 */
	public StaffEntity GetPerformanceByStaffId(@Param("id")Integer id);
	
	/**
	 * 
	* <method description>
	* 根据条形码查询产品信息
	* @param id
	* @return
	 */
	public ProductEntity GetProductById(@Param("id")String id);
	
	/**
	 * 
	* <method description>
	* 卖出产品，更新产品的库存状态
	* @param id    主键
	* @param qty   销售数量
	* @return  
	 */
	public int UpdateProductAmount(@Param("id")String id,@Param("qty")Integer qty);
	
	/**
	 * 
	* <method description>
	* 添加订单
	* @param order
	* @return
	 */
	public int AddOrder(@Param("order")OrderEntity order);
	
	/**
	 * 
	* <method description>
	*  查询商店名称列表
	* @return
	 */
	public List<StoreEntity> loadStores();
	
	/**
	 * 
	* <method description>
	* 加载每个商店的员工信息
	* @return
	 */
	public List<StaffEntity> loadStaffs(@Param("store_id")int store_id);
	
	/**
	 * 
	* <method description>
	*  根据月份和人员id查询统计
	* @return
	 */
	public List<Map<String,Object>> loadStatisticByStaffId(@Param("staff_id")int staff_id,@Param("queryDate")String queryDate );
	
	/**
	 * 
	* <method description>
	* 根据月份加载产品统计
	* @param queryDate
	* @return
	 */
	public List<Map<String,Object>> LoadProductStatisticsByMonth(@Param("queryDate")String queryDate);
}
