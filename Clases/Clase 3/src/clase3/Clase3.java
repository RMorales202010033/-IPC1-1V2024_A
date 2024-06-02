package clase3;

//Librerías para la generación de reportes
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
//Todas las librerías de lectura y escritura de archivos
import java.io.*;
//Librería scanner
import java.util.Scanner;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Clase3 {
//Declaración de variables globales:

    static boolean v1 = true;
    static int[][] M;
    //Scanner
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        // Ejemplo debugging
        int contador = 0;
        while (contador < 10) {
            System.out.println("Numero actual: " + (contador + 1));
            contador = sumarUno(contador);
        }
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Something went wrong: " + aioobe.getMessage());
        }

        try {
            double division = 21 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("Error: " + ae.getMessage());
        }
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException ne) {
            System.out.println("Error: " + ne.getMessage());
        }

        try {
            Object obj = "Hola";
            Integer num = (Integer) obj;
        } catch (ClassCastException ce) {
            System.out.println("Error: " + ce.getMessage());
        }
        try {
            int[] arr = new int[5];
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Lectura de archivos csv para las matrices
        MIM();
    }

    public static int sumarUno(int valor) {
        return (valor + 1);
    }

    public static void GRE() {
        // Fecha en la que se generó
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MMM/dd/yyyy 'at' hh:mm a");
        ZonedDateTime datetime = ZonedDateTime.now();
        String generacion = datetime.format(formato);
        //Declaracion de variables
        String RH = "", RF = "", RB = "";
        String texto = "Este es un texto de prueba el cual debe ser encriptado";
        String cifrado = "238 270 290 205 341 154 176 136 117 199 373 262 303 215 194 237 197 161 340 243 195 255 194 240";

        RH = "<!DOCTYPE html>\r\n"
            + "\t<html>\r\n"
            + "\t\t<head>\r\n"
            + "\t\t\t<meta charset=\"ISO-8859-1\"><!--codififcaion de caracteres ñ y á-->\r\n"
            + "\t\t\t<meta name=\"name\" content=\"Reporte Encriptacion - 202010033\"><!--nombre de la pagina-->\r\n"
            + "\t\t\t<meta name=\"description\" content=\"Rodolfo Morales\"><!--autor de la pagina-->\r\n"
            + "\t\t\t<meta name=\"keywods\" content=\"uno,dos,tres\"><!--Palabras claavez para, separadas por comas-->\r\n"
            + "\t\t\t<meta name=\"robots\" content=\"Index, Follow\"><!--Mejora la busqueda-->\r\n"
            + "\t\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!--visibilidaad en diferentes pantallas -->\r\n"
            + "\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\"/><!--css /estilo/tipo/ruta relativa -->\r\n"
            + "\t\t\t<title>Reporte Prueba - 202010033 </title><!--Titulo visible de la pagina-->\r\n"
            + "\t\t</head>\r\n"
            + "\r\n"
            + "\r\n"
            + "\t\t<body>\r\n"
            + "\t\t\t<center><!--centra todos lo que este dentro-->\r\n"
            + "\t\t\t\t<div class=\"te1\">\r\n"
            + "\t\t\t\t\t<h1><b> REPORTE ENCRIPTACIÓN </b></h1>\r\n"
            + "\t\t\t\t</div>\r\n";

        RB = ""
            + "\t\t\t\t<h2 class=\"te2\"><b> 1. Mensaje Ingresado: </b></h2>\r\n"
            + "\t\t\t\t<div class=\"te22\">\r\n"
            + "\t\t\t\t\t"
            + texto
            + "\r\n"
            + "\t\t\t\t</div>\r\n"
            //Matriz M
            + "\t\t\t\t<h2 class=\"te2\"><b> 2. Mensaje Codificado Ingresado a la Matriz (M): </b></h2>\r\n"
            + "\t\t\t\t<table id=\"t01\">"
            + "\r\n"
            + "\t\t\t\t\t<tr>\r\n";

        for (int i = 0; i < M.length; i++) {
            RB += "\t\t\t\t\t\t";
            for (int j = 0; j < M[0].length; j++) {
                RB += "<td>" + M[i][j] + "</td>";
            }
            if (i != (M.length - 1)) {
                RB += "\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n";
            }
        }
        RB += "\r\n\t\t\t\t\t</tr>\r\n"
            + "\t\t\t\t</table>\r\n";

        //Resultado cifrado
        RB += ""
            + "\t\t\t\t<h2 class=\"resultado\"><b> Mensaje Cifrado: </b></h2>\r\n"
            + "\t\t\t\t<div class=\"te22\">\r\n"
            + "\t\t\t\t\t"
            + cifrado
            + "\r\n"
            + "\t\t\t\t</div>\r\n"
            + "\t\t\t\t"
            + "<br>"
            + "<br>"
            + "\r\n"
            + "\t\t\t\t<div class=\"greporte\">\r\n"
            //Generacion Reporte, tiempo en que fue creado
            + "\t\t\t\t\t<h3><b> Información Generación del Reporte: </b></h3>\r\n"
            + "\t\t\t\t\t"
            + generacion
            + "\r\n"
            + "\t\t\t\t\t<br>\r\n"
            + "\t\t\t\t</div>"
            + "";
        //Cierre HTML 
        RF = "\r\n"
            + "\t\t\t</center>\r\n"
            + "\t\t</body>\r\n"
            + "\t</html>";

        try {
            FileWriter archivo = new FileWriter("./Reportes/Reporte1.html");
            archivo.write(RH + RB + RF);
            archivo.close();
            System.out.println("-> " + "El reporte fue generado exitosamente, puede visualizarlo en la siguiente ruta relativa:");
            System.out.println("./Reportes/Reporte1");
        } catch (Exception e) {
        }
    }

    //Método Ingreso Matriz M
    public static void MIM() {
        //Declaracion para lectura de un fichero de texto
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            System.out.println("[============= " + "MATRIZ M" + " =============] ");
            //Ingreso ruta, lectura y guardar el texto
            System.out.println("Ingrese ruta del archivo de la matriz M: "); // ./Matriz/MatrizM.txt ruta relativa
            String ruta = scn.nextLine();
            System.out.println("=========================================== ");
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            //Lectura de cada linea
            String line;
            int cont1 = 0;
            int filas = 0;
            int columnas = 0;
            boolean v2 = true;

            while ((line = br.readLine()) != null) {
                if (v2) {
                    String[] n1 = line.split(";");
                    columnas = n1.length;
                    v2 = !v2;
                }
                filas++;
            }
            M = new int[filas][columnas];
            line = null;
            // Cerrar el BufferedReader y FileReader
            br.close();
            fr.close();

            // Volver a abrir el BufferedReader y FileReader para leer los datos de la matriz
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String[] n1 = line.split(";");
                for (int i = 0; i < n1.length; i++) {
                    M[cont1][i] = Integer.parseInt(n1[i]);
                }
                cont1++;
            }

            // Creación de reporte usando html y css
            GRE();
        } //Verificacion Errores
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("!!!" + "Se introdujo mal la Matriz M");
            System.out.println("[==========================================] ");
        } //Paso final
        finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                //e2.printStackTrace();
                System.out.println("!!!" + "Se introdujo mal la Matriz Clave A");
                System.out.println("[==========================================] ");
            }
        }
    }
}
