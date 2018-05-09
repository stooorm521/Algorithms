package priorityQueue;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class treeAgain {
    private String name;
    private int population;
    //构造方法
    public treeAgain(String name, int population)
    {
        this.name = name;
        this.population = population;
    }
    public String getName()
    {
        return this.name;
    }

    public int getPopulation()
    {
        return this.population;
    }
    public String toString()
    {
        return getName() + " - " + getPopulation();
    }
    public static void main(String args[])
    {
        Comparator<treeAgain> OrderIsdn =  new Comparator<treeAgain>(){
            public int compare(treeAgain o1, treeAgain o2) {
                // TODO Auto-generated method stub
                int numbera = o1.getPopulation();
                int numberb = o2.getPopulation();
                if(numberb > numbera)
                {
                    return 1;
                }
                else if(numberb<numbera)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }

            }



        };
        Queue<treeAgain> priorityQueue =  new PriorityQueue<treeAgain>(11,OrderIsdn);



        treeAgain t1 = new treeAgain("t1",1);
        treeAgain t3 = new treeAgain("t3",3);
        treeAgain t2 = new treeAgain("t2",2);
        treeAgain t4 = new treeAgain("t4",0);
        priorityQueue.add(t1);
        priorityQueue.add(t3);
        priorityQueue.add(t2);
        priorityQueue.add(t4);
        System.out.println(priorityQueue.poll().toString());
    }

}
