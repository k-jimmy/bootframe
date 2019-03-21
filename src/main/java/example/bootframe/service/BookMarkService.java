package example.bootframe.service;

import example.bootframe.entity.book.BookMark;

import java.util.List;

public interface BookMarkService {

    List<BookMark> getList(Integer uid,Integer bs_id);

    BookMark findOne(Integer bmid);

    int add(BookMark bookMark);

    int edit(BookMark bookMark);

    int del(Integer id);
}
