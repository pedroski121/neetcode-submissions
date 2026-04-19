class Solution {
    public boolean isPalindrome(String s) {
        String palindrome = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
       
        int firstIndex = 0;
        int lastIndex = palindrome.length() - 1;

        while(firstIndex < lastIndex) {

            char initialChar = palindrome.charAt(firstIndex);
            char finalChar = palindrome.charAt(lastIndex);

            if(initialChar != finalChar){
                return false;
            }
            firstIndex++;
            lastIndex--;

        }
        return true;
    }
}
