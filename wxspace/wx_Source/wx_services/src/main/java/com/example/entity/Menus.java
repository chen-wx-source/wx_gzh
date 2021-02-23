package com.example.entity;

import java.io.Serializable;


public class Menus implements Serializable {
    private Integer id;

    private String menuName;

    private String icon;

    private String path;

    /**
     * 上级id
     */
    private Integer parentId;

    /**
     * 级数
     */
    private Integer level;

    private String remark;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", icon='" + icon + '\'' +
                ", path='" + path + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                ", remark='" + remark + '\'' +
                '}';
    }
}