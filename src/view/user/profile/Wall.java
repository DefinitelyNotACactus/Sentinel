/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user.profile;

import executable.Client;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import server.actors.AbstractActor;
import server.actors.Group;
import server.actors.actions.Post;
import server.actors.User;
import util.Validator;
import view.user.post.NewPost;
import view.user.post.ViewPost;
import view.util.PostRenderer;

/**
 *
 * @author David
 */
public class Wall extends JPanel {

    private final Client client;
    private final AbstractActor actor;
    private final boolean isOwner;
    
    private DefaultListModel<Post> userPostModel;
    private DefaultListModel<Post> thirdUserPostModel;
    
    public Wall(Client c, AbstractActor actor) {
        client = c;
        this.actor = actor;
        if(actor instanceof Group){
            isOwner = ((Group) actor).isAdmin(client.getUser());
        } else {
            isOwner = Validator.isSameEmail(client.getUser().getId(), actor.getId());
        }
        userPostModel = new DefaultListModel<>();
        thirdUserPostModel = new DefaultListModel<>();
        
        initComponents();
        listPosts(false);
        
        if(actor instanceof Group){
            thirdPersonWallPostLabel.setVisible(false);
            tpwpListPanel.setVisible(false);
            tpwpListPanel.setEnabled(false);
        }
    }
    
    public void listPosts(boolean reload){
        if(reload){
            userPostModel.clear();
            thirdUserPostModel.clear();
        }
        int i;
        //First Person Iteration
        Iterator it = actor.getPosts().iterator();
        for(i = 0; it.hasNext(); i++){
            Post post = (Post) it.next();
            if(!isOwner && !post.isPublic() && !actor.isRelative(client.getUser())){
                i--;
            } else {
                userPostModel.add(i,post);
            }
        }
        wopList.setCellRenderer(new PostRenderer());
        //Third Person Iteration
        if(actor instanceof User){
            User user = (User) actor;
            if(!isOwner && !user.isPublicWall() && !user.isRelative(client.getUser())){
                //do nothing
            } else {
                it = user.getPostsFromOthers().iterator();
                for(i = 0; it.hasNext(); i++){
                    thirdUserPostModel.add(i,(Post) it.next());
                }
            }
            tpwpList.setCellRenderer(new PostRenderer());
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

        wallOwnerPostsLabel = new javax.swing.JLabel();
        wopListPanel = new javax.swing.JScrollPane();
        wopList = new JList<>(userPostModel);
        thirdPersonWallPostLabel = new javax.swing.JLabel();
        tpwpListPanel = new javax.swing.JScrollPane();
        tpwpList = new JList<>(thirdUserPostModel);
        scrollPane = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        visibilityBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 102, 153));

        wallOwnerPostsLabel.setText("<html>Mensagens de <b>" + actor.getName() + "</b></html>");

        wopList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                wopListValueChanged(evt);
            }
        });
        wopListPanel.setViewportView(wopList);

        thirdPersonWallPostLabel.setText("Mensagens de Outros");

        tpwpList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tpwpListValueChanged(evt);
            }
        });
        tpwpListPanel.setViewportView(tpwpList);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollPane.setPreferredSize(new java.awt.Dimension(616, 616));

        if(actor instanceof User){
            User user = (User) actor;
            if(!isOwner && !user.isPublicWall() && !user.isRelative(client.getUser())){
                postPanel.add(new JLabel("Apenas amigos de " + user.getName() + " podem publicar novas mensagens."));
            } else {
                postPanel.add(new NewPost(client, actor, this));
            }
        } else { //instanceof Group
            if(!actor.isRelative(client.getUser())){
                postPanel.add(new JLabel("Apenas membros de " + actor.getName() + " podem publicar novas mensagens."));
            } else {
                postPanel.add(new NewPost(client, actor, this));
            }
        }
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.PAGE_AXIS));
        scrollPane.setViewportView(postPanel);

        visibilityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vis�vel para todos", "Vis�vel somente para amigos" }));
        if(!isOwner || actor instanceof Group){
            visibilityBox.setVisible(false);
            visibilityBox.setEnabled(false);
        } else {
            User user = (User) actor;
            visibilityBox.setSelectedIndex(user.isPublicWall()? 0 : 1);
        }
        visibilityBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visibilityBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wallOwnerPostsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wopListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpwpListPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(thirdPersonWallPostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visibilityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wallOwnerPostsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wopListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(thirdPersonWallPostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(visibilityBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpwpListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void wopListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_wopListValueChanged
        int index = wopList.getSelectedIndex();
        if(index >= 0){
            Post selected = actor.getPost(index);
            postPanel.removeAll();
            postPanel.add(new ViewPost(client, actor, this, selected));
            postPanel.revalidate();
        }
    }//GEN-LAST:event_wopListValueChanged

    private void tpwpListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tpwpListValueChanged
        if(actor instanceof User){
            User user = (User) actor;
            int index = tpwpList.getSelectedIndex();
            if(index >= 0){
                Post selected = user.getPostFromOthersByIndex(index);
                postPanel.removeAll();
                postPanel.add(new ViewPost(client, user, this, selected));
                postPanel.revalidate();
            }
        }
    }//GEN-LAST:event_tpwpListValueChanged

    private void visibilityBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visibilityBoxActionPerformed
        if(actor instanceof User){
            User user = (User) actor;
            user.setWallVisibility((visibilityBox.getSelectedIndex() != 1));
        }
    }//GEN-LAST:event_visibilityBoxActionPerformed
 
    public User getWallOwner(){
        if(actor instanceof User){
            return (User) actor;
        } else {
            return null;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel postPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel thirdPersonWallPostLabel;
    private javax.swing.JList<Post> tpwpList;
    private javax.swing.JScrollPane tpwpListPanel;
    private javax.swing.JComboBox<String> visibilityBox;
    private javax.swing.JLabel wallOwnerPostsLabel;
    private javax.swing.JList<Post> wopList;
    private javax.swing.JScrollPane wopListPanel;
    // End of variables declaration//GEN-END:variables
}
