package taskmanager.entities;

public class Project {
    private int id;
    private String title;
    private String description;
    private int ownerId;

    public Project(int id, String title) {
        this.id = id;
        this.title = title;
        this.description = null;
        this.ownerId = 0;
    }

    // existing constructor (keep it)
    public Project(int id, String title, String description, int ownerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getOwnerId() { return ownerId; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) {
        if (description != null && description.length() > 500) {
            throw new IllegalArgumentException("Description is too long (max 500 chars)");
        }
        this.description = description;
    }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
}
