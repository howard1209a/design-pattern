package com.dyp.mediator.impl;

import com.dyp.mediator.Colleague;
import com.dyp.mediator.Mediator;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author howard
 * @version 1.0
 */
public class LoginFrame extends Frame implements Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged();
        pack();
        show();
    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(buttonOk);
        buttonCancel.addActionListener(buttonCancel);
    }

    @Override
    public void colleagueChanged() {
        if (buttonOk.isExit || buttonCancel.isExit) {
            System.exit(0);
        }
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            if (textUser.getText().length() > 4) {
                textPass.setColleagueEnabled(true);
                if (textPass.getText().length() > 4) {
                    buttonOk.setColleagueEnabled(true);
                } else {
                    buttonOk.setColleagueEnabled(false);
                }
            } else {
                textPass.setColleagueEnabled(false);
                buttonOk.setColleagueEnabled(false);
            }
        }
    }
}
