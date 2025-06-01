package main;

import java.awt.*;
import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

    GamePanel gp;

    public final int NUM_BUTTONS = 4;
    public boolean[] buttons = new boolean[NUM_BUTTONS];
    public boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    public int mouseX, mouseY;
    public int scroll;

    PointerInfo a; Point b;

    public MouseHandler(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {

        scroll = 0;

        for (int i = 0; i < NUM_BUTTONS; i++) {

            buttonsLast[i] = buttons[i];

        }

        a = MouseInfo.getPointerInfo();
        b = a.getLocation();
        mouseX = (int) b.getX();
        mouseY = (int) b.getY();

        System.out.println("X : " + mouseX + " | Y : " + mouseY);

    }

    // BUTTONS //
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    public boolean isButton(int buttonCode) {

        return buttons[buttonCode];

    }

    public boolean isButtonUp(int buttonCode) {

        return !isButtonDown(buttonCode);

    }

    public boolean isButtonDown(int buttonCode) {

        return buttons[buttonCode] && buttonsLast[buttonCode];

    }

    // MOVEMENT //
    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    // WHEEL //
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }

    // MOUSE COORDINATES
    public int getMouseX() { return mouseX; }

    public int getMouseY() { return mouseY; }

    // WHEEL INFORMATION
    public int getScroll() { return scroll; }
}
