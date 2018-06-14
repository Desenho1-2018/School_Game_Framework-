package game;

public class GeradorScore {
	
	private IScoreBuilder scoreBuilder;
	
	public GeradorScore(IScoreBuilder scoreBuilder) {
		this.scoreBuilder = scoreBuilder;
	}

	public Score geraScore() {
		String umPlayer = " ";
		this.scoreBuilder.buildPlayer(umPlayer);
		
		String umaFase = " ";
		this.scoreBuilder.buildFase(umaFase);
		
		String umaMencao = " ";
		this.scoreBuilder.buildMencao(umaMencao);
		
		String umPassword = "";
		this.scoreBuilder.buildPassword(umPassword);
		
		String umaProximaFase = "";
		this.scoreBuilder.buildProximaFase(umaProximaFase);
		
	}
}
