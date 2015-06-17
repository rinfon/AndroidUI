package com.rinfon.view;

/**
 * Created by rinfon on 15/6/17.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.EditText;

import com.rinfon.hintsizetext.R;

public class DDEditText extends EditText {
    public DDEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DDEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.EditTextViewStyle, defStyleAttr, 0);
        int hintSize = attributes.getDimensionPixelSize(R.styleable.EditTextViewStyle_hintSize, -1);
        String hint = attributes.getString(R.styleable.EditTextViewStyle_hintText);
        if (hintSize != -1 && hint != null) {
            SpannableString text = new SpannableString(hint);
            AbsoluteSizeSpan abs = new AbsoluteSizeSpan(hintSize, true);
            text.setSpan(abs, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            this.setHint(new SpannableString(text));
        }
    }

}
