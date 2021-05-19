import java.util.HashMap;
import java.util.Scanner;

public class LetterAndCharacterCount {
    private String content;

    // Constructor
    public LetterAndCharacterCount() {
    }
    public LetterAndCharacterCount(String content) {
        this.content = content;
    }

    // Get & Set
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    // Method
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your content: ");
        content = sc.nextLine();
        sc.close();
    }

    public void countWord(){
        String[] words = content.split(" ");
        HashMap<String, Integer> f = new HashMap<String, Integer>();
        for (String e: words){
            if (!f.containsKey(e))
                f.put(e, 1);
            else 
                f.replace(e, f.get(e) + 1);
        }
        System.out.println(f.toString());
    }

    public void countLetter(){
        HashMap<Character, Integer> f = new HashMap<Character, Integer>();
        for (Character c:content.toCharArray()){
            if (c == ' ') continue;
            if (!f.containsKey(c))
                f.put(c, 1);
            else 
                f.replace(c, f.get(c) + 1);
        }
        System.out.println(f.toString());
    }

    // Main
    public static void main(String[] args) {
        LetterAndCharacterCount obj = new LetterAndCharacterCount();
        obj.input();
        obj.countWord();
        obj.countLetter();
    }
}
