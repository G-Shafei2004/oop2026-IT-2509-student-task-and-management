package taskmanager.services.notification;

public class EmailNotification implements INotification {
    @Override
    public void send(String message) {
        System.out.println("[Email Notification]: " + message);
    }
}