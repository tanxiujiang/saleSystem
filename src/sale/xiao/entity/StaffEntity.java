package sale.xiao.entity;

/**
 * 
* <class description>
*	职工表	
* @author: harrytan
* @version: 1.0, Mar 20, 2015
 */
public class StaffEntity {

    private int    id;

    private String name;

    private String sex;

    private String pwd;

    private String tel;

    private String introduce;



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



    public String getSex() {
        return sex;
    }



    public void setSex(String pSex) {
        sex = pSex;
    }



    public String getPwd() {
        return pwd;
    }



    public void setPwd(String pPwd) {
        pwd = pPwd;
    }



    public String getTel() {
        return tel;
    }



    public void setTel(String pTel) {
        tel = pTel;
    }



    public String getIntroduce() {
        return introduce;
    }



    public void setIntroduce(String pIntroduce) {
        introduce = pIntroduce;
    }

}