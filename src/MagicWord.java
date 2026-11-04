import java.util.Random;
public class MagicWord {
    private static final int MAX_FAILS = 10;
    private static final String[] palabras = {
            "carpaccio", "carcelica", "nicolapas", "ribesalbes", "diseloxulico"
    };
    private String hiddenword;
    private boolean[] correctLetters;
    private int fails;

    public MagicWord() {
        fails = 0;
        int palabraAleatoria = (int) (Math.random() * palabras.length);
        hiddenword = palabras[palabraAleatoria];
        correctLetters = new boolean[hiddenword.length()];
        for (int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = false;
        }


    }

    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i < correctLetters.length; i++) {
            if (correctLetters[i]) {
                S += hiddenword.charAt(i);
            } else {
                S += "_";
            }


        }
        return S;
    }

    public String getHiddenword() {
        return hiddenword;
    }

    public boolean wins() {
        for (int i = 0; i < correctLetters.length; i++) {
            if (!correctLetters[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean looses() {
        return fails > MAX_FAILS;
    }

    public void shoot(String wordOrLetter) {
        boolean acierto = false;
        if (wordOrLetter.length() == 1) {
            for (int i = 0; i < hiddenword.length(); i++) {
                if (wordOrLetter.charAt(0) == hiddenword.charAt(i)) {
                    correctLetters[i] = true;
                    acierto = true;
                }
            }
            if (!acierto) {
                fails++;
            }
        } else {
            if (hiddenword.equals(wordOrLetter)) {
                for (int i = 0; i < correctLetters.length; i++) {
                    correctLetters[i] = true;
                }
            } else {
                fails = MAX_FAILS + 1;
            }
        }
    }
}
