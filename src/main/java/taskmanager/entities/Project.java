package taskmanager.entities;

public class Project {
    private int id;
    private String title;
    private String description;
    private int ownerId;

    public Project(int id, String title, String description, int ownerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
    }

    // ✅ Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getOwnerId() { return ownerId; }

    // ✅ Setters (optional)
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
}