package example.bootframe.service;


import com.alibaba.fastjson.JSONObject;

public interface BookService {
    JSONObject searchBook(String url);
}
