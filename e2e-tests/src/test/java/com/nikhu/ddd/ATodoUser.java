package com.nikhu.ddd;

import net.thucydides.core.annotations.Step;

/**
 * Created by vravuri on 11-Jul-17.
 */
public class ATodoUser {

    SimplestAction action = new SimplestAction();

    @Step
    public void preparedEnvironment() {
        this.action.nothing();
    }

    @Step
    public void perform(String actionName) {
        this.action.nothing();
    }

    @Step
    public void checkResult(String action, String result) {
        this.action.nothing();
    }
}