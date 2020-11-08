package cn.liukai234.mydraw.shapes;
import org.eclipse.swt.graphics.GC;

public interface Shape {
	void setTop(int top);
	void setLeft(int left);
	void setWidth(int width);
	void setHeight(int height);
	void setGC(GC gcMain);
	void draw();
}
