package com.example.jpademo.config;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvURLDataSet;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
/**
 * データベースの状態をCSVで設定できるようにするためのクラス
 *
 */
public class CsvDataSetLoader extends AbstractDataSetLoader {
    public CsvDataSetLoader() {
    }

    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
        return new CsvURLDataSet(resource.getURL());
    }
}