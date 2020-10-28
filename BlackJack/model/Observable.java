package BlackJack.model;


import BlackJack.view.Observer;


public interface Observable {
    void addObserver(Observer o);
    void notifyObserver();
}
