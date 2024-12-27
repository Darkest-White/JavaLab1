package pckg;

import java.util.List;

// Команда добавления фигуры
class AddShapeCommand implements Command {
    private List<Shape> shapes; // Список фигур
    private Shape shape; // Фигура для добавления

    // Конструктор команды
    public AddShapeCommand(List<Shape> shapes, Shape shape) {
        this.shapes = shapes;
        this.shape = shape;
    }

    // Выполнение команды (добавление фигуры в список)
    @Override
    public void execute() {
        shapes.add(shape);
    }

    // Отмена команды (удаление фигуры из списка)
    @Override
    public void undo() {
        shapes.remove(shape);
    }
}
