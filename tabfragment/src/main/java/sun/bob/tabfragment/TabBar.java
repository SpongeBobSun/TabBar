package sun.bob.tabfragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by bob.sun on 15/10/16.
 */
public class TabBar extends LinearLayout {
    private ArrayList<View> tabs;
    private ArrayList<View> highlights;
    private int tabsContainerId;
    private int currentIndex;
    private OnTabClickedListener onTabClickedListener;

    public TabBar(Context context) {
        super(context);
        tabs = new ArrayList<>();
        highlights = new ArrayList<>();
        setOrientation(LinearLayout.HORIZONTAL);
        currentIndex = -1;
    }

    public TabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        tabs = new ArrayList<>();
        highlights = new ArrayList<>();
        setOrientation(LinearLayout.HORIZONTAL);
        currentIndex = -1;
    }


    public TabBar addTab(int imgId, int highlightImgId, String text){
        TabView tabView = new TabView(getContext()).NewTabView(imgId, highlightImgId, text);
        tabs.add(tabView);
        final int index = TabBar.this.tabs.size() - 1;
        tabView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabBar that = TabBar.this;
                ((TabView) v).change();
                that.currentIndex = index;
                if (that.onTabClickedListener != null){
                    that.onTabClickedListener.onTabCliked(index);
                }
            }
        });
        this.addView(tabView);
        return this;
    }

    public TabBar setOnTabClickedListener(OnTabClickedListener onTabClickedListener) {
        this.onTabClickedListener = onTabClickedListener;
        return this;
    }
}
