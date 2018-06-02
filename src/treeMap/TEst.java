package treeMap;

import java.util.*;

public class TEst {

    public static void main(String[] args) {
        //1. 对key进行排序
        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
        tmap.put(1, "语文");
        tmap.put(3, "英语");
        tmap.put(2, "数学");
        tmap.put(4, "政治");
        tmap.put(5, "历史");
        tmap.put(6, "地理");
        tmap.put(7, "生物");
        tmap.put(8, "化学");
        for (Map.Entry<Integer, String> entry : tmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Map<Integer, Character> k = new HashMap<>();
        k.put(32, 'c');
        k.put(21, 'd');
        k.put(45, 'd');
        k.put(31, 'f');
        k.put(66, 'm');
        k.put(87, 'b');
        TreeMap treeMap = new TreeMap(k);
//        for (Map.Entry<Integer, Character> entry : treeMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        //2.对value进行排序， 使用collections.sort
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
//注：这样就实现了Map中的value按逆序排序，如果需要升序排的话，只需要修改o2.getValue()-o1.getValue()为o1.getValue()-o2.getValue()即可。
    }
}
