package cmd.example1;

public interface DecisionManager {

    boolean predict(String question);

    default int a() {
        return 17;
    }
}
