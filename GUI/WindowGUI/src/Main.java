import cn.liukai234.mydraw.shapes.Shape;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	private static GC gcMain = null;
	private static boolean leftButtonDown = false;
	private static int lastWidth = 0;
	private static int lastHeight = 0;
	protected static int startX = 0;
	protected static int startY = 0;
	private static String shapeType = "cn.liukai234.mydraw.shapes.Rect";
	private static Shell shell;
	private static Board board;
	private static Color paintColor = null;
	private static int lineStyle = SWT.LINE_SOLID;
	private static int lineWidth = 1;
	
	
	public static void main(String[] args) {
		
		Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(900, 600);
		shell.setText("SWT Application");
		board = new Board();
		paintColor = display.getSystemColor(SWT.COLOR_BLACK);
		List listClass = null;
		String pkg = "cn.liukai234.mydraw.shapes";
		listClass = ClassUtil.getClassList(pkg, true, null);
		
		ArrayList<String> shapeTypes = new ArrayList<String>();
		for(Object object : listClass) {
			String name = ((Class<?>)object).getName();
			if(!name.equals("cn.liukai234.mydraw.shapes.Shape")) {// cn.liukai234.mydraw.shapes.Shape
				shapeTypes.add(name);
			}
		}


		int indexButton = 0;
		
		for(String strClass : shapeTypes) {
			Button btn = new Button(shell, SWT.NONE);
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					shapeType = strClass;
				}
			});
			btn.setBounds(110 * indexButton, 0, 105, 27);
			indexButton ++;
			try{
				Class<?> shapeClass = Class.forName(strClass);
//				Class shapeClass = Class.forName("cn.liukai234.mydraw.shapes." + shapeType);
				String str = shapeClass.getTypeName();
				StringTokenizer st = new StringTokenizer(str, ".", false);
				st.countTokens();
				while(st.hasMoreElements()){
					str = st.nextElement().toString();
				}
				btn.setText(str);
				btn.setData("shapeType", strClass);
			} catch(Exception e) {
				btn.setText(strClass);
				btn.setData("shapeType", strClass);
			}
		}

		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board.refresh();
			}
		});
		
		gcMain = new GC(shell);
		
		Button btnBlack = new Button(shell, SWT.NONE);
		btnBlack.setBounds(0, 460, 105, 27);
		btnBlack.setText("Black");
		btnBlack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 paintColor = display.getSystemColor(SWT.COLOR_BLACK);
			}
		});
		
		Button btnBlue = new Button(shell, SWT.NONE);
		btnBlue.setText("Blue");
		btnBlue.setBounds(0, 493, 105, 27);
		btnBlue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 paintColor = display.getSystemColor(SWT.COLOR_BLUE);
			}
		});
		
		Button btnRed = new Button(shell, SWT.NONE);
		btnRed.setText("Red");
		btnRed.setBounds(0, 526, 105, 27);
		btnRed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 paintColor = display.getSystemColor(SWT.COLOR_RED);
			}
		});
		
		Button btnDot = new Button(shell, SWT.NONE);
		btnDot.setText("Dot");
		btnDot.setBounds(111, 526, 105, 27);
		btnDot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 lineStyle = SWT.LINE_DOT;
			}
		});
		
		Button btnSolid = new Button(shell, SWT.NONE);
		btnSolid.setText("Solid");
		btnSolid.setBounds(111, 493, 105, 27);
		btnSolid.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 lineStyle = SWT.LINE_SOLID;
			}
		});
		
		
		Button btnLight = new Button(shell, SWT.NONE);
		btnLight.setText("Light");
		btnLight.setBounds(222, 526, 105, 27);
		btnLight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 lineWidth = 1;
			}
		});
		
		Button btnThick = new Button(shell, SWT.NONE);
		btnThick.setText("Thick");
		btnThick.setBounds(222, 493, 105, 27);
		btnThick.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 lineWidth = 3;
			}
		});
		
		Button btnLoad = new Button(shell, SWT.NONE);
		btnLoad.setText("Load");
		btnLoad.setBounds(777, 526, 105, 27);
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					DataInputStream in = new DataInputStream(new FileInputStream("text.txt"));
					
					String str = in.readUTF();
					System.out.println(str);
					StringTokenizer st = new StringTokenizer(str, " ,{}", false);
					String[] temp = new String[st.countTokens()];
					
			        int i = 0;
			        while(st.hasMoreElements()){
			            temp[i] = st.nextElement().toString();
			            i = i + 1;
			        }
			        i = 0;
			        
			        Shape shape = null;
					Class shapeClass = null;
//					System.out.println("i: " + i + "temp.length: " + temp.length);
//					
//					for(int j = 0; j < temp.length; j++) {
//						System.out.println("i: " + j + "temp[i]: " + temp[j]);
//					}
					
					while(i + 11 < temp.length) {
				        shapeType = temp[i + 0];
				        shapeClass = Class.forName(shapeType); // "cn.liukai234.mydraw.shapes."
						Object oShape = shapeClass.newInstance();
						
						shape = (Shape)oShape;
						shape.setTop(Integer.parseInt(temp[i + 1]));
						shape.setLeft(Integer.parseInt(temp[i + 2]));
						shape.setWidth(Integer.parseInt(temp[i + 3]));
						shape.setHeight(Integer.parseInt(temp[i + 4]));
						shape.setGC(gcMain);
						shape.setPaintColor(new Color(display, Integer.parseInt(temp[i + 6]), Integer.parseInt(temp[i + 7]), Integer.parseInt(temp[i + 8])));
						shape.setLineStyle(Integer.parseInt(temp[i + 10]));
						shape.setLineWidth(Integer.parseInt(temp[i + 11]));
						board.insertShape(shape);
						board.refresh();
						i += 12;
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setText("Save");
		btnSave.setBounds(777, 493, 105, 27);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("text.txt"));
					System.out.println(board.getSaveStream());
					outputStream.writeUTF(board.getSaveStream());
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
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
//				System.out.println("Main: " + startX + " " + startY);
				leftButtonDown = true;
				shell.setCursor(new Cursor(null, SWT.CURSOR_CROSS));
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				if(e.button == 1) {
					leftButtonDown = false;
					int width = e.x - startX;
					int height = e.y - startY;

					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					
					gcMain.setLineStyle(SWT.LINE_SOLID);
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));

					Shape shape = null;
					Class shapeClass = null;
					try {
						// TODO
						shapeClass = Class.forName(shapeType); // "cn.liukai234.mydraw.shapes."
						Object oShape = shapeClass.newInstance();

						shape = (Shape)oShape;
						shape.setTop(startX);
						shape.setLeft(startY);
						shape.setWidth(width);
						shape.setHeight(height);
						shape.setGC(gcMain);
						shape.setPaintColor(paintColor);
						shape.setLineStyle(lineStyle);
						shape.setLineWidth(lineWidth);
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
		

		
//		Button btnRect = new Button(shell, SWT.NONE);
//		btnRect.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				shapeType = "Rect";
//			}
//		});
//		btnRect.setBounds(10, 10, 98, 30);
//		btnRect.setText("Rect");
//
//		Button btnCircle = new Button(shell, SWT.NONE);
//		btnCircle.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				shapeType = "Circle";
//			}
//		});
//		btnCircle.setBounds(114, 10, 98, 30);
//		btnCircle.setText("Circle");
//
//		Button btnRoundRect = new Button(shell, SWT.NONE);
//		btnRoundRect.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				shapeType = "RoundRect";
//			}
//		});
//		btnRoundRect.setBounds(218, 10, 98, 30);
//		btnRoundRect.setText("RoundRect");

		

		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
