class Solution {
    public int lengthOfLastWord(String s) {
        String[] words=s.split(" ");
        String s1=words[words.length-1];
        return s1.length();
    }
}