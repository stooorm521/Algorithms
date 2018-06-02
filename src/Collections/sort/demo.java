package Collections.sort;

import java.util.Iterator;
import java.util.TreeSet;
//1. 内部比较器：需比较的类实现接口 Comparable，使该类对外提供一个默认比较的实现
class demo implements Comparable<demo>{
    private String name;
    private int age;

    public demo(String name, int age) {
        //construct method
        super();
        this.name = name;
        this.age = age;
    }

    // important part
    public int compareTo(demo de){
        int sub=this.age-de.age;
        if(sub==0){
            return this.name.compareTo(de.name);//使用String的comareTo方法
        }else
            return sub;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Worker [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        //创建TreeSet并加入worker对象
        TreeSet<demo> set = new TreeSet<demo>();
        set.add(new demo("zhang3", 18));
        set.add(new demo("li4", 25));
        set.add(new demo("wang5", 22));
        set.add(new demo("lao6", 22));
        set.add(new demo("xiaoming", 22));

        //遍历输出信息
        Iterator<demo> iterator = set.iterator();
        while (iterator.hasNext()) {
            demo de = iterator.next();
            System.out.println(de);
        }
    }
}

