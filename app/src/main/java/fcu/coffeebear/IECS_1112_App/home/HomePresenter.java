package fcu.coffeebear.IECS_1112_App.home;

import fcu.coffeebear.IECS_1112_App.model.HomeRepository;

public class HomePresenter implements HomeContract.IHomePresenter {
    private HomeContract.IHomeView view;
    private HomeRepository repository;

    public HomePresenter(HomeContract.IHomeView view, HomeRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getBanner() {
        view.showBanner(repository.getBanner());
    }

    @Override
    public void getMemberBar() {
        view.showMemberBar(repository.getMemberShortInfo());
    }
}
