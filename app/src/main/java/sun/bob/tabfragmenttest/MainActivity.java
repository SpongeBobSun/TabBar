package sun.bob.tabfragmenttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import sun.bob.tabfragment.OnTabClickedListener;
import sun.bob.tabfragment.TabBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((TabBar) findViewById(R.id.id_tabbar)).addTab(R.drawable.calendar, R.drawable.calendar_filled, "Calendar").addTab(R.drawable.checklist, R.drawable.checklist_filled, "CheckList").addTab(R.drawable.settings, R.drawable.settings_filled, "Settings");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
class OnClickedListener implements OnTabClickedListener{

    @Override
    public void onTabCliked(int index) {
        MainActivity that = MainActivity.this;
        FragmentManager fm = that.getSupportFragmentManager();
    }
}
}
