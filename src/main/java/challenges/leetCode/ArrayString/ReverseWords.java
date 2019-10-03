package challenges.leetCode.ArrayString;

//Given an input string , reverse the string word by word.
//
//        Example:
//
//        Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//        Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
//        Note:
//
//        A word is defined as a sequence of non-space characters.
//        The input string does not contain leading or trailing spaces.
//        The words are always separated by a single space.
//        Follow up: Could you do it in-place without allocating extra space?


public class ReverseWords {

    public static void main(String[] args) {
//        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        char[] s = {'l','a','k','.','k','b',' ','c','!','g','f','b','b','\'',' ','c','g','y',
                'x','x','r','p','h','!','a','i',' ','p','a','i','m',',','i','z','b','j','.',
                't','n','k','u','g','j','x','.','f','!','u','h','s','!','x','g','v',' ','v',
                's','x','.','n','c','y','d','m','s','g','e','a','e','n','s','t','g','t','h',
                'z','d','\'','f','v',' ','q','s','s','j','h','e','i','g','f','!','x','c','a',
                '!','d',' ',',','t','s','v','j','!','y','n','i','\'','c','s','d','n','p','h',
                't','t',' ','c','e','j','.','n','g','x','y',' ','e','g','n','h',' ','o','a',
                'x','z','x','u','g','n','e','h','o','r','k','q','k','t',','};
        reverseWords(s);
        System.out.println(s);
    }

    public static void reverseWords(char[] s) {
        char sp = ' ';
        int size = s.length;
        reverse(s, 0, size - 1);
        int start = 0; int end = 0;
        while (end < size) {
            while (end < size && s[end] != sp) {
                end++;
            }
            reverse(s, start, end - 1);
            start = end+1; end += 1;
        }
    }

    public static void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end --;
        }
    }


}
