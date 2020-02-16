/*                      LINK DO TUTORIAL
 *          http://tutorials.jenkov.com/javafx/index.html
 */
package aaa;

//import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage1) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("B.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
                
        Button btn = new Button("Select File");
        FileChooser dir = new FileChooser ();
        GridPane grade = new GridPane();
        grade.add(imageView,0,5,50,50);
        grade.add(btn,9,0,25,10);
        grade.maxHeight(50);
        HBox hbox = new HBox();
            hbox.getChildren().add(imageView);
            
            hbox.getChildren().add(btn);
            hbox.setAlignment(Pos.CENTER_RIGHT);
                btn.setOnAction(e -> {
                    File selectedFile = dir.showOpenDialog(stage1);
                });
//******************************************************************************
        MenuBar barra = new MenuBar();
        Menu menu1 = new Menu("Ações");
        Menu menu2 = new Menu("Exibir");
        Menu menu3 = new Menu("Configurações");
        barra.getMenus().add(menu1);
        barra.getMenus().add(menu2);
        barra.getMenus().add(menu3);
        
        
        
        TableView tabela = new TableView();

        TableColumn<String, Person> coluna1 = new TableColumn<>("Tecla");
        coluna1.setCellValueFactory(new PropertyValueFactory<>("tecla"));
        
        TableColumn<String, Person> coluna2 = new TableColumn<>("Programa");
        coluna2.setCellValueFactory(new PropertyValueFactory<>("Programa"));

        TableColumn<String, Person> coluna3 = new TableColumn<>("Diretório");
        coluna2.setCellValueFactory(new PropertyValueFactory<>("diretório"));
        
        tabela.getColumns().add(coluna1);
        tabela.getColumns().add(coluna2);
        tabela.getColumns().add(coluna3);

        tabela.getItems().add(new Person("John", "Doe"));
        tabela.getItems().add(new Person("Jane", "Deer"));
        
        
        VBox vbox = new VBox();
        vbox.getChildren().add(barra);
        vbox.getChildren().add(tabela);
        vbox.getChildren().add(grade);
        
        Scene scene = new Scene(vbox, 800, 400);
        stage1.setResizable(true);
        stage1.setTitle("Bind");
        stage1.setScene(scene);
        stage1.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
