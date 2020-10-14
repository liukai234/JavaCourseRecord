
import java.util.Queue;

public class QueueOperation {
        Queue queue = null;
        // 如果类中没有 任何 构造器，编译器会自动创建一个无参构造器，如果有一个的话，编译器就不会创建无参构造器
        public QueueOperation(Queue queue) {
            this.queue = queue;
        }

        public void push(String str) {
            queue.add(str); // 抛异常
        }

        public void poll() { queue.poll(); }
        public Object peek() { return queue.peek(); }
}


