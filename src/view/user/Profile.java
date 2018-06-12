/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import view.user.profile.Wall;
import executable.Client;
import util.Constants;
import view.user.profile.Info;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import server.User;

/**
 *
 * @author David
 */
public class Profile extends JPanel {

    private final Client client;
    private final User user;
    
    public Profile(Client c) {
        this.client = c;
        this.user = c.getUser();
        initComponents();
    }

    public Profile(Client c, User user) {
        this.client = c;
        this.user = user;
        initComponents();
    }
    
    public void loadPosts(boolean reload){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPhotoLabel = new javax.swing.JLabel();
        btUserName = new javax.swing.JButton();
        isFriendLabel = new javax.swing.JLabel();
        btUserInfo = new javax.swing.JButton();
        btUserWall = new javax.swing.JButton();
        page = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 102, 153));
        setPreferredSize(new java.awt.Dimension(1280, 660));

        userPhotoLabel.setText("userPhotoLabel");
        userPhotoLabel.setOpaque(true);

        btUserName.setText("" + user.getName());
        btUserName.setToolTipText("" + user.getName());

        btUserInfo.setText("Perfil");
        btUserInfo.setFont(new Font(Constants.FONT, Font.PLAIN, 11));
        btUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserInfoActionPerformed(evt);
            }
        });

        btUserWall.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserWall.setText("Mural");
        btUserWall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserWallActionPerformed(evt);
            }
        });

        page.setBackground(new java.awt.Color(0, 102, 153));
        page.setPreferredSize(new java.awt.Dimension(1086, 638));
        page.setLayout(new javax.swing.BoxLayout(page, javax.swing.BoxLayout.LINE_AXIS));
        page.removeAll();
        page.add(new Wall(client, user));
        page.revalidate();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userPhotoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isFriendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(btUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUserWall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(userPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isFriendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUserWall, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        isFriendLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if(user.getId() != client.getUser().getId()){
            if(client.getUser().isFriend(user)){
                isFriendLabel.setText("� seu amigo");
            }
        } else {
            isFriendLabel.setText("(Voc�)");
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserInfoActionPerformed
        btUserInfo.setFont(new java.awt.Font(Constants.FONT, 1, 11));
        btUserWall.setFont(new java.awt.Font(Constants.FONT, 0, 11));
        page.removeAll();
        page.add(new Info(client));
        page.revalidate();
    }//GEN-LAST:event_btUserInfoActionPerformed

    private void btUserWallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserWallActionPerformed
        btUserWall.setFont(new java.awt.Font(Constants.FONT, 1, 11));
        btUserInfo.setFont(new java.awt.Font(Constants.FONT, 0, 11));
        page.removeAll();
        page.add(new Wall(client, user));
        page.revalidate();
    }//GEN-LAST:event_btUserWallActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUserInfo;
    private javax.swing.JButton btUserName;
    private javax.swing.JButton btUserWall;
    private javax.swing.JLabel isFriendLabel;
    private javax.swing.JPanel page;
    private javax.swing.JLabel userPhotoLabel;
    // End of variables declaration//GEN-END:variables
}
