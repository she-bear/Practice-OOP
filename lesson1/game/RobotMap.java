package ru.gb.lesson1.game;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {

    // final - после инициализации никто не может изменить переменную
    private final int n;
    private final int m;

    private final List<Robot> robots;

    public RobotMap(int n, int m) {
        this.n = n;
        this.m = m;
        this.robots = new ArrayList<>();
    }

    
    public Robot createRobot(Point point) {
        validatePoint(point);
        Robot robot = new Robot(point);
        robots.add(robot);

        return robot;
    }

    
    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }

    
    // проверяем, что точка не занята
    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    // вложенный класс
    public class Robot {
        // по умолчанию робот смотрит вверх
        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x() - 1, point.y());
                case RIGHT -> new Point(point.x(), point.y() + 1);
                case BOTTOM -> new Point(point.x() + 1, point.y());
                case LEFT -> new Point(point.x(), point.y() - 1);
            };
            validatePoint(newPoint);

            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }

        @Override
        public String toString() {
            return point.toString() + ", [" + direction.name() + "]";
        }
    }

}
