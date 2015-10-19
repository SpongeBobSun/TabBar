package sun.bob.tabfragmenttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import sun.bob.tabfragment.OnTabClickedListener;
import sun.bob.tabfragment.TabBar;
import sun.bob.tabfragmenttest.fragments.FragmentCalendar;
import sun.bob.tabfragmenttest.fragments.FragmentSetting;
import sun.bob.tabfragmenttest.fragments.FragmentTask;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((TabBar) findViewById(R.id.id_tabbar))
                .addTab(R.drawable.calendar, R.drawable.calendar_filled, "Calendar", Color.GRAY, Color.rgb(34, 145, 255))
                .addTab(R.drawable.checklist, R.drawable.checklist_filled, "CheckList", Color.GRAY, Color.rgb(34, 145, 255))
                .addTab(R.drawable.settings, R.drawable.settings_filled, "Settings", Color.GRAY, Color.rgb(34, 145, 255))
                .setOnTabClickedListener(new OnClickedListener());
        FragmentCalendar f1 = new FragmentCalendar();
        FragmentTask f2 = new FragmentTask();
        FragmentSetting f3 = new FragmentSetting();
        fragments = new ArrayList<>();
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        getSupportFragmentManager().beginTransaction().add(R.id.id_fragment_container, f1)
                .add(R.id.id_fragment_container, f2)
                .hide(f2)
                .add(R.id.id_fragment_container, f3)
                .hide(f3)
                .commit();
        currentFragment = f1;
    }
class OnClickedListener implements OnTabClickedListener{

    @Override
    public void onTabCliked(int index) {
        MainActivity that = MainActivity.this;
        that.getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragments.get(index)).commit();
        currentFragment = fragments.get(index);
    }
}
}
