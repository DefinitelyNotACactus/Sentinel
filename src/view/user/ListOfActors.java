/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import executable.Client;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import server.Database;
import server.actors.User;

/*
/**
 *
 * @author aluno
 */
public class ListOfActors extends javax.swing.JPanel {
    
    
    private Database db;
    private DefaultListModel usersModel;
    
    private List<String> emails;
    private final Client client;
    private final Home home;

    
    public ListOfActors(Database db ,Client c, Home home) {
        this.client = c;
        this.home = home;
        this.db = db;
        usersModel = new DefaultListModel();
        emails = new ArrayList<>();
        initComponents();
        listFriendPanel();
    }

    private void listFriendPanel(){
        Iterator it = db.getUsers().entrySet().iterator();
        int i;
        for(i = 0; it.hasNext(); i++){
            Map.Entry pair = (Map.Entry) it.next();
            User user = (User) pair.getValue();
            if(!user.isBlocked(client.getUser())){
                usersModel.add(i, user.toString());
                emails.add(pair.getKey().toString());
            } else {
                i--;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UsersListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new JList<>(usersModel);
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(1280, 660));

        UsersListLabel.setText("Usu�rios");
        UsersListLabel.setMaximumSize(new java.awt.Dimension(103, 14));
        UsersListLabel.setMinimumSize(new java.awt.Dimension(103, 14));
        UsersListLabel.setPreferredSize(new java.awt.Dimension(103, 14));

        usersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                usersListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(usersList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UsersListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsersListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_usersListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = usersList.getSelectedIndex();
        if(index >= 0){
            User selected = db.getFromMail(emails.get(index));
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja visitar a p�gina de " + selected.getName() + " ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                home.getPage().removeAll();
                home.getPage().add(new Profile(client, selected, home));
                home.getPage().revalidate();
            }
        }
    }//GEN-LAST:event_usersListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsersListLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<User> usersList;
    // End of variables declaration//GEN-END:variables
}