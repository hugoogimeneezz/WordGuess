public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        MagicWord magic = new MagicWord();

        while (!gameOver) {
            System.out.println(magic);
            System.out.println("EnterWord or letter");
            String s = Input.readString();
            magic.shoot(s);

            if (magic.wins()) {
                System.out.println(magic);
                System.out.println("Congratulations. You win!!");
                gameOver = true;
            } else {
                if (magic.looses()) {
                    System.out.println("You lose. The hidden word was: " + magic.getHiddenword());
                    gameOver = true;
                }
            }

        }

    }


}

