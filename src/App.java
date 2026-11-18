import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        //runEjemplo1();
        //runEjemplo2();
        runEjemplo3();
    }

    private static void runEjemplo1(){
        String patron = "ab*"; //es como a(b*) (empieza con a, puede tener una b )
        String[] palabras = new String[]{"a", "ab", "abbb", "abab", "b", ""};
        for(String pal : palabras){
            //validar una palabra
            System.out.println(pal + "->" + pal.matches(patron));
            //observa si coincide la palabra con la EXPRESION REGULAR: ver si el lenguaje esta bien
            //matches devuelve un booleano

        }
    }

    private static void runEjemplo2(){
        String regex = "[TO][0-9]{3}"; // [TO] = (T | O), 
        // [0-9] = numeros del 0 AL 9, 
        // {3} = 3 digitos del 0 al 9
        String[] list = new String[]{"T001", "O120", "T01", "X001", "T0001"}; //{si, si, no, no, no} tienen que TENER 3 numeros obligatorios
        for(String codigo : list){
            System.out.printf("%s -> %s%n", codigo, codigo.matches(regex));

        }
    }

    private static void runEjemplo3(){
        String texto = "Sensores: T001 reporta 23.5 C; O001 reporta 12 PERSONAS; T002 reporta -2 C.";  //esto PUEDE ser prompt
        //de todo lo que hay en el texto, buscar palabras que coincidan con el patron
        Pattern patron = Pattern.compile("[TO][0-9]{3}"); //expresion regular
        //patron.matcher(texto) : BUSCA con el metodo .find() alguna palabra que coincida con la expresion regular
        //el patron no es texto, es una variable tipo Pattern
        Matcher matcher = patron.matcher(texto);
        while(matcher.find()){
            System.out.printf("Encontrado: %s, posicion: %d%n", matcher.group(), matcher.start());
            //da la posición de la primera letra donde comienza el String
        }

    }
}
