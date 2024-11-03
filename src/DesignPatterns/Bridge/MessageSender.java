package DesignPatterns.Bridge;

public interface MessageSender {
    void sendMessage(String message);
}

class EmailSender implements MessageSender {
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSSender implements MessageSender {
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

abstract class Notification {
    protected MessageSender sender;

    public Notification(MessageSender sender) {
        this.sender = sender;
    }

    abstract void notifyUser(String message);
}

class UrgentNotification extends Notification {
    public UrgentNotification(MessageSender sender) {
        super(sender);
    }

    public void notifyUser(String message) {
        System.out.println("Urgent: ");
        sender.sendMessage(message);
    }
}

class RegularNotification extends Notification {
    public RegularNotification(MessageSender sender) {
        super(sender);
    }

    public void notifyUser(String message) {
        System.out.println("Urgent: ");
        sender.sendMessage(message);
    }
}

class NotificationSystem {
    public static void main(String[] args) {
        MessageSender emailsender = new EmailSender();
        MessageSender smssender = new SMSSender();

        Notification urgentEmail = new UrgentNotification(emailsender);
        Notification regularEmail = new RegularNotification(smssender);

        urgentEmail.notifyUser("Server is down!");
        regularEmail.notifyUser("Weekly report is ready.");
    }
}