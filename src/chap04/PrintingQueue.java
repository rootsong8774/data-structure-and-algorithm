package chap04;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrintingQueue {
    
        public int[] solution(int[][] data) {
            
            int[] answer = new int[data.length];
            boolean onPrinting = false;
            int time = 0;
            int ptrDoc = 0;
            int remainingPages = 0;
            int insertNum = 0;
            Queue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if(o1[2]!=o2[2]){
                    return o1[2]-o2[2];
                }
                return o1[1]-o2[1];
            });
            while(insertNum < data.length){
                if(time == data[ptrDoc][1] ){
                    if(!onPrinting){
                        onPrinting = true;
                        remainingPages = data[ptrDoc][2];
                        answer[insertNum] = data[ptrDoc][0];
                        insertNum++;
                    } else {
                        priorityQueue.add(data[ptrDoc]);
                    }
                    if(ptrDoc < data.length-1){
                        ptrDoc++;
                    }
                    
                }
                
                if(!priorityQueue.isEmpty()){
                    if(remainingPages==0 && time == data[ptrDoc][1]){
                        priorityQueue.add(data[ptrDoc]);
                        int[] dequeuedDoc = priorityQueue.remove();
                        answer[insertNum] = dequeuedDoc[0];
                        remainingPages = dequeuedDoc[2];
                        onPrinting = true;
                        insertNum++;
                        ptrDoc++;
                    } else if(remainingPages ==0 && time != data[ptrDoc][1]) {
                        int[] dequeuedDoc = priorityQueue.remove();
                        answer[insertNum] = dequeuedDoc[0];
                        remainingPages = dequeuedDoc[2];
                        onPrinting = true;
                        insertNum++;
                    }
                }
                time++;
                if(onPrinting){
                    remainingPages--;
                    if (remainingPages == 0){
                        onPrinting = false;
                    }
                }
                
            }
            return answer;
        }
    
    public static void main(String[] args) {
        int[][] data = {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
        int[][] data2= {{1, 0, 3}, {2, 1, 3}, {3, 3, 2},{4, 9, 1}, {5, 10, 2}};
        int[][] data3 ={{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
        PrintingQueue queue = new PrintingQueue();
        int[] solution1 = queue.solution(data);
        int[] solution2 = queue.solution(data2);
        int[] solution3 = queue.solution(data3);
        System.out.println(Arrays.toString(solution1));
        System.out.println(Arrays.toString(solution2));
        System.out.println(Arrays.toString(solution3));
    }
        
        
    
}
