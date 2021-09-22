
public class TennisGame3 implements TennisGame {
    
    private int ScorePlayer2;
    private int ScorePlayer1;
    private String NamePlayer1;
    private String NamePlayer2;

    public TennisGame3(String p1N, String p2N) {
        this.NamePlayer1 = p1N;
        this.NamePlayer2 = p2N;
    }


    public String getScore() {
        if (Puntuacion()) {
            return ResultadoPuntuacion();
        } else {
            if (Empate()) {
                return "Deuce";
            }
            return Evento();
        }
    }

    public boolean Puntuacion(){
        return (ScorePlayer2 < 4) && (ScorePlayer1 < 4) && !(ScorePlayer2 + ScorePlayer1 == 6);
    }

    public boolean Empate(){
        return (ScorePlayer2 == ScorePlayer1);
    }

    public String Evento(){
        return ( ElevarResta() == 1) ? "Advantage " + JugadorAdelante() : "Win for " + JugadorAdelante();
    }

    public double ElevarResta(){
        return Math.pow((ScorePlayer2 - ScorePlayer1), 2);
    }

    public String JugadorAdelante(){
        return ScorePlayer2 > ScorePlayer1 ? NamePlayer1 : NamePlayer2;
    }

    public String ResultadoPuntuacion(){
        String[] Puntaje = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (ScorePlayer2 == ScorePlayer1) ? Puntaje[ScorePlayer2] + "-All" : Puntaje[ScorePlayer2] + "-" + Puntaje[ScorePlayer1];
    }

    public void wonPoint(String PlayerName) {
        int puntaje = (PlayerName == "player1") ? (ScorePlayer2 ++) : (ScorePlayer1 ++);
    }
}