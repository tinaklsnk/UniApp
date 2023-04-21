package com.example.uniapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import androidx.core.text.HtmlCompat;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uniapp.R;

public class InfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        TextView textView = view.findViewById(R.id.info_text_view);
        textView.setText(Html.fromHtml(
                "<h1>Вступ: інформація для вступників 2023 року</h1>" +
                        "<strong>До уваги вступників до Прикарпатського національного університету!</strong>" +
                        "<p>1. Триває реєстрація на НМТ для випускників шкіл та коледжів. НМТ необхідно складати вступникам, які мають наміри вступати в Університет для навчання на бакалавраті (на перший чи старші курси).</p>" +
                        "<p>2. Для вступників у магістратуру буде проведено консультацію, щодо Правил прийому та реєстрації на ЄВІ та ЄФВВ 4 травня, онлайн. Слідкуйте за анонсами на сайті Університету.</p>" +
                        "<p>3. Детальна інформація щодо Правил вступу до Університету буде опублікована 28 квітня 2023 року (після затвердження Правил прийому до Університету).</p>"
        ));

        return view;
    }
}
