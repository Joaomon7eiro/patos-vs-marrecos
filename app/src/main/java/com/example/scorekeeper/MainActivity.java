package com.example.scorekeeper;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int mTeamOneScore = 0;
    int mTeamOneVictories = 0;
    TextView mTeamOneScoreTextView;
    TextView mTeamOneVictoriesTextView;

    int mTeamTwoScore = 0;
    int mTeamTwoVictories = 0;
    TextView mTeamTwoScoreTextView;
    TextView mTeamTwoVictoriesTextView;

    Button mResetGameButton;

    // Variable to check if is a dialog showing on the screen
    boolean mDialogOpen = false;
    static final int MAX_SCORE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // change the theme to remove the splash screen
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamOneScoreTextView = findViewById(R.id.team_one_score);
        mTeamOneVictoriesTextView = findViewById(R.id.team_one_victories);

        mTeamTwoScoreTextView = findViewById(R.id.team_two_score);
        mTeamTwoVictoriesTextView = findViewById(R.id.team_two_victories);

        mResetGameButton = findViewById(R.id.reset_game_button);
        mResetGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame(true);
            }
        });
    }

    public void controlTeamOneScore(View view) {
        // check if a dialog is already open to prevent add unnecessary points
        if (mDialogOpen) return;
        switch (view.getId()) {
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
        if (mTeamOneScore >= MAX_SCORE) {
            mDialogOpen = true;

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle(getString(R.string.team_one_win_title));
            alertDialog.setMessage(getString(com.example.scorekeeper.R.string.dialog_message));
            alertDialog.setPositiveButton(getString(R.string.new_game_text), new DialogInterface.OnClickListener() {
                // reset scores and add one victory to team one
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTeamOneScore = 0;
                    mTeamOneVictories++;
                    mTeamOneScoreTextView.setText(String.valueOf(mTeamOneScore));
                    mTeamOneVictoriesTextView.setText(String.valueOf(mTeamOneVictories));

                    mTeamTwoScore = 0;
                    mTeamTwoScoreTextView.setText(String.valueOf(mTeamTwoScore));

                    mDialogOpen = false;
                }
            });
            alertDialog.setNegativeButton(getString(R.string.reset_all_text), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog.Builder confirmAlertDialog = new AlertDialog.Builder(MainActivity.this);
                    confirmAlertDialog.setTitle(getString(R.string.reset_all_question));
                    confirmAlertDialog.setPositiveButton(getString(R.string.yes_text), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // resetGame passing false because its not coming from resetGameButton
                            resetGame(false);
                            mDialogOpen = false;
                        }
                    });
                    confirmAlertDialog.setNegativeButton(getString(R.string.back_text), new DialogInterface.OnClickListener() {
                        // user don't want to reset game, so return to the previous dialog
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.show();
                        }
                    });
                    confirmAlertDialog.setCancelable(false);
                    confirmAlertDialog.show();
                }
            });
            // not allow user to cancel alert dialog
            alertDialog.setCancelable(false);
            alertDialog.show();
        }
    }


    public void controlTeamTwoScore(View view) {
        // check if a dialog is already open to prevent add unnecessary points
        if (mDialogOpen) return;
        switch (view.getId()) {
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
        if (mTeamTwoScore >= MAX_SCORE) {
            mDialogOpen = true;

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle(getString(R.string.team_two_win_title));
            alertDialog.setMessage(getString(R.string.dialog_message));
            alertDialog.setPositiveButton(getString(R.string.new_game_text), new DialogInterface.OnClickListener() {
                // reset scores and add one victory to team two
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTeamTwoScore = 0;
                    mTeamTwoVictories++;
                    mTeamTwoScoreTextView.setText(String.valueOf(mTeamTwoScore));
                    mTeamTwoVictoriesTextView.setText(String.valueOf(mTeamTwoVictories));

                    mTeamOneScore = 0;
                    mTeamOneScoreTextView.setText(String.valueOf(mTeamOneScore));

                    mDialogOpen = false;
                }
            });
            alertDialog.setNegativeButton(getString(R.string.reset_all_text), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog.Builder confirmAlertDialog = new AlertDialog.Builder(MainActivity.this);
                    confirmAlertDialog.setTitle(getString(R.string.reset_all_question));
                    confirmAlertDialog.setPositiveButton(getString(R.string.yes_text), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // resetGame passing false because its not coming from resetGameButton
                            resetGame(false);
                            mDialogOpen = false;
                        }
                    });
                    confirmAlertDialog.setNegativeButton(getString(R.string.back_text), new DialogInterface.OnClickListener() {
                        // user don't want to reset game, so return to the previous dialog
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.show();
                        }
                    });
                    confirmAlertDialog.setCancelable(false);
                    confirmAlertDialog.show();
                }
            });
            // not allow user to cancel alert dialog
            alertDialog.setCancelable(false);
            alertDialog.show();
        }
    }
    // reset all scores
    public void resetGame(boolean fromResetButton) {
        // if its is coming from resetGameButton then shows the confirm dialog
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
            confirmAlertDialog.setTitle(getString(R.string.reset_all_question));
            confirmAlertDialog.setPositiveButton(getString(R.string.yes_text), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    resetGame(false);
                }
            });
            confirmAlertDialog.setNegativeButton(getString(R.string.back_text), new DialogInterface.OnClickListener() {
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
