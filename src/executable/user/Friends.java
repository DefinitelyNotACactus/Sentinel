/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executable.user;

import executable.Client;
import executable.Constants;
import java.awt.Toolkit;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import server.User;

/**
 *
 * @author David
 */
public class Friends extends JPanel {

    /**
     * Creates new form Friends
     */
    //JButton[][] friendButton = new JButton[10][2];
    //JLabel[] friendLabel = new JLabel[11];
    private final Client client;
    private final Home home;
    
    private DefaultListModel friendModel;
    private DefaultListModel requestModel;
    private DefaultListModel blockedModel;

    public Friends(Client c, Home home) {
        this.client = c;
        this.home = home;
        friendModel = new DefaultListModel();
        requestModel = new DefaultListModel();
        blockedModel = new DefaultListModel();
        initComponents();
        listFriendPanel(false);
    }

    private void listFriendPanel(boolean reload){
        if(reload){
            friendModel.clear();
            requestModel.clear();
            blockedModel.clear();   
        }
        Iterator it = client.getUser().getFriends().iterator();
        int i;
        for(i = 0; it.hasNext(); i++) {
            friendModel.add(i, it.next().toString());
        }
        it = client.getUser().getFriendRequests().iterator();
        for (i = 0; it.hasNext(); i++) {
            requestModel.add(i, it.next().toString());
        }
        it = client.getUser().getBlocked().iterator();
        for (i = 0; it.hasNext(); i++) {
            blockedModel.add(i, it.next().toString());
        }
    }
    
    /*public void loadFriends(){
        int y = 62;
        for (int i = 0; i < 10; i++, y+= 48) {
            for(int j = 0, x = 52, width = 499; j < 2; j++, x+= 505, width -= 426){
                friendButton[i][j] = new JButton("" + i + j);
                friendButton[i][j].setBounds(x, y, width, 38);
                friendButton[i][j].addActionListener(listener);
                add(friendButton[i][j]);
            }
            friendLabel[i] = new JLabel();
            friendLabel[i].setText("" + i);
            friendLabel[i].setBounds(10, y, 38, 38);        
            add(friendLabel[i]);
        }
    }
    
    ActionListener listener = (ActionEvent e) -> {
        if (e.getSource() instanceof JButton) {
            System.out.println(e.getSource().toString());
        }
    };*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        friendListLabel = new javax.swing.JLabel();
        friendRequestListLabel = new javax.swing.JLabel();
        blockedListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendList = new javax.swing.JList<>(friendModel);
        searchBox = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        friendRequestList = new javax.swing.JList<>(requestModel);
        jScrollPane3 = new javax.swing.JScrollPane();
        blockedList = new javax.swing.JList<>(blockedModel);

        setBackground(new java.awt.Color(255, 153, 0));
        setPreferredSize(new java.awt.Dimension(1280, 660));

        friendListLabel.setText("Amigos ("+ client.getUser().getFriends().size() +")");

        friendRequestListLabel.setText("<html>Pedidos de Amizade <b>("+ client.getUser().getFriendRequests().size() + " Pendentes)</b>");

        blockedListLabel.setText("Bloqueados ("+ client.getUser().getBlocked().size() + ")");

        friendList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                friendListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(friendList);

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

        friendRequestList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                friendRequestListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(friendRequestList);

        blockedList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                blockedListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(blockedList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(friendListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(friendRequestListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockedListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(blockedListLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(friendListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(friendRequestListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        searchBox.setText(Constants.DEFAULT_SEARCH_MESSAGE);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseClicked
        if(searchBox.getText().equals(Constants.DEFAULT_SEARCH_MESSAGE)){
            searchBox.setText("");
        }
    }//GEN-LAST:event_searchBoxMouseClicked

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        Toolkit.getDefaultToolkit().beep();
        String email = searchBox.getText().toLowerCase();
        if(email.equals(client.getUser().getEmail())){
            JOptionPane.showMessageDialog(client, "Voc� j� � amigo de si mesmo (ou n�o!)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else if(client.getDatabase().emailInUse(email)){
            Toolkit.getDefaultToolkit().beep();
            String[] options = {"Adicionar", "Bloquear", "Cancelar"};
            if(client.getUser().isFriend(client.getDatabase().getFromMail(email))){
                options[0] = "Remover";
            }
            User user = client.getDatabase().getFromMail(email);
            int selection = JOptionPane.showOptionDialog(client, "O que deseja fazer com " + user.getName() + " ?" , "Op��es de Intera��o", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);           
            switch(selection){
                case 0:// add/remove friend
                    if(client.getUser().isFriend(user)){
                        JOptionPane.showMessageDialog(client, user.getName() + " foi removido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        client.getUser().removeFriend(user);
                        listFriendPanel(true);
                    } else if(user.isBlocked(client.getUser())){
                        JOptionPane.showMessageDialog(client, user.getName() + " bloqueoou voc�!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(client, "Pedido enviado para " + user.getName(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        user.newFriendRequest(client.getUser());
                        listFriendPanel(true);
                    }
                    break;
                case 1://block
                    if(client.getUser().isBlocked(user)){
                        JOptionPane.showMessageDialog(client, user.getName() + " j� est� bloqueado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(client, user.getName() + " foi bloqueado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        client.getUser().block(user);
                        listFriendPanel(true);
                    }
                    break;               
            }
            searchBox.setText(Constants.DEFAULT_SEARCH_MESSAGE);  
        } else {
            JOptionPane.showMessageDialog(client, "O usu�rio n�o existe!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void friendRequestListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_friendRequestListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = friendRequestList.getSelectedIndex();
        if(index >= 0){
            User selected = client.getUser().getFriendRequests().get(index);
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja adicionar " + selected.getName() + " ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                client.getUser().addFriend(selected);
                friendRequestList.remove(index);
            }
            listFriendPanel(true);
        }
    }//GEN-LAST:event_friendRequestListValueChanged

    private void blockedListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_blockedListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = blockedList.getSelectedIndex();
        if(index >= 0){
            User selected = client.getUser().getBlocked().get(index);
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja desbloquear " + selected.getName() + " ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                client.getUser().unblock(selected);
                blockedList.remove(index);
            }
            listFriendPanel(true);
        }
    }//GEN-LAST:event_blockedListValueChanged

    private void friendListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_friendListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = friendList.getSelectedIndex();
        if(index >= 0){
            User selected = client.getUser().getFriends().get(index);
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja visitar a p�gina de " + selected.getName() + " ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                home.getPage().removeAll();
                home.getPage().add(new Profile(client, selected));
                home.getPage().revalidate();
            }
            listFriendPanel(true);
        }
    }//GEN-LAST:event_friendListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<User> blockedList;
    private javax.swing.JLabel blockedListLabel;
    private javax.swing.JButton btSearch;
    private javax.swing.JList<User> friendList;
    private javax.swing.JLabel friendListLabel;
    private javax.swing.JList<User> friendRequestList;
    private javax.swing.JLabel friendRequestListLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField searchBox;
    // End of variables declaration//GEN-END:variables
}
