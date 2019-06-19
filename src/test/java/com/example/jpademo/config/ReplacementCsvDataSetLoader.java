package com.example.jpademo.config;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;

public class ReplacementCsvDataSetLoader extends ReplacementDataSetLoader {
    public ReplacementCsvDataSetLoader() {
        super(new CsvDataSetLoader()); // ここで実装したCsvをloadするLoaderを読み込む
    }
}
