package wp.mymvp;

/**
 * Created by wp on 17-12-21.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void loginSuccess();
    void loginFail();
}
