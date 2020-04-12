package com.example.mvisample;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


/**
 * @author gyan
 */
interface MainView {

    Map<String, Observable> getActions();

    Map<String, Consumer> getConsumers();

}
//SD7240699