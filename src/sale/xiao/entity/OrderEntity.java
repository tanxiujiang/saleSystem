package sale.xiao.entity;

/**
 * 
 * <class description> 订单对象
 * 
 * @author: harrytan
 * @version: 1.0, Mar 27, 2015
 */
public class OrderEntity {
    private Integer id;
    private String product_id;
    private Integer staff_id;
    private Integer amount;
    private double   sell_price;
    private String  sell_date;



    public Integer getId() {
        return id;
    }



    public void setId(Integer pId) {
        id = pId;
    }





    public String getProduct_id() {
        return product_id;
    }



    public void setProduct_id(String pProduct_id) {
        product_id = pProduct_id;
    }



    public Integer getStaff_id() {
        return staff_id;
    }



    public void setStaff_id(Integer pStaff_id) {
        staff_id = pStaff_id;
    }



    public Integer getAmount() {
        return amount;
    }



    public void setAmount(Integer pAmount) {
        amount = pAmount;
    }

    public double getSell_price() {
        return sell_price;
    }



    public void setSell_price(double pSell_price) {
        sell_price = pSell_price;
    }



    public String getSell_date() {
        return sell_date;
    }



    public void setSell_date(String pSell_date) {
        sell_date = pSell_date;
    }
}
