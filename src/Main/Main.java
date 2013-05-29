package Main;


import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jefferson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n =5;
//        int n =Integer.parseInt(args[0]);
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            a.add(i);
            b.add(i + 100);
        }
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(5);
//
//        b.add(6);
//        b.add(7);
//        b.add(8);
//        b.add(9);
//        b.add(10);


//        System.out.println(Set.isEqual(a, b));
//        System.out.println(Set.isEmpty(a));
//        System.out.println(Set.isSubSet(a, b));
//        System.out.println(Set.isDisjunct(a, b));
//        System.out.println(Set.intersect(a, b).toString());
//        System.out.println(Set.junction(a, b).toString());
//        System.out.println(Set.diference(a, b));


        int a2[] = new int [100];
        int b2[] = new int [100];
        for (int i = 0; i < 100; i++) {
            a2[i]= i +1;
            b2[i]= i + 101;
        }

//        System.out.println(Set.isEqual(a2, b2));
//        System.out.println(Set.isEmpty(a2));
//        System.out.println(Set.isSubSet(a2, b2));
//        System.out.println(Set.isDisjunct(a2, b2));
//        System.out.println(Set.showSet(Set.intersect(a2, b2)));
//        System.out.println(Set.showSet(Set.junction(a2, b2)));
//        System.out.println(Set.diference(a2, b2));


        long a3[] = {Long.MAX_VALUE,68719476735l, 0, 0};
        long b3[] = {0, 68719476735l, 0, 0};
//        System.out.println(Set.isEqual(a3, b3));
//        System.out.println(Set.isEmpty(a2));
//        System.out.println(Set.isSubSet(a2, b2));
//        System.out.println(Set.isDisjunct(a2, b2));
//        System.out.println(Set.showSet(Set.intersect(a3, b3)));
//        System.out.println(Set.showSet(Set.junction(a3, b3)));
//        System.out.println(Set.showSet(Set.diference(a3, b3)));
        System.out.println(Set.showSet(a3));
    }
}
