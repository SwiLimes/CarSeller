package gui;

import javax.swing.*;

public class AutobazaInfoWindow extends JFrame {
    public AutobazaInfoWindow() {
        setTitle("Информация о приложении «Автобаза»");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание меток для отображения информации о приложении
        JLabel appNameLabel = new JLabel("Название приложения: Автобаза");
        JLabel versionLabel = new JLabel("Версия приложения: 1.0");
        JLabel authorLabel = new JLabel("Авторы: Семён Мыслин, Кравченко Андрей,Никита Берденников,Настя Петрова, Максим Вороничев");
        JLabel descriptionLabel = new JLabel("Описание: Приложение для учета автопарка на автобазе");

        // Создание панели для размещения меток
        JPanel infoPanel = new JPanel();
        infoPanel.add(appNameLabel);
        infoPanel.add(versionLabel);
        infoPanel.add(authorLabel);
        infoPanel.add(descriptionLabel);

        // Добавление панели на окно
        add(infoPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AutobazaInfoWindow();
    }
}
