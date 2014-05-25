package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.viewModel.StocksViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

/**
 * Date: 16.05.14
 * Time: 8:16
 *
 * @author SarokaA
 */
public class StocksController implements Controller {

    private StocksViewModel viewModel;

    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (StocksViewModel) viewModel;
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }

}
