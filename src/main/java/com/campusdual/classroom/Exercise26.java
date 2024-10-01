package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise26 {

    public static void menu(Phonebook p, Scanner sc) {
        int eleccion = 0;
        do {
            p.mostrarMenu();
            System.out.println("Elige una opción:");
            eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    p.addContact(p.getContactos());
                    break;
                case 2:
                    p.showContacts(p.getContactos());
                    break;
                case 3:
                    p.menuAccionContacto(p.getContactos());
                    break;
                case 4:
                    System.out.println("Introduce el código del contacto a eliminar:");
                    String code = sc.nextLine();
                    p.deleteContact(code);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (eleccion != 5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();
        menu(phonebook, sc);
    }
}
