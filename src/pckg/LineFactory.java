package pckg;

import java.awt.*;

// Фабрика для линий
class LineFactory implements ShapeFactory {
    @Override
    public Shape createShape(Point start, Point end, Color color) {
        return new Line(start, end, color); // Создаем линию
    }
}
