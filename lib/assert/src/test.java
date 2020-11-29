/**
 * test
 */
public class test {

    public static void main(String[] args) {
        int num = -1;
        // 格式: assert 表达式 : 提示语句
        // 当assert表达式为false时从assert出停止执行并输出调试语句
        // 调试参数: -ea
        // Emp: java -ea test
        // IDEA在项目配置VM: option中添加参数-ea

        assert num >= 0 : "num < 0 !";
    }
}