package chap04;

import chap04.IntQueue.EmptyIntQueueException;
import chap04.IntQueue.OverflowIntQueueException;
import java.util.Scanner;

public class IntQueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue q = new IntQueue(64);
        while (true) {
            System.out.println("현재 데이터 수: " + q.size() + " / " + q.capacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료:");
            int menu = stdIn.nextInt();
            if (menu == 0) {
                break;
            }
            
            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터:");
                    x = stdIn.nextInt();
                    try {
                        q.enque(x);
                    } catch (OverflowIntQueueException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        x = q.deque();
                        System.out.println("꺼낸 데이터는 "+x+"입니다.");
                    } catch (EmptyIntQueueException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("확인한 데이터는 "+x+" 입니다.");
                    } catch (EmptyIntQueueException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                
                case 4:
                    q.dump();
                    break;
            }
        }
    }
}
