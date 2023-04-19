package pl.animalshelter.UI;

import pl.animalshelter.Units.AnimalList;
import pl.animalshelter.DatabaseAnimals.DataBase;
import pl.animalshelter.dialogs.AboutDialog;
import pl.animalshelter.imports.WriterToCSV;
import pl.animalshelter.imports.WriterToPDF;

import javax.swing.*;

public class MenuConfig extends JMenu{
    private AboutDialog aboutDialog;

    public MenuConfig(JFrame owner, AnimalList animalList, DataBase dataBase) {
        super("Plik");

        JMenuItem aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(e -> {
            if (aboutDialog == null) aboutDialog = new AboutDialog(owner);
            else aboutDialog.setVisible(true);
        });

        JMenuItem toCSV = new JMenuItem("Import do CSV");
        toCSV.addActionListener(e -> {
            new WriterToCSV(animalList.getActualAnimals());
        });

        JMenuItem toPDF = new JMenuItem("Import do PDF");
        toPDF.addActionListener(e -> {
            new WriterToPDF(animalList);
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(e -> {
            dataBase.disconnect();
            System.exit(0);
        });

        this.add(aboutItem);
        this.add(toCSV);
        this.add(toPDF);
        this.addSeparator();
        this.add(exitItem);
    }
}
