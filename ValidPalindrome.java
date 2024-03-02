import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Ans: " + isPalindrome(str));
        sc.close();
    }
 
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            while(left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }

            while(left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++; right--;  
        } 
        return true; 
    }

    public static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') ;
    }


}
