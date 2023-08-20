package com.dyp.interpreter.turtle;

import com.dyp.interpreter.language.Executor;
import com.dyp.interpreter.language.ExecutorFactory;

import java.awt.*;

/**
 * @Description: TODO
 */
public class TurtleCanvas extends Canvas implements ExecutorFactory {
    static final int UNIT_LENGTH = 30; // 前进时的长度单位
    static final int DIRECTION_UP = 0; //上方
    static final int DIRECTION_RIGHT = 3; // 右方
    static final int DIRECTION_DOWN = 6; // 下方
    static final int DIRECTION_LEFT = 9; // 左方
    static final int RELETIVE_DIRECTION_RIGHT = 3; // 右转
    static final int RELETIVE_DIRECTION_LEFT = -3; // 左转
    static final int RADIUS = 3; // 半径
    private int direction = 0;
    private Point position;
    private Executor executor;

    public TurtleCanvas(int width, int height) {
        setSize(width, height);
        initialize();
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    void setRelativeDirection(int relativeDirection) {
        setDirection(direction + relativeDirection);
    }

    void setDirection(int direction) {
        if (direction < 0) {
            direction = 12 - (-direction) % 12;
        } else {
            direction = direction % 12;
        }
        this.direction = direction % 12;
    }

    void go(int length) {
        int newx = position.x;
        int newy = position.y;
        switch (direction) {
            case DIRECTION_UP:
                newy -= length;
                break;
            case DIRECTION_RIGHT:
                newx += length;
                break;
            case DIRECTION_DOWN:
                newy += length;
                break;
            case DIRECTION_LEFT:
                newx -= length;
                break;
            default:
                break;
        }
        Graphics g = getGraphics();
        if (g != null) {
            g.drawLine(position.x, position.y, newx, newy);
            g.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1);
        }
        position.x = newx;
        position.y = newy;
    }

    private void initialize() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size().height / 2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics g = getGraphics();
        if (g != null) {
            g.clearRect(0, 0, size.width, size.height);
        }
    }

    @Override
    public Executor createExecutor(String name) {
        if ("go".equals(name)) {
            return new GoExecutor(this);
        } else if ("left".equals(name)) {
            return new DirectionExecutor(this, RELETIVE_DIRECTION_LEFT);
        } else if ("right".equals(name)) {
            return new DirectionExecutor(this, RELETIVE_DIRECTION_RIGHT);
        } else {
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        initialize();
        if (executor != null) {
            executor.execute();
        }
    }


    abstract class TurtleExecutor implements Executor {
        protected TurtleCanvas canvas;

        public TurtleExecutor(TurtleCanvas canvas) {
            this.canvas = canvas;
        }
    }

    class GoExecutor extends TurtleExecutor {

        public GoExecutor(TurtleCanvas canvas) {
            super(canvas);
        }

        @Override
        public void execute() {
            canvas.go(UNIT_LENGTH);
        }
    }

    class DirectionExecutor extends TurtleExecutor {
        private int relativeDirection;

        public DirectionExecutor(TurtleCanvas canvas, int relativeDirection) {
            super(canvas);
            this.relativeDirection = relativeDirection;
        }

        @Override
        public void execute() {
            canvas.setRelativeDirection(relativeDirection);
        }
    }
}
