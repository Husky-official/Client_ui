package src.utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class IconTextComponentHelper {
    private static final int ICON_SPACING = 4;
    private Border mBorder;
    private Icon mIcon;
    private Border mOrigBorder;
    private JTextComponent mTextComponent;

    IconTextComponentHelper(JTextComponent component) {
        this.mTextComponent = component;
        this.mOrigBorder = component.getBorder();

        this.mBorder = this.mOrigBorder;
    }



    Border getBorder() {
        return this.mBorder;
    }

    void onPaintComponent(Graphics g) {
        if (this.mIcon != null) {
            Insets iconInsets = this.mOrigBorder.getBorderInsets(this.mTextComponent);
            this.mIcon.paintIcon(this.mTextComponent, g, iconInsets.left, iconInsets.top);
        }

    }

    void onSetBorder(Border border) {
        this.mOrigBorder = border;
        if (this.mIcon == null) {
            this.mBorder = border;
        } else {
            Border margin = BorderFactory.createEmptyBorder(0, this.mIcon.getIconWidth() + 4, 0, 0);
            this.mBorder = BorderFactory.createCompoundBorder(border, margin);
        }

    }

    void onSetIcon(Icon icon) {
        this.mIcon = icon;
        this.resetBorder();
    }

    private void resetBorder() {
        this.mTextComponent.setBorder(this.mOrigBorder);
    }
}
