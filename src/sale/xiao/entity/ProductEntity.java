package sale.xiao.entity;

/**
 * 
* <class description>
*		产品表
* @author: harrytan
* @version: 1.0, Mar 20, 2015
 */
public class ProductEntity {
    private String    id;
    private String product_name;
    private double factory_price;
    private double sell_price;
    private int    total_amount;
    private int    remain_amount;
    private int    group_amount;
    private String introduction;
    private String image_url;
    
    public int getGroup_amount() {
		return group_amount;
	}



	public void setGroup_amount(int group_amount) {
		this.group_amount = group_amount;
	}


    public String getId() {
        return id;
    }



    public void setId(String pId) {
        id = pId;
    }



    public String getProduct_name() {
        return product_name;
    }



    public void setProduct_name(String pProduct_name) {
        product_name = pProduct_name;
    }



    public double getFactory_price() {
        return factory_price;
    }



    public void setFactory_price(double pFactory_price) {
        factory_price = pFactory_price;
    }



    public double getSell_price() {
        return sell_price;
    }



    public void setSell_price(double pSell_price) {
        sell_price = pSell_price;
    }



    public int getTotal_amount() {
        return total_amount;
    }



    public void setTotal_amount(int pTotal_amount) {
        total_amount = pTotal_amount;
    }



    public int getRemain_amount() {
        return remain_amount;
    }



    public void setRemain_amount(int pRemain_amount) {
        remain_amount = pRemain_amount;
    }



    public String getIntroduction() {
        return introduction;
    }



    public void setIntroduction(String pIntroduction) {
        introduction = pIntroduction;
    }



    public String getImage_url() {
        return image_url;
    }



    public void setImage_url(String pImage_url) {
        image_url = pImage_url;
    }
}
