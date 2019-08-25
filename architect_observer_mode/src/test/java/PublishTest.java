import com.architect.observer.core.Event;
import com.architect.observer.core.EventType;
import com.architect.observer.topic.Observer;
import com.architect.observer.topic.Publish;

import java.lang.reflect.Method;

public class PublishTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Observer observer = new Observer();
        Method advice = observer.getClass().getMethod("advice", Event.class);

        Publish publish = new Publish();
        publish.addListener(EventType.ON_PUBLISH,observer,advice);

        publish.send("hello world");
    }
}
