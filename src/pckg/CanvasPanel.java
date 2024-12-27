package pckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

// Панель для рисования
class CanvasPanel extends JPanel {
    private ShapeFactory shapeFactory; // Текущая фабрика для создания фигур
    private Color currentColor = Color.BLACK; // Цвет для рисуемых фигур
    private List<Shape> shapes = new ArrayList<>(); // Список всех нарисованных фигур
    private CommandManager commandManager = CommandManager.getInstance(); // Менеджер команд для отмены/выполнения действий
    private Point startPoint; // Начальная точка для рисования

    // Устанавливаем фабрику для создания фигур
    public void setShapeFactory(ShapeFactory factory) {
        this.shapeFactory = factory;
    }

    // Устанавливаем текущий цвет
    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    // Получаем текущий цвет
    public Color getCurrentColor() {
        return currentColor;
    }

    // Конструктор, в котором добавляется слушатель нажатий мыши
    public CanvasPanel() {
        // Добавляем слушатель для событий мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint(); // Сохраняем точку, где нажата мышь
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Когда кнопка мыши отпускается, создаем фигуру и добавляем команду в менеджер команд
                if (shapeFactory != null && startPoint != null) {
                    Shape shape = shapeFactory.createShape(startPoint, e.getPoint(), currentColor);
                    AddShapeCommand command = new AddShapeCommand(shapes, shape);
                    commandManager.executeCommand(command);
                    repaint(); // Перерисовываем панель
                }
            }
        });
    }

    // Метод для рисования всех фигур на панели
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g); // Отрисовываем каждую фигуру
        }
    }
}
