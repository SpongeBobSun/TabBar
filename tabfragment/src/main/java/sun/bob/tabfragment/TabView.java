package sun.bob.tabfragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
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
    private int fontColor, highlightFontColor;

    public TabView(Context context) {
        super(context);
        init();
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.setOrientation(VERTICAL);
        imageView = new ImageView(getContext());
        textView = new TextView(getContext());
        this.setPadding(0,0,0,0);
    }

    public TabView NewTabView(int iconImgId, int highlightImgId, String text, int fontColor, int highlightFontColor) {
        this.iconImgId = iconImgId;
        this.highlightImgId = highlightImgId;
        this.fontColor = fontColor;
        this.highlightFontColor = highlightFontColor;
        textView.setText(text);
        textView.setTextColor(fontColor);
        imageView.setImageResource(iconImgId);
        imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 4));
        textView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setPadding(0,0,0,0);
        this.addView(imageView);
        this.addView(textView);
        return this;
    }

    public TabView change() {
        if (highlighted) {
            imageView.setImageResource(this.iconImgId);
            textView.setTextColor(fontColor);
        } else {
            imageView.setImageResource(this.highlightImgId);
            textView.setTextColor(highlightFontColor);
        }
        this.invalidate();
        highlighted = !highlighted;
        return this;
    }
}
