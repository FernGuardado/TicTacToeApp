package io.fernandoguardado.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    public Button buttons[][] = new Button[3][3];
    public TextView txtTurns;
    public Button btnNew_Game;
    public int countButtons = 0;

    // Setting the player turn to X
    private boolean playerXTurn = true;

    //Dark theme
    Switch d_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {

                // Getting each button with indexs
                String btn = "button" + i + y;
                // Getting the resource id name
                int rsId = getResources().getIdentifier(btn, "id", getPackageName());
                buttons[i][y] = findViewById(rsId);
                buttons[i][y].setBackgroundResource(android.R.drawable.btn_default);
                buttons[i][y].setOnClickListener(this);
            }
        }

        txtTurns = findViewById(R.id.txtTurns);
        btnNew_Game = findViewById(R.id.btnNewGame);
        btnNew_Game.setBackgroundResource(android.R.drawable.btn_default);
        btnNew_Game.setOnClickListener(this);

        // Getting a dark theme
        d_switch = findViewById(R.id.swDarkTheme);
        d_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }

    // Check turn method
    public void CheckTurn(View view){
        if (playerXTurn)
        {
            ((Button) view).setText("X");
            txtTurns.setText("O's Turn");
            playerXTurn = false;
        }
        else
        {
            ((Button) view).setText("O");
            txtTurns.setText("X's Turn");
            playerXTurn = true;
        }

    }

    // Check for winner or a draw
    public boolean CheckWinner(){

        // Horizontal
        if(buttons[0][0].getText().toString().equals("X") &&
                buttons[0][1].getText().toString().equals("X") &&
                buttons[0][2].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[1][0].getText().toString().equals("X") &&
                buttons[1][1].getText().toString().equals("X") &&
                buttons[1][2].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[2][0].getText().toString().equals("X") &&
                buttons[2][1].getText().toString().equals("X") &&
                buttons[2][2].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[0][0].getText().toString().equals("O") &&
                buttons[0][1].getText().toString().equals("O") &&
                buttons[0][2].getText().toString().equals("O")){


            txtTurns.setText("O Wins!");
            return true;
        }
        else if (buttons[1][0].getText().toString().equals("O") &&
                buttons[1][1].getText().toString().equals("O") &&
                buttons[1][2].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        else if (buttons[2][0].getText().toString().equals("O") &&
                buttons[2][1].getText().toString().equals("O") &&
                buttons[2][2].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        // Vertical
        else if (buttons[0][0].getText().toString().equals("X") &&
                buttons[1][0].getText().toString().equals("X") &&
                buttons[2][0].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[0][1].getText().toString().equals("X") &&
                buttons[1][1].getText().toString().equals("X") &&
                buttons[2][1].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[0][2].getText().toString().equals("X") &&
                buttons[1][2].getText().toString().equals("X") &&
                buttons[2][2].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[0][0].getText().toString().equals("O") &&
                buttons[1][0].getText().toString().equals("O") &&
                buttons[2][0].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        else if (buttons[0][1].getText().toString().equals("O") &&
                buttons[1][1].getText().toString().equals("O") &&
                buttons[2][1].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        else if (buttons[0][2].getText().toString().equals("O") &&
                buttons[1][2].getText().toString().equals("O") &&
                buttons[2][2].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        // Diagonal
        else if (buttons[0][0].getText().toString().equals("X") &&
                buttons[1][1].getText().toString().equals("X") &&
                buttons[2][2].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[0][2].getText().toString().equals("X") &&
                buttons[1][1].getText().toString().equals("X") &&
                buttons[2][0].getText().toString().equals("X")){

            txtTurns.setText("X Wins!");
            return true;
        }
        else if (buttons[0][0].getText().toString().equals("O") &&
                buttons[1][1].getText().toString().equals("O") &&
                buttons[2][2].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        else if (buttons[0][2].getText().toString().equals("O") &&
                buttons[1][1].getText().toString().equals("O") &&
                buttons[2][0].getText().toString().equals("O")){

            txtTurns.setText("O Wins!");
            return true;
        }
        else if (countButtons == 9){
            txtTurns.setText("It's a draw...");
        }

        return false;
    }

    // Resetting the game
    public void RestGame(){
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                buttons[i][y].setText("");
                buttons[i][y].setBackgroundResource(android.R.drawable.btn_default);
                buttons[i][y].setEnabled(true);
            }
        }
        txtTurns.setText("X's Turn");
        countButtons = 0;
        playerXTurn = true;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnNewGame:
                RestGame();
                break;
        }
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }

        // Check player turn
        if (playerXTurn)
        {
            ((Button) view).setText("X");
            txtTurns.setText("O's Turn");
            playerXTurn = false;
        }
        else
        {
            ((Button) view).setText("O");
            txtTurns.setText("X's Turn");
            playerXTurn = true;
        }

        //Counting the number of buttons just in case there is a draw
        countButtons++;
        if(CheckWinner() || countButtons == 9){
            for (int i = 0; i < 3; i++) {
                for (int y = 0; y < 3; y++) {
                    buttons[i][y].setBackgroundResource(android.R.drawable.btn_default);
                    buttons[i][y].setEnabled(false);
                }
            }
        }
    }

    // Instance states
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countButtons",countButtons);
        outState.putBoolean("playerXTurn", playerXTurn);
        outState.putString("txtTurns", txtTurns.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle onSaveInstanceState) {
        super.onRestoreInstanceState(onSaveInstanceState);

        countButtons = onSaveInstanceState.getInt("countButtons");
        playerXTurn = onSaveInstanceState.getBoolean("playerXTurn");
        txtTurns.setText(onSaveInstanceState.getString("txtTurns"));

    }
}
