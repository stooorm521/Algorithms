package Collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Worker {
    private String name;
    private int age;

    public Worker(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Worker [name=" + name + ", age=" + age + "]";
    }

}


public class Test {
    public static void main(String[] args) {
        //创建List并加入worker对象
        List<Worker> list = new ArrayList<Worker>();
        list.add(new Worker("zhang3", 18));
        list.add(new Worker("li4", 25));
        list.add(new Worker("wang5", 22));
        list.add(new Worker("lao6", 22));
        list.add(new Worker("xiaoming", 22));

        Collections.sort(list, new MyComparator());//传入list和比较器排序
        //遍历输出信息
        for (int i = 0; i < list.size(); i++) {
            Worker worker = list.get(i);
            System.out.println(worker);
        }

        //or 第二种
        Collections.sort(list, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    static class MyComparator implements Comparator<Worker> {
        /*
         * 先按年龄排，次要按名字排
         * 根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数
         */
        @Override
        public int compare(Worker o1, Worker o2) {
            int sub = o1.getAge() - o2.getAge();
            if (sub == 0)
                return o1.getName().compareTo(o2.getName());//使用String的comareTo方法
            else
                return sub;
        }

    }
}
