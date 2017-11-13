package modelo;

public class Retroceso extends DesplazamientoDinamico{
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}

	public void moverDel2al6(Jugador jugador) {
		Dados dados = Dados.getDados();
		for (int i = 0;i<(dados.getSuma()-jugador.cantPropiedades());i++) {
			this.tablero.retroceder(jugador);
		}
	}
	
	public void moverDel7al10(Jugador jugador) {
		Dados dados = Dados.getDados();
		for (int i = 0;i<(jugador.getDinero())%(dados.getSuma());i++) {
			this.tablero.retroceder(jugador);
		}	
	}

	public void moverDel11al12(Jugador jugador) {
		Dados dados = Dados.getDados();
		for (int i = 0;i<dados.getSuma()-2;i++) {
			this.tablero.retroceder(jugador);
		}
	}

}
