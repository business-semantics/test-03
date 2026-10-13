package com.smartkyc.test.test03.reporting;

import java.util.List;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

/**
 * Report and PDF generation libraries managed by test-03-bom.
 */
public final class ReportingLibraries {

	/** One public type of every library this module depends on (itext7-core is a pom aggregating kernel and layout). */
	public static final List<Class<?>> USED = List.of(
			org.faceless.pdf2.PDF.class,
			org.thymeleaf.TemplateEngine.class,
			com.itextpdf.kernel.pdf.PdfDocument.class,
			com.itextpdf.layout.Document.class,
			com.itextpdf.html2pdf.HtmlConverter.class,
			org.apache.xalan.processor.TransformerFactoryImpl.class,
			org.apache.xml.serializer.Serializer.class,
			com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder.class,
			com.openhtmltopdf.pdfboxout.PdfRendererBuilder.class,
			com.openhtmltopdf.bidi.support.ICUBidiReorderer.class,
			com.openhtmltopdf.slf4j.Slf4jLogger.class,
			org.jblas.DoubleMatrix.class);

	private ReportingLibraries() {
	}

	public static String renderHtml(String template, Map<String, Object> variables) {
		StringTemplateResolver resolver = new StringTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		return engine.process(template, new Context(null, variables));
	}
}
