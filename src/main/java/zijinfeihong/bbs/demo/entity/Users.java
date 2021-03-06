package zijinfeihong.bbs.demo.entity;

public class Users {
    private int id;
    private String email;
    private String username;
    private String password;
    private String headpath;

    public Users(String email, String username, String password,String headpath) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.headpath="";
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headpath='" + headpath + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath;
    }
}
