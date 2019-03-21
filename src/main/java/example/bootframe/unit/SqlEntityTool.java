package example.bootframe.unit;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class SqlEntityTool {
    private final static File FILE = new File("src/main/resources/mybatis/generatorConfig.xml");

    /**
     * @param list  查询数据库的结果集
     * @param index 需要进行的操作 0:不操作,1:删掉第一个下划线左边,2:删掉最后一个下划线右边,3:删掉第一个和最后一个下划线的两边
     * @throws Exception
     */
    public static void getTableMap(List<Map> list, int index) throws Exception {
        Map<String, String> map = new TreeMap<>();
        for (Map m : list) {
            String key = m.get("table_name") + "";
            String value = key;
            //名称裁剪
            if (index == 1) {
                value = value.substring(value.indexOf("_") + 1);
            }
            if (index == 2) {
                value = value.substring(0, value.lastIndexOf("_"));
            }
            if (index == 3) {
                value = value.substring(value.indexOf("_") + 1, value.lastIndexOf("_"));
            }
            //首字母大写
            value = value.substring(0, 1).toUpperCase() + value.substring(1);
            //驼峰命名
            if (value.indexOf("_") > 0) {
                value = getStr(value);
            }
            map.put(key, value);
        }

        xmlToString(map);
    }

//    /**
//     * 使用 Map按key进行排序
//     *
//     * @param map
//     * @return
//     */
//    public static Map<String, String> sortMapByKey(Map<String, String> map) {
//        if (map == null || map.isEmpty()) {
//            return null;
//        }
//
//        Map<String, String> sortMap = new TreeMap<String, String>(
//                new MapKeyComparator());
//
//        sortMap.putAll(map);
//
//        return sortMap;
//    }
//
//    /**
//     * 比较器类
//     */
//    static class MapKeyComparator implements Comparator<String> {
//
//        @Override
//        public int compare(String str1, String str2) {
//
//            return str1.compareTo(str2);
//        }
//    }

    /**
     * 驼峰命名
     *
     * @param value
     * @return
     */
    private static String getStr(String value) {
        if (value.contains("_")) {
            int i = value.indexOf("_");
            value = value.substring(0, i) + value.substring(i + 1, i + 2).toUpperCase() + value.substring(i + 2);
            return getStr(value);
        } else {
            return value;
        }
    }

    public static void xmlToString(Map<String, String> map) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(FILE);
        //获取根节点
        Element root = document.getRootElement();
        //获取context节点
        Element ele = root.element("context");
        //删除table
        delTable(ele);
        //实体类位置
        Element entity = ele.element("javaModelGenerator");
        Attribute entitya = entity.attribute("targetPackage");
        //映射文件位置
        Element mapperre = ele.element("sqlMapGenerator");
        Attribute mapperrea = mapperre.attribute("targetPackage");
        //dao位置
        Element mapperja = ele.element("javaClientGenerator");
        Attribute mapperjaa = mapperja.attribute("targetPackage");
        //判断是否是遍历的第一个元素
        int i = 1;
        for (String key : map.keySet()) {
            //当前遍历的map
            String packageName = key.substring(0, key.indexOf("_"));
            //当前路径
            String nowUrl = entitya.getValue();
            //当前路径最后一个.后的名称
            String nowPackage = nowUrl.substring(nowUrl.lastIndexOf("."));
            //否则写入文件,并且修改路径
            if (nowPackage.equals("." + packageName)) {
                addTable(ele, key, map);
            } else {
                if (i != 1) {
                    writeXML(document, nowPackage);
                    delTable(ele);
                }
                entity.addAttribute("targetPackage", stitchingPath(entitya, packageName));
                mapperre.addAttribute("targetPackage", stitchingPath(mapperrea, packageName));
                mapperja.addAttribute("targetPackage", stitchingPath(mapperjaa, packageName));
                addTable(ele, key, map);
            }
            if (i == map.size()) {
                writeXML(document, nowPackage);
            }
            i++;
        }
    }

    public static void delTable(Element ele) {
        //获取table节点
        List<Element> eltable = ele.elements("table");
        //删除table节点
        for (Element o : eltable) {
            ele.remove(o);
        }
    }

    /**
     * 修改路径
     *
     * @param entity
     * @param entitya
     * @param mapperre
     * @param mapperrea
     * @param mapperja
     * @param mapperjaa
     * @param packageName
     * @param ele
     * @param key
     * @param map
     */
    public static void modifyUrl(Element entity, Attribute entitya, Element mapperre, Attribute mapperrea, Element mapperja, Attribute mapperjaa, String packageName, Element ele, String key, Map<String, String> map) {
        entity.addAttribute("targetPackage", stitchingPath(entitya, packageName));
        mapperre.addAttribute("targetPackage", stitchingPath(mapperrea, packageName));
        mapperja.addAttribute("targetPackage", stitchingPath(mapperjaa, packageName));
        addTable(ele, key, map);
    }

    /**
     * 增加table
     *
     * @param ele
     * @param key
     * @param map
     */
    public static void addTable(Element ele, String key, Map<String, String> map) {
        Element table = ele.addElement("table");
        table.addAttribute("tableName", key);
        table.addAttribute("domainObjectName", map.get(key));
    }

    /**
     * 拼接路径
     */
    public static String stitchingPath(Attribute a, String packageName) {
        return a.getValue().substring(0, a.getValue().lastIndexOf(".")) + "." + packageName;
    }

    /**
     * 写入xml
     *
     * @param document
     * @param nowPackage
     * @throws Exception
     */
    public static void writeXML(Document document, String nowPackage) throws Exception {
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter;
        xmlWriter = new XMLWriter(new FileOutputStream(FILE), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        generator();
        System.out.println("成功写入:" + nowPackage);
    }


    /**
     * 根据xml生成文件
     *
     * @throws Exception
     */
    public static void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指向逆向工程配置文件
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(FILE);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
}
