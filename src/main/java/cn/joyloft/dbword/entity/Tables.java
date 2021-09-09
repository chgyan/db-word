package cn.joyloft.dbword.entity;

import lombok.Data;

@Data
public class Tables {
    private String name;
    private String comment;

    @Override
    public String toString() {
        return "Tables{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
