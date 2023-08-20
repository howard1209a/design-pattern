package com.dyp.state.impl;

import com.dyp.state.Context;
import com.dyp.state.State;

/**
 * @Description: TODO
 */
public class DayState implements State {
    private static final DayState DAY_STATE = new DayState();

    private DayState() {
    }

    public static DayState getInstance() {
        return DAY_STATE;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        } else if (hour >= 11 && hour < 13) {
            context.changeState(LunchState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("使用金库(白天)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(白天)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话(白天)");
    }

    @Override
    public String toString() {
        return "[白天]";
    }
}
