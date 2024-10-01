package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact {
    private String name;
    private String surnames;
    private String phone;
    private String code;

    // Constructor
    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(); // Genera el código automáticamente
    }

    // Método para generar el código según las reglas específicas
    private String generateCode() {
        // Convertir los apellidos a minúsculas y dividirlos por espacios
        String[] apellidoParts = this.surnames.toLowerCase().split(" ");

        // Primer apellido
        String primerApellido = apellidoParts[0];
        String segundoApellido = "";

        // Si hay más de un apellido, tomar el segundo apellido completo
        if (apellidoParts.length > 1) {
            segundoApellido = String.join("", apellidoParts).substring(apellidoParts[0].length()).trim(); // Unir el resto de los apellidos
        }

        // Eliminar los diacríticos (acentos)
        String normalizedPrimerApellido = Normalizer.normalize(primerApellido, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        String normalizedSegundoApellido = Normalizer.normalize(segundoApellido, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        // Incluir la primera letra del nombre (en minúsculas)
        String primeraLetraNombre = this.name.toLowerCase().substring(0, 1);

        // Si tiene más de un apellido, el código es la primera letra del nombre + primera letra del primer apellido + segundo apellido completo
        if (!normalizedSegundoApellido.isEmpty()) {
            return (primeraLetraNombre + normalizedPrimerApellido.charAt(0) + normalizedSegundoApellido).replace(" ", "").toLowerCase();
        }

        // Si solo tiene un apellido, devolver la primera letra del nombre + el primer apellido completo
        return (primeraLetraNombre + normalizedPrimerApellido).replace(" ", "").toLowerCase();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    // Métodos de la interfaz ICallActions
    public void callMyNumber() {
        System.out.println(getName()+getSurnames()+getPhone());
    }

    public void callOtherNumber(String number) {
        System.out.println("Llamando desde " + getName() + " " + getSurnames() + " al número: " + number);

    }

    public void showContactDetails() {
        System.out.println("Detalles del contacto:");
        System.out.println("Nombre: " + this.name);
        System.out.println("Apellidos: " + this.surnames);
        System.out.println("Teléfono: " + this.phone);
        System.out.println("Código: " + this.code);
    }
}
