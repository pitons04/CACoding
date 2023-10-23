package use_case.clear_users;

// TODO Complete me

import entity.User;
import use_case.login.*;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface clearDataAccessObject;
    final ClearOutputBoundary ClearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface clearDataAccessObject,
                           ClearOutputBoundary ClearOutputBoundary) {
        this.clearDataAccessObject = clearDataAccessObject;
        this.ClearPresenter = ClearOutputBoundary;
    }

    @Override
    public void execute() {
        ClearOutputData clearOutputData = new ClearOutputData(clearDataAccessObject.getaccounts(), false);
        clearDataAccessObject.deleteall();
        ClearPresenter.prepareSuccessView(clearOutputData);
    }
}
