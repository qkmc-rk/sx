package xyz.ruankun.laughingspork.util.constant;

public enum Rating {
    EXCELLENT("优秀"),
    GOOD("良好"),
    MEDIUM("中等"),
    PASS("及格"),
    FIAL("不及格");

    final String name;


    Rating(String name) {
        this.name = name;
    }

    public static Rating getEnum(String name) {
        for (Rating r : Rating.values()
        ) {
            if (r.toString().equals(name))
                return r;
        }
        throw new IllegalArgumentException("Invalid value: " + name);
    }

    @Override
    public String toString() {
        return name;
    }
}