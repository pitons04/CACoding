package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.login.LoginState;

import java.util.ArrayList;

public class ClearState {
    private String usernames = "";

    public ClearState(ClearState copy) {
        usernames = copy.usernames;
    }

    public ClearState() {
    }

    public String getUsernames() {
        return usernames;
    }

    public void setusernames(ArrayList<String> userNames) {
        for (String user : userNames) {
            usernames = usernames + user;
        }
    }



}
