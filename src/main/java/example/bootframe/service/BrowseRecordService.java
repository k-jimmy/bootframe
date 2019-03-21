package example.bootframe.service;

import example.bootframe.entity.book.BookMark;
import example.bootframe.entity.book.BookShelf;
import example.bootframe.entity.book.BrowseRecord;

import java.util.List;

public interface BrowseRecordService {

    List<BrowseRecord> getList(Integer uid);

    BrowseRecord findOne(String url);

    int add(BrowseRecord browseRecord);

    int edit(BrowseRecord browseRecord);

    int del(Integer id);
}
