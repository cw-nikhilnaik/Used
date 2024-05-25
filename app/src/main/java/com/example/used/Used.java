package com.example.used;

import java.util.ArrayList;
import java.util.List;

public class Used {

    private int totalCount;
    private boolean showSimilarCarsLink;
    private String searchPageDescription;

    private ArrayList<UsedCarDetails> stocks;

    public Used(int totalCount, boolean showSimilarCarsLink, String searchPageDescription, ArrayList<UsedCarDetails>stocks) {
        this.totalCount = totalCount;
        this.showSimilarCarsLink = showSimilarCarsLink;
        this.searchPageDescription = searchPageDescription;
        this.stocks = stocks;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isShowSimilarCarsLink() {
        return showSimilarCarsLink;
    }

    public void setShowSimilarCarsLink(boolean showSimilarCarsLink) {
        this.showSimilarCarsLink = showSimilarCarsLink;
    }

    public String getSearchPageDescription() {
        return searchPageDescription;
    }

    public void setSearchPageDescription(String searchPageDescription) {
        this.searchPageDescription = searchPageDescription;
    }

    public ArrayList<UsedCarDetails> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<UsedCarDetails> stocks) {
        this.stocks = stocks;
    }
}
