
public class tennisGame3 implements TennisGame {
    
    private int scorePlayer2;
    private int scorePlayer1;
    public final String  namePlayer1;
    public final String  namePlayer2;

    public tennisGame3(String puntNam1, String puntNan2) {
        this.namePlayer1 = puntNam1;
        this.namePlayer2 = puntNan2;
    }


    public String getScore() {
        if (puntuacion()) {
            return resultadoPuntuacion();
        } else {
            if (empate()) {
                return "Deuce";
            }
            return evento();
        }
    }

    public boolean puntuacion(){
        return (scorePlayer2 < 4) && (scorePlayer1 < 4) &&  (scorePlayer2 + scorePlayer1 == 6);
    }

    public boolean empate(){
        return (scorePlayer2 == scorePlayer1);
    }

    public String evento(){
        return ( elevarResta() == 1) ? "Advantage " + jugadorAdelante() : "Win for " + jugadorAdelante();
    }

    public double elevarResta(){
        return Math.pow((scorePlayer2 - scorePlayer1), 2);
    }

    public String jugadorAdelante(){
        return scorePlayer2 > scorePlayer1 ? namePlayer1 : namePlayer2;
    }

    public String resultadoPuntuacion(){
        String[] puntaje = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (scorePlayer2 == scorePlayer1) ? puntaje[scorePlayer2] + "-All" : puntaje[scorePlayer2] + "-" + puntaje[scorePlayer1];
    }

    public void wonPoint(String playerName) {
        int puntaje = (playerName == "player1") ? (scorePlayer2++) : (scorePlayer1++);
    }
}