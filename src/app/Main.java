
package app;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    private static DateTimeFormatter formatoFecha;
    private static DateTimeFormatter formatoHora;

    public static void main(String[] args) {
        formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZoneId zonaMadrid = ZoneId.of("Europe/Madrid");
        ZoneId zonaCaracas = ZoneId.of("America/Caracas");

        LocalDate fechaMadrid = fechaActual(zonaMadrid);
        LocalDate fechaCaracas = fechaActual(zonaCaracas);
        int añosDescubrimientoAmerica = descubrimientoAmerica();
        LocalTime horaMadrid = horaActual(zonaMadrid);
        LocalTime horaCaracas = horaActual(zonaCaracas);
        int horasDiferenciaMadridCaracas = horasDiferencia(zonaMadrid, zonaCaracas);
        LocalDateTime pisadaLuna = fechaPisadaLuna();

        System.out.println("Fecha actual en Madrid: " + fechaMadrid.format(formatoFecha) + "\n");
        System.out.println("Fecha actual en Caracas: " + fechaCaracas.format(formatoFecha) + "\n");
        System.out.println("Años desde el descubrimiento de América: " + añosDescubrimientoAmerica + "\n");
        System.out.println("Hora actual en Madrid: " + horaMadrid.format(formatoHora) + "\n");
        System.out.println("Hora actual en Caracas: " + horaCaracas.format(formatoHora) + "\n");
        System.out.println("Horas de diferencia entre Madrid y Caracas: " + horasDiferenciaMadridCaracas + "\n");

        System.out.println("Neil Armstrong pisó la luna el: " + pisadaLuna.toLocalDate().format(formatoFecha)
            + " a las " + pisadaLuna.toLocalTime().format(formatoHora) + "\n");
    }

    public static LocalDate fechaActual(ZoneId zonaHoraria) {
        LocalDate fechaCiudad = LocalDate.now(zonaHoraria);
        return fechaCiudad;
    }

    public static int descubrimientoAmerica() {
        LocalDate descubrimientoAmerica = LocalDate.of(1492, 10, 12);
        int añosTranscurridos = LocalDate.now().getYear() - descubrimientoAmerica.getYear();

        return añosTranscurridos;
    }

    public static LocalTime horaActual(ZoneId zonaHoraria) {
        LocalTime horaCiudad = LocalTime.now(zonaHoraria);
        return horaCiudad;
    }

    public static int horasDiferencia(ZoneId zona1, ZoneId zona2) {
        ZonedDateTime ahora = ZonedDateTime.now();
        int offsetZona1 = zona1.getRules().getOffset(ahora.toInstant()).getTotalSeconds() / 3600;
        int offsetZona2 = zona2.getRules().getOffset(ahora.toInstant()).getTotalSeconds() / 3600;

        int diferencia = offsetZona1 - offsetZona2;

        return diferencia;
    }

    public static LocalDateTime fechaPisadaLuna() {

        LocalDate diaPisadaLuna = LocalDate.of(1969, 7, 21);
        LocalTime horaPisadaLuna = LocalTime.of(3, 56);

        LocalDateTime fechaPisadaLuna = LocalDateTime.of(diaPisadaLuna, horaPisadaLuna);
        return fechaPisadaLuna;
    }

}