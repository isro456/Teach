
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Stack
{
    public static boolean isValid(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0 ; i < s.length(); i ++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else
            {
                if(stack.isEmpty()) return false;
                char last = stack.pop();
                if ((c == ')' && last != '(') ||
                    (c == ']' && last != '[') ||
                    (c == '}' && last != '{')) {
                    return false;
            }
        }
    }
    return stack.isEmpty();
    }
    public static int calPoints(String[] operations)
    {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i  = 0; i < operations.length; i ++)
        {
            String c = operations[i];

            if (c.equals("+"))
            {
                int top = stack.pop(); 
                int sum = top + stack.peek();
                stack.push(top);
                stack.push(sum);
            }
            else if(c.equals("D"))
            {
                int top = stack.pop();
                stack.push(top);
                stack.push(top * 2);
            }
            else if(c.equals("C"))
            {
                stack.pop();
            }
            else 
            {
                stack.push(Integer.parseInt(c));
            }
        }
        
        if(stack.isEmpty()) return 0;
        
        int sum = 0;
        while (!stack.isEmpty()) 
        {
            sum += stack.pop();
        }
        
        return sum;
    }
    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else {
                stack1.push(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i); 
            if (c == '#') {
                if (!stack2.isEmpty()) stack2.pop(); 
            } else {
                stack2.push(c); 
            }
        }

        System.out.println(stack1); 
        System.out.println(stack2); 

        return Arrays.equals(stack1.toArray(), stack2.toArray());
    }
    
}