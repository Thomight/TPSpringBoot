package sample.aop.client;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.aop.store.IFastLane;
import sample.aop.store.IJustHaveALook;
import sample.aop.store.ILane;

@Component
public class Client implements IClient, IRun {

    @Autowired
    IFastLane fastLane;

    @Autowired
    ILane lane;

    @Autowired
    IJustHaveALook justHaveALook;

    @Override
    public void run() {
        scenario1(3, 2, "chez moi", 5);
        // scenario2(List.of(1, 2), "chez toi", 3);
    }

    private void scenario1(int reference, int quantité, String adresse, int compte) {
        fastLane.oneShotOrder(reference, quantité, adresse, compte);
    }

    private void scenario2(List<Integer> references, String adresse, int compte) {
        for (Integer reference : references) {
            lane.addItemToCart(reference);
            lane.pay(justHaveALook.getPrice(reference), adresse, compte);

        }

    }

    
}
