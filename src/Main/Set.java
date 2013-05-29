package Main;

import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jefferson,
 */
public class Set {
    //

    public static boolean isEqual(LinkedList<Integer> a, LinkedList<Integer> b) {
        return a.containsAll(b) & b.containsAll(a);
    }

    public static boolean isEqual(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(long[] a, long[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(LinkedList<Integer> a) {
        return a.isEmpty();
    }

    public static boolean isEmpty(boolean[] a) {
        return a.length == 0;
    }

    public static boolean isEmpty(long[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSubSet(LinkedList<Integer> a, LinkedList<Integer> b) {
        return isEmpty(b) | a.containsAll(b);
    }

    public static boolean isSubSet(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (!(a[i] & b[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSubSet(long[] a, long[] b) {
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & b[i]) != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDisjunct(LinkedList<Integer> a, LinkedList<Integer> b) {
        return intersect(a, b).isEmpty();
    }

    public static boolean isDisjunct(boolean[] a, boolean[] b) {
        return intersect(a, b).length == 0 ? true : false;
    }

    public static boolean isDisjunct(long[] a, long[] b) {
        return intersect(a, b).length == 0 ? true : false;
    }

    public static LinkedList<Integer> intersect(LinkedList<Integer> a, LinkedList<Integer> b) {
        a.retainAll(b);
        return a;
    }

    public static boolean[] intersect(boolean[] a, boolean[] b) {
        boolean[] c = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] & b[i]);
        }
        return c;
    }

    public static long[] intersect(long[] a, long[] b) {
        long[] c = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] & b[i]);
        }
        return c;
    }

    public static LinkedList<Integer> junction(LinkedList<Integer> a, LinkedList<Integer> b) {
        a.removeAll(b);
        a.addAll(b);
        return a;
    }

    public static boolean[] junction(boolean[] a, boolean[] b) {
        boolean[] c = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] | b[i]);
        }
        return c;
    }

    public static long[] junction(long[] a, long[] b) {
        long[] c = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] | b[i]);
        }
        return c;
    }

    public static LinkedList<Integer> diference(LinkedList<Integer> a, LinkedList<Integer> b) {
        b.removeAll(a);
        return b;
    }

    public static boolean[] diference(boolean[] a, boolean[] b) {
        boolean[] c = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] ^ b[i]);
        }
        return c;
    }

    public static long[] diference(long[] a, long[] b) {
        long[] c = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] ^ b[i]);
        }
        return c;
    }

    public static String showSet(int a[]) {
        String str = "[";
        for (int i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        return str + a[a.length - 1] + "]";
    }

    public static String showSet(long a[]) {
        String str = "[";
        for (int i = 0; i < a.length * 64; i++) {
            if ((a[(i) / 64] & (long) 1 << i) != 0) {
                str += i + ", ";
            }
        }
        str += "]";
        str = str.replaceAll(", ]", "]");
        return str;
    }
}
