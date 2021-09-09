package cn.joyloft.dbword.entity;

import lombok.Data;

@Data
public class TableFileds {

    private String field;//字段名
    private String type;//类型
    private String Null;//是否为空
    private String key;//主键
    private String comment;//字段说明

    @Override
    public String toString() {
        return "TableFileds{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", Null='" + Null + '\'' +
                ", key='" + key + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }


}
