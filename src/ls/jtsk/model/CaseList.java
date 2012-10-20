package ls.jtsk.model;

import java.util.ArrayList;

public class CaseList {

	/**
	 * UI should pass one parameter as numberOfOnePage
	 * @param numberOfOnePage
	 * @return
	 */
	public static ArrayList getLatestCases(int numberOfOnePage) {
		return getCasesSortByField(numberOfOnePage, 1, "createDate");
	}
	
	/**
	 * 
	 * @param numberOfOnePage
	 * @param pageIndex
	 * @param sortByField TODO should be a enum
	 * @return
	 */
	public static ArrayList  getCasesSortByField(int numberOfOnePage, int pageIndex, String sortByField) {
		return new ArrayList  ();
	}
}
