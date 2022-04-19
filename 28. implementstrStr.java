class Solution {
    public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int index = -1;
        int flag = 0;
        String s ="";
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                s+=haystack.charAt(i);
                System.out.println(s+" ya rays");
                if (index == -1 ) {
                    index = i;
                } else {
                    index = Math.min(index, i);
                }
                j++;
                if (j == needle.length()) {
                    return index;
                }

            } else {
                
                if (index != -1) {
                    i = flag;
                }++flag;
                index = -1;
                j = 0;
                s="";

            }
            
        }
       
         return (s.length()== needle.length())?  index :  -1;
    }
}
