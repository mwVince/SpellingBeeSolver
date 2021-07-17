import java.io.*;
import java.util.Arrays;

public class PuzzleSolver {
    char necessaryChar;
    char[] allChars;

    public PuzzleSolver(char necessaryChar, char[] allChars) {
        this.necessaryChar = necessaryChar;
        this.allChars = allChars;
    }

    public void solve(int dictionaryChoice) {
        try {
            InputStream inputStream = null;
            if (dictionaryChoice == 1) {
                inputStream = this.getClass().getResourceAsStream("/words_alpha.txt");
            }
            else {
                inputStream = this.getClass().getResourceAsStream("/google-10000-english.txt");
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while (bufferedReader.ready()) {
                String currentWord = bufferedReader.readLine();
                if (checkWord(currentWord)) {
                    System.out.println(currentWord);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean checkWord(String word) {
        if (word.length() <= 3) {
            return false;
        }

        if (word.contains(Character.toString(this.necessaryChar))
                && word.matches("^[" + Arrays.toString(allChars) + "]+$")) {
            return true;
        }
        return false;
    }
}
