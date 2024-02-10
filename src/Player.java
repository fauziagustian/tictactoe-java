public class Player {
    private char mark;
    private String name;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }
}
