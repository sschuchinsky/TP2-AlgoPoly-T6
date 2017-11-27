package vista;

import eventos.BotonMoverHandler;
import eventos.BotonTirarDadosHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;

public class ContenedorPrincipal extends BorderPane {

	private AlgoPoly algoPoly;

	BarraDeMenu menuBar;
	VistaTablero vistaTablero;
	Canvas canvas;
	StackPane paneCentral;
	Label dineroDisponible;
	VBox datosYBotones;
	Stage stage;
	Label turno;

	public ContenedorPrincipal(AlgoPoly algoPoly, Stage stage) {

		this.algoPoly = algoPoly;

		this.setCentro();
		this.setConsola();
		this.setPanelInformativo();
	}

	private void setCentro() {
		paneCentral = new StackPane();
		vistaTablero = new VistaTablero(algoPoly, this, paneCentral);
		vistaTablero.dibujar();

		paneCentral.setAlignment(Pos.TOP_LEFT);
		this.setBorder(algoPoly, paneCentral);
		this.setCenter(paneCentral);
	}

	private void setPanelInformativo() {

		this.datosYBotones = new VBox();
		// datosYBotones.setPadding(new Insets(60));
		datosYBotones.setSpacing(20);

		Image fondo = new Image("file:src/vista/imagenes/fondo.png");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		this.setBackground(new Background(imagenDeFondo));
		this.setBorder(algoPoly, datosYBotones);

		Text titulo = new Text("TURNO DEL JUGADOR: ");
		titulo.setFill(Color.BLACK);
		titulo.setFont(Font.font(30));
		this.datosYBotones.getChildren().add(titulo);
		VBox.setMargin(titulo, new Insets(10));

		this.mostrarJugadorActual(algoPoly.getJugadorActual().getNombre());

		for (Jugador jugador : algoPoly.getJugadores()) {
			Text txtJugador = new Text("Dinero Disponible : $ " + String.valueOf(jugador.getDinero()));
			txtJugador.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			setearColor(txtJugador, jugador);
			datosYBotones.getChildren().add(txtJugador);
			VBox.setMargin(txtJugador, new Insets(15));
		}

		Button btnTirarDados = new Button();
		btnTirarDados.setText("Tirar Dados");
		BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(this.algoPoly, this);
		btnTirarDados.setOnAction(tirarDadosHandler);
		VBox.setMargin(btnTirarDados, new Insets(15));
		this.datosYBotones.getChildren().add(btnTirarDados);

		this.mostrarDados(algoPoly.getDados().getDado1());
		this.mostrarDados(algoPoly.getDados().getDado2());

		Button btnMover = new Button();
		btnMover.setText("Mover Ficha");
		BotonMoverHandler moverHandler = new BotonMoverHandler(this.algoPoly, this);
		btnMover.setOnAction(moverHandler);
		VBox.setMargin(btnMover, new Insets(20));
		this.datosYBotones.getChildren().add(btnMover);

		this.datosYBotones.setAlignment(Pos.CENTER);
		this.setRight(datosYBotones);
	}

	private void mostrarJugadorActual(String nombre) {
		Image image = new Image("file:src/vista/imagenes/ficharoja.png");
		if (nombre == "Verde")
			image = new Image("file:src/vista/imagenes/fichaverde.png");
		if (nombre == "Azul")
			image = new Image("file:src/vista/imagenes/fichaazul.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(50);
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		datosYBotones.getChildren().add(imageView);
	}

	private void mostrarDados(double valor) {
		Image image = new Image("file:src/vista/imagenes/dado1.png");
		if (valor == 2)
			image = new Image("file:src/vista/imagenes/dado2.png");
		if (valor == 3)
			image = new Image("file:src/vista/imagenes/dado3.png");
		if (valor == 4)
			image = new Image("file:src/vista/imagenes/dado4.png");
		if (valor == 5)
			image = new Image("file:src/vista/imagenes/dado5.png");
		if (valor == 6)
			image = new Image("file:src/vista/imagenes/dado6.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(50);
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		datosYBotones.getChildren().add(imageView);

	}

	private void setearColor(Text txt, Jugador jugador) {
		if (jugador.getNombre().equals("Rojo"))
			txt.setFill(Color.RED);
		if (jugador.getNombre().equals("Verde"))
			txt.setFill(Color.GREEN);
		if (jugador.getNombre().equals("Azul"))
			txt.setFill(Color.BLUE);
	}

	private void setBorder(AlgoPoly algoPoly, Pane pane) {
		String color = "BLACK";
		Jugador jugadorActual = algoPoly.getJugadorActual();
		if (jugadorActual.getNombre().equals("Rojo"))
			color = "RED";
		if (jugadorActual.getNombre().equals("Verde"))
			color = "GREEN";
		if (jugadorActual.getNombre().equals("Azul"))
			color = "BLUE";
		pane.setStyle("-fx-padding: 2;" + "-fx-border-style: solid inside;" + "-fx-border-width: 7;"
				+ "-fx-border-insets: 2;" + "-fx-border-radius: 10;" + "-fx-border-color: " + color + ";");
	}

	private void setConsola() {

		// TODO cambiar por el modelo de Consola... Va la consola???
		Label etiqueta = new Label();
		etiqueta.setText("Consola...");
		etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		etiqueta.setTextFill(Color.WHITE);

		VBox contenedorConsola = new VBox(etiqueta);
		contenedorConsola.setSpacing(10);
		contenedorConsola.setPadding(new Insets(15));
		contenedorConsola.setStyle("-fx-background-color: black;");

		this.setBottom(contenedorConsola);
	}

	public void refrescar() {
		this.setCentro();
		this.setConsola();
		this.setPanelInformativo();
	}
}
