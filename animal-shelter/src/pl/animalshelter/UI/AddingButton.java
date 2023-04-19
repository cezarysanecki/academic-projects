package pl.animalshelter.UI;

import pl.animalshelter.Units.Animal;
import pl.animalshelter.Units.AnimalList;
import pl.animalshelter.DatabaseAnimals.DataBase;
import pl.animalshelter.dialogs.AddDialog;
import pl.animalshelter.dialogs.NoSpaceDialog;
import pl.animalshelter.imports.SendingMail;
import pl.animalshelter.imports.WriterToPDF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingButton extends JButton {
    private AddDialog addAnimalDialog;
    private ShelterFrame owner;
    private NoSpaceDialog noSpaceDialog;

    public AddingButton(ShelterFrame owner) {
        super("Dodaj zwierzaka");
        this.setPreferredSize(new Dimension(150, 30));
        this.owner = owner;
        this.addActionListener(new ActionHandler());
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AnimalList animalList = owner.getAnimalList();
            int capacity = owner.getAnimalList().getCapacity();
            DataBase dataBase = owner.getDataBase();
            JLabel capacityLabel = owner.getCapacityLabel();

            if (addAnimalDialog == null) addAnimalDialog = new AddDialog(owner);
            addAnimalDialog.getTypeAge().setText("");
            addAnimalDialog.getTypeName().setText("");
            addAnimalDialog.setVisible(true);

            String name = addAnimalDialog.getTypeName().getText();
            String kind = addAnimalDialog.getOptionKindKind();
            int age = 0;
            try {
                 age = Integer.parseInt(addAnimalDialog.getTypeAge().getText() == "" ? //wywala blad przy wylaczaniu dodawania
                        "0" : addAnimalDialog.getTypeAge().getText());
            }
            catch (Exception ea) {
                ea.printStackTrace();
            }   ///

            if (name != "" && kind != "" && age != 0) {
                Animal animal = new Animal(name, kind, age);

                animalList.addAnimal(animal);
                dataBase.add(animal);
                capacityLabel.setText("Pojemność: " + animalList.getModel().getSize()
                        + "/" + capacity);
                if (animalList.getModel().getSize() > capacity - 3) {
                    WriterToPDF pdf = new WriterToPDF(animalList);
                    String nameOfPDF = pdf.toString();

                    if (animalList.getModel().getSize() < capacity) {
                        new SendingMail(nameOfPDF, "Dear Employee,"
                                + "\n\nOur shelter is going to be full! Please, do something!" +
                                "\nI attached report in PDF on our shelter." + "\nWe have only " +
                                (capacity - animalList.getActualAnimals().size()) + " space(s) for next animals!" +
                                "\n\nBest regards," + "\nBreeder", "The animal shelter is growing too big!");
                    } else {
                        new SendingMail(nameOfPDF, "Dear Employee,"
                                + "\n\nOur shelter is full! We have to think about increasing number of spaces to live!" +
                                "\nI attached report in PDF on our shelter." +
                                "\n\nBest regards," + "\nBreeder", "The animal shelter is full!");
                    }
                }
            } else {
                if (noSpaceDialog == null) noSpaceDialog = new NoSpaceDialog(owner);
                noSpaceDialog.setVisible(true);
            }
        }
    }
}
