package tp4.ejercicio6;

/*
 * ============================================================
 * CLASE TURNO
 * ============================================================
 *
 * Atributos:
 *
 * - dniCliente
 * - obraSocial
 * - fueAtendido
 *
 * ============================================================
 */

public class Turno {

    private int dniCliente;

    private String obraSocial;

    private boolean fueAtendido;

    public Turno(
            int dniCliente,
            String obraSocial,
            boolean fueAtendido) {

        this.dniCliente =
                dniCliente;

        this.obraSocial =
                obraSocial;

        this.fueAtendido =
                fueAtendido;
    }

    public int getDniCliente() {

        return dniCliente;
    }

    public String getObraSocial() {

        return obraSocial;
    }

    public boolean getFueAtendido() {

        return fueAtendido;
    }

    public void setFueAtendido(
            boolean fueAtendido) {

        this.fueAtendido =
                fueAtendido;
    }

    @Override
    public String toString() {

        return "DNI: "
                + dniCliente
                + " | Obra Social: "
                + obraSocial
                + " | Atendido: "
                + fueAtendido;
    }
}
