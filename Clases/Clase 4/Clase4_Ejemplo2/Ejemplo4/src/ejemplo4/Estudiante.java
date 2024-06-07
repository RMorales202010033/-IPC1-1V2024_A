package ejemplo4;

/**
 *
 * @author jrodo
 */
// Clase Estudiante que hereda de Persona
public class Estudiante extends Persona {

    // Atributos de un estudiante
    private int carnet;
    private String carrera;
    private String[] cursos;
    private int contador;

    // Constructor del estudiante, ojo que lleva los atributos de su padre
    public Estudiante(String nombre, char sexo, double altura, long CUI, int edad, int carnet, String carrera) {
        // super se utiliza para poder utilizar los atributos de su clase padre
        super(nombre, sexo, altura, CUI, edad);
        this.carnet = carnet;
        this.carrera = carrera;
        this.cursos = new String[5];
        this.contador = 0;
        System.out.println("Creacion de un estudiante");
    }

    // Procedimiento que va guardando los cursos de un estudiante
    public void setCursos(String curso) {
        if (this.getContador() < this.getCursos().length) { // contador < cursos.length -> 0 < 5
            this.getCursos()[this.getContador()] = curso; //cursos[0] = curso
            setContador(getContador() + 1); // contador = contador + 1
        } else {
            System.out.println("La capacidad de cursos asignados ha llegado a su límite.");
        }
    }

    // Procedimiento que muestra los cursos que tiene un estudiante
    public void mostrarCursos() {
        System.out.println("Cursos asignados: ");
        for (int i = 0; i < this.getCursos().length; i++) {
            System.out.println((i + 1) + ". " + this.getCursos()[i]);
        }
    }

    // Procedimiento que muestra si el estudiante gana o no dependiendo de la nota
    public void NotaIPC(int nota) {
        if (nota >= 61) {
            System.out.println(this.getNombre() + " ha aprobado el curso de IPC 1 con una nota de " + nota);
            System.out.println("Por lo tanto, podrá seguir adelantando los cursos de la carrera de: " + this.getCarrera());
        } else {
            System.out.println("El estudiante con carnet: " + this.getCarnet() + " ha reprobado el curso.");
        }
    }
    
    // Imprimir informacion de cada objeto estudiante que este en el arrayList de la clase main (Ejemplo4)
    public void verEstudiantes(){
        for (int i = 0; i < Ejemplo4.estudiantesRegistrados.size(); i++) {
            System.out.println(Ejemplo4.estudiantesRegistrados.get(i).getNombre());
            System.out.println(String.valueOf(Ejemplo4.estudiantesRegistrados.get(i).getCarnet()));
            System.out.println(Ejemplo4.estudiantesRegistrados.get(i).getCarrera());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    // Metodos de encapsulamiento del objeto estudiante
    /**
     * @return the carnet
     */
    public int getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the cursos
     */
    public String[] getCursos() {
        return cursos;
    }


    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

}
