package vn.hoangptit.tiger.core.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleGraphics2DExporterOutput;
import net.sf.jasperreports.export.SimpleGraphics2DReportConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import vn.hoangptit.tiger.core.exception.LogicException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Create file JasperReportUtils
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
public final class JasperReportUtils {
    private static final Logger log = LoggerFactory.getLogger(JasperReportUtils.class);

    public static byte[] exportPdf(Map<String, Object> beans, String templateDesign) throws JRException {
        JasperReport jasperReport = getJasperReport(templateDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, beans, new JREmptyDataSource());
        jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public static byte[] exportImage(Map<String, Object> beans, String templateDesign, String exportType) throws JRException {
        JasperReport jasperReport = getJasperReport(templateDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, beans, new JREmptyDataSource());
        jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
        int page = jasperPrint.getPages().size();
        float zoom = 2.0F;
        List<BufferedImage> allPages = new ArrayList();

        for (int i = 0; i < page; ++i) {
            BufferedImage currentPage = new BufferedImage(Math.round((float) jasperPrint.getPageWidth() * 2.0F),
                    Math.round((float) jasperPrint.getPageHeight() * 2.0F), 1);
            JRGraphics2DExporter exporter = new JRGraphics2DExporter();
            ExporterInput input = new SimpleExporterInput(jasperPrint);
            SimpleGraphics2DExporterOutput output = new SimpleGraphics2DExporterOutput();
            SimpleGraphics2DReportConfiguration configuration = new SimpleGraphics2DReportConfiguration();
            configuration.setZoomRatio(2.0F);
            configuration.setPageIndex(i);
            output.setGraphics2D((Graphics2D) currentPage.getGraphics());
            exporter.setExporterInput(input);
            exporter.setExporterOutput(output);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            allPages.add(currentPage);
        }

        BufferedImage joinedImage = joinImageVertically(allPages);

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] var17;
            try {
                ImageIO.write(joinedImage, exportType, baos);
                var17 = baos.toByteArray();
            } catch (Throwable var15) {
                try {
                    baos.close();
                } catch (Throwable var14) {
                    var15.addSuppressed(var14);
                }

                throw var15;
            }

            baos.close();
            return var17;
        } catch (IOException var16) {
            throw new LogicException(var16.getMessage(), var16);
        }
    }

    private static BufferedImage joinImageVertically(List<BufferedImage> images) {
        if (images.size() == 1) {
            return (BufferedImage) images.get(0);
        } else {
            int width = images.stream().mapToInt(BufferedImage::getWidth).max().orElse(0);
            int height = images.stream().mapToInt(BufferedImage::getHeight).sum();
            BufferedImage newImage = new BufferedImage(width, height, ((BufferedImage) images.get(0)).getType());
            Graphics g2 = newImage.getGraphics();
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, width, height);
            int currentY = 0;

            BufferedImage image;
            for (Iterator var6 = images.iterator(); var6.hasNext(); currentY += image.getHeight()) {
                image = (BufferedImage) var6.next();
                g2.drawImage(image, 0, currentY, (ImageObserver) null);
            }

            g2.dispose();
            return newImage;
        }
    }

    private static JasperReport getJasperReport(String templateDesign) throws JRException {
        ClassPathResource templateJasper = new ClassPathResource(templateDesign.replace("jrxml", "jasper"));

        try {
            JasperReport jasperReport;
            if (templateJasper.exists()) {
                jasperReport = (JasperReport) JRLoader.loadObject(templateJasper.getInputStream());
            } else {
                InputStream inputStream = (new ClassPathResource(templateDesign)).getInputStream();
                jasperReport = JasperCompileManager.compileReport(inputStream);
            }

            return jasperReport;
        } catch (IOException var4) {
            throw new LogicException(var4.getMessage(), var4);
        }
    }
}
