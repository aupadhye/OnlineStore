package com.onlinestore.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/18/16
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginUser implements Serializable {

    private String userName;
    private boolean permissionToBuyStuff;

    public LoginUser(String userName, boolean permissionToBuyStuff) {
        this.userName = userName;
        this.permissionToBuyStuff = permissionToBuyStuff;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isPermissionToBuyStuff() {
        return permissionToBuyStuff;
    }

    public void setPermissionToBuyStuff(boolean permissionToBuyStuff) {
        this.permissionToBuyStuff = permissionToBuyStuff;
    }
}
