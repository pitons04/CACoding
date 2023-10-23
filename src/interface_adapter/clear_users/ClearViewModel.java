package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClearViewModel extends ViewModel {
    public final String TITLE_LABEL = "Clear View";

    public static final String CLEAR_BUTTON_LABEL  = "Clear";

    private static ClearState state = new ClearState();

    public ClearViewModel() {
        super("clear");
    }

    public void setState(ClearState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static ClearState getState() {
        return state;
    }

    public void setClearError(String error) {
    }
}
