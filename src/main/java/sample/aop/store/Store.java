package sample.aop.store;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.aop.bank.IBank;
import sample.aop.provider.IProvider;

@Component
public class Store implements IStore, IFastLane, IJustHaveALook, ILane{

    @Autowired
    IBank bank;

    @Autowired
    IProvider provider;

    int storeCompte = 9;
    int taxeStore = 2;
    Map<Integer, Integer> stock = Map.of(1, 1, 2, 2, 3, 3);

    @Override
    public void addItemToCart(int reference) {
        if (isAvailable(reference, 1)){
            // stock.replace(reference, stock.get(reference)-1);
        }else {
            if (provider.order(reference, 1)) {
                // stock.replace(reference, stock.get(reference) + 1);
                System.out.println("coming soon");
            }else{
                System.out.println("reference unknow");
            }
        }
    }
    
    @Override
    public void pay(int price, String adresse, int compte) {
        bank.transfert(price, compte, storeCompte);
        
    }
    
    @Override
    public int getPrice(int reference) {
        return provider.getPrice(reference)*taxeStore;
    }
    
    @Override
    public boolean isAvailable(int reference, int quantite) {
        Integer articleQ = stock.get(reference);
        return articleQ != null ?  articleQ >= quantite : false;
    }
    
    @Override
    public void oneShotOrder(int reference, int quantite, String adresse, int compte) {
        if (isAvailable(reference, quantite)) {
            // stock.replace(reference, stock.get(reference)-quantite);
            pay(getPrice(reference)*quantite, adresse, compte);
        }else{
            if (provider.order(reference, quantite)) {
                // stock.replace(reference, stock.get(reference) + quantite);
                System.out.println("coming soon");
            }else{
                System.out.println("reference unknow");
            }
        }
    }
    
}
