package Calculator; 

import dao.Dao;
import Data.Ehdokkaat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class answerCalc {
	public Dao dao;
	public ArrayList<Ehdokkaat> matchCandidates(ArrayList<Integer> answers) {
		dao = new Dao();
		dao.getConnection();
		ArrayList <Ehdokkaat> ehdokkaat = dao.lueEhdokkaat();
		float score = 100;
		ArrayList <Integer> userAnswers = answers;
		int counted = 0;

		for (int i = 0; i < ehdokkaat.size(); i++) {
			ArrayList <Integer> candAnswers = dao.lueVastaukset(ehdokkaat.get(i).getEhdokas_id());
			if (candAnswers.size() == dao.countKysymykset()) {
				System.out.println("Pepu");
				score = 0;
				for (int y = 0; y < userAnswers.size(); y++) {
					if (userAnswers.get(y)!= 3 && candAnswers.get(y)!= 3) {
						System.out.println("kaka");
						
						counted++;
						score += Math.abs(userAnswers.get(y) - candAnswers.get(y));
					}
				}
				score = score / counted;
			}
				ehdokkaat.get(i).setScore(score);
			
		}		
		ArrayList<Ehdokkaat> topThree = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			topThree.add(Collections.min(ehdokkaat, Comparator.comparing(s -> s.getScore())));
			ehdokkaat.remove(Collections.min(ehdokkaat, Comparator.comparing(s -> s.getScore())));
		}

		return topThree;

	}
}
