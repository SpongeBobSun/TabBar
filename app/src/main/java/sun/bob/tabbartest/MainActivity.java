package sun.bob.tabbartest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import sun.bob.tabbartest.fragments.FragmentTask;
import sun.bob.tabbar.OnTabClickedListener;
import sun.bob.tabbar.TabBar;
import sun.bob.tabfragmenttest.R;
import sun.bob.tabbartest.fragments.FragmentCalendar;
import sun.bob.tabbartest.fragments.FragmentSetting;


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
    public void onTabClicked(int index) {
        MainActivity that = MainActivity.this;
        that.getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragments.get(index)).commit();
        currentFragment = fragments.get(index);
    }
}
}
