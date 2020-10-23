import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MainWindow {
    public static void main(String[] args) {
        Display display = Display.getDefault();
        Shell shell = new Shell();

        shell.setSize(450, 300);
        shell.setText("SWT Main Window");

        shell.open();
        shell.setLayout(new FillLayout());
        Label label = new Label(shell, SWT.CENTER);
        label.setText("Line");
        Color red = new Color(display, 225, 0, 0);
        label.setForeground(red);
        Button button = new Button(shell, 1);
        button.setText("Button");
        Button button1 = new Button(shell, 1);
        button.setText("Test");
        shell.layout();

        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}

