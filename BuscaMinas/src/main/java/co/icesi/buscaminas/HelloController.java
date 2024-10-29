package co.icesi.buscaminas;

import co.icesi.buscaminas.model.BoardGame;
import co.icesi.buscaminas.model.Cell;
import co.icesi.buscaminas.model.Clock;
import co.icesi.buscaminas.model.ClockObserver;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, ClockObserver {
    public static final String flagStyle ="-fx-background-color: red;";
    BoardGame game = new BoardGame();
    Clock clock;

    boolean gameEnd;

    int minesDetected;

    @FXML
    private GridPane girid;
    @FXML
    private Label mines;
    @FXML
    private Label lblClock;
    @FXML
    void  handleRightEvent(ContextMenuEvent event) {
        Button source = (Button) event.getSource();
        String style = source.getStyle();
        if(!style.contains(flagStyle)){
            source.setStyle(flagStyle);
            minesDetected--;
        }else{
            source.setStyle("");
            minesDetected++;
        }
        mines.setText(minesDetected+"");


    }

    @FXML
    void handleEvent(ActionEvent event) {
        Button source = (Button) event.getSource();
        if(source.getStyle().contains(flagStyle)||gameEnd){
            return;
        }
        Integer row = GridPane.getRowIndex(source);
        Integer col = GridPane.getColumnIndex(source);
        row = row==null?0:row;
        col = col==null?0:col;
        System.out.println(row+" "+col);

        try {
            boolean b=game.selectCell(row,col);
            if(b){
                showMessage("Congratulations");
            }


        }catch (RuntimeException e){
            showMessage(e.getMessage());
            game.showAll(true);
            gameEnd = true;
        }finally {
            updateMatrix();
            game.printBoard();
        }

    }
    private void showMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setContentText(message);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //girid.add(new Button(""),0,0);
        newGame();
    }

    public void setClock(Clock clock) {
        this.clock = clock;
        clock.registerObserver(this);
    }

    @FXML
    void startGame(ActionEvent event) {
        newGame();
    }
    private void newGame(){
        gameEnd = false;
        minesDetected = game.initGame(8,8,10);
        mines.setText(minesDetected+"");
        for (Node node: girid.getChildren()) {
         node.setStyle("");
        }
        updateMatrix();
    }

    private void updateMatrix(){
        Cell[][] cells = game.getBoard();
        int a=0;
        for (Node node: girid.getChildren()){
            if(node instanceof Button){
                Button b = (Button)node;
                int i = a/8;
                int j = a%8;
                String value = cells[i][j].toString();
                if (value.trim().equals(".") || value.trim().equals("0")){
                    value = "";
                }
                b.setDisable(!cells[i][j].isHide() || gameEnd);
                if(value.contains("*")){
                    value = "*";
                    b.setStyle(flagStyle);
                }
                b.setText(value);
                a++;
            }
        }
    }

    public void updateClock(short minutes, short seconds){
        Platform.runLater(()->{
            lblClock.setText(minutes+":"+seconds);
        });

    }
}
