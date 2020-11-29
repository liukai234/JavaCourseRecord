public class Circle implements Shape{
    private String circle = "Circle";
    public Circle(){}

    // 注解 名称屏蔽
    @Override
    public String getType() { return circle; }
}
