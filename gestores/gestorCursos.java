package gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

import classes.curso;
import classes.usuario;

public class gestorCursos {

    private static final String USUARIOS_FILE = "usuarios.txt";
    private static final String CURSOS_FILE = "cursos.txt";

    private static List<usuario> usuarios;
    private static List<curso> cursos;
    private static int idCursoActual = 1;
    private static int dniUsuarioActual = 10000000;

    public static void main(String[] args) {
        usuarios = FileHandler.cargarUsuarios(USUARIOS_FILE);
        cursos = FileHandler.cargarCursos(CURSOS_FILE);

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner);
                    break;
                case 2:
                    mostrarCursosDisponibles();
                    break;
                case 3:
                    registrarEnCurso(scanner);
                    break;
                case 4:
                    mostrarUsuarios();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }

        } while (opcion != 5);

        FileHandler.guardarUsuarios(USUARIOS_FILE, usuarios);
        FileHandler.guardarCursos(CURSOS_FILE, cursos);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Mostrar Cursos Disponibles");
        System.out.println("3. Registrarse en un Curso");
        System.out.println("4. Mostrar Usuarios Registrados");
        System.out.println("5. Salir");
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("=== Registro de Usuario ===");
        System.out.print("Nombre Completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Correo Electrónico: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(dniUsuarioActual++, nombreCompleto, correoElectronico, contraseña);
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario registrado exitosamente.");
    }

    private static void mostrarCursosDisponibles() {
        System.out.println("=== Cursos Disponibles ===");
        for (Curso curso : cursos) {
            System.out.println(curso.getIdCurso() + ". " + curso.getNombreCurso());
        }
    }

    private static void registrarEnCurso(Scanner scanner) {
        System.out.println("=== Registro en Curso ===");
        mostrarCursosDisponibles();
        System.out.print("Selecciona el ID del curso al que deseas registrarte: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Curso cursoSeleccionado = encontrarCursoPorId(idCurso);
        if (cursoSeleccionado != null) {
            cursoSeleccionado.mostrarInformacionCurso();
            Usuario usuarioActual = obtenerUsuarioActual();

            if (usuarioActual != null) {
                cursoSeleccionado.registrarUsuario(usuarioActual);
                System.out.println("Te has registrado en el curso exitosamente.");
            } else {
                System.out.println("Usuario no encontrado. Por favor, registra un usuario primero.");
            }
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    private static void mostrarUsuarios() {
        System.out.println("=== Usuarios Registrados ===");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getDni() + ". " + usuario.getNombreCompleto());
        }
    }

    private static Curso encontrarCursoPorId(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.getIdCurso() == idCurso) {
                return curso;
            }
        }
        return null;
    }

    private static Usuario obtenerUsuarioActual() {
        System.out.print("Ingresa tu DNI: ");
        int dniUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dniUsuario) {
                return usuario;
            }
        }
        return null;
    }
}
