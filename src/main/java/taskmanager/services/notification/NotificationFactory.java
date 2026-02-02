package taskmanager.services.notification;

public class NotificationFactory {
    public static INotification getNotification(String type) {
        if (type == null) return null;

        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        // You can add SMS or PUSH here later
        return null;
    }
}