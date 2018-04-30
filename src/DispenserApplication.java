/*
 * Program: CST-135-Homework
 * File: DispenserApplication.java
 * Summary:
 * Author: Chase Hausman
 * Date: April 29, 2018
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DispenserApplication extends Application {
	private Button goBack;
	private GridPane itemGrid;
	private Cart cart;
	private Button doneButton;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create a new cart
		cart = new Cart();

		// Create and define a grid, per Milestone 4 Directions
		GridPane mainGrid = new GridPane();

		// Create buttons for each category, assign them to a 2x2grid
		Button drinkButton = new Button("Drinks", new ImageView("resources/coke-logo.png"));
		drinkButton.setPrefHeight(200);
		drinkButton.setPrefWidth(200);
		GridPane.setConstraints(drinkButton, 0, 0);

		Button chipsButton = new Button("Chips", new ImageView("resources/lays-logo.png"));
		chipsButton.setPrefHeight(200);
		chipsButton.setPrefWidth(200);
		GridPane.setConstraints(chipsButton, 1, 0);

		Button candyButton = new Button("Candy", new ImageView("resources/mms-logo.png"));
		candyButton.setPrefWidth(200);
		candyButton.setPrefHeight(200);
		GridPane.setConstraints(candyButton, 0, 1);

		Button gumButton = new Button("Gum", new ImageView("resources/wrigley-logo.png"));
		gumButton.setPrefHeight(200);
		gumButton.setPrefWidth(200);
		GridPane.setConstraints(gumButton, 1, 1);

		mainGrid.getChildren().addAll(drinkButton, chipsButton, candyButton, gumButton);

		Pane container = new VBox();
		container.setPrefWidth(400);
		container.setPrefHeight(500);

		// Create a header with a Done button
		Pane header = new HBox();

		this.doneButton = new Button("Done");
		this.doneButton.setPrefHeight(75);
		this.doneButton.setPrefWidth(400);
		this.doneButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayDonePane();
			}
		});
		header.getChildren().add(doneButton);

		container.getChildren().add(header);
		container.getChildren().add(mainGrid);

		// Create button to go back
		this.goBack = new Button("Back");
		goBack.setPrefWidth(200);
		goBack.setPrefHeight(200);
		goBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				switchGrid(container, itemGrid, mainGrid);
			}
		});

		drinkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				itemGrid = createProductGrid(createSampleDrinkInventory());
				switchGrid(container, mainGrid, itemGrid);
			}
		});

		chipsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				itemGrid = createProductGrid(createSampleChipsInventory());
				switchGrid(container, mainGrid, itemGrid);
			}
		});

		candyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				itemGrid = createProductGrid(createSampleCandyInventory());
				switchGrid(container, mainGrid, itemGrid);
			}
		});

		gumButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				itemGrid = createProductGrid(createSampleGumInventory());
				switchGrid(container, mainGrid, itemGrid);
			}
		});

		Scene mainScene = new Scene(container);
		primaryStage.setTitle("\"Bug Smashers\" Vending");
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void switchGrid(Pane container, GridPane removeGrid, GridPane addGrid) {
		container.getChildren().remove(removeGrid);
		container.getChildren().add(addGrid);
	}

	private GridPane createProductGrid(Product[] products) {
		GridPane productsGrid = new GridPane();

		Button[] buttons = new Button[products.length + 1];

		buttons[0] = this.goBack;

		// Loop through products, adding them to rows/columns in a grid
		int column = 1;
		int row = 0;
		for (int i = 0; i < products.length; i++) {
			Product temp = products[i];
			buttons[i + 1] = new Button(products[i].getName()+"\n$"+products[i].getPrice());
			buttons[i + 1].setPrefWidth(200);
			buttons[i + 1].setPrefHeight(200);
			buttons[i + 1].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					cart.addItemToCart(temp);
					doneButton.setText("Done ("+cart.getNumberOfItems()+": $"+cart.getTotal()+")");
				}
			});
			GridPane.setConstraints(buttons[i + 1], column, row);

			if(column == 0) {
				column++;
			} else {
				column = 0;
				row++;
			}
		}

		productsGrid.getChildren().addAll(buttons);

		return productsGrid;
	}

	private void displayDonePane() {
		 Pane itemList = new VBox();

		 ObservableList<Product> itemObservableList = FXCollections.observableArrayList(cart.getItems());

		TableView<Product> items = new TableView<>(itemObservableList);
		items.setPrefWidth(300);
		items.setPrefHeight(600);

		TableColumn itemName = new TableColumn("Item");
		itemName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

		TableColumn itemPrice = new TableColumn("Price");
		itemPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));

		items.getColumns().addAll(itemName, itemPrice);

		itemList.getChildren().add(items);

		Text total = new Text("Total: $"+cart.getTotal());
		total.setFont(new Font(18));

		itemList.getChildren().add(total);

		Scene itemScene = new Scene(itemList);
		Stage cartPopup = new Stage();
		cartPopup.setTitle("Your Cart");
		cartPopup.setScene(itemScene);
		cartPopup.setResizable(false);
		cartPopup.show();
	}

	private Product[] createSampleDrinkInventory() {
		Product[] drinks = new Product[4];

		drinks[0] = new Drink();
		drinks[0].setName("Coke");
		drinks[0].setPrice(1.50);

		drinks[1] = new Drink();
		drinks[1].setName("Diet Coke");
		drinks[1].setPrice(1.50);

		drinks[2] = new Drink();
		drinks[2].setName("Sprite");
		drinks[2].setPrice(1.50);

		drinks[3] = new Drink();
		drinks[3].setName("Barques");
		drinks[3].setPrice(1.50);

		return drinks;
	}

	private Product[] createSampleChipsInventory() {
		Product[] chips = new Chips[4];

		chips[0] = new Chips();
		chips[0].setName("Original");
		chips[0].setPrice(1);

		chips[1] = new Chips();
		chips[1].setName("Salt and Vinegar");
		chips[1].setPrice(1);

		chips[2] = new Chips();
		chips[2].setName("BBQ");
		chips[2].setPrice(1);

		chips[3] = new Chips();
		chips[3].setName("Sun Chips");
		chips[3].setPrice(1.50);

		return chips;
	}

	private Product[] createSampleCandyInventory() {
		Product[] candies = new Candy[4];

		candies[0] = new Candy();
		candies[0].setName("M&Ms");
		candies[0].setPrice(.75);

		candies[1] = new Candy();
		candies[1].setName("Skittles");
		candies[1].setPrice(.75);

		candies[2] = new Candy();
		candies[2].setName("Hersheys");
		candies[2].setPrice(.75);

		candies[3] = new Candy();
		candies[3].setName("Gummy Bears");
		candies[3].setPrice(.75);

		return candies;
	}

	private Product[] createSampleGumInventory() {
		Product[] gums = new Gum[4];

		gums[0] = new Gum();
		gums[0].setName("Mint");
		gums[0].setPrice(.50);

		gums[1] = new Gum();
		gums[1].setName("Spearmint");
		gums[1].setPrice(.50);

		gums[2] = new Gum();
		gums[2].setName("Bubble Gum");
		gums[2].setPrice(.50);

		gums[3] = new Gum();
		gums[3].setName("Sugar Free");
		gums[3].setPrice(.50);

		return gums;
	}
}
