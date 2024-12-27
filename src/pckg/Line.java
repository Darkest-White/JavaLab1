package pckg;

import java.awt.*;

// Линия
class Line implements Shape {
    private Point start; // Начальная точка
    private Point end; // Конечная точка
    private Color color; // Цвет линии

    // Конструктор линии
    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    // Метод рисования линии
    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Устанавливаем цвет
        g.drawLine(start.x, start.y, end.x, end.y); // Рисуем линию
    }
}
