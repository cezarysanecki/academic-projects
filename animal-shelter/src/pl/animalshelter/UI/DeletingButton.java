package pl.animalshelter.UI;

import pl.animalshelter.DatabaseAnimals.DataBase;
import pl.animalshelter.Units.Animal;
import pl.animalshelter.Units.AnimalList;
import pl.animalshelter.dialogs.DeleteDialog;
import pl.animalshelter.dialogs.NoAnimalDialog;
import pl.animalshelter.dialogs.NoChosenDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletingButton extends JButton {
    private ShelterFrame owner;
    private NoAnimalDialog noAnimalDialog;
    private NoChosenDialog noChosenDialog;
    private DeleteDialog deleteAnimalDialog;

    public DeletingButton(ShelterFrame owner) {
        super("Oddać do adopcji");
        this.setPreferredSize(new Dimension(150,30));
        this.owner = owner;
        this.addActionListener(new ActionHandler());
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AnimalList animalList = owner.getAnimalList();
            DataBase dataBase = owner.getDataBase();
            DrawInformation drawInformation = owner.getDrawInformation();
            JLabel capacityLabel = owner.getCapacityLabel();

            if(animalList.getModel().getSize() == 0) {
                if (noAnimalDialog == null) noAnimalDialog = new NoAnimalDialog(owner);
                noAnimalDialog.setVisible(true);
            }
            else {
                if (drawInformation.getAnimal() == null) {
                    if (noChosenDialog == null) noChosenDialog = new NoChosenDialog(owner);
                    noChosenDialog.setVisible(true);
                }
                else {
                    if (deleteAnimalDialog == null) deleteAnimalDialog = new DeleteDialog(owner);
                    deleteAnimalDialog.setVisible(true);
                    dataBase.delete(drawInformation.getAnimal());
                    int i = drawInformation.getAnimal().getId_animal();
                    for(int j = i; j < animalList.getModel().getSize(); j++) {
                        animalList.getModel().getElementAt(j).setId_animal(j);
                        dataBase.updateID(j);
                    }
                    Animal.setNext_id(animalList.getModel().getSize());

                }
                ((DefaultListModel)animalList.getModel()).removeElement(drawInformation.getAnimal());
                drawInformation.updateInformation(null);
                drawInformation.setAnimal(null);
                capacityLabel.setText("Pojemność: " + animalList.getActualAnimals().size()
                        + "/" + animalList.getCapacity());
            }}
        }
    }
