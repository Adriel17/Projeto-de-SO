/*                      LINK DO TUTORIAL
 *          http://tutorials.jenkov.com/javafx/index.html
 */
package aaa;

//import java.awt.Image;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
        imageView.setId("imagem");
                
        Text tpane = new Text();
        String t1 = "+";
        tpane.setText(t1);
        tpane.setId("tpane");
        
        
        
        //botão de arquivos
        Button file = new Button("Select File");
        file.setId("file");
        
        //botão das teclas
        Button tecla = new Button("Selecione a tecla");
        tecla.setId("tecla");
        //Função da tecla
        FileChooser dir = new FileChooser ();
        file.setOnAction(e -> {
            File selectedFile = dir.showOpenDialog(stage1);
        });

/******************************************************************************/
                    
    HBox hbox = new HBox();
    hbox.setId("hbox");
    hbox.getChildren().add(imageView);
    hbox.getChildren().add(tecla);
    hbox.getChildren().add(tpane);
    hbox.getChildren().add(file);
        
    tecla.setTranslateX(630.0);
    tecla.setTranslateY(12);
    file.setTranslateX(380);
    file.setTranslateY(12);
    tpane.setTranslateX(487);
    tpane.setTranslateY(-4);
    
/*******************************************************************************
//                              STACK PANE
//          https://www.tutorialspoint.com/javafx/javafx_text.htm
       
 /*      
        
        
        Pane pilha = new StackPane();
        
        
        pilha.getChildren().add(imageView);
        pilha.getChildren().add(tpane);
        pilha.getChildren().add(file);
        
        pilha.setAlignment(file,Pos.CENTER_RIGHT);
        pilha.setAlignment(imageView,Pos.CENTER_LEFT);
        
        file.setOnAction(e -> {
                    File selectedFile = dir.showOpenDialog(stage1);
        });

*/
//*****************************************************************************/
/*
Pane painel = new Pane();
painel.setMinHeight(50);
painel.setMinWidth(800);

painel.getChildren().add(imageView);
painel.getChildren().add(tecla);
painel.getChildren().add(tpane);
painel.getChildren().add(file);

painel.setMinHeight(50.0);

file.setMinWidth(75);
//posição file
file.setLayoutX(600.0);
file.setLayoutY(12.0);

//posição tecla
file.setTranslateX(700.0);
file.setTranslateX(12.0);
/*
//posição texto
tpane.setLayoutX(100.0);
tpane.setLayoutY(25.0);

//posição imagem        
imageView.setLayoutX(0.0);
imageView.setLayoutY(0.0);

*/

//******************************************************************************
        MenuBar barra = new MenuBar();
        barra.setId("barra");
        Menu menu1 = new Menu("Ações");
        MenuItem item1 = new MenuItem("Sair");
        item1.setOnAction(ee ->{
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
        coluna1.setId("tabela1");
        
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
        
        VBox vbox = new VBox(barra,tabela,hbox);
        
        Scene scene = new Scene(vbox, 800, 400);
        scene.getStylesheets().add(Main.class.getResource("estilos.css").toString());
        stage1.setResizable(true);
        stage1.setTitle("Bind");
        stage1.setScene(scene);
        
        stage1.show();
         
        };

    public static void main(String[] args) {
        launch(args);
        
    }
    
}
