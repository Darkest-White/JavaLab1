package pckg;

import javax.swing.*;

public class Main {
    // Точка входа в приложение
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphicEditor::new);
    }
}
