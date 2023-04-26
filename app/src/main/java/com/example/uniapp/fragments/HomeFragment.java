package com.example.uniapp.fragments;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uniapp.R;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView = view.findViewById(R.id.home_text_view);

        String headerText = "Прикарпатський національний університет імені Василя Стефаника – один із провідних закладів вищої освіти України – засновано 1940 року.";
        String visionText = "\n\nНаше бачення: ";
        String missionText = "\nНаша місія:";
        String educationText = "\nосвіта ";
        String scienceText = "наука ";
        String regionText = "регіон ";
        String accreditationText = "\n\nУніверситет акредитований за найвищим, ІV рівнем акредитації.\n";

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(headerText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), 0, headerText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 0, headerText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);

        spannableStringBuilder.append(visionText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), spannableStringBuilder.length() - visionText.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append("Прикарпатський національний університет імені Василя Стефаника – сучасний конкурентоспроможний освітній та науково-дослідницький центр міжнародного рівня, потенціал якого впливає на розвиток регіону та формування людського капіталу.\n");

// Append mission text with bold font size and italicized education, science, and region text
        spannableStringBuilder.append(missionText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), spannableStringBuilder.length() - missionText.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(educationText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), spannableStringBuilder.length() - educationText.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append("– надання якісних освітніх послуг, спрямованих на підготовку високопрофесійних фахівців;\n");
        spannableStringBuilder.append(scienceText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), spannableStringBuilder.length() - scienceText.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append("– формування сучасного дослідницького університету – центру генерування інноваційних ідей та їх реалізації;\n");
        spannableStringBuilder.append(regionText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), spannableStringBuilder.length() - regionText.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append("– спрямування освітнього та наукового потенціалу на розвиток і зміцнення регіону.");

        spannableStringBuilder.append(accreditationText);
        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), spannableStringBuilder.length() - accreditationText.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append("\nПрикарпатський національний університет імені Василя Стефаника займає високі позиції у міжнародних та вітчизняних рейтингах ЗВО. Згідно з міжнародним рейтингом SciMago Institutions Rankings  університет посідає 2 місце (2021 р.) серед університетів України, 7 позицію у Міжнародному рейтингу U-Multirank (2021), 10 місце у рейтингу “Кращі класичні університети” (2021), 10 місце у міжнародному рейтингу SCOPUS (2021), 10 місце у рейтингу ТОП-10 серед класичних університетів України, 12 місце у рейтингу Webometrix Ranking of world’s university, 20 місце у рейтинг найвпливовіших університетів світу (2021), 23 місце у рейтингу «ТОП-200 Україна 2021».\n");
        spannableStringBuilder.append("\nПрикарпатський національний університет імені Василя Стефаника здійснює підготовку фахівців за 7 спеціальностями фахового молодшого бакалавра, 82 спеціальностями та освітніми програмами рівня бакалавра, 70 спеціальностями та освітніми програмами рівня магістра, 25-ма спеціальностями підготовки докторів філософії, 18-ма спеціальностями підготовки докторів наук, веде плідну науково-дослідну та інноваційну діяльність. За весь час своєї діяльності у закладі вищої освіти було підготовлено понад 140 тисяч фахівців.\n");
        spannableStringBuilder.append("\nУніверситет підтримує тісні зв’язки з багатьма науковими та навчальними закладами світу, зокрема США, Азії  і ЄС. Реалізує 12-ть безкоштовних магістерських програм подвійних дипломів з провідними університетами Республіки Польща.\n");
        spannableStringBuilder.append("\nУніверситет є членом міжнародних консорціумів: член Європейської асоціації університетів (2010 р.); член консорціуму Варшавського та українських університетів (2006 р.);  член міжнародного консорціуму університетів (2015 р.); член консорціуму університетів Балтійського регіону та України (2015 р.); член міжнародної університетської спільноти «Один пояс – один шлях» (2016 р.); член Великої хартії університетів «Magna charta universitatum» (2018 р.); член Європейського університетського альянсу EDUC (European Digital UniverCity) (2022 р.).\n");
        spannableStringBuilder.append("\nАктивно розвивається мережа співпраці з іноземними партнерами: підписано більше 80 угод про співпрацю з університетами і організаціями з різних країн світу.\n");
        spannableStringBuilder.append("\nУніверситет щороку реалізовує освітні, наукові та інфраструктурні грантові проєкти, розвиваючи свій науковий потенціал, удосконалюючи навчальний процес та впливаючи на розвиток регіону.\n");
        spannableStringBuilder.append("\nВ університеті функціонує спільна навчально-наукова лабораторія фізики магнітних плівок з Інститутом металофізики ім. Г.В. Курдюмова НАН України,  яка має статус Національного надбання України.\n");
        spannableStringBuilder.append("\nНаукова інфраструктура університету представлена  23 навчально-науковими центрами, Міжнародним науковим центром “Обсерваторія”, Національним контактним пунктом програми ЄС Горизонт – 2020 за напрямком “Нанотехнології, сучасні матеріали та передові сучасні виробництва”, Науковим парком “Прикарпатський університет”,  Ботанічним садом, Дендропарком “Дружба”, Науковою бібліотекою, 2 міжвідомчими лабораторіями, 10 науковими лабораторіями та Центром колективного користування науковим обладнанням.\n");
        spannableStringBuilder.append("\nУспішно реалізуються міжнародні проєкти – Державний інвестиційний проект «Будівництво Міжнародного центру зустрічей студентської молоді України і Республіки Польща (селище Микуличин Івано-Франківської області)» та проєкт “Міжнародний науковий центр “Обсерваторія” на горі Піп Іван” (г. Піп Іван, Чорногірський хребет, Карпати), який виконується за грантові кошти ЄС.\n");

        textView.setText(spannableStringBuilder);

        return view;
    }
}
