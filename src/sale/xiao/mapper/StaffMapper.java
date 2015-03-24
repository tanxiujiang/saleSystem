package sale.xiao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import sale.xiao.entity.StaffEntity;

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
	
	
	
}
