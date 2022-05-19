package src.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class IconTextField extends JTextField {
    private IconTextComponentHelper mHelper = new IconTextComponentHelper(this);

    public IconTextField() {
    }

    public IconTextField(int cols) {
        super(cols);
    }

    private IconTextComponentHelper getHelper() {
        if (this.mHelper == null) {
            this.mHelper = new IconTextComponentHelper(this);
        }

        return this.mHelper;
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.getHelper().onPaintComponent(graphics);
    }

    public void setIcon(Icon icon) {
        this.getHelper().onSetIcon(icon);
    }

    public void setBorder(Border border) {
        this.getHelper().onSetBorder(border);
        super.setBorder(this.getHelper().getBorder());
    }
}
