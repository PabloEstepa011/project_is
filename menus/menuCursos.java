package menus;

import java.util.Scanner;

public class menuCursos {

    public static void mostrarMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Mostrar Cursos Disponibles");
        System.out.println("3. Registrarse en un Curso");
        System.out.println("4. Mostrar Usuarios Registrados");
        System.out.println("5. Salir");
    }

    public static int obtenerOpcion(Scanner scanner) {
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }
}
