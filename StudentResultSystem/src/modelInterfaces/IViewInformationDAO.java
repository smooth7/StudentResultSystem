package modelInterfaces;

import java.util.ArrayList;

public interface IViewInformationDAO {
	ArrayList<String> getNewsList(String loginId, String loginUserType);
}
