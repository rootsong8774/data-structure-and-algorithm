package chap03;

import java.util.Scanner;

public class SeqSearchSentinel {
    
    static int seqSearchSentinel(int[] a, int n, int key) {
        int i = 0;
        
        a[n] = key;
        while (a[i] != key) {
            i++;
        }
        return i==n? -1: i;
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
    
        System.out.print("Number of elements: ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];
    
        for (int i = 0; i < num; i++) {
            System.out.print("x["+i+"]:");
            x[i] = stdIn.nextInt();
        }
    
        System.out.print("검색할 값:");
        int ky = stdIn.nextInt();
    
        int idx = seqSearchSentinel(x, num, ky);
    
        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
        }
    }
}
