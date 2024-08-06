package model;

public class RegisterUserModel {
    private int id;
    private String username;
    private String name;
    private String email;
    private String address;
    private String password;
    private int userRole;
    private String phoneNum;
    private String icNum;

    public RegisterUserModel() {
    }

    public RegisterUserModel(int id, String username, String name, String email, String address, String password, int userRole, String phoneNum, String icNum) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userRole = userRole;
        this.phoneNum = phoneNum;
        this.icNum = icNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIcNum() {
        return icNum;
    }

    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }

    @Override
    public String toString() {
        return "RegisterUserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", phoneNum='" + phoneNum + '\'' +
                ", icNum='" + icNum + '\'' +
                '}';
    }
}
