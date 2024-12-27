package pckg;

import java.awt.*;

// Фабрика для прямоугольников
class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape(Point start, Point end, Color color) {
        return new Rectangle(start, end, color); // Создаем прямоугольник
    }
}
