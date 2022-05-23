class Solution { 
  public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int l = s.length();
        char c;
        char top;
        for (int i = 0; i < l; i++) {
            
            c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else if (c == '}' || c == ')' || c == ']') {
                
                if (stack.empty()) {
                    return false;
                }
                
                top = stack.peek();

                if (top == '{' && c != '}' 
                      || top == '(' && c != ')' 
                      || top == '[' && c != ']') {
                    
                    return false;
                }

                stack.pop();
            }
        }

        return stack.empty();

    }
}