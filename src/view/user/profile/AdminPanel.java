/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user.profile;

import executable.Client;
import java.awt.Toolkit;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import server.actors.AbstractActor;
import server.actors.Group;
import server.actors.User;
import view.util.UserRenderer;

/**
 *
 * @author user
 */
public class AdminPanel extends JPanel {

    /**
     * Creates new form AdminPanel
     */
    private final Client client;
    private final AbstractActor actor;
    
    private DefaultListModel<User> userRequestModel;
    private DefaultListModel<User> blockedUserModel;
    
    public AdminPanel(Client c, AbstractActor actor) {
        this.client = c;
        this.actor = actor;
        
        userRequestModel = new DefaultListModel<>();
        blockedUserModel = new DefaultListModel<>();
        
        initComponents();
        listUsers(false);
    }

    private void listUsers(boolean reload){
        if(reload){
            userRequestModel.clear();
            blockedUserModel.clear();
        }
        Iterator it = actor.getRequests().iterator();
        int i;
        for(i = 0; it.hasNext(); i++){
            userRequestModel.add(i, (User) it.next());
        }
        requestList.setCellRenderer(new UserRenderer());
        it = actor.getBlocked().iterator();
        for(i = 0; it.hasNext(); i++){
            blockedUserModel.add(i, (User) it.next());
        }
        blockedList.setCellRenderer(new UserRenderer());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newMembersRequestLabel = new javax.swing.JLabel();
        blockedMembersLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestList = new JList<>(userRequestModel);
        jScrollPane2 = new javax.swing.JScrollPane();
        blockedList = new JList<>(blockedUserModel);
        searchBox = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));
        setPreferredSize(new java.awt.Dimension(1086, 638));

        newMembersRequestLabel.setText("Solicita��es de Entrada");

        blockedMembersLabel.setText("Membros Bloqueados");

        requestList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                requestListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(requestList);

        blockedList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                blockedListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(blockedList);

        searchBox.setText("Insira o email de um membro do grupo para ver op��es...");
        searchBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoxMouseClicked(evt);
            }
        });

        btSearch.setText("Pesquisar");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    .addComponent(newMembersRequestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockedMembersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newMembersRequestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(blockedMembersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Group group = (Group) actor;
        String member = searchBox.getText().toLowerCase();
        if(member.equals(client.getUser().getId())){
            JOptionPane.showMessageDialog(client, "O Painel do Moderador � para tirar privil�gios dos outros, n�o o seu.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else if(actor.isRelative(client.getDatabase().getFromMail(member))){
            Toolkit.getDefaultToolkit().beep();
            String[] options = {"Tornar Moderador", "Remover", "Bloquear", "Cancelar"};
            if(group.isAdmin(client.getDatabase().getFromMail(member))){
                options[0] = "Remover Moderador";
            }
            if(actor.isBlocked(client.getDatabase().getFromMail(member))){
                options[2] = "Desbloquear";
            }
            User user = client.getDatabase().getFromMail(member);
            int selection = JOptionPane.showOptionDialog(client, "O que deseja fazer com " + user.getName() + " ?" , "Op��es de Intera��o", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch(selection){
                case 0:
                  if(group.isAdmin(client.getDatabase().getFromMail(member))){
                      group.removeAdmin(user);
                  } else {
                      group.addAdmin(user);
                  }
                  break;
                case 1:
                    group.removeRelative(user);
                    JOptionPane.showMessageDialog(client, user.getName() + " foi removido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    if(actor.isBlocked(user)){
                        group.unblock(user);
                    } else{
                        group.block(user);
                    }
                    break;
            }
            listUsers(true);
        }
    }                                            

    private void requestListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_requestListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = requestList.getSelectedIndex();
        if(index >= 0){
            User selected = actor.getRequests().get(index);
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja aceitar " + selected.getName() + " no grupo?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                actor.addRelative(selected);
                requestList.remove(index);
            } else if(confirm == 1) {
                actor.removeRequest(selected);
                requestList.remove(index);
            }
            listUsers(true);
        }
    }//GEN-LAST:event_requestListValueChanged

    private void blockedListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_blockedListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = blockedList.getSelectedIndex();
        if(index >= 0){
            User selected = actor.getBlocked().get(index);
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja desbloquear " + selected.getName() + " ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                actor.unblock(selected);
                blockedList.remove(index);
            }
            listUsers(true);
        }
    }//GEN-LAST:event_blockedListValueChanged

    private void searchBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseClicked
        if(searchBox.getText().equals("Insira o email de um membro do grupo para ver op��es...")){
            searchBox.setText("");
        }
    }//GEN-LAST:event_searchBoxMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<User> blockedList;
    private javax.swing.JLabel blockedMembersLabel;
    private javax.swing.JButton btSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newMembersRequestLabel;
    private javax.swing.JList<User> requestList;
    private javax.swing.JTextField searchBox;
    // End of variables declaration//GEN-END:variables
}
