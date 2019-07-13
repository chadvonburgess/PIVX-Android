package pivx.org.pivxwallet.ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import global.N8VModule;
import pivx.org.pivxwallet.N8VApplication;

/**
 * Created by furszy on 6/29/17.
 */

public class BaseFragment extends Fragment {

    protected N8VApplication n8VApplication;
    protected N8VModule n8VModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        n8VApplication = N8VApplication.getInstance();
        n8VModule = n8VApplication.getModule();
    }

    protected boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getActivity(),permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
