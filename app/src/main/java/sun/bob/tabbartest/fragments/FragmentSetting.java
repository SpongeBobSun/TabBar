package sun.bob.tabbartest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sun.bob.tabfragmenttest.R;

/**
 * Created by bob.sun on 15/10/19.
 */
public class FragmentSetting extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_settings, null);
    }
}
