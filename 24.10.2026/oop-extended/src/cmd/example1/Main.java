package cmd.example1;

import cmd.example1.impl.AlwaysYesDecisionManagerImpl;

public class Main {

    public static void main(String[] args) {
        DecisionManager decisionManager = new AlwaysYesDecisionManagerImpl();
        System.out.println(decisionManager.predict("Is it possible to pass exams without study?"));
    }

}
