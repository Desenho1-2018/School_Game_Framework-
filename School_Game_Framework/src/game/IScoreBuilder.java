package game;

public interface IScoreBuilder {

	void buildPlayer(String umPlayer);
	void buildFase(String umaFase);
	void buildMencao(String umaMencao);
	void buildPassword(String umPassword);
	void buildProximaFase(String umaProximaFase);
	
	Score getScore();
	
}
