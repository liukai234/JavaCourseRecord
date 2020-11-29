import java.util.Queue;
import java.util.Stack;

// 堆栈，后进先出
public class StackStrOperation {
    Stack stack = null;
    Queue queue = null;
    // 如果类中没有 任何 构造器，编译器会自动创建一个无参构造器，如果有一个的话，编译器就不会创建无参构造器
    public StackStrOperation(Stack stack) {
        this.stack = stack;
    }

    public void push(String str) {
        stack.push(str);
    }

    public void pop() {
        stack.pop();
    }

    public boolean empty() {
        return stack.empty();
    }

    public Object peek() {
        return stack.peek(); // 返回堆栈栈顶的数据，但不删除该数据
    }

    public int search (Object data) {
        return stack.search(data);
    }

    // 内存泄露
    // 不使用资源的时候将其置为空

}
