package com.example.scorekeeper;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int mTeamOneScore = 0;
    int mTeamOneVictories = 0;
    TextView mTeamOneScoreTextView;
    TextView mTeamOneVictoriesTextView;


    int mTeamTwoScore = 0;
    int mTeamTwoVictories = 0;
    TextView mTeamTwoScoreTextView;
    TextView mTeamTwoVictoriesTextView;

    Button resetGameButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamOneScoreTextView = findViewById(R.id.team_one_score);
        mTeamOneVictoriesTextView = findViewById(R.id.team_one_victories);

        mTeamTwoScoreTextView = findViewById(R.id.team_two_score);
        mTeamTwoVictoriesTextView = findViewById(R.id.team_two_victories);

        resetGameButton = findViewById(R.id.reset_game_button);
        resetGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame(true);
            }
        });

    }

    public void controlTeamOneScore(View view) {

        switch (view.getId()){
            case R.id.team_one_add_one:
                mTeamOneScore++;
                break;
            case R.id.team_one_subtract_one:
                if (mTeamOneScore > 0) mTeamOneScore--;
                break;
            case R.id.team_one_add_three:
                mTeamOneScore += 3;
                break;
            case R.id.team_one_add_six:
                mTeamOneScore += 6;
                break;
            case R.id.team_one_add_nine:
                mTeamOneScore += 9;
                break;
            default:
        }

        mTeamOneScoreTextView.setText(String.valueOf(mTeamOneScore));

        if (mTeamOneScore >= 12){
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Time dos Marrecos Venceu !");
            alertDialog.setMessage("Escolha o que deseja fazer:");

            alertDialog.setPositiveButton("Nova Partida", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTeamOneScore = 0;
                    mTeamOneVictories++;
                    mTeamOneScoreTextView.setText(String.valueOf(mTeamOneScore));
                    mTeamOneVictoriesTextView.setText(String.valueOf(mTeamOneVictories));

                    mTeamTwoScore = 0;
                    mTeamTwoScoreTextView.setText(String.valueOf(mTeamTwoScore));
                }
            });
            alertDialog.setNegativeButton("Resetar Tudo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog.Builder confirmAlertDialog = new AlertDialog.Builder(MainActivity.this);
                    confirmAlertDialog.setTitle("Tem certeza que deseja resetar tudo?");
                    confirmAlertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            resetGame(false);
                        }
                    });

                    confirmAlertDialog.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.show();
                        }
                    });

                    confirmAlertDialog.setCancelable(false);
                    confirmAlertDialog.show();
                }
            });


            alertDialog.setCancelable(false);
            alertDialog.show();
        }
    }


    public void controlTeamTwoScore(View view) {

        switch (view.getId()){
            case R.id.team_two_add_one:
                mTeamTwoScore++;
                break;
            case R.id.team_two_subtract_one:
                if (mTeamTwoScore > 0) mTeamTwoScore--;
                break;
            case R.id.team_two_add_three:
                mTeamTwoScore += 3;
                break;
            case R.id.team_two_add_six:
                mTeamTwoScore += 6;
                break;
            case R.id.team_two_add_nine:
                mTeamTwoScore += 9;
                break;
            default:
        }

        mTeamTwoScoreTextView.setText(String.valueOf(mTeamTwoScore));

        if (mTeamTwoScore >= 12){
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Time dos Patos Venceu !");
            alertDialog.setMessage("Escolha o que deseja fazer:");
            alertDialog.setPositiveButton("Nova Partida", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTeamTwoScore = 0;
                    mTeamTwoVictories++;
                    mTeamTwoScoreTextView.setText(String.valueOf(mTeamTwoScore));
                    mTeamTwoVictoriesTextView.setText(String.valueOf(mTeamTwoVictories));

                    mTeamOneScore = 0;
                    mTeamOneScoreTextView.setText(String.valueOf(mTeamOneScore));
                }
            });

            alertDialog.setNegativeButton("Resetar Tudo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog.Builder confirmAlertDialog = new AlertDialog.Builder(MainActivity.this);
                    confirmAlertDialog.setTitle("Tem certeza que deseja resetar tudo?");
                    confirmAlertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            resetGame(false);
                        }
                    });

                    confirmAlertDialog.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.show();
                        }
                    });

                    confirmAlertDialog.setCancelable(false);
                    confirmAlertDialog.show();
                }
            });

            alertDialog.setCancelable(false);
            alertDialog.show();
        }
    }

    public void resetGame(boolean fromResetButton) {
        if (!fromResetButton) {
            mTeamOneScore = 0;
            mTeamOneVictories = 0;
            mTeamOneScoreTextView.setText(String.valueOf(mTeamOneScore));
            mTeamOneVictoriesTextView.setText(String.valueOf(mTeamOneVictories));

            mTeamTwoScore = 0;
            mTeamTwoVictories = 0;
            mTeamTwoScoreTextView.setText(String.valueOf(mTeamTwoScore));
            mTeamTwoVictoriesTextView.setText(String.valueOf(mTeamTwoVictories));
        } else {
            AlertDialog.Builder confirmAlertDialog = new AlertDialog.Builder(MainActivity.this);
            confirmAlertDialog.setTitle("Tem certeza que deseja resetar tudo?");
            confirmAlertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    resetGame(false);
                }
            });

            confirmAlertDialog.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            confirmAlertDialog.setCancelable(false);
            confirmAlertDialog.show();
        }

    }
}
