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
public class Set {
    //
    public static boolean isEqual(LinkedList<Integer> a, LinkedList<Integer> b) {
        return a.containsAll(b) & b.containsAll(a);
    }
    
    public static boolean isEqual(int[] a, int[] b) {
        return containAll(a, b) & containAll(b, a);
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
    
    public static boolean isEmpty(int[] a) {
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
    
    public static boolean isSubSet(int[] a, int[] b) {
        return isEmpty(b) | containAll(a, b);
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
    
    public static boolean isDisjunct(int[] a, int[] b) {
        return intersect(a, b).length == 0 ? true : false;
    }
    
    public static boolean isDisjunct(long[] a, long[] b) {
        return intersect(a, b).length == 0 ? true : false;
    }
    
    public static LinkedList<Integer> intersect(LinkedList<Integer> a, LinkedList<Integer> b) {
        a.retainAll(b);
        return a;
    }
    
    public static int[] intersect(int[] a, int[] b) {
        int n = a.length;
        int _n = 0;
        int[] c = new int[n];
        int ic = 0;
        for (int i = 0; i < n; i++) {
            for (int z = _n; z < n; z++) {
                if (b[i] == a[z]) {
                    a[z] = a[_n];
                    a[_n] = b[i];
                    _n++;
                    c[ic] = b[i];
                    ic++;
                }
            }
        }
        int[] c2 = new int[ic];
        System.arraycopy(c, 0, c2, 0, ic);
        return c2;
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
    
    public static int[] junction(int[] a, int[] b) {
        int ab[] = noContainAll(a, b);
        int ba[] = noContainAll(b, a);
        int intersection[] = intersect(a, b);
        int c[] = new int[ab.length + ba.length + intersection.length];
        System.arraycopy(intersection, 0, c, 0, intersection.length);
        System.arraycopy(ab, 0, c, intersection.length, ab.length);
        System.arraycopy(ba, 0, c, intersection.length + ab.length, ba.length);
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
    
    public static int[] diference(int[] a, int[] b) {
        return noContainAll(a, b);
    }
    
    public static long[] diference(long[] a, long[] b) {
        long[] c = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] ^ b[i]);
        }
        return c;
    }

    /**
     ********************
     * Alter Fuctions *******************
     */
    public static boolean containAll(int[] a, int[] b) {
        int n = a.length;
        int _n = 0;
        for (int i = 0; i < n; i++) {
            for (int z = _n; z < n; z++) {
                if (b[i] == a[z]) {
                    a[z] = a[_n];
                    a[_n] = b[i];
                    _n++;
                    break;
                }
                if (z + 1 == n) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Devuelve los elementos que pertenecen al conjunto b pero no al a.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] noContainAll(int[] a, int[] b) {
        int n = a.length;
        int _n = 0;
        int c[] = new int[n];
        int ic = 0;
        for (int i = 0; i < n; i++) {
            for (int z = _n; z < n; z++) {
                if (b[i] == a[z]) {
                    a[z] = a[_n];
                    a[_n] = b[i];
                    _n++;
                    break;
                }
                if (z + 1 == n) {
                    c[ic] = b[i];
                    ic++;
                }
            }
        }
        int[] c2 = new int[ic];
        System.arraycopy(c, 0, c2, 0, ic);
        return c2;
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
            if ((a[(i)/ 64] & (long) 1 << i) != 0) {
                str += i  + ", ";
            }
        }
        str += "]";
        str = str.replaceAll(", ]", "]");
        return str;
    }
}
