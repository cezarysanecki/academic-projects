package pl.animalshelter.dialogs;

import pl.animalshelter.UI.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddDialog extends JDialog {
    private JTextField typeName;
    private JComboBox<String> optionKind;
    private JTextField typeAge;

    public AddDialog(JFrame owner) {
        super(owner, "Nowy podopieczny", true);
        setLayout(new GridBagLayout());

        JLabel name = new JLabel("Imię: ");
        add(name, new GBC(0, 0).setInsets(10));

        typeName = new JTextField(12);
        add(typeName, new GBC(1, 0).setInsets(5));

        JLabel kind = new JLabel("Rodzaj: ");
        add(kind, new GBC(0, 1).setInsets(10));

        optionKind = new JComboBox<>(new String[] {"Pies", "Kot", "Mysz", "Kanarek", "Chomik", "Królik", "Rybka"});
        add(optionKind, new GBC(1, 1).setInsets(5));

        JLabel age = new JLabel("Wiek: ");
        add(age, new GBC(0, 2).setInsets(10));

        typeAge = new JTextField(12);
        add(typeAge, new GBC(1, 2).setInsets(5));

        JButton buttonOk = new JButton("Super!");
        buttonOk.addActionListener(e ->setVisible(false));
        add(buttonOk, new GBC(0, 3, 2, 1).setInsets(5));

        pack();
        setLocation(owner.getLocation().x + (owner.getWidth() - getWidth()) / 2, owner.getLocation().y +
                (owner.getHeight() - getHeight()) / 2);

        addWindowListener(new WindowHandler());
        setResizable(false);
    }

    public String getOptionKindKind() {
        return (String) optionKind.getSelectedItem();
    }

    public JTextField getTypeAge() {
        return typeAge;
    }

    public JTextField getTypeName() {
        return typeName;
    }

    private class WindowHandler extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);
        }

        @Override
        public void windowClosed(WindowEvent e) {
            setVisible(false);
        }
    }
}
