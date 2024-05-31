package com.anunciaMe.api.dtos;

import java.util.List;

public class PageDto<T> {

    private List<T> items;
    private boolean existMoreItems;

    public PageDto() {}

    public PageDto(List<T> items, boolean existMoreItems) {

        this.items = items;
        this.existMoreItems = existMoreItems;

    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean getExistMoreItems() {
        return existMoreItems;
    }

    public void setExistMoreItems(boolean existMoreItems) {
        this.existMoreItems = existMoreItems;
    }

}