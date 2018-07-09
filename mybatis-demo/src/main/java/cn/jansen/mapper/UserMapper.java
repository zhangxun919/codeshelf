package cn.jansen.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.jansen.pojo.User;

public interface UserMapper {
	
	@Select("select user_id userId, user_name userName, user_gender userGender, birthdate, address from user where user_id = #{userId}")
	public User selectUserById(int userId);
	
	@Insert("insert into user(user_name, user_gender, birthdate, address) values(#{userName}, #{userGender}, #{birthdate}, #{address})")
	public void insertUser(User user);
	
	@Update("update user set user_name = #{userName}, user_gender = #{userGender}, birthdate = #{birthdate}, address= #{address} where user_id = #{userId}")
	public void updateUserBuId(User user);
	
	@Delete("delete from user where user_id = #{userId}")
	public void deleteUserById(int userId);

}
