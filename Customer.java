public class Customer {
    private String name;
    private String lastName;
    private String password;
    private int age;
    private String tel;

    /*getters and setters*/
    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTel() {
        return tel;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String  tel) {
        this.tel = tel;
    }

    /*getters and setters*/
}
