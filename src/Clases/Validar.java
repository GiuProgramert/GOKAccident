package Clases;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/*
    Para poder validar debemos crear un objeto de esta clase
    pasando como parametro al constructor cuantod campos de texto queremos validar
    luego llamando a los respectivos métodos depende de si queres validar un String o un int
    
    al final de haber llamado todos los métodos para validar debemos llamar al método comprobarCampos()
    si este retorna true todos los campos estan intrucidos correctamente
    si retorna false hay un campo que no esta instroducido correctamente
*/
public class Validar {

    private static int cCampos;
    private int maxCampos;

    public Validar(int maxCampos) {
        this.maxCampos = maxCampos;
        this.cCampos = 0;
    }
    
    /*
        El primer parametro es lo que queremos validar
        el segundo es el objeto que estamos queriendo aplicar la validación
    */
    public String Vcadena(String Elemento, JTextField campo) {
        if(Elemento.equals("")){
            campo.setBorder(new LineBorder(Color.RED));
        }
        if (!Elemento.equals("")) {
            cCampos++;
            campo.setBorder(new LineBorder(Color.BLACK));
            return Elemento;
        }
        return null;
    }
    
    /*
        El primer parametro es lo que queremos validar
        El segundo es el objeto que estamos queriendo aplicar la validación
        El tercer parametro es utilizado si queremos que el número ingresado no sea negativo
        si deseamos que sea negativo el parametro debe ser <<false>>
    */
    public int Ventero(String elemento, JTextField campo, boolean ValidNEgativo) {
        int comprobar = 0;
        int result = 0;
        try {
            //Comprobar si el elemento ingresado no es una letra
            result = Integer.parseInt(elemento);
            comprobar = 1;
            //Comprobar si el elemento ingresado no sea igual a 0
            if (result == 0) {
                comprobar = 0;
                campo.setBorder(new LineBorder(Color.RED));
            }
            //Comprobar si el elemento ingresado es negativo
            //Esta parte solo se ejecuta si ValidNegativo es true
            if(ValidNEgativo) {
                if (result < 0){
                    comprobar = 0;
                    campo.setBorder(new LineBorder(Color.RED));
                }
            }
        } catch (NumberFormatException e) {
            campo.setBorder(new LineBorder(Color.RED));
        }
        
        if (comprobar == 1) {
            cCampos++;
            campo.setBorder(new LineBorder(Color.BLACK));
            return result;
        }
        return 0;
    }
    /*
        Esta funcion retorna true si estan correctamente validados todos los
        campos de texto
    */
    public boolean comprobarCampos(){
        return (this.maxCampos == this.cCampos);
    }

}
