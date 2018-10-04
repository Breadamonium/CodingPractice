class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> aStack = new Stack<Character>();
        char[] theCharacteres = s.toCharArray();

        if (s.length()==0) {
            return true;
        }
        for(int i = 0; i < theCharacteres.length; i++) {
            char current = theCharacteres[i];
            if((current == '{') || (current == '[') || (current == '(')) {
                aStack.push(current);
            }
            else {
                if (aStack.empty()) {
                    return false;
                }
                char prevBracket = aStack.pop();
                if(current == '}') {
                    if (prevBracket != '{') {
                        return false;
                    }
                }
                else if (current == ']') {
                    if (prevBracket != '[') {
                        return false;
                    }
                }
                else if (current == ')') {
                    if (prevBracket != '(') {
                        return false;
                    }
                }
            }
        }
        if (aStack.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
}