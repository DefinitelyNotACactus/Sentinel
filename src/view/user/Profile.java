/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import executable.Client;
import util.Constants;
import view.user.profile.Info;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import server.actors.AbstractActor;
import server.actors.Group;
import server.actors.User;
import util.Validator;
import view.user.profile.AdminPanel;
import view.user.profile.Wall;

/**
 *
 * @author David
 */
public class Profile extends JPanel {

    private final Client client;
    private final Home home;
    private final AbstractActor actor;
    private Group group = null;
    
    private final boolean isOwner;
    private boolean btAddAdmin = false;
    
    public Profile(Client c, Home home) {
        this.client = c;
        this.home = home;
        this.actor = c.getUser();
        isOwner = Validator.isSameEmail(actor.getId(), client.getUser().getId());
        initComponents();
    }

    public Profile(Client c, AbstractActor actor, Home home) {
        this.client = c;
        this.actor = actor;
        this.home = home;
        if(actor instanceof User){
            isOwner = Validator.isSameEmail(actor.getId(), client.getUser().getId());
        } else {
            group = (Group) actor;
            isOwner = group.isAdmin(client.getUser());
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

        actorPhotoLabel = new javax.swing.JLabel();
        btActorName = new javax.swing.JButton();
        isRelativeLabel = new javax.swing.JLabel();
        btActorInfo = new javax.swing.JButton();
        btActorWall = new javax.swing.JButton();
        btAddActor = new javax.swing.JButton();
        page = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 102, 153));
        setPreferredSize(new java.awt.Dimension(1280, 660));

        actorPhotoLabel.setIcon(new ImageIcon(actor.getIcon().getImage().getScaledInstance(164, 164, Image.SCALE_SMOOTH)));
        actorPhotoLabel.setOpaque(true);

        btActorName.setText("" + actor.getName());
        btActorName.setToolTipText("" + actor.getName());
        btActorName.setEnabled(false);

        btActorInfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btActorInfo.setText("Perfil");
        btActorInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActorInfoActionPerformed(evt);
            }
        });

        btActorWall.setText("Mural");
        btActorWall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActorWallActionPerformed(evt);
            }
        });
        if(actor instanceof Group && !actor.isRelative(client.getUser())){
            btActorWall.setEnabled(false);
        }

        btAddActor.setText("Adicionar Amigo");
        btAddActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActorActionPerformed(evt);
            }
        });
        if(actor instanceof Group){
            Group group = (Group) actor;
            if(!group.isRelative(client.getUser())){
                btAddActor.setText("Pedir para Entrar");
            } else if(group.isAdmin(client.getUser())){
                btAddActor.setText("Painel de Moderador");
                btAddAdmin = true;
            } else {
                btAddActor.setVisible(false);
                btAddActor.setEnabled(false);
            }
        } else { //instanceof User
            if(isOwner || client.getUser().isRelative((User) actor)){
                btAddActor.setVisible(false);
                btAddActor.setEnabled(false);
            }
        }

        page.setBackground(new java.awt.Color(0, 102, 153));
        page.setPreferredSize(new java.awt.Dimension(1086, 638));
        page.setLayout(new javax.swing.BoxLayout(page, javax.swing.BoxLayout.LINE_AXIS));
        page.removeAll();
        page.add(new Info(client, actor, this));
        page.revalidate();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(actorPhotoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isRelativeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btActorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btActorInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btActorWall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddActor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(page, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(page, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(actorPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btActorName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isRelativeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btActorInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btActorWall, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAddActor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        isRelativeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if(!isOwner && actor instanceof User){
            if(client.getUser().isRelative((User) actor)){
                isRelativeLabel.setText("� seu amigo");
            } else {
                isRelativeLabel.setText("(Voc�)");
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btActorInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActorInfoActionPerformed
        btActorInfo.setFont(new java.awt.Font(Constants.FONT, 1, 11));
        btActorWall.setFont(new java.awt.Font(Constants.FONT, 0, 11));
        btActorWall.setText("Mural");
        page.removeAll();
        if(actor instanceof User){
            page.add(new Info(client, (User) actor, this));
        } else {
            page.add(new Info(client, (Group) actor, this));
        }
        page.revalidate();
    }//GEN-LAST:event_btActorInfoActionPerformed

    private void btActorWallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActorWallActionPerformed
        btActorWall.setFont(new java.awt.Font(Constants.FONT, 1, 11));
        btActorWall.setText("Nova Mensagem");
        btActorInfo.setFont(new java.awt.Font(Constants.FONT, 0, 11));
        page.removeAll();
        page.add(new Wall(client, actor));
        page.revalidate();
    }//GEN-LAST:event_btActorWallActionPerformed

    private void btAddActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActorActionPerformed
        User requester = client.getUser();
        if(btAddAdmin){
            page.removeAll();
            page.add(new AdminPanel());
            page.revalidate();
        } else {
            if(actor.isRequestSent(requester)){
                JOptionPane.showMessageDialog(client, "O pedido j� foi enviado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(actor.isRelative(requester)){
                if(actor instanceof User){
                    JOptionPane.showMessageDialog(client, actor.getName() + " j� � seu amigo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(client, "Voc� j� � membro de " + actor.getName(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else if(actor.isBlocked(requester)){
                JOptionPane.showMessageDialog(client, "Voc� foi bloqueado por " + actor.getName(), "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                actor.sendNewRequest(client.getUser());
                JOptionPane.showMessageDialog(client, "Pedido enviado para " + actor.getName(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btAddActorActionPerformed

    public void reloadUserPhoto(){
        actorPhotoLabel.setIcon(new ImageIcon(actor.getIcon().getImage().getScaledInstance(164, 164, Image.SCALE_SMOOTH)));
        home.getUserIcon().setIcon(new ImageIcon(client.getUser().getIcon().getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH)));
    }
    
    public JLabel getUserPhotoLabel(){
        return actorPhotoLabel;
    }

    public Home getHome(){
        return home;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actorPhotoLabel;
    private javax.swing.JButton btActorInfo;
    private javax.swing.JButton btActorName;
    private javax.swing.JButton btActorWall;
    private javax.swing.JButton btAddActor;
    private javax.swing.JLabel isRelativeLabel;
    private javax.swing.JPanel page;
    // End of variables declaration//GEN-END:variables
}
