/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user.post;

import executable.Client;
import java.awt.Image;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import server.actors.actions.Answer;
import server.actors.actions.Comment;
import server.actors.actions.Post;

/**
 *
 * @author David
 */
public class ViewComment extends JPanel {

    private final Client client;
    private final Comment comment;
    private final Post post;
    
    private final boolean isOwner;
    private boolean isEditing;
    /**
     * Creates new form ViewComment
     * @param c
     * @param post
     * @param comment
     */
    public ViewComment(Client c, Post post, Comment comment) {
        this.client = c;
        this.post = post;
        this.comment = comment;
        
        isOwner = true;
        isEditing = false;
        
        initComponents();
    }

    public ViewComment(Client c, Comment comment) {
        this.client = c;
        this.post = null;
        this.comment = comment;
        
        isOwner = true;
        isEditing = false;
        
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

        textField = new javax.swing.JTextPane();
        answersPanel = new javax.swing.JPanel();
        answersButtonsPanel = new javax.swing.JPanel();
        btDeleteAnswer = new javax.swing.JButton();
        btEditAnswer = new javax.swing.JButton();
        answersLabel = new javax.swing.JLabel();
        answersContentPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btComment = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        commentsPanel = new javax.swing.JPanel();

        textField.setEditable(false);
        textField.setText(comment.getText());
        textField.setToolTipText("");

        answersButtonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        btDeleteAnswer.setText("Apagar");
        answersButtonsPanel.add(btDeleteAnswer);
        if(!isOwner){
            btDelete.setEnabled(false);
        }

        btEditAnswer.setText("Editar");
        answersButtonsPanel.add(btEditAnswer);
        if(!isOwner){
            btEdit.setEnabled(false);
        }

        if(isOwner){
            userLabel.setText("<html><b>(Voc�)</b> respondeu: </html>");
        } else {
            answersLabel.setText("<html><b>" + comment.getAuthor().getName() + "</b> respondeu: </html>");
        }

        answersContentPanel.setLayout(new javax.swing.BoxLayout(answersContentPanel, javax.swing.BoxLayout.LINE_AXIS));
        answersContentPanel.add(new JScrollPane(textField));

        javax.swing.GroupLayout answersPanelLayout = new javax.swing.GroupLayout(answersPanel);
        answersPanel.setLayout(answersPanelLayout);
        answersPanelLayout.setHorizontalGroup(
            answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(answersContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answersButtonsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        answersPanelLayout.setVerticalGroup(
            answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answersContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answersButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        btDelete.setText("Apagar");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        buttonsPanel.add(btDelete);
        if(!isOwner){
            btDelete.setEnabled(false);
        }

        btEdit.setText("Editar");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        buttonsPanel.add(btEdit);
        if(!isOwner){
            btEdit.setEnabled(false);
        }

        btComment.setText("Responder");
        btComment.setOpaque(false);
        btComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCommentActionPerformed(evt);
            }
        });
        buttonsPanel.add(btComment);

        if(isOwner){
            userLabel.setText("<html><b>(Voc�)</b> comentou: </html>");
        } else {
            userLabel.setText("<html><b>" + comment.getAuthor().getName() + "</b> respondeu: </html>");
        }

        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));
        if(comment.getIcon() != null){
            JLabel image = new JLabel();
            image.setIcon(new ImageIcon(comment.getIcon().getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            contentPanel.add(image);
        }
        contentPanel.add(new JScrollPane(textField));

        commentsPanel.setLayout(new javax.swing.BoxLayout(commentsPanel, javax.swing.BoxLayout.PAGE_AXIS));
        loadAnswers();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(commentsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 314, Short.MAX_VALUE)
                    .addComponent(commentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCommentActionPerformed
        btComment.setEnabled(false);
        commentsPanel.add(new NewComment(client, comment));
        revalidate();
    }//GEN-LAST:event_btCommentActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        if(!isEditing){
            textField.setEditable(true);
            btEdit.setText("Salvar");
            isEditing = true;
        } else {
            textField.setEditable(false);
            comment.setText(textField.getText());
            btEdit.setText("Editar");
            isEditing = false;
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if(post != null){
            post.getComments().remove(comment);
        }
        this.getParent().revalidate();
        this.getParent().remove(this);
    }//GEN-LAST:event_btDeleteActionPerformed

    public void loadAnswers(){
        Iterator it = comment.getAnswers().iterator();
        while(it.hasNext()){
            commentsPanel.add(new ViewAnswer(client, comment, (Answer) it.next()));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel answersButtonsPanel;
    private javax.swing.JPanel answersContentPanel;
    private javax.swing.JLabel answersLabel;
    private javax.swing.JPanel answersPanel;
    private javax.swing.JButton btComment;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDeleteAnswer;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btEditAnswer;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel commentsPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextPane textField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
