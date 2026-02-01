package taskmanager.services.notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[Email System]: " + message);
    }
}
