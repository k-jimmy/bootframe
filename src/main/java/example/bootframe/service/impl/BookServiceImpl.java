package example.bootframe.service.impl;

import com.alibaba.fastjson.JSONObject;
import example.bootframe.service.BookService;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private static final String HEADER_NAME = "User-Agent";
    private static final String HEADER_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36";

    //搜索书本
    @Override
    public JSONObject searchBook(String url, String attr) {
        return JSONObject.parseObject(getHttpContent(url));
    }

    //获得目录
    @Override
    public JSONObject getCatalog(String url, String attr) {
        String result = getHttpContent(url);
        result = jsoupXML(result, "listmain");
        Map<String, Object> map = new HashMap<>();
        map.put("catalog", result);
        return new JSONObject(map);
    }

    //获得内容
    @Override
    public JSONObject getContent(String url, String attr) {
        String result = getHttpContent(url);
        String title = jsoupXML(result, attr + " h1");
        String content = jsoupXML(result, attr + " .showtxt");
        content = content.replace("<br>", "");
        String pre = jsoupXML(result, attr + " .page_chapter li:eq(0)");
        String next = jsoupXML(result, attr + " .page_chapter li:eq(2)");
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("content", content);
        map.put("pre", pre);
        map.put("next", next);
        return new JSONObject(map);
    }

    //获取html指定内容,解析html
    private String jsoupXML(String content, String attr) {
        Document doc = Jsoup.parse(content); // 解析网页 得到文档对象
        Elements elements = doc.select("." + attr);//需获得的标签及以下内容
        Element element = elements.get(0); // 获取第1个元素
        String result = element.html(); // 返回元素的文本
        return result;
    }


    /**
     * @param url    请求的地址
     * @return
     */
    private String getHttpContent(String url) {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        System.out.println(url);
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader(HEADER_NAME, HEADER_VALUE);
        CloseableHttpResponse response = null;
        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            //4.处理结果，这里将结果返回为字符串
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}