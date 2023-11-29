package bbdd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import classes.curso;
import classes.usuario;

public class FileHandler {

    private static final String USUARIOS_FILE = "usuarios.txt";
    private static final String CURSOS_FILE = "cursos.txt";

    public static void guardarUsuario(usuario usuario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USUARIOS_FILE, true))) {
            oos.writeObject(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarCurso(curso curso) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CURSOS_FILE, true))) {
            oos.writeObject(curso);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<usuario> cargarUsuarios() {
        List<usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USUARIOS_FILE))) {
            while (true) {
                Object obj = ois.readObject();
                if (obj instanceof usuario) {
                    usuarios.add((usuario) obj);
                }
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static List<curso> cargarCursos() {
        List<curso> cursos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CURSOS_FILE))) {
            while (true) {
                Object obj = ois.readObject();
                if (obj instanceof curso) {
                    cursos.add((curso) obj);
                }
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cursos;
    }
}