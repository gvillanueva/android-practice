package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int m_TeamAScore = 0, m_TeamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("TeamAScore", m_TeamAScore);
        outState.putInt("TeamBScore", m_TeamBScore);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        addToTeamA(inState.getInt("TeamAScore"));
        addToTeamB(inState.getInt("TeamBScore"));
    }

    public void addThreeForTeamA(View view) {
        addToTeamA(3);
    }

    public void addTwoForTeamA(View view) {
        addToTeamA(2);
    }

    public void addOneForTeamA(View view) {
        addToTeamA(1);
    }

    public void addThreeForTeamB(View view) {
        addToTeamB(3);
    }

    public void addTwoForTeamB(View view) {
        addToTeamB(2);
    }

    public void addOneForTeamB(View view) {
        addToTeamB(1);
    }

    public void resetScores(View view) {
        m_TeamAScore = m_TeamBScore = 0;
        TextView teamAScore = (TextView)findViewById(R.id.team_a_score),
                 teamBScore = (TextView)findViewById(R.id.team_b_score);
        teamAScore.setText("" + m_TeamAScore);
        teamBScore.setText("" + m_TeamBScore);
    }

    /**
     * Adds the increment to Team A's score and updates the display.
     * @param increment
     */
    public void addToTeamA(int increment) {
        m_TeamAScore += increment;
        TextView teamAScore = (TextView)findViewById(R.id.team_a_score);
        teamAScore.setText("" + m_TeamAScore);
    }

    /**
     * Adds the increment to Team B's score and updates the display.
     * @param increment
     */
    public void addToTeamB(int increment) {
        m_TeamBScore += increment;
        TextView teamBScore = (TextView)findViewById(R.id.team_b_score);
        teamBScore.setText("" + m_TeamBScore);
    }
}
