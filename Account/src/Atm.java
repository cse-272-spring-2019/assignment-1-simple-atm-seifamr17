import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Atm extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		
		Account account = new Account();

		Validate validate = new Validate(primaryStage);
		validate.prepareScene();
		
		Options options = new Options(primaryStage);
		options.prepareScene();
		
		validate.setOptions(options);
		
		Numbers  numbers = new Numbers(primaryStage);
		numbers.prepareScene();
		
		validate.setAccount(account);
		options.setAccount(account);
		numbers.setAccount(account);
		
		options.setNumbers(numbers);
		numbers.setOptions(options);
		
		Error error = new Error(primaryStage);
		error.prepareScene();
		
		numbers.setError(error);
		error.setOptions(options);
		
		
		primaryStage.setScene(validate.getScene());
		primaryStage.show();
		
	}

	

}
