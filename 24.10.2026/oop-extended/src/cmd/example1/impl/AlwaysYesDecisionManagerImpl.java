package cmd.example1.impl;

import cmd.example1.DecisionManager;

public class AlwaysYesDecisionManagerImpl implements DecisionManager {

    @Override
    public boolean predict(String question) {
        // Very simple implementation - question is not matter
        return true;
    }
}
