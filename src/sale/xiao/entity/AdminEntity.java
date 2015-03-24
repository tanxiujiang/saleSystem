package sale.xiao.entity;

/**
 * 
* <class description>
*		管理员信息
* @author: harrytan
* @version: 1.0, Mar 24, 2015
 */
public class AdminEntity {
    private int id;
    private String name;
    private String email;
    private String pwd;
    public int getId() {
        return id;
    }
    public void setId(int pId) {
        id = pId;
    }
    public String getName() {
        return name;
    }
    public void setName(String pName) {
        name = pName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String pEmail) {
        email = pEmail;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pPwd) {
        pwd = pPwd;
    }
}
