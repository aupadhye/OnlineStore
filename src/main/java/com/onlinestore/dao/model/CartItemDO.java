package com.onlinestore.dao.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/22/16
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CartItemDO {

    private String userName;
    private String itemCode;

    public CartItemDO(String userName, String itemCode) {
        this.userName = userName;
        this.itemCode = itemCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
