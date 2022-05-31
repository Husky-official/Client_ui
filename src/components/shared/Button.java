package src.components.shared;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Button extends JButton {
    private String content;
    private Color foreGround;
    private Color backgroundColor;
    private Font textFont;
    private String linearGradient;
    private int textSize;
    private int buttonWidth;
    private int buttonHeight;
    private int radius;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Color getForeGround() {
        return this.foreGround;
    }

    public void setForeGround(Color foreGround) {
        this.foreGround = foreGround;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackground(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Font getTextFont() {
        return this.textFont;
    }

    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }

    public String getLinearGradient() {
        return this.linearGradient;
    }

    public void setLinearGradient(String linearGradient) {
        this.linearGradient = linearGradient;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getButtonWidth() {
        return this.buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return this.buttonHeight;
    }
    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }
    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Button(String content, Color foreGround, Color backgroundColor, Font textFont, int textSize, int buttonWidth, int buttonHeight, int radius) {
        this.content = content;
        this.foreGround = foreGround;
        this.backgroundColor = backgroundColor;
        this.textFont = textFont;
        this.textSize = textSize;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.radius = radius;
        this.setBackground(backgroundColor);
        this.initColors();
    }

    public void initColors() {
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setText(this.content);
        this.setFont(this.textFont);
        this.setForeground(this.foreGround);
        this.setSize(this.buttonWidth, this.buttonHeight);
        this.setBorderPainted(false);
    }
    public Button(String content, Color foreGround, String linearGradient, Font textFont, int textSize, int buttonWidth, int buttonHeight, int radius) {
        this.content = content;
        this.foreGround = foreGround;
        this.textFont = textFont;
        this.linearGradient = linearGradient;
        this.textSize = textSize;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.radius = radius;
        this.initColors();
    }

    public Button(String content, Color foreGround, Color backgroundColor, Font textFont, int radius) {
        this.content = content;
        this.foreGround = foreGround;
        this.textFont = textFont;
        this.backgroundColor = backgroundColor;
        this.radius = radius;
        this.initColors();
    }
    

    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        Color concentrated = new Color(151, 196, 253);
        Color blur = new Color(195, 232, 251);
        if (this.linearGradient != null) {
            System.out.println("Linear is not null");
            GradientPaint gradient = new GradientPaint(0.0F, 0.0F, concentrated, 200.0F, 100.0F, blur);
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setPaint(gradient);
        } else {
            graphics2D.setColor(this.backgroundColor);
        }

        graphics2D.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.radius, this.radius);
        super.paintComponent(graphics);
    }
}
