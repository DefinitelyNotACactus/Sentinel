/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import server.actors.Group;

/**
 *
 * @author nguyenvanquan7826 
 * @author David
 */
public class GroupRenderer extends JPanel implements ListCellRenderer<Group>{
 
    private JLabel iconLabel;
    private JLabel nameLabel;
 
    public GroupRenderer() {
        this.nameLabel = new JLabel();
        this.iconLabel = new JLabel();
        setLayout(new BorderLayout(5, 5));
 
        JPanel panelText = new JPanel(new GridLayout(0, 2));
        panelText.add(nameLabel);
        add(iconLabel, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Group> list, Group group, int index, boolean isSelected, boolean cellHasFocus) {

        iconLabel.setIcon(new ImageIcon(group.getIcon().getImage().getScaledInstance(62, 62, Image.SCALE_SMOOTH)));
        nameLabel.setText("<html>" + group.getName() + "<br/>(ID: " + group.getId() + ")</html>");
        // set Opaque to change background color of JLabel
        nameLabel.setOpaque(true);
        iconLabel.setOpaque(true);
        // when select item
        if (isSelected) {
            nameLabel.setBackground(list.getSelectionBackground());
            iconLabel.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            nameLabel.setBackground(list.getBackground());
            iconLabel.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }
        return this;
    }
}
