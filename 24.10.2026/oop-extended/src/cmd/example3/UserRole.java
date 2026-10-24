package cmd.example3;

public enum UserRole {
    COMMON(0),
    MODERATOR(5),
    ADMINISTRATOR(100);

    private int adminLvl;

    UserRole(int adminLvl) {
        this.adminLvl = adminLvl;
    }

    public int getAdminLvl() {
        return adminLvl;
    }
}
