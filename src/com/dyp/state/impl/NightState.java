package com.dyp.state.impl;

import com.dyp.state.Context;
import com.dyp.state.State;

/**
 * @Description: TODO
 */
public class NightState implements State {
    private static final NightState NIGHT_STATE = new NightState();

    private NightState() {
    }

    public static NightState getInstance() {
        return NIGHT_STATE;
    }

    @Override
    public void doClock(Context context, int hour) {
        if ((hour >= 9 && hour < 11) || (hour >= 13 && hour < 17)) {
            context.changeState(DayState.getInstance());
        } else if (hour >= 11 && hour < 13) {
            context.changeState(LunchState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急:晚上使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(晚上)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("晚上的通话录音");
    }

    @Override
    public String toString() {
        return "[晚上]";
    }
}
