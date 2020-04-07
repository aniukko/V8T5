package com.example.v11t2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    Button plus;
    Button minus;
    private int textSize = 16;

    TextView textView;
    TextView fontSize;

    Switch bold;
    Switch italic;

    ScrollView scrollView;
    TextView heightIndicator;
    TextView widthIndicator;
    Button moreHeight;
    Button lessHeight;
    Button moreWidth;
    Button lessWidth;

    private int height = 300;
    private int width = 1300;

    Button moreRows;
    Button lessRows;
    TextView rowIndicator;

    private int rows = 6;

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_settings, container, false);

        textView = v.findViewById(R.id.textView);
        fontSize = v.findViewById(R.id.fontSizeIndicator);
        plus = v.findViewById(R.id.buttonPlus);
        minus = v.findViewById(R.id.buttonMinus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSizePlus();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSizeMinus();
            }
        });

        bold = v.findViewById(R.id.switchBold);
        italic = v.findViewById(R.id.switchItalic);

        bold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeFontType();
            }
        });
        italic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeFontType();
            }
        });

        scrollView = v.findViewById(R.id.scrollView);
        heightIndicator = v.findViewById(R.id.heightIndicator);
        widthIndicator = v.findViewById(R.id.widthIndicator);

        moreHeight = v.findViewById(R.id.moreHeight);
        lessHeight = v.findViewById(R.id.lessHeight);
        moreWidth = v.findViewById(R.id.moreWidth);
        lessWidth = v.findViewById(R.id.lessWidth);

        moreHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editHeight(v);
            }
        });
        lessHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editHeight(v);
            }
        });
        moreWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editWidth(v);
            }
        });
        lessWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editWidth(v);
            }
        });

        moreRows = v.findViewById(R.id.moreRows);
        lessRows = v.findViewById(R.id.lessRows);
        rowIndicator = v. findViewById(R.id.rowIndicator);

        moreRows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editRows(v);
            }
        });
        lessRows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editRows(v);
            }
        });

        return v;
    }

    public void textSizePlus() {
        textSize += 1;
        textView.setTextSize(textSize);
        fontSize.setText(String.valueOf(textSize));
    }

    public void textSizeMinus() {
        if (textSize >= 1) {
            textSize -= 1;
            textView.setTextSize(textSize);
            fontSize.setText(String.valueOf(textSize));
        }
    }

    public void changeFontType() {
        if (bold.isChecked() && italic.isChecked()) {
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
        } else if (bold.isChecked()) {
            textView.setTypeface(null, Typeface.BOLD);
        } else if (italic.isChecked()) {
            textView.setTypeface(null, Typeface.ITALIC);
        } else {
            textView.setTypeface(null, Typeface.NORMAL);
        }
    }

    public void editHeight(View v) {
        ViewGroup.LayoutParams params = scrollView.getLayoutParams();
        if (v == moreHeight && params.height < 800) {
            height += 50;
            params.height = height;
        } else if (v == lessHeight && params.height > 100) {
            height -= 50;
            params.height = height;
        }
        scrollView.setLayoutParams(params);
        heightIndicator.setText(String.valueOf(params.height));
    }

    public void editWidth(View v) {
        ViewGroup.LayoutParams params = scrollView.getLayoutParams();
        if (v == moreWidth && params.width < 1300) {
            width += 50;
            params.width = width;
        } else if (v == lessWidth && params.height > 100) {
            width -= 50;
            params.width = width;
        }
        scrollView.setLayoutParams(params);
        widthIndicator.setText(String.valueOf(params.width));
    }

    public void editRows(View v) {
        if (v == moreRows) {
            rows += 1;
            textView.setLines(rows);
            rowIndicator.setText(String.valueOf(rows));
        } else if (v == lessRows && rows > 0) {
            rows -= 1;
            textView.setLines(rows);
            rowIndicator.setText(String.valueOf(rows));
        }

    }
}
