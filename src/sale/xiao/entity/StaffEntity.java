package sale.xiao.entity;

import java.util.List;

/**
 * 
 * <class description> 职工表
 * 
 * @author: harrytan
 * @version: 1.0, Mar 20, 2015
 */
public class StaffEntity {

    private int    id;

    private String email;

    private String name;

    private String sex;

    private String pwd;

    private String tel;

    private String introduction;

    private int    store_id;

    private int    is_delete;

    private int    role;



    public String getEmail() {
        return email;
    }



    public void setEmail(String pEmail) {
        email = pEmail;
    }



    public int getIs_delete() {
        return is_delete;
    }



    public void setIs_delete(int pIs_delete) {
        is_delete = pIs_delete;
    }



    public int getRole() {
        return role;
    }



    public void setRole(int pRole) {
        role = pRole;
    }



    public int getStore_id() {
        return store_id;
    }



    public void setStore_id(int pStore_id) {
        store_id = pStore_id;
    }

    private List<ProductEntity> products;



    public List<ProductEntity> getProducts() {
        return products;
    }



    public void setProducts(List<ProductEntity> pProducts) {
        products = pProducts;
    }



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



    public String getIntroduction() {
        return introduction;
    }



    public void setIntroduction(String pIntroduction) {
        introduction = pIntroduction;
    }

}
