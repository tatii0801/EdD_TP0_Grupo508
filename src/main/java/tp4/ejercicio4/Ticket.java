package tp4.ejercicio4;

public class Ticket {

    private int idTicket;
    private String departamento;
    private int nivelUrgencia;

    public Ticket(int idTicket, String departamento, int nivelUrgencia) {
        this.idTicket = idTicket;
        this.departamento = departamento;
        this.nivelUrgencia = nivelUrgencia;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + idTicket + " | Área: " + departamento + " | Urgencia: " + nivelUrgencia;
    }
}
