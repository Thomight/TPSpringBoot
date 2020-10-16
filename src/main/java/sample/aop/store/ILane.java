package sample.aop.store;

public interface ILane {
    public void addItemToCart(int reference);
    public void pay(int price, String adresse, int compte);
}
