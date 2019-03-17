package example.bootframe.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TableMapper {
    @Select("select table_name from information_schema.TABLES where TABLE_SCHEMA=(select database())")
    List<Map> listTable();
}
