package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaSalida extends VistaRectangulo implements Dibujable {

	public VistaSalida(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaSalida Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaSalida(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GREY);
		this.etiquetar("SALIDA");
	}
}
