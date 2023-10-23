package use_case.clear_users;

// TODO Complete me

import java.util.ArrayList;

public class ClearOutputData {
    private final ArrayList<String> usernames;
    private boolean useCaseFailed;

    public ClearOutputData(ArrayList<String> usernames, boolean useCaseFailed) {
        this.usernames = usernames;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<String> getUsernames() {return usernames;}

}
