import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Validate {

	private Account account;
	private Options options;
	private Scene scene;
	private Stage stage;
	
	public Validate(Stage stage) {
		this.stage=stage;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public void prepareScene() {
				
		Label cardnumberLabel = new Label("Enter card number: ");
		TextField cardnumberField = new TextField();
		Button submit = new Button("submit");
		Label validationLabel = new Label();
		
		GridPane grid = new GridPane();
		grid.add(cardnumberLabel, 0, 0);
		grid.add(cardnumberField, 1, 0);
		grid.add(submit, 1, 1);
		grid.add(validationLabel, 2, 0);
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String cardnumber=cardnumberField.getText();
				if(account.valid(cardnumber)) {
					stage.setScene(options.getScene());
				}
				else {
					validationLabel.setText("Invalid card number!!!");
				}				
			}
		});
		
		scene = new Scene(grid,500,100);
		
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Scene getScene() {
		return this.scene;
	}

	

}
