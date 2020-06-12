package com.dwsoft.admin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tlk
 * @date 2020/5/25-10:40
 */
public class Menu {
    private Integer id;
    private Integer pid;
    private  String name;
    private List<Menu>child=new ArrayList<Menu>();

    public Menu() {
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    } @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", child=" + child +
                '}';
    }


}
