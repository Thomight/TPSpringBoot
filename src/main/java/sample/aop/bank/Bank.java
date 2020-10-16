package sample.aop.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{

    @Override
    public void transfert(int price, int out, int in) {
        System.out.println("payment accepted");
    }
    
}
