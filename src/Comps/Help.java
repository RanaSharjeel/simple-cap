package Comps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends ToolButton {

    String html = "<html>\n" +
            "<body>\n" +
            "<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n" +
            "    <tbody>\n" +
            "    <tr>\n" +
            "        <td style=\"width: 100%; background-color: #7cfc00; border-style: dashed; text-align: center;\"><strong><em>screen-cap</em></strong></td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "</table>\n" +
            "<p style=\"text-align: center;\">(Sharjeel Qaiser)</p>\n" +
            "<p style=\"text-align: center;\"><a href=\"https://github.com/RanaSharjeel\">github.com/RanaSharjeel</a></p>\n" +
            "<table style=\"border-collapse: collapse; width: 100%; height: 97px;\" border=\"1\">\n" +
            "    <tbody>\n" +
            "    <tr style=\"height: 80px;\">\n" +
            "        <td style=\"width: 21.3987%; height: 80px; background-color: #90ee90; border-style: dashed;\">\n" +
            "            <h1 style=\"text-align: center;\">Copy</h1>\n" +
            "        </td>\n" +
            "        <td style=\"width: 78.6013%; height: 80px;\">\n" +
            "            <table style=\"border-collapse: collapse; width: 100%; height: 68px;\" border=\"1\">\n" +
            "                <tbody>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #90ee90; border-style: dotted;\"><em>Select area you wish to crop</em></td>\n" +
            "                </tr>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #90ee90; border-style: dotted;\"><em>Image gets copied to clipboard</em></td>\n" +
            "                </tr>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #90ee90; border-style: dotted;\"><em>Program exits automatically</em></td>\n" +
            "                </tr>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #90ee90; border-style: dotted;\"><em>Paste image to desired location</em></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "            </table>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "    <tr style=\"height: 17px;\">\n" +
            "        <td style=\"width: 21.3987%; height: 17px; border-style: dashed; background-color: #98fb98;\">\n" +
            "            <h1 style=\"text-align: center;\">Save</h1>\n" +
            "        </td>\n" +
            "        <td style=\"width: 78.6013%; height: 17px;\">\n" +
            "            <table style=\"border-collapse: collapse; width: 100%; height: 68px;\" border=\"1\">\n" +
            "                <tbody>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #98fb98;\"><em>Select area you wish to crop</em></td>\n" +
            "                </tr>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #98fb98;\"><em>You get prompted with the save menu</em></td>\n" +
            "                </tr>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #98fb98;\"><em>Select area you wish to crop</em></td>\n" +
            "                </tr>\n" +
            "                <tr style=\"height: 17px;\">\n" +
            "                    <td style=\"width: 100%; height: 17px; text-align: center; background-color: #98fb98;\"><em>Enter file name, select an extension (PNG/JPG) and save</em></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "            </table>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "</table>\n" +
            "<p>&nbsp;</p>\n" +
            "</body>\n" +
            "</html>";

    public Help(String name){
        super(name);

        // Pop dialog explaining program on click
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel label = new JLabel(html);
                label.setFont(new Font("Arial", Font.PLAIN, 24));

                JOptionPane.showMessageDialog(null, label, "Usage", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}
