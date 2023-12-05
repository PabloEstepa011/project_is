package gestores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.curso;
import classes.usuario;
import menus.menuCursos;

public class gestorCursos {

    private static final String USUARIOS_FILE = "usuarios.txt";
    private static final String CURSOS_FILE = "cursos.txt";

    private static List<usuario> usuarios;
    private static List<curso> cursos;

    public static void main(String[] args) {
       usuarios = cargarUsuarios();
       cursos = cargarCursos();

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            menuCursos.mostrarMenu();
            opcion=menuCursos.obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner,usuarios);
                    break;
                case 2:
                    mostrarCursosDisponibles(cursos);
                    break;
                case 3:
                    registrarEnCurso(scanner,usuarios,cursos);
                    break;
                case 4:
                    mostrarUsuarios(usuarios);
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }

        } while (opcion != 5);

        guardarUsuarios(usuarios);
        guardarCursos(cursos);

        scanner.close();
    }

    private static void registrarUsuario(Scanner scanner,List<usuario> usuarios) {
        System.out.println("=== Registro de Usuario ===");
        scanner.nextLine();
        System.out.print("DNI: ");
        int dni=0;
        try {
            dni = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido para el DNI.");
            return;
        }
        System.out.print("Nombre Completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Correo Electrónico: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        usuario nuevoUsuario = new usuario(dni, nombreCompleto, correoElectronico, contraseña);
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario registrado exitosamente.");
    }

    private static void mostrarCursosDisponibles(List<curso> cursos) {
        System.out.println("=== Cursos Disponibles ===");
        for (curso curso : cursos) {
            System.out.println(curso.getidCurso() + ". " + curso.getcurso());
        }
    }

    private static void registrarEnCurso(Scanner scanner, List<usuario> usuarios, List<curso> cursos) {
    	System.out.println("=== Registro en Curso ===");
        System.out.println("Ingrese el DNI del usuario que desea inscribir:");
        int dniUsuario = scanner.nextInt();
        usuario usuarioEncontrado = buscarUsuarioPorDni(dniUsuario, usuarios);

        if (usuarioEncontrado == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        mostrarCursosDisponibles(cursos);
        System.out.println("Ingrese el ID del curso al que desea inscribir al usuario:");
        int idCurso = scanner.nextInt();
        curso cursoEncontrado = buscarCursoPorId(idCurso, cursos);

        if (cursoEncontrado == null) {
            System.out.println("Curso no encontrado.");
            return;
        }
        mostrarInformacionCurso(cursos);
        if (usuarioEncontrado.getCursosInscritos().contains(idCurso)) {
            System.out.println("El usuario ya está inscrito en este curso.");
        } else {
        		usuarioEncontrado.inscribirEnCurso(idCurso);
        }
        
        System.out.println("Usuario inscrito exitosamente en el curso.");
    }
    
    private static void mostrarInformacionCurso(List<curso> cursos2) {
    	 if (cursos.isEmpty()) {
    	        System.out.println("No hay cursos disponibles.");
    	    } else {
    	        System.out.println("Información de Cursos:");
    	        for (curso curso : cursos) {
    	            System.out.println("ID: " + curso.getidCurso());
    	            System.out.println("Nombre: " + curso.getcurso());
    	            System.out.println("Fecha de Inicio: " + curso.getfechaInicio());
    	            System.out.println("Fecha de Fin: " + curso.getfechaFin());
    	            System.out.println("DNI ponenete: " + curso.getponente());
    	            System.out.println("Descripción: " + curso.getdescripcion());
    	            System.out.println("--------------");
    	        }
    	    }	
    }

    private static void mostrarUsuarios(List<usuario> usuarios) {
        System.out.println("=== Usuarios Registrados ===");
        for (usuario usuario : usuarios) {
            System.out.println(usuario.getDni() + ". " + usuario.getNombreCompleto());
        }
    }

    private static usuario buscarUsuarioPorDni(int dni, List<usuario> usuarios) {
        for (usuario user : usuarios) {
            if (user.getDni() == dni) {
                return user;
            }
        }
        return null;
    }

    private static curso buscarCursoPorId(int idCurso, List<curso> cursos) {
        for (curso curso : cursos) {
            if (curso.getidCurso() == idCurso) {
                return curso;
            }
        }
        return null;
    }
    
    
    
    private static void guardarUsuarios(List<usuario> usuarios) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USUARIOS_FILE))) {
            for (usuario user : usuarios) {
                writer.println(user.getDni() + "," + user.getNombreCompleto() + "," +
                                user.getCorreoElectronico() + "," + user.getContraseña());
            }
            System.out.println("Datos de usuarios guardados correctamente en " + USUARIOS_FILE);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    private static List<usuario> cargarUsuarios() {
        List<usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int dni = Integer.parseInt(parts[0]);
                String nombreCompleto = parts[1];
                String correo = parts[2];
                String contraseña = parts[3];
                usuarios.add(new usuario(dni, nombreCompleto, correo, contraseña));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private static void guardarCursos(List<curso> cursos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CURSOS_FILE))) {
            for (curso curso : cursos) {
                writer.println(curso.getidCurso() + "," + curso.getcurso());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    private static List<curso> cargarCursos() {
        List<curso> cursos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CURSOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int idCurso = Integer.parseInt(parts[0]);
                String nombreCurso = parts[1];
                String fechaInicioStr = parts[2];
                String fechaFinStr = parts[3];
                String nombreponente = parts[4];
                String descripcion = parts[5];

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaInicio = dateFormat.parse(fechaInicioStr);
                Date fechaFin = dateFormat.parse(fechaFinStr);
                usuario ponente = buscarUsuarioPorNombre(nombreponente, usuarios);

                if (ponente == null) {
                    System.out.println("Error: Ponente no encontrado.");
                    continue;  // Saltar al siguiente ciclo si el ponente no se encuentra
                }
                cursos.add(new curso(idCurso, nombreCurso,fechaInicio,fechaFin,ponente,descripcion));
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            e.printStackTrace();
        }
        return cursos;
    }
    
    private static usuario buscarUsuarioPorNombre(String nombre, List<usuario> usuarios) {
        for (usuario usuario : usuarios) {
            if (usuario.getNombreCompleto().equals(nombre)) {
                return usuario;
            }
        }
        return null; // Devolver null si no se encuentra ningún usuario con ese nombre
    }
   }
