package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> contactos = new HashMap<>();
    private Scanner sc = new Scanner(System.in); // Para leer entrada del usuario

    public void mostrarMenu() {
        System.out.println("=== Menú del Listín Telefónico ===\n" +
                "1. Añadir un contacto\n" +
                "2. Mostrar contactos\n" +
                "3. Seleccionar un contacto y mostrar menú de acciones\n" +
                "4. Eliminar un contacto\n" +
                "5. Salir");
    }

    public void addContact(Map<String, Contact> contacts) {
        System.out.println("Dime su nombre:");
        String nombre = sc.nextLine();
        System.out.println("Dime su apellido:");
        String apellidoUno = sc.nextLine();
        System.out.println("Dime su número de teléfono:");
        String tlf = sc.nextLine();

        // Crear el contacto
        Contact newContact = new Contact(nombre, apellidoUno, tlf);

        // Usamos el código generado por el contacto como clave en el mapa
        contacts.put(newContact.getCode(), newContact);
        System.out.println("Contacto añadido con éxito: " + newContact.getName() + " " + newContact.getSurnames() + " (Código: " + newContact.getCode() + ")");
    }

    public void addContact(Contact contact) {
        contactos.put(contact.getCode(), contact);
    }

    public Map<String, Contact> getData() {
        return contactos; // Devuelve el mapa de contactos
    }

    public void showPhonebook() {
        if (!contactos.isEmpty()) {
            for (Map.Entry<String, Contact> entry : contactos.entrySet()) {
                Contact contact = entry.getValue();
                System.out.println("Código: " + entry.getKey());
                System.out.println("Nombre: " + contact.getName());
                System.out.println("Apellidos: " + contact.getSurnames());
                System.out.println("Teléfono: " + contact.getPhone());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No hay contactos disponibles.");
        }
    }

    public void showContacts(Map<String, Contact> contacts) {
        if (!contacts.isEmpty()) {
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                Contact contact = entry.getValue();
                System.out.println("Código: " + entry.getKey());
                System.out.println("Nombre: " + contact.getName());
                System.out.println("Apellidos: " + contact.getSurnames());
                System.out.println("Teléfono: " + contact.getPhone());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No hay contactos disponibles.");
        }
    }

    public void deleteContact(String code) {
        if (contactos.containsKey(code)) {
            contactos.remove(code);
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("No se encontró un contacto con el código: " + code);
        }
    }

    public Map<String, Contact> getContactos() {
        return contactos;
    }

    public void menuAccionContacto(Map<String, Contact> contacts) {
        System.out.println("Introduce el código del contacto para ver acciones:");
        String llave = sc.nextLine();

        if (contacts.containsKey(llave)) {
            Contact contact = contacts.get(llave);
            mostrarMenuAcciones();
            int eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    contact.callMyNumber();
                    break;
                case 2:
                    System.out.println("Introduce el número al que deseas llamar:");
                    String number = sc.nextLine();
                    contact.callOtherNumber(number);
                    break;
                case 3:
                    contact.showContactDetails();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("No se encontró un contacto con el código: " + llave);
        }
    }

    public void mostrarMenuAcciones() {
        System.out.println("=== Menú de Acciones ===\n" +
                "1. Llamar a mi número\n" +
                "2. Llamar a otro número\n" +
                "3. Mostrar detalles del contacto\n" +
                "4. Volver");
    }
}
