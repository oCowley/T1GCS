public class Operator {
    private String name;
    private String initials;

    public Operator(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
