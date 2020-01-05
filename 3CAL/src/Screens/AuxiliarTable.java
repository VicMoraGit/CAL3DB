/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victo
 */
public class AuxiliarTable extends javax.swing.JPanel {

    /**
     * Creates new form AuxiliarTable
     * @param rs
     */
    public AuxiliarTable(ResultSet rs) {
        
        ArrayList<String> columnNames = new ArrayList();
        ArrayList<ArrayList<String>> rowsData = new ArrayList();
        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSetMetaData rsmd = null;
        this.setBounds(0, 0, 827, 518);
        this.setVisible(true);
        jTable1 = new JTable();
        this.add(jTable1);

        try {
            rsmd = rs.getMetaData(); //returns de information of the query (columns, rows...)
            
            System.out.println("Adding columns...");
            
            for (int i = 1; i<rsmd.getColumnCount(); i++){
                columnNames.add(rsmd.getColumnName(i));
                System.out.println(rsmd.getColumnName(i));
            }
            
            // create an auxiliar row
            
            System.out.println("Adding rows...");
            
            ArrayList<String> row; 
            
            // while there is a row it gets the row data an adds it to the arraylist of rows
            
            while(rs.next()){
                row = new ArrayList();
                System.out.println(rs);
                for (int i = 1; i<rsmd.getColumnCount()+1;i++){
                   
                    
                    row.add(rs.getObject(i).toString());
                }
                rowsData.add(row);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        //Add to the table model the columns of the result set
        System.out.println("Adding columns to the table model");
        for (String columnName : columnNames) {
            tableModel.addColumn(columnName);
        }
        
        //Add to the table model the rows of the result set
        System.out.println("Adding rows to the table model");
        for(ArrayList<String> RowData : rowsData){
            tableModel.addRow(RowData.toArray());
        }
        
        jTable1.setModel(tableModel);
        jTable1.setSize(827, 520);
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane pane = new JScrollPane(jTable1);
        this.add(pane);
        
        

        jTable1.revalidate();
        jTable1.repaint();
       
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
