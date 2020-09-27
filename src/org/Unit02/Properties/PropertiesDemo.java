package org.Unit02.Properties;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("B", "百度");
        prop.setProperty("A", "阿里巴巴");
        prop.setProperty("T", "腾讯");

        //遍历
        Set<Object> set = prop.keySet();
        for (Object o : set) {
            System.out.println(o + "---" + prop.get(o));
        }
    }
}
