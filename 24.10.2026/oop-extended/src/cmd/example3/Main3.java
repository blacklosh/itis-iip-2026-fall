package cmd.example3;

public class Main3 {

    public static void main(String[] args) {
        UserRole ur = UserRole.valueOf("ADMINISTRATOR");


        System.out.println(ur.getAdminLvl());
    }
}
