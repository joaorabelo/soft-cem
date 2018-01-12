package com.soft.cem.viewResolver;


import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.soft.cem.view.PdfView;

import java.util.Locale;


public class PdfViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        PdfView view = new PdfView();
        return view;
    }
}
