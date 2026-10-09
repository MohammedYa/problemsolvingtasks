public class nextChar {
    private char letter;

    public nextChar(char letter){
        setLetter(letter);
        nextLetter(getLetter());
    }

    private void setLetter(char letter) {
        this.letter = letter;
    }
    public char getLetter() {
        return letter;
    }

    private void nextLetter(char letter) {
        letter = Character.toUpperCase(letter);

        char next;

        if (letter == 'Z') {
            next = 'A';
        } else {
            next = (char) (letter + 1);
        }

        System.out.println("The Next Letter of " + letter + " is " + next);
    }
}
