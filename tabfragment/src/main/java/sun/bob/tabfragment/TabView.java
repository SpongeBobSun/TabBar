package sun.bob.tabfragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bob.sun on 15/10/16.
 */
public class TabView extends LinearLayout {
    private boolean highlighted = false;
    private ImageView imageView;
    private TextView textView;
    private int iconImgId, highlightImgId;
    private LinearLayout cell;
    public TabView(Context context) {
        super(context);
        this.setOrientation(VERTICAL);
        imageView = new ImageView(context);
        textView = new TextView(context);
        cell = new LinearLayout(context);
        cell.setOrientation(VERTICAL);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(VERTICAL);
        imageView = new ImageView(context);
        textView = new TextView(context);
        cell = new LinearLayout(context);
        cell.setOrientation(VERTICAL);
    }

    public TabView NewTabView(int iconImgId, int highlightImgId, String text){
        this.iconImgId = iconImgId;
        this.highlightImgId = highlightImgId;
        textView.setText(text);
        imageView.setImageResource(iconImgId);
        this.addView(cell);
        this.cell.addView(imageView);
        this.cell.addView(textView);
        return this;
    }

    public TabView change(){
        if (highlighted){
            ((ImageView) ((LinearLayout) this.getChildAt(0)).getChildAt(0)).setImageResource(this.highlightImgId);
        } else {
            ((ImageView) ((LinearLayout) this.getChildAt(0)).getChildAt(0)).setImageResource(this.iconImgId);
        }
        this.invalidate();
        highlighted = !highlighted;
        return this;
    }
}
