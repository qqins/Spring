package edu.cqupt.eini.chapter09.po;

import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/17 11:13
 */
public class Orders {
    private Integer id;
    private String number;
    private List<Products> productsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", productsList=" + productsList +
                '}';
    }
}
