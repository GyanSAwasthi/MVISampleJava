package com.example.mvisample;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;
import java.util.Map;


import butterknife.BindView;
import butterknife.ButterKnife;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author gyan
 */
public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new MainIntent(this).start();
    }

    @Override
    public Map<String, Observable> getActions() {
        Map<String, Observable> actions = new HashMap<>();
        actions.put("Button", RxView.clicks(button));
        actions.put("EditText", RxTextView.textChanges(editText));
        return actions;
    }

    @Override
    public Map<String, Consumer> getConsumers() {
        Map<String, Consumer> consumers = new HashMap<>();
        consumers.put("TextView", RxTextView.text(text));
        consumers.put("EditText", RxTextView.text(editText));
        return consumers;
    }
}