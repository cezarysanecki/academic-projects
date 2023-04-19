package pl.animalshelter.UI;

import pl.animalshelter.Units.AnimalList;
import pl.animalshelter.DatabaseAnimals.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShelterFrame extends JFrame {
    private MenuConfig menuConfig;
    private JMenuBar menuBar;
    private JLabel capacityLabel;
    private AnimalList animalList;
    private DrawInformation drawInformation;
    private DataBase dataBase;
    private AddingButton addButton;
    private DeletingButton deleteButton;

    public ShelterFrame() {                      //tworzy główną ramkę
        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;        //pobiera szerokość i długość ekrranu
        int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLayout(new GridBagLayout());

        dataBase = new DataBase();
        dataBase.connection();

        drawInformation = new DrawInformation();
        drawInformation.setPreferredSize(new Dimension(200, 350));
        add(drawInformation, new GBC(1, 0, 1, 8));

        animalList = new AnimalList(drawInformation, dataBase.getDatabase());
        animalList.setPreferredSize(new Dimension(200, 450));
        animalList.setCapacity(20);
        JScrollPane scrollPane = new JScrollPane(animalList);
        scrollPane.setPreferredSize(new Dimension(250, 460));
        add(scrollPane, new GBC(0, 0, 1, 9).setWeight(10, 10));

        menuBar = new JMenuBar();
        menuConfig = new MenuConfig(this, animalList, dataBase);
        menuBar.add(menuConfig);
        setJMenuBar(menuBar);   //ustawia menu

        addButton = new AddingButton(this);
        add(addButton, new GBC(1, 8, 1, 1).setInsets(10));
        deleteButton = new DeletingButton(this);
        add(deleteButton, new GBC(1, 9, 1, 1).setInsets(10));

        capacityLabel = new JLabel("Pojemność: " +
                animalList.getActualAnimals().size() + "/" + animalList.getCapacity());
        add(capacityLabel, new GBC(0, 9, 1, 1));

        pack();
        setBounds((widthScreen - getWidth()) / 2, (heightScreen - getHeight()) / 2, getWidth(), getHeight());   //ustawia ramkę na środku ekranu
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowHandler());
    }

    public DrawInformation getDrawInformation() {
        return drawInformation;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public AnimalList getAnimalList() {
        return animalList;
    }

    public JLabel getCapacityLabel() {
        return capacityLabel;
    }

    private class WindowHandler extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            dataBase.disconnect();
        }
    }

    public static void main(String[] args) {
        new ShelterFrame();
    }       //test
}
