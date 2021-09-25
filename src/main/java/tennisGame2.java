import java.util.Arrays;
import java.util.List;

public class tennisGame2 implements TennisGame
{
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    public final String player1Name;
    public final String player2Name;

    public tennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String Score = "";
        if (empate()){
            Score = puntajesIguales();
        }  else if(seleccionDeAvance()){
            int DiferenciaDePuntaje = scorePlayer1 - scorePlayer2;
            Score = avance(DiferenciaDePuntaje);
        } else {
            Score = puntaje(scorePlayer1) + "-" + puntaje(scorePlayer2);
        }
        return Score;
    }

    public void wonPoint(String Player) {
        var puntaje = (Player == "player1") ?
                (scorePlayer1++) : (scorePlayer2++);
    }


    public boolean empate(){
        return (scorePlayer1 == scorePlayer2);
    }


    public boolean seleccionDeAvance(){
        return ((scorePlayer1 >= 4) || (scorePlayer2 >= 4));
    }


    public String puntajesIguales() {
        List<String> Puntajes = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return Puntajes.get(scorePlayer1);
    }


    public String avance(int DiferenciaDePuntaje){
        switch (DiferenciaDePuntaje){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (DiferenciaDePuntaje >= 2)? "Win for player1" : "Win for player2";
        }
    }

    public String puntaje(int ScorePlayer){
        List<String> Puntajes = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return Puntajes.get(ScorePlayer);
    }
}
