package com.example.mvisample;

import java.util.Map;

import io.reactivex.functions.Consumer;

/**
 * @author gyan
 */
class MainModel {

    private final String defaultText = "Default Text";

    private String text;

    private Map<String, Consumer> consumers;

    MainModel(Map<String, Consumer> consumers) {
        this.consumers = consumers;
        resetText();
    }

    @SuppressWarnings("unchecked")
    void changeText(String text) {
        this.text = text;
        try {
         Consumer a =   consumers.get("TextView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    void resetText() {
        this.text = defaultText;
        try {
            consumers.get("EditText").accept(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
