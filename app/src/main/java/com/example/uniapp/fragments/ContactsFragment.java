package com.example.uniapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uniapp.R;

public class ContactsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        TextView textView = view.findViewById(R.id.contacts_text_view);
        textView.setText(Html.fromHtml(
                        "<h1>Контакти</h1>" +
                                "<p><strong>Код ЕДРПОУ 02125266</strong></p>" +
                                "<p><strong>76018, м. Івано-Франківськ,</strong></p>" +
                                "<p><strong>вул. Шевченка, 57</strong></p>" +
                                "<p><strong>тел. (0342) 75-23-51</strong></p>" +
                                "<p><strong>факс (0342) 53-15-74</strong></p>" +
                                "<p><strong>e-mail: office@pnu.edu.ua</strong></p>"
        ));

        return view;
    }
}