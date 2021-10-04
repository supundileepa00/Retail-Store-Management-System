package util.Utility;

import bean.Order;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class PrintReport extends JFrame {

    public void generateSpecificOrderReport(Order order) {
        try {
                HashMap parameter = new HashMap();
                parameter.put("oID", order.getoID());
                parameter.put("oIID", order.getoIID());
                parameter.put("oIName", order.getoIName());
                parameter.put("oQuantity", order.getoQuantity());
                parameter.put("oSellingPrice", String.valueOf(JUtility.numberDisplayWithCommasAndDecimalPlaces(order.getoTotalPrice() /order.getoQuantity())));
                parameter.put("oTotalPrice", String.valueOf("Rs : "+JUtility.numberDisplayWithCommasAndDecimalPlaces(order.getoTotalPrice())));
                parameter.put("oCID", order.getoCID());
                parameter.put("oCName", order.getoCName());
                parameter.put("oDate", order.getoDate());

                JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath() + "/src/resource/reportTemplate/SpecificOrderReport.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(jd);
                JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, parameter, new JREmptyDataSource());
                JRViewer viewer = new JRViewer(JasperPrint);

                //viewer.setOpaque(true);
                viewer.setVisible(true);

                add(viewer);
                this.setSize(850, 800); // JFrame size
                this.setVisible(true);
                try {

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error Occured While generating Report:" + ex);
                }
            } catch (JRException e) {
                e.printStackTrace();
            }

    }

}
