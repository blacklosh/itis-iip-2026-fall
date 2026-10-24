package cmd.example1.impl;

import cmd.example1.DecisionManager;
import cmd.example1.WishService;

public class GoodWishServiceImpl implements DecisionManager, WishService {

    @Override
    public boolean predict(String question) {
        return false;
    }

    @Override
    public int a() {
        return 100;
    }

    @Override
    public String answer() {
        return "блин я не знаю";
    }
}
