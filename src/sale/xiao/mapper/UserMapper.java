package sale.xiao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sale.xiao.entity.UserEntity;

public interface UserMapper {
	public List<UserEntity> GetUserList();
	public List<UserEntity> GetUserById(@Param("id")Integer id);
	public List<UserEntity> GetUserByName(@Param("name")String name);
}
