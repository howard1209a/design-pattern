package com.dyp.mediator.impl;

import com.dyp.mediator.Colleague;
import com.dyp.mediator.Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author howard
 * @version 1.0
 */
public class ColleagueButton extends Button implements ActionListener,Colleague {
    private Mediator mediator;
    public boolean isExit = false;

    public ColleagueButton(String label) throws HeadlessException {
        super(label);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isExit = true;
        mediator.colleagueChanged();
    }
}
