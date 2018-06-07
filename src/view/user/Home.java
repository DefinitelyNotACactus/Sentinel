/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import view.user.Groups;
import executable.Client;
import util.Constants;
import view.login.Login;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Homed
     */
    private final Client client;
    
    public Home(Client c) {
        this.client = c;
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

        page = new javax.swing.JPanel();
        userBar = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        btUser = new javax.swing.JButton();
        btFriends = new javax.swing.JButton();
        btGroups = new javax.swing.JButton();
        btLogoff = new javax.swing.JButton();

        page.setBackground(new java.awt.Color(0, 153, 204));
        page.setPreferredSize(new java.awt.Dimension(1280, 660));
        page.setLayout(new javax.swing.BoxLayout(page, javax.swing.BoxLayout.LINE_AXIS));
        page.removeAll();
        page.add(new Profile(client));
        page.revalidate();

        userBar.setBackground(new java.awt.Color(51, 102, 0));
        userBar.setMinimumSize(new java.awt.Dimension(739, 60));

        userIcon.setText("userIcon");

        btUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btUser.setText(client.getUser().getName());
        btUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserActionPerformed(evt);
            }
        });

        btFriends.setText("Amigos");
        btFriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFriendsActionPerformed(evt);
            }
        });

        btGroups.setText("Grupos");
        btGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGroupsActionPerformed(evt);
            }
        });

        btLogoff.setText("Sair");
        btLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userBarLayout = new javax.swing.GroupLayout(userBar);
        userBar.setLayout(userBarLayout);
        userBarLayout.setHorizontalGroup(
            userBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLogoff)
                .addContainerGap())
        );
        userBarLayout.setVerticalGroup(
            userBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btUser, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGroups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btFriends, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(page, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(page, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btFriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFriendsActionPerformed
        btFriends.setFont(new Font(Constants.FONT, 1, 12));
        btGroups.setFont(new Font(Constants.FONT, 0, 12));
        btUser.setFont(new Font(Constants.FONT, 0, 12));
        page.removeAll();
        page.add(new Friends(client, this));
        page.revalidate();
    }//GEN-LAST:event_btFriendsActionPerformed

    private void btGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGroupsActionPerformed
        btGroups.setFont(new Font(Constants.FONT, 1, 12));
        btFriends.setFont(new Font(Constants.FONT, 0, 12));       
        btUser.setFont(new Font(Constants.FONT, 0, 12));
        page.removeAll();
        page.add(new Groups());
        page.revalidate();
    }//GEN-LAST:event_btGroupsActionPerformed

    private void btLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoffActionPerformed
        Toolkit.getDefaultToolkit().beep();
        int confirm = JOptionPane.showConfirmDialog(client, Constants.WINDOW_CLOSE_MESSAGE[0], Constants.WINDOW_CLOSE_MESSAGE[1], JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == 0) {
            client.remove(this);
            client.add(new Login(client));
            client.revalidate();
        }
    }//GEN-LAST:event_btLogoffActionPerformed

    private void btUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserActionPerformed
        btUser.setFont(new Font(Constants.FONT, 1, 12));
        btFriends.setFont(new Font(Constants.FONT, 0, 12));
        btGroups.setFont(new Font(Constants.FONT, 0, 12));
        page.removeAll();
        page.add(new Profile(client));
        page.revalidate();
    }//GEN-LAST:event_btUserActionPerformed

    public JPanel getPage(){
        return page;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFriends;
    private javax.swing.JButton btGroups;
    private javax.swing.JButton btLogoff;
    private javax.swing.JButton btUser;
    private javax.swing.JPanel page;
    private javax.swing.JPanel userBar;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}