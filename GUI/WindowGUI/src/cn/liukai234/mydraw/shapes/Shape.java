package cn.liukai234.mydraw.shapes;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

public interface Shape {
	void setTop(int top);
	void setLeft(int left);
	void setWidth(int width);
	void setHeight(int height);
	void setGC(GC gcMain);
	void draw();
	void setPaintColor(Color paintColor);
	void setLineStyle(int lineStyle);
	void setLineWidth(int lineWidth);
	
	public String getString();
}
