package sale.xiao.entity;

/**
 * 
* <class description>
*		商店
* @author: harrytan
* @version: 1.0, Mar 20, 2015
 */
public class StoreEntity {
    private String id;
    private String store_name;
    private String adress;
    private String introduce;



    public String getId() {
        return id;
    }



    public void setId(String pId) {
        id = pId;
    }



    public String getStore_name() {
        return store_name;
    }



    public void setStore_name(String pStore_name) {
        store_name = pStore_name;
    }



    public String getAdress() {
        return adress;
    }



    public void setAdress(String pAdress) {
        adress = pAdress;
    }



    public String getIntroduce() {
        return introduce;
    }



    public void setIntroduce(String pIntroduce) {
        introduce = pIntroduce;
    }
}
