package pckg;

import java.awt.*;

// Интерфейс фабрики фигур
interface ShapeFactory {
    Shape createShape(Point start, Point end, Color color); // Метод для создания фигуры с двумя точками
}
