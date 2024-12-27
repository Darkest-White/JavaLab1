package pckg;

import java.util.Stack;

// Менеджер команд (Singleton)
class CommandManager {
    private static CommandManager instance; // Экземпляр менеджера команд
    private Stack<Command> commandStack = new Stack<>(); // Стек для хранения команд
    private CanvasPanel canvas; // Ссылка на панель рисования

    // Приватный конструктор для Singleton
    private CommandManager() {}

    // Метод для получения единственного экземпляра менеджера команд
    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    // Устанавливаем ссылку на панель рисования
    public void setCanvas(CanvasPanel canvas) {
        this.canvas = canvas;
    }

    // Метод для выполнения команды
    public void executeCommand(Command command) {
        command.execute(); // Выполнение команды
        commandStack.push(command); // Добавляем команду в стек
        if (canvas != null) {
            canvas.repaint(); // Перерисовываем панель
        }
    }

    // Метод для отмены последней команды
    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.pop(); // Извлекаем последнюю команду из стека
            command.undo(); // Отменяем команду
            if (canvas != null) {
                canvas.repaint(); // Перерисовываем панель
            }
        }
    }
}