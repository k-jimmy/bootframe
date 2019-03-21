package example.bootframe.service.impl;

import example.bootframe.entity.book.BookMark;
import example.bootframe.service.BookMarkService;

import java.util.List;

public class BookMarkServiceImpl implements BookMarkService {
    @Override
    public List<BookMark> getList(Integer uid, Integer bs_id) {
        return null;
    }

    @Override
    public BookMark findOne(Integer bmid) {
        return null;
    }

    @Override
    public int add(BookMark bookMark) {
        return 0;
    }

    @Override
    public int edit(BookMark bookMark) {
        return 0;
    }

    @Override
    public int del(Integer id) {
        return 0;
    }
}
