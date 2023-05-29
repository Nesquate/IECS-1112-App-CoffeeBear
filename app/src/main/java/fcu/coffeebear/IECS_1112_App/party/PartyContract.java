package fcu.coffeebear.IECS_1112_App.party;

import java.util.ArrayList;
import java.util.HashMap;

public interface PartyContract {
    interface IPartyView{
        void showPartyList(ArrayList<HashMap<String, String>> partyList);
    }
    interface IPartyPresenter{
        void getPartyList();
    }
}
