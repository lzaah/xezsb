package cn.entity;

/**
 * Created by 维吉的笔记本 on 2018/6/12.
 */
public class Takeout {
    private Integer id;
    private Integer quantity;
    private String outdate;
    private String hanfler;
    private Integer productid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOutdate() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }

    public String getHanfler() {
        return hanfler;
    }

    public void setHanfler(String hanfler) {
        this.hanfler = hanfler;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
