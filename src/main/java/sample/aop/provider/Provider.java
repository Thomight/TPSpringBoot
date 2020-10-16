package sample.aop.provider;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider{

    Map<Integer, Integer> articles = Map.of(1, 10, 2, 20, 3, 30);

    @Override
    public int getPrice(int reference) {
        return articles.get(reference);
    }

    @Override
    public boolean order(int reference, int n) {
        return articles.containsKey(reference);
    }
    
}
