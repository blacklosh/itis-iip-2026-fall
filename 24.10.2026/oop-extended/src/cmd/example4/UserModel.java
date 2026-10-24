package cmd.example4;

import java.util.Objects;
import java.util.Random;

public class UserModel {

    private Long id;
    private String nickname;
    private String password;

    public UserModel(String nickname, String password) {
        this.id = new Random().nextLong();
        this.nickname = nickname;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(hashCode() != o.hashCode()) {
            return false;
        }
        if (!(o instanceof UserModel userModel)) return false;
        return Objects.equals(id, userModel.id)
                && Objects.equals(nickname, userModel.nickname)
                && Objects.equals(password, userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, password);
    }
}
