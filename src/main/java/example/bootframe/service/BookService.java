package example.bootframe.service;


import com.alibaba.fastjson.JSONObject;

public interface BookService {
    String searchBook(String url, String attr);

    JSONObject getCatalog(String url, String attr);

    JSONObject getContent(String url, String attr);
}
