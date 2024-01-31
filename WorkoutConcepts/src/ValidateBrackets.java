import java.util.Stack;

public class ValidateBrackets {

    public static void main(String[] args) {

        ValidateBrackets v= new ValidateBrackets();
        v.validate();

    }

    public boolean validate() {
        String str = "(){}[]";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ']') {

                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }

            } else if (ch == '}') {

                if (stack.peek() == '{') {
                    stack.pop();

                } else {
                    return false;
                }

            } else if (ch == ')') {

                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }

            if (stack.size() == 0) {
                return true;
            }
        }
        return false;

    }
}

