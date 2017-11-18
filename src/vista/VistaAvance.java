package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaAvance extends VistaRectangulo implements Dibujable {

	public VistaAvance(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero,canvas,x,y,ancho,alto);
	}

	public static VistaAvance Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		return new VistaAvance(casillero,canvas,x,y,ancho,alto);
	}

	public void dibujar() {
		canvas.getGraphicsContext2D().setFill(Color.GREEN);
		canvas.getGraphicsContext2D().fillRect(x, y, ancho, alto);
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillText("Avance", x + 5, y + alto / 2);
	}
}
