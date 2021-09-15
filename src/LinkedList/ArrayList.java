package LinkedList;

public class ArrayList {
    public static void main(String[] args) {
        java.util.ArrayList<Integer> list=new java.util.ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(0,11);
        list.remove(0);
        System.out.println(list.remove(0));
        System.out.println(list.remove(0)+" "+list.set(5,50));
//        list.add(10f);
//        list.add("Mohit");
//        list.add("M");
        System.out.println(list.size());
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        for(int element :list){
            System.out.print(element+" ");
        }
    }
}
