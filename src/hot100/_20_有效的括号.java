package hot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _20_有效的括号 {

    public boolean isValid(String s) {
        // 思路：使用栈来进行匹配操作
        if (s.length() % 2 != 0){
            return false;
        }
        // 这种初始化一个map是第一次学习
        final Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> stack = new LinkedList<>();
        // 遍历字符串s，如果遇到map中包含的key就入栈，如果右括号遇到匹配的左括号就让栈中的左括号出栈，如果栈空，说明是有效括号，否则不是
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // 如果是左括号就直接入栈
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                // 进入else的一定是右括号，如果栈不为空 且 栈顶的括号key对应的value为c，就证明是匹配的括号，将栈顶元素弹出栈
                if (!stack.isEmpty() || c == map.get(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20_有效的括号 obj = new _20_有效的括号();
        String s = "([)]";
        System.out.println(obj.isValid(s));
    }
}
