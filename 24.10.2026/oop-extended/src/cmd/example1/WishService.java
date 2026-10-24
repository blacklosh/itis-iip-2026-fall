package cmd.example1;

public interface WishService {

    String answer();

    default int a() {
        return 42;
    }
}
