package example.bootframe.service.impl;

import example.bootframe.entity.book.BookMark;
import example.bootframe.entity.book.BookShelf;
import example.bootframe.service.BookShelfService;

import java.util.List;

public class BookShelfServiceImpl implements BookShelfService {
    @Override
    public List<BookShelf> getList(Integer uid) {
        return null;
    }

    @Override
    public BookMark findOne(Integer bsid) {
        return null;
    }

    @Override
    public int add(BookShelf bookShelf) {
        return 0;
    }

    @Override
    public int edit(BookShelf bookShelf) {
        return 0;
    }

    @Override
    public int del(Integer id) {
        return 0;
    }
}
