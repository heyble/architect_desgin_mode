package com.architect.observer.core;

import java.lang.reflect.Method;

public class Event {
    private Object src;
    private Object target;
    private Method callback;
    private String trigger;
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "Event{" +
                "src=" + src +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }

    public Object getSrc() {
        return src;
    }

    public void setSrc(Object src) {
        this.src = src;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }
}
