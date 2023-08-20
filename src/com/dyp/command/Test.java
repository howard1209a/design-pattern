package com.dyp.command;

import com.dyp.command.impl.ColorCommand;
import com.dyp.command.impl.DrawCanvas;
import com.dyp.command.impl.DrawCommand;
import com.dyp.command.impl.MacroCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @Description: TODO
 */
public class Test extends JFrame implements ActionListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton = new JButton("clear");
    private JButton redButton = new JButton("redButton");
    private JButton greenButton = new JButton("greenButton");
    private JButton blueButton = new JButton("blueButton");
    private JButton undoButton = new JButton("undoButton");

    public Test(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas, e.getPoint());
                history.append(command);
                command.execute();
            }
        });
        clearButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        } else if (e.getSource() == redButton) {
            Command command = new ColorCommand(canvas, Color.red);
            history.append(command);
            command.execute();
        } else if (e.getSource() == greenButton) {
            Command command = new ColorCommand(canvas, Color.green);
            history.append(command);
            command.execute();
        } else if (e.getSource() == blueButton) {
            Command command = new ColorCommand(canvas, Color.blue);
            history.append(command);
            command.execute();
        } else if (e.getSource() == undoButton) {
            for (int i = 0; i < 10; i++) {
                history.undo();
            }
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new Test("command pattern sample");
    }
}
