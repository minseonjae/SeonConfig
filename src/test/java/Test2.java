


public enum Test2 {
    A("asdf"),
    B("qwer"),
    C("zxcv");

    private String name;

    private Test2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(Test2.B.getName());
    }
}
