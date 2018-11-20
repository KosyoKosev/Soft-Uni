package BorderControl;

public class PetImpl implements Pet{
    private String name;
    private String birthday;

    public PetImpl(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
