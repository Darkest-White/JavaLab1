package pckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Основной класс редактора
public class GraphicEditor extends JFrame {
    private CanvasPanel canvas; // Панель для рисования
    private CommandManager commandManager; // Менеджер команд для управления откатом и выполнением действий

    // Конструктор редактора
    public GraphicEditor() {
        super("Графический редактор");

        // Инициализация панели для рисования и менеджера команд
        canvas = new CanvasPanel();
        commandManager = CommandManager.getInstance();
        commandManager.setCanvas(canvas); // Устанавливаем панель рисования в менеджер команд

        // Панель с кнопками для управления
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        // Кнопки для выбора типа фигуры
        JButton rectangleButton = new JButton("Прямоугольник");
        JButton circleButton = new JButton("Круг");
        JButton lineButton = new JButton("Линия");

        // Кнопка для выбора цвета
        JButton colorButton = new JButton("Выбрать цвет");

        // Кнопка для отмены последнего действия
        JButton undoButton = new JButton("Отменить (Ctrl+Z)");

        // Добавляем кнопки в панель управления
        controls.add(rectangleButton);
        controls.add(circleButton);
        controls.add(lineButton);
        controls.add(colorButton);
        controls.add(undoButton);

        // Обработчики для кнопок
        rectangleButton.addActionListener(e -> canvas.setShapeFactory(new RectangleFactory()));
        circleButton.addActionListener(e -> canvas.setShapeFactory(new CircleFactory()));
        lineButton.addActionListener(e -> canvas.setShapeFactory(new LineFactory()));

        // Обработчик для выбора цвета
        colorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Выберите цвет", canvas.getCurrentColor());
            if (newColor != null) canvas.setCurrentColor(newColor);
        });

        // Обработчик для кнопки отмены
        undoButton.addActionListener(e -> commandManager.undo());

        // Горячая клавиша Ctrl+Z для отмены действия
        canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK), "undo");
        canvas.getActionMap().put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandManager.undo(); // Откат действия
            }
        });

        // Добавляем панель управления и панель рисования в окно
        add(controls, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        // Устанавливаем размеры окна и его поведение при закрытии
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}























