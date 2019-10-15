package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

    @Id
    private String id;
    private String labelname;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐

    public String getId() {
        return id;
    }

    public String getLabelname() {
        return labelname;
    }

    public String getState() {
        return state;
    }

    public Long getCount() {
        return count;
    }

    public Long getFans() {
        return fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Label(String id, String labelname, String state, Long count, Long fans, String recommend) {
        this.id = id;
        this.labelname = labelname;
        this.state = state;
        this.count = count;
        this.fans = fans;
        this.recommend = recommend;
    }

    public Label() {
    }
}
