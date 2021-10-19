package com.Jingyalin.entity;



import java.io.Serializable;
import java.util.List;



public class Menu implements Serializable {

    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    /**
     * 主键
     */
    private Integer id;

    /**
     * 父级菜单ID
     */
    private Integer pid;

    /**
     * 类型[topmenu/leftmenu/permission]
     */
    private String type;

    /**
     * topmenu:system/business
permission:menu:addMenu

     */
    private String typecode;

    /**
     * 名称
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 连接地址
     */
    private String href;

    private String target;

    /**
     * 是否展开
     */
    private Integer spread;

    /**
     * 排序码
     */
    private Integer ordernum;

    /**
     * 状态【0不可用1可用】
     */
    private Integer available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}