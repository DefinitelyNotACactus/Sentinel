/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user.post;

import executable.Client;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import server.actors.AbstractActor;
import server.actors.Group;
import server.actors.actions.Post;
import server.actors.User;
import util.Constants;
import util.Validator;
import view.user.profile.Wall;

/**
 *
 * @author David
 */
public class NewPost extends JPanel {

    private final Client client;
    private final AbstractActor actor;
    private final Wall wall;
    
    private final boolean isOwner;
    
    private String selected_file = "";
    
    public NewPost(Client c, AbstractActor actor, Wall wall) {
        client = c;
        this.actor = actor;
        this.wall = wall;
        
        if(actor instanceof User){
            isOwner = Validator.isSameEmail(client.getUser().getId(), actor.getId());
        } else {
            isOwner = false;
        }
        
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleField = new javax.swing.JTextField();
        textPane = new javax.swing.JScrollPane();
        textField = new javax.swing.JTextPane();
        selectedFileLabel = new javax.swing.JLabel();
        btSend = new javax.swing.JButton();
        btAddPhoto = new javax.swing.JButton();
        visibilityBox = new javax.swing.JComboBox<>();

        titleField.setText(Constants.NEWPOST_TITLE_TEXT);
        titleField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleFieldMouseClicked(evt);
            }
        });

        textField.setToolTipText("Texto da sua mensagem");
        textPane.setViewportView(textField);

        selectedFileLabel.setText(Constants.DEFAULT_FILE_TEXT);

        btSend.setText("Enviar");
        btSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendActionPerformed(evt);
            }
        });

        btAddPhoto.setText("Adicionar Foto");
        btAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddPhotoActionPerformed(evt);
            }
        });

        visibilityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visibilidade", "P�blico", "Somente Amigos" }));
        if(!isOwner || actor instanceof Group){
            visibilityBox.setSelectedIndex(1);
            visibilityBox.setEnabled(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(visibilityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSend, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(selectedFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAddPhoto))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPane, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectedFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSend, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibilityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddPhotoActionPerformed
        final JFileChooser fc = new JFileChooser(); 
        FileFilter imageFilter = new FileNameExtensionFilter("Arquivos de Imagem", ImageIO.getReaderFileSuffixes());
        fc.setFileFilter(imageFilter);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selected_file = fc.getSelectedFile().getAbsolutePath();
            if(!selected_file.endsWith(".png") && !selected_file.endsWith(".jpg")){
                selected_file = "Inv�lido";
            }
            ImageIcon preview = new ImageIcon(selected_file);
            selectedFileLabel.setIcon(new ImageIcon(preview.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
            selectedFileLabel.setText("Arquivo Selecionado: " + selected_file);
        }
    }//GEN-LAST:event_btAddPhotoActionPerformed

    private void btSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendActionPerformed
        if(titleField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(client, "O t�tulo est� vazio!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(textField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(client, "O texto est� vazio!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(visibilityBox.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(client, "Escolha uma visibilidade para sua mensagem!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Post post;
            if(selected_file.equals("Inv�lido") || selected_file.trim().equals("")){
                post = new Post(titleField.getText(), textField.getText(), client.getUser(), (visibilityBox.getSelectedIndex() == 1));
                if(isOwner || actor instanceof Group){
                    actor.addPost(post);
                } else { 
                    User user = (User) actor;
                    user.addPostFromOthers(post);
                }
            } else {
                post = new Post(titleField.getText(), textField.getText(), client.getUser(), selected_file, (visibilityBox.getSelectedIndex() == 1));
                if(isOwner || actor instanceof Group){
                    actor.addPost(post);
                } else {
                    User user = (User) actor;
                    user.addPostFromOthers(post);
                }
            }
            JOptionPane.showMessageDialog(client, "Mensagem Enviada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            this.getParent().revalidate();
            this.getParent().add(new ViewPost(client, actor, wall, post));
            this.getParent().remove(this);
            wall.listPosts(true);
        }
    }//GEN-LAST:event_btSendActionPerformed

    private void titleFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleFieldMouseClicked
        if(titleField.getText().equals(Constants.NEWPOST_TITLE_TEXT)){
            titleField.setText("");
        }
    }//GEN-LAST:event_titleFieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddPhoto;
    private javax.swing.JButton btSend;
    private javax.swing.JLabel selectedFileLabel;
    private javax.swing.JTextPane textField;
    private javax.swing.JScrollPane textPane;
    private javax.swing.JTextField titleField;
    private javax.swing.JComboBox<String> visibilityBox;
    // End of variables declaration//GEN-END:variables
}
