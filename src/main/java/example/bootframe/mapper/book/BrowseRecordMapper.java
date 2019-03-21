package example.bootframe.mapper.book;

import example.bootframe.entity.book.BrowseRecord;
import example.bootframe.entity.book.BrowseRecordExample;
import example.bootframe.entity.book.BrowseRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrowseRecordMapper {
    int countByExample(BrowseRecordExample example);

    int deleteByExample(BrowseRecordExample example);

    int deleteByPrimaryKey(Integer bmId);

    int insert(BrowseRecordWithBLOBs record);

    int insertSelective(BrowseRecordWithBLOBs record);

    List<BrowseRecordWithBLOBs> selectByExampleWithBLOBs(BrowseRecordExample example);

    List<BrowseRecord> selectByExample(BrowseRecordExample example);

    BrowseRecordWithBLOBs selectByPrimaryKey(Integer bmId);

    int updateByExampleSelective(@Param("record") BrowseRecordWithBLOBs record, @Param("example") BrowseRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") BrowseRecordWithBLOBs record, @Param("example") BrowseRecordExample example);

    int updateByExample(@Param("record") BrowseRecord record, @Param("example") BrowseRecordExample example);

    int updateByPrimaryKeySelective(BrowseRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BrowseRecordWithBLOBs record);

    int updateByPrimaryKey(BrowseRecord record);
}