package pckg;

import java.awt.*;

// Фабрика для кругов
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape(Point start, Point end, Color color) {
        return new Circle(start, end, color); // Создаем круг
    }
}
