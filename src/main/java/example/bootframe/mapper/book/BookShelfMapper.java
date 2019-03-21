package example.bootframe.mapper.book;

import example.bootframe.entity.book.BookShelf;
import example.bootframe.entity.book.BookShelfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookShelfMapper {
    int countByExample(BookShelfExample example);

    int deleteByExample(BookShelfExample example);

    int deleteByPrimaryKey(Integer bsId);

    int insert(BookShelf record);

    int insertSelective(BookShelf record);

    List<BookShelf> selectByExampleWithBLOBs(BookShelfExample example);

    List<BookShelf> selectByExample(BookShelfExample example);

    BookShelf selectByPrimaryKey(Integer bsId);

    int updateByExampleSelective(@Param("record") BookShelf record, @Param("example") BookShelfExample example);

    int updateByExampleWithBLOBs(@Param("record") BookShelf record, @Param("example") BookShelfExample example);

    int updateByExample(@Param("record") BookShelf record, @Param("example") BookShelfExample example);

    int updateByPrimaryKeySelective(BookShelf record);

    int updateByPrimaryKeyWithBLOBs(BookShelf record);

    int updateByPrimaryKey(BookShelf record);
}