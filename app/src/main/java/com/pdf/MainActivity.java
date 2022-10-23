package com.pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.File;

public class MainActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {
    private PDFView pdfView;
    //private PDFView pdfView;
    public static final String SAMPLE_FILE = "sample.pdf";
    String pdfFileName;
    Integer pageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        displayFromAsset("sample.pdf");
    }
    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .pageFitPolicy(FitPolicy.BOTH)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageError(int page, Throwable t) {

    }
}