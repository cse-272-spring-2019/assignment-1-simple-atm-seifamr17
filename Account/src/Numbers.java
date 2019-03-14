import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Numbers {

	private Scene scene;
	private Account account;
	private Options options;
	private Error error;
	private boolean success=true;
	private int x;

	public int getX() {
		return x;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	private Stage stage;
	public Numbers(Stage stage) {
		this.stage=stage;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void prepareScene() {
				
		Label display = new Label();
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button zero = new Button("0");
		Button submit = new Button("submit");
		
		GridPane grid = new GridPane();
		grid.add(display, 1, 0, 5, 1);
		grid.add(one, 0, 1);
		grid.add(two, 1, 1);
		grid.add(three, 2, 1);
		grid.add(four, 0, 2);
		grid.add(five, 1, 2);
		grid.add(six, 2, 2);
		grid.add(seven, 0, 3);
		grid.add(eight, 1, 3);
		grid.add(nine, 2, 3);
		grid.add(zero, 1, 4);
		grid.add(submit, 2, 4);
		
		zero.setMinWidth(100);
		one.setMinWidth(100);
		two.setMinWidth(100);
		three.setMinWidth(100);
		four.setMinWidth(100);
		five.setMinWidth(100);
		six.setMinWidth(100);
		seven.setMinWidth(100);
		eight.setMinWidth(100);
		nine.setMinWidth(100);
		submit.setMinWidth(100);
		
		one.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"1");
			}
		});
		
		two.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"2");
			}
		});
		
		three.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent arg0) {
			    display.setText(display.getText()+"3");
			}
		});
		
		four.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"4");
			}
		});
		
		five.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"5");
			}
		});
		
		six.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"6");
			}
		});
		
		seven.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"7");
			}
		});
		
		eight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"8");
			}
		});
		
		nine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"9");
			}
		});
		
		zero.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				display.setText(display.getText()+"0");
			}
		});
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(account.getOperation()==1) {
					x=Integer.parseInt(display.getText());
					if(x>account.getBalance()) {
						success = false;
					}
					else {
					    account.Withdraw(x);
					    success = true;
					}
				}
				else if(account.getOperation()==2) {
					x=Integer.parseInt(display.getText());
					account.Deposit(x);
				}
				display.setText("");
				if(success==true)
				    stage.setScene(options.getScene());
				else {
					stage.setScene(error.getScene());
					success=true;
				}
				String[] a=account.getHistory();
				byte b=account.getY();
				if(b==-1&&account.getCount()==-1) 
					options.display.setText(a[0]);
				else if(b==-1) 
					options.display.setText(a[account.getCount()]);
				else if(b==5)
					options.display.setText(a[4]);
				else
				    options.display.setText(a[b]);
			}
		});
		
		
		scene = new Scene(grid,310,150);
		
		
		
	}

	public Scene getScene() {
		return this.scene;
	}



}
