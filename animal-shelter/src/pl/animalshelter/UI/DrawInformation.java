package pl.animalshelter.UI;

import pl.animalshelter.Units.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawInformation extends JPanel {
    private JLabel idAnimal;
    private JLabel nameAniamal;
    private JLabel kindAnimal;
    private JLabel ageAnimal;
    private JLabel image;
    private Animal animal;
    private ArrayList<ImageIcon> animalImages;

    public DrawInformation() {
        setLayout(new GridLayout(2,1));

        String[] imagesPaths = new String[] {"Pies.png", "Kot.png", "Mysz.png", "Kanarek.png",
                "Chomik.png", "Królik.png", "Rybka.png", "brak.png"};

        animalImages = new ArrayList<>();
        for(String i : imagesPaths) animalImages.add(new ImageIcon(i));

        image = new JLabel(animalImages.get(animalImages.size() - 1));

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,2));

        JLabel id = new JLabel("ID: ");
        id.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(id);
        idAnimal = new JLabel("" + 0);
        panel.add(idAnimal);

        JLabel name = new JLabel("Imię: ");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(name);
        nameAniamal = new JLabel("brak");
        panel.add(nameAniamal);

        JLabel kind = new JLabel("Rodzaj: ");
        kind.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(kind);
        kindAnimal = new JLabel("brak");
        panel.add(kindAnimal);

        JLabel age = new JLabel("Wiek: ");
        age.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(age);
        ageAnimal = new JLabel("" + 0);
        panel.add(ageAnimal);

        add(image);
        add(panel);
    }

    public void updateInformation(Animal animal) {
        if (animal != null) {
            idAnimal.setText("" + animal.getId_animal());
            nameAniamal.setText(animal.getName());
            kindAnimal.setText(animal.getKindOfAnimal());
            ageAnimal.setText("" + animal.getAge());
            for (ImageIcon i : animalImages) {
                String temp = animal.getKindOfAnimal() + ".png";
                if(i.getDescription().equals(temp)) {
                    image.setIcon(i);
                    break;
                }
            }
        }
        else {
            idAnimal.setText("");
            nameAniamal.setText("");
            kindAnimal.setText("");
            ageAnimal.setText("");
            image.setIcon(animalImages.get(animalImages.size() - 1));
        }
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
