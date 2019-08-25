package com.architect.observer.topic;

import com.architect.observer.core.Event;
import com.architect.observer.core.EventType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObserverListener {

    private Map<EventType, Event> eventMap = new HashMap<EventType, Event>();

    public void addListener(EventType type, Object target, Method callback){
        eventMap.put(type, new Event(target,callback));
    }

    private void trigger(Event e){
        e.setSrc(this);
        e.setTime(System.currentTimeMillis());
        try {
            e.getCallback().invoke(e.getTarget(),e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void trigger(EventType eventType){
        if (!eventMap.containsKey(eventType)) {
            return;
        }
        trigger(eventMap.get(eventType).setTrigger(eventType.toString()));
    }
}
