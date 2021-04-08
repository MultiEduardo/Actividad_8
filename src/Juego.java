import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Dealer dealer = new Dealer(new Baraja());

    public Juego() {
        this.dealer.mezclarBaraja((byte)15);
        this.jugadores = new ArrayList();
        System.out.println("Se mezcló el Deck.");
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void repartirCartas(byte numeroCartas) {
        Iterator var2 = this.jugadores.iterator();

        while(var2.hasNext()) {
            Jugador jugador = (Jugador)var2.next();

            for(byte i = 0; i < numeroCartas; i++) {
                jugador.adicionarCarta(this.dealer.entregarCarta());
            }
        }

    }

    public String mostrarBaraja() {
        return this.dealer.mostrarBaraja();
    }

    public int getNumeroCartasDealer() {
        return this.dealer.getNumeroCartas();
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        System.out.println("Barajas Inicial de : " + juego.getNumeroCartasDealer() + " cartas.");
        juego.addJugador(new Jugador("Jugador 1"));
        juego.addJugador(new Jugador("Jugador 2"));
        juego.addJugador(new Jugador("Jugador 3"));
        juego.addJugador(new Jugador("Jugador 4"));
        juego.addJugador(new Jugador("Jugador 5"));
        juego.addJugador(new Jugador("Jugador 6"));
        juego.repartirCartas((byte)7);
        System.out.println("\n----- Cartas por Jugador ------\n");
        Iterator var2 = juego.getJugadores().iterator();

        while(var2.hasNext()) {
            Jugador j = (Jugador)var2.next();
            System.out.println(j.toString());
        }

        System.out.println("\n");
        System.out.println("Queda: " + juego.getNumeroCartasDealer() + " cartas.");
        System.out.println(juego.mostrarBaraja());
    }
}
