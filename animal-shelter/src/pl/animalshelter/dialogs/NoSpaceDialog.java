package pl.animalshelter.dialogs;

import pl.animalshelter.UI.GBC;

import javax.swing.*;
import java.awt.*;

public class NoSpaceDialog extends JDialog {
    public NoSpaceDialog(JFrame owner) {
        super(owner, "Brak miejsca", true);
        setSize(400, 200);
        setLayout(new GridBagLayout());

        JPanel panelName = new JPanel();
        Font font = new Font("Serif", Font.BOLD, 15);
        JLabel text = new JLabel("Nie ma miejsca w schronisku na następne zwierzątko :(");
        text.setFont(font);
        panelName.add(text, BorderLayout.SOUTH);
        add(panelName, new GBC(2, 1));

        JButton buttonOk = new JButton("Ehh!");
        buttonOk.addActionListener(e -> setVisible(false));
        add(buttonOk, new GBC(2, 2, 100, 20));

        setLocation(owner.getLocation().x + (owner.getWidth() - getWidth()) / 2, owner.getLocation().y +
                (owner.getHeight() - getHeight()) / 2);
        setResizable(false);
    }
}