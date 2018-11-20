package BorderControl;

public class RobotImpl implements Robot{

    private String id;
    private String name;

    public RobotImpl(String id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
