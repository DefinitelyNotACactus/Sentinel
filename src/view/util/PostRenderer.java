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
import server.actors.actions.Post;

/**
 *
 * @author nguyenvanquan7826 
 * @author David
 */
public class PostRenderer extends JPanel implements ListCellRenderer<Post>{
 
    private JLabel iconLabel;
    private JLabel nameLabel;
 
    public PostRenderer() {
        this.nameLabel = new JLabel();
        this.iconLabel = new JLabel();
        setLayout(new BorderLayout(5, 5));
 
        JPanel panelText = new JPanel(new GridLayout(0, 2));
        panelText.add(nameLabel);
        add(iconLabel, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Post> list, Post post, int index, boolean isSelected, boolean cellHasFocus) {

        if(post.getIcon() == null){
            iconLabel.setText("SEM FOTO");
            iconLabel.setIcon(null);
        } else {
            iconLabel.setText("");
            iconLabel.setIcon(new ImageIcon(post.getIcon().getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        }
        nameLabel.setText("<html>" + post.getTitle() + " <br/><b>Por:</b> " + post.getAuthor().getName() + "</html>");
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
