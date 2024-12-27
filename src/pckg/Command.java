package pckg;

// Интерфейс для команд
interface Command {
    void execute(); // Метод для выполнения команды
    void undo(); // Метод для отмены команды
}
