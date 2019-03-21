package example.bootframe.mapper.book;

import example.bootframe.entity.book.BookMark;
import example.bootframe.entity.book.BookMarkExample;
import example.bootframe.entity.book.BookMarkWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMarkMapper {
    int countByExample(BookMarkExample example);

    int deleteByExample(BookMarkExample example);

    int deleteByPrimaryKey(Integer bmId);

    int insert(BookMarkWithBLOBs record);

    int insertSelective(BookMarkWithBLOBs record);

    List<BookMarkWithBLOBs> selectByExampleWithBLOBs(BookMarkExample example);

    List<BookMark> selectByExample(BookMarkExample example);

    BookMarkWithBLOBs selectByPrimaryKey(Integer bmId);

    int updateByExampleSelective(@Param("record") BookMarkWithBLOBs record, @Param("example") BookMarkExample example);

    int updateByExampleWithBLOBs(@Param("record") BookMarkWithBLOBs record, @Param("example") BookMarkExample example);

    int updateByExample(@Param("record") BookMark record, @Param("example") BookMarkExample example);

    int updateByPrimaryKeySelective(BookMarkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookMarkWithBLOBs record);

    int updateByPrimaryKey(BookMark record);
}