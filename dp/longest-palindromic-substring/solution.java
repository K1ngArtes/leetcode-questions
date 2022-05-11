class Solution {
    static Range range = new Range(0, 0);

    public static void main(String[] args) {
        String answer = longestPalindrome("babad");

        boolean goodAnswer = answer.equals("bab") || answer.equals("aba");  
        System.out.println("Answer: '" + answer + "', " + goodAnswer);
    }

    public static String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        
        char[] c = s.toCharArray();
        
        // Range range = new Range(1, 1);
        recur(0, c.length-1, c);
        
        String a = "";
        for(int i = range.l; i <= range.r; i++) {
            a = a + c[i];
        }
        
        return a;
    }
    
    private static void recur(int i, int j, char[] c) {
        if(i == j) {
            return;
        }
        boolean isP = isPalindrome(i, j, c);
        
        // System.out.println("Longest length: " + range.length());
        if(isP && j-i > range.length()) {
            range = new Range(i,j);
        }
        
        recur(i+1, j, c);
        recur(i, j-1, c);
    }
    
    private static boolean isPalindrome(int i, int j, char[] c) {
        // System.out.println("[" + i + "," + j + "]");
        while(i < j) {
            char ci = c[i];
            char cj = c[j];
            if(ci == cj) {
                i++;
                j--;
            } else {
                // System.out.println("Returning false");
                return false;
            }
        }
        // System.out.println("Returning true");
        return true;
    }
}

class Range {
    int l;
    int r;
    Range(int l, int r) {
        this.l = l;
        this.r = r;
    }
    
    int length() {
        return r - l;
    }
}