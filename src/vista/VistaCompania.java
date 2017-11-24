package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaCompania Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaCompania(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		if (this.getCasillero().getNombre() == "AYSA") {
			this.pintar(Color.GAINSBORO);
			this.ponerImagen("file:src/vista/imagenes/aysa.png");
		}
		if (this.getCasillero().getNombre() == "EDESUR") {
			this.pintar(Color.GAINSBORO);
			this.ponerImagen("file:src/vista/imagenes/edesur.png");
		}
		if (this.getCasillero().getNombre() == "TREN") {
			this.pintar(Color.GAINSBORO);
			this.ponerImagen("file:src/vista/imagenes/tren.png");
			this.etiquetar("TRENES", Color.WHITE);
		}
		if (this.getCasillero().getNombre() == "SUBTE") {
			this.pintar(Color.GAINSBORO);
			this.ponerImagen("file:src/vista/imagenes/subte.png");
			this.etiquetar("SUBTE", Color.BLACK);
		}
	}
}