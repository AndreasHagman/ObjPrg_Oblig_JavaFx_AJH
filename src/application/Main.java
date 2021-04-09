package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	private Stage vindu;
	//Menybar
	private MenuBar menylinje = new MenuBar();
	//Menyelementer
	private Menu filmeny = new Menu("Fil");
	private Menu redigermeny = new Menu("Rediger");
	//Menyelementer til Filmenydropdown
	private MenuItem noe1 = new MenuItem("noe1");
	private MenuItem noe2 = new MenuItem("noe2");
	private MenuItem avslutt = new MenuItem("Avslutt");
	//Menyelementer til Redigermenydropdown
	private MenuItem kunde = new MenuItem("Kunde");
	private MenuItem vare = new MenuItem("Vare");
	private MenuItem r3 = new MenuItem("noe3");
	private Scene scene_meny, scene2;
	BorderPane rotpanel1 = new BorderPane();
	BorderPane rotpanel2 = new BorderPane();
	private TableView tabell;
	private ObservableList<Kunde> data = FXCollections.observableArrayList(new Firmakunde("Andreas","12345678","1111", "123"));
	private TextField nyttnavn, nytelefon, nykredittgrense;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			vindu = primaryStage;
			vindu.setTitle("Applikasjon");
			vindu.setWidth(500);
			vindu.setHeight(400);
			lagscene_meny();
			vindu.setScene(scene_meny);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void lagscene_meny() {
		scene_meny = new Scene(rotpanel1, 400, 300);
		//Legger til menyelementer til filmenyen
		filmeny.getItems().addAll(noe1,noe2,avslutt);
		//Legger ønskede menyelementer til redigermenyen
		redigermeny.getItems().addAll(kunde,vare,r3);
		//Legger hovedmenyelementene inn i menylinjen
		menylinje.getMenus().addAll(filmeny, redigermeny);
		noe1.setOnAction(e -> behandleNoe1(e));
		avslutt.setOnAction(e -> behandleAvslutt());
		//Lager kundescenen før den blir kalt på
		lagkundescene();
		kunde.setOnAction(e -> vindu.setScene(scene2));
		rotpanel1.setTop(menylinje);
		scene_meny.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		vindu.setScene(scene_meny);
		vindu.show();
		
	}
	
	public void behandleNoe1(ActionEvent e) {
		System.out.println("hore");
	}
	
	public void lagkundescene() {
	scene2 = new Scene(rotpanel2,400,300);
	tabell = new TableView();
	//Oppretter 4 kolonner med overskrifter -> refererer til Firmakundeklassen
	TableColumn colNavn = new TableColumn("Navn:");
	colNavn.setMinWidth(100);
	colNavn.setCellValueFactory(new PropertyValueFactory<Kunde, String>("navn"));
	TableColumn colKundenr = new TableColumn("Kundenummer:");
	colKundenr.setMinWidth(100);
	colKundenr.setCellValueFactory(new PropertyValueFactory<Kunde, String>("kundenr"));
	TableColumn colTlfnr = new TableColumn("Telefonnummer:");
	colTlfnr.setMinWidth(100);
	colTlfnr.setCellValueFactory(new PropertyValueFactory<Kunde, String>("tlfnr"));
	TableColumn colKredittgrense = new TableColumn("Kredittgrense:");
	colKredittgrense.setMinWidth(100);
	colKredittgrense.setCellValueFactory(new PropertyValueFactory<Kunde, String>("kredittgrense"));
	//Lager et flowpane til registreringsfelter
	FlowPane registreringspanel = new FlowPane();
	//Lager 4 TextField-objekter:
	nyttnavn = new TextField();
	nyttnavn.setPromptText("Navn:");
	nyttnavn.setMinWidth(100);
	nytelefon = new TextField();
	nytelefon.setPromptText("Telefon:");
	nytelefon.setMinWidth(100);
	nykredittgrense = new TextField();
	nykredittgrense.setPromptText("Kredittgrense:");
	nykredittgrense.setMinWidth(100);
	//Lager knapper
	Button nyFirmakunde = new Button("Legg till");
	nyFirmakunde.setOnAction(e -> behandleNyFirmakunde());
	Button tilbake = new Button("Tilbake");
	tilbake.setOnAction(e -> behandleTilbake());
	
	//Plasserer tabellen i rotpanelet
	tabell.getColumns().addAll(colNavn, colKundenr, colTlfnr, colKredittgrense);
	tabell.setItems(data);
	rotpanel2.setCenter(tabell);
	//Plasserer registreringspanelet i rotpanelet
	registreringspanel.getChildren().addAll(nyttnavn, nytelefon, nykredittgrense,nyFirmakunde, tilbake);
	rotpanel2.setBottom(registreringspanel);
	vindu.setScene(scene2);
	
	}
	//Lytter til knapp for å legge til firmakunde:
	public void behandleNyFirmakunde() {
		//Legger et nytt Person-objekt til ObservableList'en data:
		data.add(new Firmakunde(nyttnavn.getText(),"1", nykredittgrense.getText(), nytelefon.getText()));
		
	}
	
	public void behandleAvslutt() {
		System.exit(0);
	}
	public void behandleTilbake() {
		vindu.setScene(scene_meny);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
