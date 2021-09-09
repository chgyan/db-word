package cn.joyloft.dbword.mapper;


import cn.joyloft.dbword.entity.TableFileds;
import cn.joyloft.dbword.entity.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QueryDao {

    /**
     * @return 某个库所有表名和注释 gateway_admin_stable为库名
     */
    @Select("select table_name as name,table_comment as comment from information_schema.tables where table_schema =#{dataName} order by table_name")
    List<Tables> getAllTables(@Param("dataName") String dataName);

    @Select("SHOW FULL FIELDS FROM ${tableName}")
    List<TableFileds> getTable(@Param("tableName") String tableName);

    @Select("SELECT database()")
    String getDatabase();


}
