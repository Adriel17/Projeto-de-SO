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
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
 * @Adriel
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
        grade.add(imageView,2,0,2,2);
        grade.add(btn,3,0,1,1);
        
        
        btn.setOnAction(e -> {
                    File selectedFile = dir.showOpenDialog(stage1);
        
        });
              //btn.setAlignment(Pos.CENTER_RIGHT);      
                    
                    
        /*HBox hbox = new HBox();
            hbox.getChildren().add(imageView);
            
            hbox.getChildren().add(btn);
            hbox.setAlignment(Pos.CENTER_RIGHT);
                btn.setOnAction(e -> {
                    File selectedFile = dir.showOpenDialog(stage1);
                */
//******************************************************************************
        MenuBar barra = new MenuBar();
        
        Menu menu1 = new Menu("Ações");
        MenuItem item1 = new MenuItem("Sair");
        item1.setOnAction(e ->{
            System.exit(0);
        });
        menu1.getItems().add(item1);
        
        Menu menu2 = new Menu("Exibir");
        Menu menu3 = new Menu("Configurações");
        barra.getMenus().add(menu1);
        barra.getMenus().add(menu2);
        barra.getMenus().add(menu3);
        
//******************************************************************************        
        
        TableView tabela = new TableView();
        
        TableColumn<String, Bind> coluna1 = new TableColumn<>("Tecla");
        coluna1.setCellValueFactory(new PropertyValueFactory<>("tecla"));
        coluna1.setMinWidth(50);
        coluna1.setStyle("-fx-alignment: CENTER");
        
        TableColumn<String, Bind> coluna2 = new TableColumn<>("Programa");
        coluna2.setCellValueFactory(new PropertyValueFactory<>("programa"));
        coluna2.setMinWidth(150);
        coluna2.setStyle("-fx-alignment: CENTER");
        
        TableColumn<String, Bind> coluna3 = new TableColumn<>("Diretório");
        coluna3.setCellValueFactory(new PropertyValueFactory<>("dir"));
        coluna3.setMinWidth(300); 
        coluna3.setStyle("-fx-alignment: CENTER");
        
        tabela.getColumns().add(coluna1);
        tabela.getColumns().add(coluna2);
        tabela.getColumns().add(coluna3);
        tabela.getItems().add(new Bind("A", "Chrome","C:////Users////Chrome.exe"));
        tabela.getItems().add(new Bind("B", "Opera","C:////Users////Opera.exe"));

//******************************************************************************        
        
        VBox vbox = new VBox(barra,tabela,grade);
        
        Scene scene = new Scene(vbox, 800, 400);
        stage1.setResizable(false);
        stage1.setTitle("Bind");
        stage1.setScene(scene);
        stage1.show();
        
        };

    public static void main(String[] args) {
        launch(args);
    }
    
}
