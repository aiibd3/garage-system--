package parking.message;

import java.util.ArrayList;

public class MessageHandler {
    private final ArrayList<MassageObserver> messageObserverList = new ArrayList<>();

    public void subscribe(MassageObserver messageObserver) {
        this.messageObserverList.add(messageObserver);
    }

    public void handleMessageData(MessageData massageData) {
        this.messageObserverList.forEach(messageDataObserver -> messageDataObserver.sendMassage(massageData));

    }

    public void unsubscribe(MassageObserver messageObserver) {
        this.messageObserverList.remove(messageObserver);

    }
}