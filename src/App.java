import java.util.ArrayList;
import java.util.List;
import models.Persona;
import models.genericos.Caja;
import models.genericos.Par;

public class App {
    public static void main(String[] args) throws Exception {
        // Crear instancias de Caja y probar su funcionalidad
        Caja<String> cajaString = new Caja<>();
        Caja<Integer> cajaInteger = new Caja<>();
        Caja<Persona> cajaPersona = new Caja<>();

        Persona persona = new Persona();
        persona.setNombre("Cristina");
        persona.setEdad(19);

        cajaString.guardar("Guardo un String");
        cajaInteger.guardar(10);
        cajaPersona.guardar(persona);

        System.out.println(cajaString.obtener());
        System.out.println(cajaInteger.obtener());
        System.out.println("Persona en la caja: " + cajaPersona.obtener().getNombre());

        // Usar la clase Par<K, V>
        Par<Integer, String> par = new Par<>();
        par.establecerClave(1);
        par.establecerValor("Valor asociado a la clave 1");

        System.out.println("Clave: " + par.obtenerClave());
        System.out.println("Valor: " + par.obtenerValor());

        // -----------------------------------------------------------------------
        // Crear arreglo de nombres para las personas
        String[] nombres = {
            "Cristina", "Juan", "Ariana", "Carlos", "Denisse", 
            "Luis", "Paula", "José", "Danna", "Pedro"
        };

        // Crear un arreglo de 10 Personas con datos
        Persona[] personas = new Persona[10];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona();
            personas[i].setNombre(nombres[i]); // Asignar nombre del arreglo
            personas[i].setEdad(15 + i); // Edades entre 15 y 24
        }

        // Crear arreglos tipo Par
        List<Par<String, Integer>> mayores = new ArrayList<>();
        List<Par<Integer, String>> menores = new ArrayList<>();

        // Clasificar las personas en mayores y menores de edad
        for (Persona p : personas) {
            if (p.getEdad() >= 18) {
                mayores.add(new Par<>(p.getNombre(), p.getEdad()));
            } else {
                menores.add(new Par<>(p.getEdad(), p.getNombre()));
            }
        }

        // Imprimir arreglos mayores y menores
        System.out.println("\nArreglo de Mayores de Edad:");
        for (Par<String, Integer> parMayor : mayores) {
            System.out.println("Clave (Nombre): " + parMayor.obtenerClave() + ", Valor (Edad): " + parMayor.obtenerValor());
        }

        System.out.println("\nArreglo de Menores de Edad:");
        for (Par<Integer, String> parMenor : menores) {
            System.out.println("Clave (Edad): " + parMenor.obtenerClave() + ", Valor (Nombre): " + parMenor.obtenerValor());
        }
    }
}
