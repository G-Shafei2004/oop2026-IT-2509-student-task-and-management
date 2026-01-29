package taskmanager.entities;

public class User {
    private int id;
    private String name;
    private String email;
    private String role;

    public User(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }


    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format: must contain @");
        }
        this.email = email; }
    public void setRole(String role) {
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        this.role = role; }
}