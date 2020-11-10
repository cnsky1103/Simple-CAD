package Stage;

import javafx.scene.control.Button;

public class MyButton extends Button {
    private String name;

    MyButton(String name){
        super();
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
