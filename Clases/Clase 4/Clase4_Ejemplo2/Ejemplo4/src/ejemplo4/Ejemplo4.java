package ejemplo4;

// Libreria para poder usar ArrayLists
import java.util.ArrayList;

/**
 *
 * @author Rodolfo Morales - 202010033
 */
public class Ejemplo4 {

    // Declaracion de arrayList de tal manera que sea un objeto global, pueda ser accedido desde cualquier clase y aparte sea estatico
    // Esta lista guarda objetos de tipo estudiante
    public static ArrayList<Estudiante> estudiantesRegistrados = new ArrayList<>();

    public static void main(String[] args) {
        Persona persona1 = new Persona("Rodolfo Morales", 'M', 1.70, 12345678, 22);
        persona1.hablar("Hola este es el laboratorio de la clase 4.");
        persona1.MostrarDatos();
        System.out.println("*****************************************************************");

        Persona persona2 = new Persona("Esteban Ennati", 'M', 1.65, 123456789, 23);
        persona2.hablar("Hola yo soy Esteban");
        persona2.MostrarDatos();
        System.out.println("*****************************************************************");
        persona2.setNombre("Esteban Valdez");
        persona2.MostrarDatos();
        System.out.println("El nombre del objeto persona 2 es: " + persona2.getNombre());
        System.out.println("*****************************************************************");

        Estudiante student1 = new Estudiante("Isaac Chang", 'M', 1.85, 12345678, 20, 201801573, "Electronica");
        student1.MostrarDatos();
        student1.NotaIPC(88);
        student1.setCursos("IPC 1");
        student1.setCursos("Aplicada 1");
        student1.setCursos("Aplicada 3");
        student1.setCursos("Logica de sistemas");
        student1.setCursos("Fisica 1");
        student1.mostrarCursos();
        student1.setCursos("Aplicada 2");
        student1.mostrarCursos();

        Estudiante student2 = new Estudiante("Allan Cardona", 'M', 1.95, 12345679, 20, 201801574, "Ciencias y Sistemas");
        student2.MostrarDatos();
        student2.NotaIPC(88);
        student2.setCursos("IPC 1");
        student2.setCursos("Aplicada 1");
        student2.setCursos("Aplicada 3");
        student2.setCursos("Logica de sistemas");
        student2.setCursos("Fisica 1");
        student2.mostrarCursos();
        student2.setCursos("Aplicada 2");
        student2.mostrarCursos();

        Estudiante student3 = new Estudiante("Pedro Avila", 'M', 1.88, 12345677, 20, 201801575, "Ciencias y Sistemas");
        student3.MostrarDatos();
        student3.NotaIPC(88);
        student3.setCursos("IPC 1");
        student3.setCursos("Aplicada 1");
        student3.setCursos("Aplicada 3");
        student3.setCursos("Logica de sistemas");
        student3.setCursos("Fisica 1");
        student3.mostrarCursos();
        student3.setCursos("Aplicada 2");
        student3.mostrarCursos();

        estudiantesRegistrados.add(student1);
        estudiantesRegistrados.add(student2);
        estudiantesRegistrados.add(student3);
        System.out.println("=====================================================");
        student1.verEstudiantes();
    }

}
