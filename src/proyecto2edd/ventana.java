/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2edd;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static proyecto2edd.rabin_karp.search;

/**
 *
 * @author massimo
 */
public class ventana extends javax.swing.JFrame {
    
    FondoPanel fondo = new FondoPanel();
    

    /**
     * Creates new form ventana
     */
    public ventana() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    public static String ruta = "";
    public static String texto = "";
    public static String texto2 = "";
    public static Hash_table tabla_hash = new Hash_table(10111);
    public static Hash_table tabla_hash_global = new Hash_table(10111);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        filechooser = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buscadorPlagio = new javax.swing.JButton();
        buscarPalabra = new javax.swing.JButton();
        masUsadas = new javax.swing.JButton();
        repPalabras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        filechooser.setText("choose file");
        filechooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filechooserActionPerformed(evt);
            }
        });
        jPanel1.add(filechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 40));

        jButton1.setText("mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 200, 40));

        buscadorPlagio.setText("Buscador plagio");
        buscadorPlagio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorPlagioActionPerformed(evt);
            }
        });
        jPanel1.add(buscadorPlagio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 200, 40));

        buscarPalabra.setText("Buscar palabra");
        buscarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPalabraActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 200, 40));

        masUsadas.setText("Palabras mas usadas");
        masUsadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masUsadasActionPerformed(evt);
            }
        });
        jPanel1.add(masUsadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 200, 40));

        repPalabras.setText("Mostrar rep palabras");
        repPalabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repPalabrasActionPerformed(evt);
            }
        });
        jPanel1.add(repPalabras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 200, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filechooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filechooserActionPerformed
        // TODO add your handling code here:

        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();

            ruta = fichero.getAbsolutePath();

        }

        funciones f = new funciones();

        texto = f.leerTxt(ruta);
        texto2 = texto;

        texto = texto.replace("(", "").replace(")", "").replace(".", "").replace(",", "");

        texto = texto.toLowerCase();
        
        
                tabla_hash.vaciado();

        String[] arreglo = texto.split(" ");

        for (int i = 0; i < arreglo.length; i++) {
            tabla_hash.insertar(arreglo[i]);
            tabla_hash_global.insertar(arreglo[i]);
//            System.out.println(tabla_hash.buscar("ide").getContador());

        }


    }//GEN-LAST:event_filechooserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:


        JOptionPane.showMessageDialog(null, texto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscadorPlagioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorPlagioActionPerformed
        // TODO add your handling code here:

        texto2 = texto2.replace("(", "").replace(")", "").replace(".", "").replace(",", "");

        texto2 = texto2.toLowerCase();
        String pat = JOptionPane.showInputDialog("Ingrese la oracion a buscar").toLowerCase();
        

        //un numero primo
        int q = 101;

        search(pat, texto2, q);
    }//GEN-LAST:event_buscadorPlagioActionPerformed

    private void repPalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repPalabrasActionPerformed
        // TODO add your handling code here:
        String repPalabra = "";

        for (int i = 0; i < tabla_hash.tamano_tabla; i++) {
            if (tabla_hash.tabla[i] != null) {
                repPalabra += "Palabra " + tabla_hash.tabla[i].getName() + ": " + tabla_hash.tabla[i].getContador() + "\n";

                if (tabla_hash.tabla[i].getNext() != null) {
                    Nodo_hash temp = tabla_hash.tabla[i].getNext();
                    while (temp != null) {
                        System.out.println(temp.getName());
                        temp = temp.getNext();
                    }

                }
            }

        }
        JOptionPane.showMessageDialog(null, repPalabra);

//       tabla_hash_global.imprimir();
    }//GEN-LAST:event_repPalabrasActionPerformed

    private void masUsadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masUsadasActionPerformed
        // TODO add your handling code here:
        String repPalabra2 = "";
        
        Lista lista = new Lista();
        lista.vaciar();

        for (int i = 0; i < tabla_hash_global.tamano_tabla; i++) {
            if (tabla_hash_global.tabla[i] != null) {
                //agregar lisa por aqui
                lista.agregarFinal(tabla_hash_global.tabla[i]);

                if (tabla_hash_global.tabla[i].getNext() != null) {
                    Nodo_hash temp = tabla_hash_global.tabla[i].getNext();
                    while (temp != null) {
                        System.out.println(temp.getName());
                        temp = temp.getNext();
                    }

                }
            }

        }
        try {
            lista.Ordena();
        } catch (Exception ex) {
            Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < lista.getTamanio(); i++) {

            try {
                repPalabra2 += "Palabra " + lista.getName(i) + ": " + lista.getValor(i) + "\n";
            } catch (Exception ex) {
                Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//        tabla_hash.imprimir();
        JOptionPane.showMessageDialog(null, repPalabra2);
    }//GEN-LAST:event_masUsadasActionPerformed

    private void buscarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPalabraActionPerformed
        // TODO add your handling code here:
        
        
        String palabraBuscada = JOptionPane.showInputDialog("Ingrese la palabra a buscar").toLowerCase();
        String frase ="";

        for (int i = 0; i < tabla_hash.tamano_tabla; i++) {
            if (tabla_hash.tabla[i] != null) {
                if (tabla_hash.tabla[i].getName().equals(palabraBuscada)) {
                    frase += "Palabra " + tabla_hash.tabla[i].getName() + ": " + tabla_hash.tabla[i].getContador() + "\n";
                }
                

                if (tabla_hash.tabla[i].getNext() != null) {
                    Nodo_hash temp = tabla_hash.tabla[i].getNext();
                    while (temp != null) {
                        System.out.println(temp.getName());
                        temp = temp.getNext();
                    }

                }
            }

        }
        if (frase.equals("")) {
            JOptionPane.showMessageDialog(null, "No se encuentra esa palabra en el texto");
        }else{
            JOptionPane.showMessageDialog(null, frase);
        }
        

    

    }//GEN-LAST:event_buscarPalabraActionPerformed

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana

.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana

.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana

.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana

.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscadorPlagio;
    private javax.swing.JButton buscarPalabra;
    private javax.swing.JButton filechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton masUsadas;
    private javax.swing.JButton repPalabras;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel{
        private Image imagen ;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagenes/Green Illustrative Accounting Service Website.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            super.paint(g);
            
        }
    }

}
