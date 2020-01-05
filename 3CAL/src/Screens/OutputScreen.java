/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Victo
 */
public class OutputScreen extends javax.swing.JFrame {

    Connection conn;
    
    public OutputScreen(Connection connection) {
        conn = connection;
        initComponents();
        this.setVisible(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String option = jComboBox1.getSelectedItem().toString();
        try {
           Statement st = conn.createStatement();
        
        
        switch(option){
            case "1": {
                ResultSet rs = st.executeQuery("Select \"Bar_code\", \"Price_no_VAT\" from \"Product\"");
               
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "2": {
                ResultSet rs = st.executeQuery("Select \"Name\", \"Type\" from \"Worker\" order by \"Type\",\"Name\"");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "3": {
                ResultSet rs = st.executeQuery("Select \"Name\", \"Number_of_Hours\" from \"Replenter\" where \"Number_of_Hours\">20\n" +
"Order by \"Number_of_Hours\"");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "4": {
                ResultSet rs = st.executeQuery("Select round(Sum(\"Total_price\")) from \"Ticket\"");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "5": {
                ResultSet rs = st.executeQuery("Select \"Affected_Product\", \"Discount\" from \"Couppon\";");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "6": {
                ResultSet rs = st.executeQuery("Select \"Member_code\",\"Member\", \"Name\" , \"Discount\" from (((\"Relationship_Couppon_N:M_Product\" inner join \"Product\" on \"Bar_code_Product\"=\"Bar_code\") \n" +
                "inner join \"Couppon\" on \"Coupon_Code_Couppon\"=\"Coupon_Code\")inner join \"Member\" on \"ID_Customer\"=\"Member\".\"ID_Customer\")\n" +
                "order by \"Member_code\"");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "7": {
                ResultSet rs = st.executeQuery("select avg(\"Punctuation\")from \"Opinion\"");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "8": {
                ResultSet rs = st.executeQuery("select \"Name\", \"Address\", count(*) as TotTickets\n" +
                "from (\"Ticket\" inner join \"Cashier\" on \"SSN\"=\"SSN_Cashier\")inner join \"Supermarket\" on \"Supermarket\".\"ID\"=\"ID_Supermarket\"\n" +
                "group by \"Name\", \"Address\",  \"Supermarket\".\"ID\"\n" +
                "order by  TotTickets desc");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "9": {
                ResultSet rs = st.executeQuery("select \"ID_Supermarket\" , count (*) as \"Number_Workers\" from \"Worker\" group by \"ID_Supermarket\" order by \"Number_Workers\" ");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "10": {
                ResultSet rs = st.executeQuery("select \"Name\", \"Landline_nr\", \"Average_Grade\" from \"Worker\" where \"Average_Grade\"=(select max(\"Average_Grade\") from \"Worker\" )");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "11": {
                ResultSet rs = st.executeQuery("select \"Bar_code_Product\", \"Percent\" from (\"Product\" inner join \"Relationship_Discount_N:M_Product\" on \"Bar_code_Product\"=\"Bar_code\") \n" +
                "inner join \"Discount\" on \"Discount_ID\"=\"Discount_ID_Discount\"\n" +
                "where (\"Start_date\" between '01/05/2019' and '07/05/2019'\n" +
                "	   or \"End_date\" between '07/05/2019' and '14/05/2019')");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "12": {
                ResultSet rs = st.executeQuery("select distinct\"Name\" from ((\"Ticket\" inner join \"Member\" on \"ID_Customer_Member\"=\"ID_Customer\") inner join \"Relationship_Product_N:M_Ticket\" on \"ID\"=\"ID_Ticket\")inner join \n" +
                "\"Customer\" on \"ID_Customer\"=\"Customer\".\"ID\"\n" +
                "where \"Bar_code_Product\" in (select \"Bar_code_Product\" from \"Discount\" inner join \"Relationship_Discount_N:M_Product\" on\n" +
                "					 \"Discount_ID_Discount\"=\"Discount_ID\" where \"Start_date\" between '24/05/2019' and '31/05/2019'\n" +
                "	   or \"End_date\" between '24/05/2019' and '31/05/2019') and \"Ticket\".\"Date_insurance\" between '24/05/2019' and '31/05/2019'\n" +
                "");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "13": {
                ResultSet rs = st.executeQuery("Select \"Name\", \"Address\" from (\"Worker\" inner join \"Supermarket\" on \"ID\"=\"ID_Supermarket\") where \"Address\" like 'M%' order by \"Name\" asc");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "14": {
                ResultSet rs = st.executeQuery("Select \"email\" from \"Member\" where \"Accumulate_points\"=(select MAX(\"Accumulate_points\") from \"Member\")");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "15": {
                ResultSet rs = st.executeQuery("Select \"Name\",\"returned\" from \"Product\" where \"returned\"=(select max(\"returned\") from \"Product\" )");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "16": {
                ResultSet rs = st.executeQuery("SELECT \"SSN_Cashier\", \"Name\", count (*)\n" +
                "FROM (\"Ticket\" inner join \"Worker\" on \"SSN_Cashier\"=\"SSN\")\n" +
                "GROUP BY \"SSN_Cashier\", \"Name\"\n" +
                "HAVING COUNT(*) = ( SELECT MAX(Nr) FROM ( SELECT \"SSN_Cashier\", COUNT(*) Nr FROM \"Ticket\" GROUP BY \"SSN_Cashier\") T);");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "17": {
                ResultSet rs = st.executeQuery("select \"Name\", \"Punctuation\" from (\"Customer\" inner join \"Opinion\" on \"ID_Customer\"=\"ID\") where \n" +
                "\"Punctuation\"=(select max(\"Punctuation\")from \"Opinion\" )\n" +
                "group by \"Name\", \"Punctuation\"");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "18": {
                ResultSet rs = st.executeQuery("select *\n" +
                "from \"Ticket\" \n" +
                "where \"SSN_Cashier\" in(\n" +
                "	select \"SSN\" from(\"Cashier\" inner join \"Ticket\" on \"SSN_Cashier\"=\"SSN\")\n" +
                "	where \"Name\" like 'A%' and \"Address_Supermarket\" like 'M%'\n" +
                "	)");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "19": {
                ResultSet rs = st.executeQuery("select \"Ticket\".\"ID\", \"Name\" from (\"Ticket\" inner join \"Cashier\" on \"SSN_Cashier\"=\"SSN\")\n" +
                "where \"Address_Supermarket\" like '%Alcala De Henares%'");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
            case "20": {
                ResultSet rs = st.executeQuery("select \"ID\", \"Name\" from (\"Ticket\" inner join \"Cashier\" on \"SSN_Cashier\"=\"SSN\")\n" +
                "where \"Address_Supermarket\" like '%Alcala De Henares%' and \"ID\" not in (\n" +
                "	select \"ID_Ticket\" \n" +
                "	from (((\"Relationship_Product_N:M_Ticket\" \n" +
                "		inner join \"Relationship_Discount_N:M_Product\" \n" +
                "		on \"Relationship_Product_N:M_Ticket\".\"Bar_code_Product\"=\"Relationship_Discount_N:M_Product\".\"Bar_code_Product\") \n" +
                "		inner join \"Discount\" \n" +
                "		on \"Relationship_Discount_N:M_Product\".\"Discount_ID_Discount\"=\"Discount_ID\") \n" +
                "		inner join \"Ticket\" \n" +
                "		on \"Relationship_Product_N:M_Ticket\".\"ID_Ticket\"=\"Ticket\".\"ID\") \n" +
                "	where \"Ticket\".\"Date_insurance\" between \"Discount\".\"Start_date\" and \"Discount\".\"End_date\")	");
                
                jPanel1.removeAll();
                jPanel1.add(new AuxiliarTable(rs));
                jPanel1.validate();
                jPanel1.repaint();
                break;
            }
        }
        
        
        } catch (SQLException ex) {
        }    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
