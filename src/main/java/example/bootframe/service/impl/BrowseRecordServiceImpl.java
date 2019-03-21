package example.bootframe.service.impl;

import example.bootframe.entity.book.BrowseRecord;
import example.bootframe.service.BrowseRecordService;

import java.util.List;

public class BrowseRecordServiceImpl implements BrowseRecordService {
    @Override
    public List<BrowseRecord> getList(Integer uid) {
        return null;
    }

    @Override
    public BrowseRecord findOne(String url) {
        return null;
    }

    @Override
    public int add(BrowseRecord browseRecord) {
        return 0;
    }

    @Override
    public int edit(BrowseRecord browseRecord) {
        return 0;
    }

    @Override
    public int del(Integer id) {
        return 0;
    }
}
