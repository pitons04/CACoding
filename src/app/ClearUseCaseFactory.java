package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupUserDataAccessInterface;
import view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class ClearUseCaseFactory {
    /** Prevent instantiation. */
    ClearUseCaseFactory() {}

    public static ClearController create(
            ViewManagerModel viewManagerModel,
            ClearViewModel clearViewModel,
            ClearUserDataAccessInterface userDataAccessObject) {

        try {
            ClearController clearController = createClearUseCase(viewManagerModel, clearViewModel, userDataAccessObject);
            return clearController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static ClearController createClearUseCase(ViewManagerModel viewManagerModel, ClearViewModel clearViewModel, ClearUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(viewManagerModel, clearViewModel);

        UserFactory userFactory = new CommonUserFactory();

        ClearInputBoundary clearInteractor = new ClearInteractor(
                userDataAccessObject, clearOutputBoundary);

        return new ClearController(clearInteractor);
    }
}

