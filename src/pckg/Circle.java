package pckg;

import java.awt.*;

// Круг
class Circle implements Shape {
    private Point start; // Начальная точка
    private Point end; // Конечная точка
    private Color color; // Цвет круга

    // Конструктор круга
    public Circle(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    // Метод рисования круга
    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Устанавливаем цвет
        int radius = (int) start.distance(end); // Радиус круга
        int x = start.x - radius; // Вычисляем X для верхнего левого угла
        int y = start.y - radius; // Вычисляем Y для верхнего левого угла
        g.fillOval(x, y, 2 * radius, 2 * radius); // Рисуем круг
    }
}
