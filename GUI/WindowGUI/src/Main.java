import cn.liukai234.mydraw.shapes.Shape;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {
	private static GC gcMain = null;
	private static boolean leftButtonDown = false;
	private static int lastWidth = 0;
	private static int lastHeight = 0;
	protected static int startX = 0;
	protected static int startY = 0;
	private static String shapeType = "Rect";
	private static Shell shell;
	private static Board board;
	
	public static void main(String[] args) {
		
		Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		board = new Board();
		
//		List listClass = null;
//		String pkg = "cn.liukai234.mydraw.shapes";
//		getClass = ClassUtil
		
//		ArrayList<String> shapeTypes = new ArrayList<String>();
		
		
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board.refresh();
			}
		});
		
		gcMain = new GC(shell);
		
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if(leftButtonDown) {
					// Erase
					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					
					// Draw
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
					gcMain.drawRectangle(startX, startY, arg0.x-startX,arg0.y-startY);
					
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					gcMain.setLineStyle(SWT.LINE_SOLID);
					board.refresh();
					
					lastWidth = arg0.x - startX;
					lastHeight = arg0.y - startY;
				}
			}
		});
		
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				startX = e.x;
				startY = e.y;
				leftButtonDown = true;
				shell.setCursor(new Cursor(null, SWT.CURSOR_CROSS));
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				if(e.button == 1) {
					leftButtonDown = false;
					int width = e.x - startX;
					int height = e.y - startY;

					// �����������������
					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					
					gcMain.setLineStyle(SWT.LINE_SOLID);
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));

					Shape shape = null;
					Class<?> shapeClass = null;
					try {
						shapeClass = Class.forName("cn.liukai234.mydraw.shapes." + shapeType);
						Object oShape = shapeClass.newInstance();
						
						shape = (Shape)oShape;
						shape.setTop(startX);
						shape.setLeft(startY);
						shape.setWidth(width);
						shape.setHeight(height);
						shape.setGC(gcMain);
					} catch (Exception ex) {
						shape = null;
						System.out.println(ex.getMessage());
					}
						
//					switch(shapetype) {
//					case 1:
//						shape=new Rect(startX,startY,width,height,gcMain);
//						break;
//					case 2:
//						shape=new Circle(startX,startY,width,height,gcMain);
//						break;
//					case 3:
//						shape=new RoundRect(startX,startY,width,height,50,50,gcMain);
//						break;
//					}
					
					
					shell.setCursor(new Cursor(null, SWT.CURSOR_ARROW));
					
					if(shape != null) {
						board.insertShape(shape);
						board.refresh();	
					}
					
				}
			}
			
		});
		

		
		Button btnRect = new Button(shell, SWT.NONE);
		btnRect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "Rect";
			}
		});
		btnRect.setBounds(10, 10, 98, 30);
		btnRect.setText("Rect");
		
		Button btnCircle = new Button(shell, SWT.NONE);
		btnCircle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "Circle";
			}
		});
		btnCircle.setBounds(114, 10, 98, 30);
		btnCircle.setText("Circle");
		
		Button btnRoundRect = new Button(shell, SWT.NONE);
		btnRoundRect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "RoundRect";
			}
		});
		btnRoundRect.setBounds(218, 10, 98, 30);
		btnRoundRect.setText("RoundRect");

		
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
