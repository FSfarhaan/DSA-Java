
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;



class Task {
    char task;
    int freq;

    public Task(char task) {
        this.task = task;
        this.freq = 1;
    }

    public Task(char task, int freq) {
        this.task = task;
        this.freq = freq;
    }
}
public class TaskScheduler {

    //failed (My code)
    static int leastIntervalMine(char[] tasks, int n) {
        int idle = 0;
        if(n >= tasks.length) idle = n  - tasks.length + 1;
        
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(char task: tasks) {
            pq.add(new Task(task));
        }
        pq.add(new Task('x', idle));

        int timer = 1;

        while(!pq.isEmpty()) {
            char lastOcc = 'x';
            if(pq.peek().task != lastOcc) {
                Task t = pq.poll();
                if(--t.freq > 0) {
                    pq.add(t);
                }
                lastOcc = t.task;
                timer++;
            }
        }
        
        return timer;
    }

    static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int freq: map.values()) {
            pq.add(freq);
        }

        int time = 0;

        while(!pq.isEmpty()) {
            ArrayList<Integer> remaining = new ArrayList<>();

            int cycle = n + 1;
            
            int i = 0;
            while(i < cycle && !pq.isEmpty()) {
                int freq = pq.poll();
                if(--freq > 0) {
                    remaining.add(freq);
                }
                i++;
            }

            if(!remaining.isEmpty()) {
                time += cycle;
                pq.addAll(remaining);
            } else {
                time += i;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','C','A','B','D','B'}; 
        int n = 1;
        System.out.println(leastInterval(tasks, n));
    }
}