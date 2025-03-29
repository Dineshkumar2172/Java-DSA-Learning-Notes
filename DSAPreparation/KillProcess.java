package DSAPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            if (!hashmap.containsKey(ppid.get(i))) hashmap.put(ppid.get(i), new ArrayList<>());

            hashmap.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(kill);

        while (!queue.isEmpty()) {
            int proc = queue.poll();
            result.add(proc);
            if (hashmap.containsKey(proc)) {
                for (int childProc: hashmap.get(proc)) {
                    queue.add(childProc);
                }
            }
        }

        return result;
    }
}
