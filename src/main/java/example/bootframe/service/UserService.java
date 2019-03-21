package example.bootframe.service;

import example.bootframe.entity.book.User;

public interface UserService {

    User findOne(Integer bsid);

    int add(User user);

    int edit(User user);

    int del(Integer id);
}
