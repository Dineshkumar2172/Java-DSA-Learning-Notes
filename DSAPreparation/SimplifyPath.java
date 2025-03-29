package DSAPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] pathSplit = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < pathSplit.length; i++) {
            if (!pathSplit[i].equals(".") && !pathSplit[i].equals("")) {
                if (!pathSplit[i].equals("..")) {
                    stack.push(pathSplit[i]);
                    continue;
                }

                if (!stack.isEmpty()) stack.pop();
            }
        }

        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(0, stack.pop());
        }

        return "/" + String.join("/", result);
    }
}
