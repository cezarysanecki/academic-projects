package pl.animalshelter.Units;

import pl.animalshelter.UI.DrawInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AnimalList extends JList<Animal>{
    private DefaultListModel defaultListModel;
    private Animal animal;
    private int capacity;
    private static int nextId;

    public AnimalList(DrawInformation drawInformation) {
        defaultListModel = new DefaultListModel();
        this.setModel(defaultListModel);
        setMinimumSize(new Dimension(100,200));
        setPreferredSize(new Dimension(200,400));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(new MouseHandler(drawInformation));
    }

    public AnimalList(DrawInformation drawInformation, ArrayList<Animal> animals) {
        defaultListModel = new DefaultListModel();
        this.setModel(defaultListModel);
        for (int i = 0; i < animals.size(); i++) {
            defaultListModel.addElement(animals.get(i));
        }
        nextId = animals.size();

        setMinimumSize(new Dimension(100, 100));
        setPreferredSize(new Dimension(200, 200));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(new MouseHandler(drawInformation));
    }

    public void addAnimal(Animal animal) {
        defaultListModel.addElement(animal);
    }

    public ArrayList<Animal> getActualAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < defaultListModel.size(); i++) {
            animals.add((Animal) defaultListModel.get(i));
        }
        return animals;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    private class MouseHandler extends MouseAdapter {
        private DrawInformation drawInformation;
        public MouseHandler(DrawInformation drawInformation) {
            this.drawInformation = drawInformation;
        }

        public void mouseClicked(MouseEvent e) {
            animal = (Animal) ((JList)e.getSource()).getSelectedValue();
            drawInformation.updateInformation(animal);
            drawInformation.setAnimal(animal);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            animal = (Animal) ((JList)e.getSource()).getSelectedValue();
            drawInformation.updateInformation(animal);
            drawInformation.setAnimal(animal);
        }
    }
}
