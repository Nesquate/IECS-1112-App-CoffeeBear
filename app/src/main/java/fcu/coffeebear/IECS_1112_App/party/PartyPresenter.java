package fcu.coffeebear.IECS_1112_App.party;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.model.PartyRepository;

public class PartyPresenter implements PartyContract.IPartyPresenter {
    private PartyRepository repository;
    private PartyContract.IPartyView view;

    public PartyPresenter(PartyContract.IPartyView view, PartyRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getPartyList() {
        ArrayList<HashMap<String, String>> partyList = repository.getPartyList();
        view.showPartyList(partyList);
    }
}
