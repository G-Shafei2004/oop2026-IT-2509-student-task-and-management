package taskmanager.services.notification;

public class NotificationFactory {
    public static Notification getNotification(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        return null;
    }
}
