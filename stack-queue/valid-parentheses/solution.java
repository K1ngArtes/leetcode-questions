class Solution {
    public boolean isValid(String str) {
        char b1c = ')';
        char b2c = '}';
        char b3c = ']';
        
        char b1 = '(';
        char b2 = '{';
        char b3 = '[';
        
        char[] chars = str.toCharArray();
        if(chars.length % 2 != 0) {
            return false;
        }
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if((c == b1c || c == b2c || c == b3c) && s.isEmpty()) {
                return false;
            }
            
            if(c == b1c) {
                if(b1 != s.pop()) {
                    return false;
                }
            } else if(c == b2c) {
                if(b2 != s.pop()) {
                    return false;
                }
            } else if(c == b3c) {
                if(b3 != s.pop()) {
                    return false;
                }
            } else {
                s.add(c);
            }
        }
        
        if(!s.isEmpty()) {
            return false;
        }
        return true;
    }
}