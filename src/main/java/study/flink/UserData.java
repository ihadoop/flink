package study.flink;

import lombok.Getter;

public class UserData {
    @Getter
    private final String whatsappNumber;
    @Getter
    private final String email;
    private final String name;


    public UserData(String whatsappNumber, String email, String name) {
        this.whatsappNumber = whatsappNumber;
        this.email = email;
        this.name = name;
    }


}