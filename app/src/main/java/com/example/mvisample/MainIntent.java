package com.example.mvisample;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author gyan
 */
class MainIntent {

    private Map<String, Observable> actions;
    private MainModel mainModel;

    MainIntent(MainView mainView) {
        actions = mainView.getActions();
        mainModel = new MainModel(mainView.getConsumers());
    }

    @SuppressWarnings("unchecked")
    void start() {
        actions.get("Button").subscribe(next -> mainModel.resetText());
        actions.get("EditText").subscribe(changedText -> mainModel.changeText(changedText.toString()));
    }
}
