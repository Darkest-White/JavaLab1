package pckg;

import java.awt.*;

// Прямоугольник
class Rectangle implements Shape {
    private Point start; // Начальная точка
    private Point end; // Конечная точка
    private Color color; // Цвет прямоугольника

    // Конструктор прямоугольника
    public Rectangle(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    // Метод рисования прямоугольника
    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Устанавливаем цвет
        int x = Math.min(start.x, end.x); // Вычисляем координату X
        int y = Math.min(start.y, end.y); // Вычисляем координату Y
        int width = Math.abs(start.x - end.x); // Вычисляем ширину
        int height = Math.abs(start.y - end.y); // Вычисляем высоту
        g.fillRect(x, y, width, height); // Рисуем прямоугольник
    }
}
