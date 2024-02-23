public class test1 {
    public static void main(String[] args) {
        String inputString = "bananas";
        int consonantCount = getConsonants(inputString);
        System.out.println("Number of consonants in '" + inputString + "': " + consonantCount);
    }

    public static int getConsonants(String str) {
        return countConsonants(str, 0);
    }

    private static int countConsonants(String str, int index) {
        if (index == str.length()) {
            return 0;
        } else {
            char currentChar = str.charAt(index);
            if (Character.isLetter(currentChar) && !isVowel(currentChar)) {
                return 1 + countConsonants(str, index + 1);
            } else {
                return countConsonants(str, index + 1);
            }
        }
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

