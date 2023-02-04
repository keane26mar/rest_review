package restaurant_project;

import java.util.Comparator;


public class TitleComparator implements Comparator<Rest> {

	public int compare(Rest r1, Rest r2) {
		return r2.getTitle().compareTo(r1.getTitle());
	}

}