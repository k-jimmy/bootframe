package example.bootframe.service;

import example.bootframe.entity.book.BookMark;
import example.bootframe.entity.book.BookShelf;

import java.util.List;

public interface BookShelfService {

    List<BookShelf> getList(Integer uid);

    BookMark findOne(Integer bsid);

    int add(BookShelf bookShelf);

    int edit(BookShelf bookShelf);

    int del(Integer id);
}
