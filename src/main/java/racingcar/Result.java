package racingcar;

public class Result {
    private String name;
    private int position;

    public Result(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
