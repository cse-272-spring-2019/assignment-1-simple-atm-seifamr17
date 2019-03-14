import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Options {
	
	private Account account;
	private Scene scene;
	private Stage stage;
	private Numbers numbers;
	public Label display = new Label();
	
	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}

	public Options(Stage stage) {
		this.stage=stage;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public void prepareScene() {
		
		Button withdraw = new Button("Withdraw");
		Button deposit = new Button("Deposit");
		Button balance = new Button("Balance inquiry");
		Button prev = new Button("previous");
		Button next = new Button("next");
		
		GridPane grid = new GridPane();
		grid.add(display, 1, 0, 5, 1);
		grid.add(withdraw, 0, 1);
		grid.add(deposit, 2, 1);
		grid.add(balance, 1, 2);
		grid.add(prev, 0, 3);
		grid.add(next, 2, 3);
		
		next.setMinWidth(100);
		prev.setMinWidth(100);
		withdraw.setMinWidth(100);
		deposit.setMinWidth(100);
		balance.setMinWidth(100);		
		
		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				account.setOperation(1);
				stage.setScene(numbers.getScene());
			}
		});
		
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				account.setOperation(2);
				stage.setScene(numbers.getScene());
			}
		});
		
		next.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(account.next());
			}
		});
		
		prev.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(account.prev());
			}
		});
		
		balance.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				account.balanceinquiry();
				display.setText("Current Balance: "+Integer.toString(account.getBalance()));
			}
		});
		

		
		scene = new Scene(grid,350,150);

		
	}

	public Scene getScene() {
		return this.scene;
	}

}
