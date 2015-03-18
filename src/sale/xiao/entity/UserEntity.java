package sale.xiao.entity;

/**
 * @description 系统角色
 * @author Administrator
 *
 */
public class UserEntity {

	// 主键
	private int id;

	// 角色
	private int role;

	// 名字
	private String name;

	// 密码
	private String pwd;

	// 邮箱
	private String email;

	// 介绍
	private String introduce;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
