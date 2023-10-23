package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;


public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
    }


    @Override
    public void prepareSuccessView(ClearOutputData response) {
        ClearState clearState = clearViewModel.getState();
        clearState.setusernames(response.getUsernames());
        this.clearViewModel.setState(clearState);
        this.clearViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(clearViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
