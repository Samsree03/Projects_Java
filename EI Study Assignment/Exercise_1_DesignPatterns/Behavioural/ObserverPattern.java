import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class EmailUser implements Observer {
    private String email;

    public EmailUser(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}

class Notifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();
        notifier.addObserver(new EmailUser("user1@example.com"));
        notifier.addObserver(new EmailUser("user2@example.com"));

        notifier.notifyObservers("New event has occurred!");
    }
}
