/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author massimo
 */
public class rabin_karp {

    public final static int d = 256;

    /* pat -> patron
        txt -> texto
        q -> numero primo
     */
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // valor hash por patron
        int t = 0; // valor hash por texto
        int h = 1;
        int w = 0;//valor index comienzo frase buscada

        // el valor de h seria "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calcule el valor hash del patrón y primero
        // ventana de texto
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Desliza el patrón sobre el texto uno por uno
        for (i = 0; i <= N - M; i++) {

            // Verifique los valores hash de la ventana de texto actual
            // y patrón. Si los valores hash coinciden, solo
            // verifica los caracteres uno por uno
            if (p == t) {
                /* verifica los caracteres uno por uno */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                // si p == t y pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) //                    
                {
                    w=i;
             
                }
                for (int k = 0; k < 1; k++) {
    
                }
            }

            // Calcular el valor hash para la siguiente ventana de texto: Eliminar
            // dígito inicial, agregar dígito final
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                // Podríamos obtener un valor negativo de t, convirtiéndolo
                // a positivo
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        
        if (w!=0) {
            
        

        String substring1 = "";

        for (int k = 0; k < w ; k++) {
            substring1 += txt.charAt(k);

        }


        String substring2 = "";


        for (int k = w+pat.length(); k < txt.length(); k++) {
            substring2 += txt.charAt(k);

        }
        


        String master = substring1 + "&&"+pat+"&&" +substring2;
        JOptionPane.showMessageDialog(null, "El fragmento fue encontrado en la posición: "+w+"\n\nFragmento resaltado:\n\n"+master);
    }
    else{
            
            JOptionPane.showMessageDialog(null, "El fragmento no esta dentro del texto");
            
    
}

}
    
}
