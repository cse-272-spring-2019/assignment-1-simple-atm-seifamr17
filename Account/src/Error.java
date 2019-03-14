import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Error {

	private Stage stage;
	private Account account;
	private Numbers numbers;
	private Options options;
	private Scene scene;

	public Error(Stage stage) {
		this.stage = stage;
	}
	
	public void setOptions(Options options) {
		this.options = options;
	}

	public void prepareScene() {
		
		Label error = new Label("Insuffitient Balance!!!");
		Button ok = new Button("OK");
		Label space = new Label("     ");
		
		GridPane grid = new GridPane();
		grid.add(error, 1, 0);
		grid.add(ok, 1, 1);
		grid.add(space, 0, 1);
		
		ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(options.getScene());
			}
		});
		
		scene = new Scene(grid,200,80);
	}

	public Scene getScene() {
		return scene;
	}

}
