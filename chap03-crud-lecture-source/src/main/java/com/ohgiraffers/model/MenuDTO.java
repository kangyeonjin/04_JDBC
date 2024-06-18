package com.ohgiraffers.model;

public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderablestatus;

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderablestatus() {
        return orderablestatus;
    }

    public void setOrderablestatus(String orderablestatus) {
        this.orderablestatus = orderablestatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderablestatus='" + orderablestatus + '\'' +
                '}';
    }
}
