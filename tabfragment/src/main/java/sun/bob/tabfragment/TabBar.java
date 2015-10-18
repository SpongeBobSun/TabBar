package sun.bob.tabfragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.Gravity;

/**
 * Created by bob.sun on 15/10/16.
 */
public class TabBar extends LinearLayout {
    private int count = 0;
    private int lastIndex = 0;
    private OnTabClickedListener onTabClickedListener;

    public TabBar(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public TabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
    }


    public TabBar addTab(int imgId, int highlightImgId, String text){
        TabView tabView = new TabView(getContext()).NewTabView(imgId, highlightImgId, text);
        count ++;
        final int index = count - 1;
        tabView.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        this.addView(tabView);
        tabView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabBar that = TabBar.this;
                ((TabView) that.getChildAt(lastIndex)).change();
                that.lastIndex = index;
                ((TabView) v).change();
                if (that.onTabClickedListener != null) {
                    that.onTabClickedListener.onTabCliked(index);
                }
            }
        });
        if (index == 0){
            // TODO: 15/10/18 First tab
            tabView.change();
        }
        return this;
    }

    public TabBar setOnTabClickedListener(OnTabClickedListener onTabClickedListener) {
        this.onTabClickedListener = onTabClickedListener;
        return this;
    }
}
