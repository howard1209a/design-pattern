package com.dyp.state.impl;

import com.dyp.state.Context;
import com.dyp.state.State;

/**
 * @Description: TODO
 */
public class LunchState implements State {
    private static final LunchState LUNCH_STATE = new LunchState();

    private LunchState() {
    }

    public static LunchState getInstance() {
        return LUNCH_STATE;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        } else if ((hour >= 9 && hour < 11) || (hour >= 13 && hour < 17)) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急:中午使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(中午)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("中午的通话录音");
    }
}
